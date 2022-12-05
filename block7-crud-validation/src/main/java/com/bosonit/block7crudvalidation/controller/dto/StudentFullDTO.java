package com.bosonit.block7crudvalidation.controller.dto;

import com.bosonit.block7crudvalidation.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFullDTO {

    int id_student;
    int num_hours_week;
    String comments;
    int id_profesor;
    String branch;
    Persona persona;


}
