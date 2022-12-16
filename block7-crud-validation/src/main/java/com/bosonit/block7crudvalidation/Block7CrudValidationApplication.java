package com.bosonit.block7crudvalidation;

import com.bosonit.block7crudvalidation.domain.Persona;
import com.bosonit.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class Block7CrudValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block7CrudValidationApplication.class, args);
	}

	@Autowired
	PersonaRepository personaRepository;

	@PostConstruct
	public void createPerson(){
		Persona p1 = new Persona();
		p1.setId_persona(0);
		p1.setUsuario("alex154");
		p1.setPassword("abc123");
		p1.setName("Alexander");
		p1.setSurname("Suarez");
		p1.setCompany_email("prueba");
		p1.setPersonal_email("prueba");
		p1.setCity("Santiago");
		p1.setImagen_url("imagen");

		Persona p2 = new Persona();
		p2.setId_persona(0);
		p2.setUsuario("Matin433");
		p2.setPassword("abc123");
		p2.setName("Martin");
		p2.setSurname("Lopez");
		p2.setCompany_email("prueba");
		p2.setPersonal_email("prueba");
		p2.setCity("Santiago");
		p2.setImagen_url("imagen");

		Persona p3 = new Persona();
		p3.setId_persona(0);
		p3.setUsuario("alex1");
		p3.setPassword("abc123");
		p3.setName("Alejandro");
		p3.setSurname("Faren");
		p3.setCompany_email("prueba");
		p3.setPersonal_email("prueba");
		p3.setCity("Santiago");
		p3.setImagen_url("imagen");


		Persona p4 = new Persona();
		p4.setId_persona(0);
		p4.setUsuario("Maria123");
		p4.setPassword("abc123");
		p4.setName("Martin");
		p4.setSurname("Berna");
		p4.setCompany_email("prueba");
		p4.setPersonal_email("prueba");
		p4.setCity("Santiago");
		p4.setImagen_url("imagen");

		Persona p5 = new Persona();
		p5.setId_persona(0);
		p5.setUsuario("David1231");
		p5.setPassword("abc123");
		p5.setName("David");
		p5.setSurname("Faren");
		p5.setCompany_email("prueba");
		p5.setPersonal_email("prueba");
		p5.setCity("Santiago");
		p5.setImagen_url("imagen");

		personaRepository.save(p1);
		personaRepository.save(p2);
		personaRepository.save(p3);
		personaRepository.save(p4);
		personaRepository.save(p5);
	}


}
