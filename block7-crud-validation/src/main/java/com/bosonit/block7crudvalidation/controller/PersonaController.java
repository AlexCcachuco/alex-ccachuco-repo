package com.bosonit.block7crudvalidation.controller;

import com.bosonit.block7crudvalidation.application.PersonaServiceImpl;
import com.bosonit.block7crudvalidation.controller.dto.PersonaInputDto;
import com.bosonit.block7crudvalidation.controller.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaServiceImpl personServiceImpl;

    @PostMapping(value = "/persona")
    public void addPerson(@RequestBody PersonaInputDto personaInputDto) throws Exception {
        System.out.println(personaInputDto.toString()+ " persona DTO ");
        personServiceImpl.addPersona(personaInputDto);
    }

    @GetMapping(value = "/persona/{id}")
    public PersonaOutputDto getById(@PathVariable int id){
        return personServiceImpl.getPersonaById(id);
    }

    @GetMapping(value = "/persona/name/{name}")
    public PersonaOutputDto getByName(@PathVariable String name){
        return personServiceImpl.getPersonaByName(name);
    }

    @GetMapping(value = "/personas")
    public List<PersonaOutputDto> getAll(){
    return personServiceImpl.getAllPersonas();
    }

}
