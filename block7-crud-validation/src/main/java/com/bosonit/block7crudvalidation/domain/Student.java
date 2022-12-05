package com.bosonit.block7crudvalidation.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudiantes")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_student;

    @Column(name = "horas_por_semana")
    int num_hours_week;

    @Column(name = "comentarios")
    String comments;

    @Column(name = "rama")
    String branch;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Professor profesor;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "asignaturas_estudiantes")
    List<Asignatura> asignaturas = new ArrayList<>();
}
