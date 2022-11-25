package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.controller.dto.PersonaInputDto;
import com.bosonit.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.bosonit.block7crudvalidation.domain.Persona;
import com.bosonit.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository personaRepo;

    public void addPersona(PersonaInputDto personaInputDto) throws Exception {
        Persona persona = new Persona(personaInputDto);
        if(Objects.isNull(persona.getUsuario()) || persona.getUsuario().isBlank()){
            throw new Exception("Usuario no puede ser null o vacío");
        } else if(persona.getUsuario().length() > 10){
            throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres");
        }
        System.out.println(persona.toString() + " object persona");
        personaRepo.save(persona);

    }

    public PersonaOutputDto getPersonaById(int id){
        Persona persona = personaRepo.findById(id).orElseThrow();
        return persona.personaToPersonaDto();
    }

    public PersonaOutputDto getPersonaByName(String name){
        Persona persona = personaRepo.findByUsuario(name);
        return persona.personaToPersonaDto();
    }

    public List<PersonaOutputDto> getAllPersonas(){
         return personaRepo.findAll().stream().map(PersonaOutputDto::new).collect(Collectors.toList());
    }

}
