package com.bosonit.block7crud.controller;

import com.bosonit.block7crud.application.PersonServiceImpl;
import com.bosonit.block7crud.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/URL")
public class ControllerPut {

    @Autowired
    PersonServiceImpl personServiceImpl;

    @PutMapping(value = "/persona")
    public void updatePerson(@RequestBody Person person){
        personServiceImpl.createPerson(person);
    }

}
