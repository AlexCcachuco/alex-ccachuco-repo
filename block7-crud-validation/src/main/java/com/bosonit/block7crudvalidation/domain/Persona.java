package com.bosonit.block7crudvalidation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_persona;

    @Column(name = "usuario", nullable = false, length = 10)
    String usuario;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "surname", nullable = true)
    String surname;

    @Column(name = "company_email", nullable = false)
    String company_email;

    @Column(name = "personal_email", nullable = false)
    String personal_email;

    @Column(name = "city", nullable = false)
    String city;

    @Column(name = "active", nullable = false)
    boolean active =true;

    @Column(name = "created_date", nullable = false)
    Date created_date = new Date();

    @Column(name = "imagen_url", nullable = true)
    String imagen_url;

    @Column(name = "termination_date", nullable = false)
    Date termination_date = new Date();

//    public Persona(PersonaInputDto personaDtoToPersona){
//        this.id_persona = personaDtoToPersona.getId_persona();
//        this.usuario = personaDtoToPersona.getUsuario();
//        this.password = personaDtoToPersona.getPassword();
//        this.name = personaDtoToPersona.getName();
//        this.surname = personaDtoToPersona.getSurname();
//        this.company_email = personaDtoToPersona.getCompany_email();
//        this.personal_email = personaDtoToPersona.getPersonal_email();
//        this.city = personaDtoToPersona.getCity();
//        this.imagen_url = personaDtoToPersona.getImagen_url();
//    }
//
//    public PersonaOutputDto personaToPersonaDto(){
//        return new PersonaOutputDto(this.id_persona, this.usuario, this.name,
//                this.surname, this.company_email, this.personal_email, this.city, this.imagen_url);
//    }


}
