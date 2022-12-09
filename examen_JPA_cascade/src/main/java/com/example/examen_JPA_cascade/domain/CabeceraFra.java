package com.example.examen_JPA_cascade.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabeceraFra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JoinColumn(name = "codigo_cliente")
    @ManyToOne
    Cliente cliente;

    @Column(name = "importe_factura")
    double importeFra;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "factura_lineas")
    List<LineasFra>lineas = new ArrayList<>();


    public CabeceraFra(int id, Cliente cliente, double importeFra) {
        this.id = id;
        this.cliente = cliente;
        this.importeFra = importeFra;
    }
}
