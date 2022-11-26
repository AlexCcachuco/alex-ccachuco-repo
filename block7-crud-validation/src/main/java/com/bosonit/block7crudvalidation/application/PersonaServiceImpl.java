package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.controller.dto.PersonaInputDto;
import com.bosonit.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.bosonit.block7crudvalidation.domain.Persona;
import com.bosonit.block7crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.block7crudvalidation.exceptions.UnprocessableEntityException;
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

    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto)   {
        checkInputData(personaInputDto);
        Persona persona = new Persona(personaInputDto);
        personaRepo.save(persona);
        return persona.personaToPersonaDto();
    }

    public PersonaOutputDto getPersonaById(int id){
        Persona persona = personaRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Person not found! Try another id"));
        return persona.personaToPersonaDto();
    }

    public PersonaOutputDto getPersonaByName(String name){
        Persona persona = personaRepo.findByUsuario(name).orElseThrow(()-> new EntityNotFoundException("Person not found! Try another name"));
        return persona.personaToPersonaDto();
    }

    public List<PersonaOutputDto> getAllPersonas(){
         return personaRepo.findAll().stream().map(PersonaOutputDto::new).collect(Collectors.toList());
    }

    public void deleteById(int id){
        personaRepo.deleteById(id);
    }

    public PersonaOutputDto updatePersona(PersonaInputDto personaInputDto, int id){
        personaRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Person not found! Try another id"));
        checkInputData(personaInputDto);
        Persona persona = new Persona(personaInputDto);
        persona.setId_persona(id);
        personaRepo.save(persona);
        return persona.personaToPersonaDto();
    }


    public void checkInputData(PersonaInputDto persona){
        if(Objects.isNull(persona.getUsuario()) || persona.getUsuario().isBlank()){
            throw new UnprocessableEntityException("Username cant be null or empty");
        } else if(persona.getUsuario().length() > 10){
            throw new UnprocessableEntityException("Username length cannot be more than 10");
        }
    }
}
