package com.bosonit.block7crudvalidation.controller;

import com.bosonit.block7crudvalidation.application.ProfessorServiceImpl;
import com.bosonit.block7crudvalidation.controller.dto.ProfessorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/profesor")
public class ProfessorController {

    @Autowired
    ProfessorServiceImpl profesorServiceImp;

    @PostMapping
    public ProfessorDTO addProfesor(@RequestBody ProfessorDTO profesorDto){
        return profesorServiceImp.addProfesor(profesorDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProfessorDTO> getById(@PathVariable int id){
        return ResponseEntity.ok(profesorServiceImp.getProfessorById(id));
    }

    @GetMapping(value = "/all")
    public List<ProfessorDTO> getAll(){
        return profesorServiceImp.getAllProfessor();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProfessor(@PathVariable int id){
        profesorServiceImp.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted correctly");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProfessorDTO> update(@RequestBody ProfessorDTO professorDTO, @PathVariable int id){
        return ResponseEntity.ok().body(profesorServiceImp.updateProfessor(professorDTO, id));
    }
}
