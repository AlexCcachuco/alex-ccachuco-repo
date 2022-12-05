package com.bosonit.block7crudvalidation.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Professor")
@Data
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona Persona;

    @Column(name = "comentarios")
    String comments;

    @Column(name = "rama", nullable = false)
    String branch;

    @OneToMany
    List<Student> estudiantes = new ArrayList<>();
}
