package com.bosonit.block7crudvalidation.controller;

import com.bosonit.block7crudvalidation.application.AsignaturaServiceImpl;
import com.bosonit.block7crudvalidation.controller.dto.AsignaturaDTO;
import com.bosonit.block7crudvalidation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {

    @Autowired
    AsignaturaServiceImpl asignaturaServiceImpl;

    @PostMapping
    public ResponseEntity<AsignaturaDTO> addAsignatura(@RequestBody AsignaturaDTO asignaturaDTO){
        return ResponseEntity.ok(asignaturaServiceImpl.addAsignatura(asignaturaDTO));
    }

    @GetMapping("/all")
    public List<AsignaturaDTO> getAll(){ return asignaturaServiceImpl.getAll();}

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteAsignatura(@PathVariable int id) {
        asignaturaServiceImpl.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Correctly");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AsignaturaDTO> update(@PathVariable int id, @RequestBody AsignaturaDTO asignaturaDTO){
        return ResponseEntity.ok().body(asignaturaServiceImpl.updateAsignatura(asignaturaDTO, id));
    }

    @GetMapping(value = "/AllByIdStudent/{id}")
    public List<AsignaturaDTO> getAllByStudentId(@PathVariable int id){
        return asignaturaServiceImpl.getAllByStudentId(id);
    }


}
