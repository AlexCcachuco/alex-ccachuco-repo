package com.example.block17springbatch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorTemperatura {

    private String localidad;
    private String fecha;
    private int temperatura;

}
