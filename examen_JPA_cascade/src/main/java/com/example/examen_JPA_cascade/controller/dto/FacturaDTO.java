package com.example.examen_JPA_cascade.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturaDTO {

    int id;

    double importeFra=0;
    ClienteDTO cliente;
    List<LineaOutputDTO> lineaOutputDTOList;

}
