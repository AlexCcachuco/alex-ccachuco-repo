package com.bosonit.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/controlador2")
public class Controlador2 {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private CiudadService ciudadService;

    @GetMapping(value="/getPersona")
    public Persona getPersona(){
        Persona persona = personaService.getPerson();
        persona.setEdad(persona.getEdad()*2);
    return persona;
    }

    @GetMapping(value = "/getCiudad")
    public ArrayList<Ciudad> getAllCiudad (){
        ArrayList<Ciudad> listCity = ciudadService.getAllCity();
        return listCity;
    }




}
