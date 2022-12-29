package com.bosonit.block7crudvalidation;

import com.bosonit.block7crudvalidation.domain.Persona;
import com.bosonit.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
		p1.setPassword(new BCryptPasswordEncoder().encode("abc123."));
		p1.setName("Alexander");
		p1.setSurname("Suarez");
		p1.setCompany_email("prueba");
		p1.setPersonal_email("prueba");
		p1.setCity("Santiago");
		p1.setImagen_url("imagen");
		p1.setAdmin(true);



		Persona p2 = new Persona();
		p2.setId_persona(0);
		p2.setUsuario("David1231");
		p2.setPassword(new BCryptPasswordEncoder().encode("abc123."));
		p2.setName("David");
		p2.setSurname("Faren");
		p2.setCompany_email("prueba");
		p2.setPersonal_email("prueba");
		p2.setCity("Santiago");
		p2.setImagen_url("imagen");
		p2.setAdmin(false);

		Persona p3 = new Persona();
		p3.setId_persona(0);
		p3.setUsuario("Laura1");
		p3.setPassword(new BCryptPasswordEncoder().encode("abc123."));
		p3.setName("David");
		p3.setSurname("Faren");
		p3.setCompany_email("prueba");
		p3.setPersonal_email("prueba");
		p3.setCity("Santiago");
		p3.setImagen_url("imagen");
		p3.setAdmin(false);
		personaRepository.save(p1);
		personaRepository.save(p2);
		personaRepository.save(p3);

	}


}
