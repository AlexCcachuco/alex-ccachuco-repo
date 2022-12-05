package com.bosonit.block7crudvalidation.controller;

import com.bosonit.block7crudvalidation.application.StudentServiceImpl;
import com.bosonit.block7crudvalidation.controller.dto.AsignaturaWithStudentsDTO;
import com.bosonit.block7crudvalidation.controller.dto.StudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO studentDto){
     return studentServiceImpl.createStudent(studentDto);
    }

    @GetMapping(value = "/all")
    public List<StudentDTO> getAll(){
        return studentServiceImpl.getAllStudents();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        studentServiceImpl.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted correctly");
    }

    @GetMapping(value = "/{id}")
    public Optional<?> getStudentById(@PathVariable int id, @RequestParam(required = false) String outputType){
        if(outputType != null && !outputType.isBlank()){
            if(outputType.equals("simple")){
                return Optional.ofNullable(studentServiceImpl.getStudentById(id));
            } else if(outputType.equals("full")){
                return Optional.ofNullable(studentServiceImpl.getStudentFullById(id));
            }
        }
        return Optional.ofNullable(studentServiceImpl.getStudentById(id));

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable int id, @RequestBody StudentDTO studentDto){
        return ResponseEntity.ok().body(studentServiceImpl.updateStudent(studentDto, id));
    }

    @PostMapping("/asignatura")
    public AsignaturaWithStudentsDTO createRelationStudentAsignatura(@RequestParam int id_student, @RequestParam int id_asignatura){
        return studentServiceImpl.createRelationStudentAsignatura(id_student, id_asignatura);
    }

    @DeleteMapping("/asignatura")
    public void deleteRelationStudentsAsignatura(@RequestParam int id_student, @RequestParam int id_asignatura){
        studentServiceImpl.deleteRelationStudentAsignatura(id_student, id_asignatura);
    }
}
