package com.bosonit.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/controlador1")
public class Controlador1 {

    @Autowired
    PersonaService personaService;

    @Autowired
    CiudadService ciudadService;


    @GetMapping(value="/addPersona")
    public Persona addPersona(@RequestHeader(value="name") String name, @RequestHeader(value="edad") int edad,
        @RequestHeader(value = "poblacion") String poblacion){
        Persona persona = new Persona(name, edad, poblacion);
        personaService.save(persona);
        return persona;
    }

    @PostMapping(value="/addCiudad")
    public void addCity(@RequestBody Ciudad ciudad){
        ciudadService.addCity(ciudad);
    }



    @Qualifier("bean1")
    Persona persona1;

    @Qualifier("bean2")
    Persona persona2;

    @Qualifier("bean3")
    Persona persona3;


    @GetMapping(value = "/bean/{bean}")
    public Persona getBean(@PathVariable String bean){
        switch (bean){
            case "bean1": return persona1;
            case "bean2": return persona2;
            case "bean3": return persona3;
            default: return null;
        }
    }

}
