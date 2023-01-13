package com.example.block17springbatch.domain;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TiempoRiesgo {

    public static final String HIGH = "HIGH";
    public static final String LOW = "LOW";
    public static final String MEDIUM = "MEDIUM";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String localidad;
    private String mes;
    private String anio;
    private String riesgo;

//  private int media;
//    private int numMedicion;

    @OneToOne(cascade = CascadeType.ALL)
    Tiempo tiempo;

    public TiempoRiesgo(String localidad, String mes, String anio, String riesgo, Tiempo tiempo) {
        this.localidad = localidad;
        this.mes = mes;
        this.anio = anio;
        this.riesgo = riesgo;
        this.tiempo = tiempo;
    }
}
