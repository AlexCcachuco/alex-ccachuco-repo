package com.bosonit.block7crud.controller;

import com.bosonit.block7crud.application.PersonServiceImpl;
import com.bosonit.block7crud.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/URL")
public class ControllerPost {

    @Autowired
    PersonServiceImpl personServiceImpl;

    @PostMapping(value = "/persona")
    public void addPersona(@RequestBody Person person){
        personServiceImpl.createPerson(person);
    }
}
