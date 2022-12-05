package com.bosonit.block7crudvalidation.domain;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Asignatura")
@Data
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_study;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiantes_asignaturas")
    @ToString.Exclude
    List<Student> students = new ArrayList<>();

    @Column(name = "asignatura")
    String asignatura;

    @Column(name = "comentarios")
    String comment;

    @Column(name = "initial_date")
    Date initial_date;

    @Column(name = "finish_date")
    Date finish_date;


}
