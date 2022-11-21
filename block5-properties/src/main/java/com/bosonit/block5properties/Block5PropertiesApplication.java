package com.bosonit.block5properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5PropertiesApplication implements CommandLineRunner {

	@Value("${greeting}")
	private String greeting;

	@Value("${my.number}")
	private int number;

	@Value("${new.property}")
	private String newProperty;

	public static void main(String[] args){
		// Esto llama al método run que ejecuta lo que haya dentro, por defecto, está vacío.
		SpringApplication.run(Block5PropertiesApplication.class, args);
	}


	@Override
	// Modificamos el método run para que imprima unos mensajes.
	public void run(String... args) throws Exception {
		System.out.println("YAML El valor de greeting es: "+ greeting);
		System.out.println("YAML El valor de my.number es: "+ number);
		System.out.println("YAML El valor de new.property es: "+ newProperty);

	}
}
