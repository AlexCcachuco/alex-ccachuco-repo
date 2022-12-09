package com.example.examen_JPA_cascade.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineasFra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "Nombre_producto", nullable = false)
    String proNomb;

    @Column(name = "cantidad")
    double cantidad;

    @Column(name = "precio")
    double precio;


}
