package com.bosonit.block6personcontrollers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonaService extends Persona {

    ArrayList<Persona> list = new ArrayList<>();

    public void save(Persona persona){
        list.add(persona);

    }

    public Persona getPerson(){
        return list.get(0);
    }

}