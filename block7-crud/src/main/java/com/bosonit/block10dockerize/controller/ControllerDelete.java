package com.bosonit.block10dockerize.controller;

import com.bosonit.block10dockerize.application.PersonServiceImpl;
import com.bosonit.block10dockerize.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/URL")
public class ControllerDelete {

    @Autowired
    PersonServiceImpl personServiceImpl;

    @DeleteMapping(value = "/persona/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable String id){
        try{
            System.out.println(Integer.parseInt(id));
            personServiceImpl.delete(Integer.parseInt(id));
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
