package com.bosonit.block7crudvalidation.controller;

import com.bosonit.block7crudvalidation.application.PersonaServiceImpl;
import com.bosonit.block7crudvalidation.controller.dto.PersonaInputDto;
import com.bosonit.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.bosonit.block7crudvalidation.domain.Persona;
import com.bosonit.block7crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.block7crudvalidation.exceptions.UnprocessableEntityException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaServiceImpl personServiceImpl;

    @PostMapping(value = "/persona")
    public ResponseEntity<PersonaOutputDto> addPerson(@RequestBody PersonaInputDto personaInputDto)   {
         return ResponseEntity.ok(personServiceImpl.addPersona(personaInputDto));
    }

    @GetMapping(value = "/persona/{id}")
    public ResponseEntity<PersonaOutputDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(personServiceImpl.getPersonaById(id));
    }

    @GetMapping(value = "/persona/name/{name}")
    public ResponseEntity<PersonaOutputDto> getByName(@PathVariable String name) {
        return ResponseEntity.ok(personServiceImpl.getPersonaByName(name));
    }

    @GetMapping(value = "/personas")
    public List<PersonaOutputDto> getAll() {
        return personServiceImpl.getAllPersonas();
    }

    @DeleteMapping(value = "/persona/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable int id)  {
            personServiceImpl.getPersonaById(id);
            personServiceImpl.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted correctly!");
    }
    @PutMapping(value = "/persona/{id}")
    public ResponseEntity<PersonaOutputDto> update(@PathVariable int id, @RequestBody PersonaInputDto personaDTO){
            return ResponseEntity.ok().body(personServiceImpl.updatePersona(personaDTO,id));

    }
}