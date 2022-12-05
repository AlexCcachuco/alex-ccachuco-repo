package com.bosonit.block7crudvalidation.controller.dto;

import com.bosonit.block7crudvalidation.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaWithStudentsDTO {

    int id_study;
    String asignatura;
    String comment;
    Date initial_date;
    Date finish_date;
    List<StudentDTO> students = new ArrayList<>();
}
