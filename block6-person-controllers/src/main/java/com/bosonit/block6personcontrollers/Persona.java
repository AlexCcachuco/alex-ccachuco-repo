package com.bosonit.block6personcontrollers;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Persona {

    private String name;
    private int edad;
    private String poblacion;

    public Persona(String name, int edad, String poblacion) {
        this.name = name;
        this.edad = edad;
        this.poblacion = poblacion;
    }
}
