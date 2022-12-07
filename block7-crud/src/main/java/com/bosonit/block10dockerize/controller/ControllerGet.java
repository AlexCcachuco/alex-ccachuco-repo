package com.bosonit.block10dockerize.controller;

import com.bosonit.block10dockerize.application.PersonServiceImpl;
import com.bosonit.block10dockerize.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/URL")
public class ControllerGet {

    @Autowired
    PersonServiceImpl personServiceImpl;

    @GetMapping(value = "/persona/{id}")
    public ResponseEntity<Person> GetPersonById(@PathVariable String id){
        try{
            Person personReceived = personServiceImpl.getPersonById(Integer.parseInt(id));
            return ResponseEntity.ok().body(personReceived);
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/persona/nombre/{name}")
    public List<Person> getPersonByName(@PathVariable String name){
        return personServiceImpl.findByName(name);
    }

}
