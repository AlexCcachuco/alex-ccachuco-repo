package com.bosonit.block7crudvalidation.controller.dto;

import com.bosonit.block7crudvalidation.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaOutputDto {

    int id;
    String usuario;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    String imagen_url;

    public PersonaOutputDto(Persona persona) {
        id = persona.getId_persona();
        usuario = persona.getUsuario();
        name = persona.getName();
        surname = persona.getName();
        company_email = persona.getCompany_email();
        personal_email = persona.getPersonal_email();
        city = persona.getCity();
        imagen_url = persona.getImagen_url();
    }
}
