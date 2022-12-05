package com.bosonit.block7crudvalidation.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    int id_student;
    int id_persona;
    int num_hours_week;
    String comments;
    int id_profesor;
    String branch;


}
