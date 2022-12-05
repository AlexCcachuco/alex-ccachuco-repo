package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.controller.dto.StudentDTO;
import com.bosonit.block7crudvalidation.controller.dto.StudentFullDTO;

import java.util.List;

public interface StudentService {

    public StudentDTO createStudent(StudentDTO studentDTO);
    public List<StudentDTO> getAllStudents();
    public void deleteById(int id);
    public StudentDTO getStudentById(int id);
    public StudentFullDTO getStudentFullById(int id);

}
