package com.bosonit.block6simplecontrollers;

import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {

    @GetMapping(value="/user/{name}")
    public String hello(@PathVariable String name){
        return "Hola "+ name;
    }

    @PostMapping(value ="/useradd")
    public Persona userAdd(@RequestBody Persona persona){
        persona.setEdad(persona.getEdad()+1);
            return persona;
    }
}
