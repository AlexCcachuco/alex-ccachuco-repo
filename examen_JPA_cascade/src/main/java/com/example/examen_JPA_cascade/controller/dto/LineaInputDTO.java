package com.example.examen_JPA_cascade.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineaInputDTO {

    String producto;

    double cantidad;

    double importe;

}
