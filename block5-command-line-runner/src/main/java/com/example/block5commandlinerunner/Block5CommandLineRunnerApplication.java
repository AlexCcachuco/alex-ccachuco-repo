package com.example.block5commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Block5CommandLineRunnerApplication{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);

	//	FirstClass fc = new FirstClass();
	//	fc.Hello();

	//	SecondClass sc= new SecondClass();
	//	sc.ejecutame();

		ThirdClass tc = new ThirdClass();
		tc.run();

	}

	// Se ejecutan primero las clases marcadas como @Bean en primer orden
	// Ejecutando después las demás clases no
	static class FirstClass {

		@PostConstruct
		public void Hello(){
			System.out.println("Hola desde clase inicial");
		}

		public FirstClass(){
		}
	}

	static class SecondClass {

		@Bean
		CommandLineRunner ejecutame(){
			return p->
			{
				System.out.println("Hola desde la clase secundaria");
			};
		}
		public SecondClass(){
		}
	}

	static class ThirdClass implements CommandLineRunner {

		public ThirdClass(){
		}

		@Override
		public void run(String... args) throws Exception {

			FirstClass fc = new FirstClass();
			SecondClass sc = new SecondClass();

			fc.Hello();
			sc.ejecutame();
			System.out.println("Soy la tercera clase");
		}
	}
}
