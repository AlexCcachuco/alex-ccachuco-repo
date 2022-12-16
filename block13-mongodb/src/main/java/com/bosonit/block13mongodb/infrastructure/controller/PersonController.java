package com.bosonit.block13mongodb.infrastructure.controller;

import com.bosonit.block13mongodb.application.PersonService;
import com.bosonit.block13mongodb.domain.Person;
import com.bosonit.block13mongodb.infrastructure.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO personDto){
        return ResponseEntity.ok().body(personService.createPerson(personDto));
    }

    @GetMapping("/all")
    public List<PersonDTO> getPersonById(){
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(personService.getPersonById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable  String id){
        personService.deletePersonById(id);
        return ResponseEntity.ok().body("Delete Correctly!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@RequestBody PersonDTO personDto, @PathVariable String id){
        return ResponseEntity.ok().body(personService.updatePerson(personDto, id));
    }

}
