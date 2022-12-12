package com.bosonit.block7crudvalidation.controller;

import com.bosonit.block7crudvalidation.application.PersonaServiceImpl;
import com.bosonit.block7crudvalidation.application.ProfessorServiceImpl;
import com.bosonit.block7crudvalidation.controller.dto.PersonaDTO;
import com.bosonit.block7crudvalidation.controller.dto.ProfessorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonaController {

    @Autowired
    PersonaServiceImpl personServiceImpl;



    @PostMapping(value = "/addperson")
    public ResponseEntity<PersonaDTO> addPerson(@RequestBody PersonaDTO personaInputDto)   {
         return ResponseEntity.ok(personServiceImpl.addPersona(personaInputDto));
    }
    @GetMapping(value = "/persona/name/{name}")
    public ResponseEntity<?> getStudentOrProfessorByName(@PathVariable String name, @RequestParam(required = false) String outputType){
        if(outputType !=null && !outputType.isBlank()){
            if(outputType.equals("simple")){
                return ResponseEntity.ok().body(Optional.ofNullable(personServiceImpl.getPersonaByName(name)));
            } else if(outputType.equals("full")){
                return ResponseEntity.ok().body(Optional.ofNullable(personServiceImpl.getStudentOrProfessorByName(name)));
            }
        }
        return ResponseEntity.ok().body(Optional.ofNullable(personServiceImpl.getPersonaByName(name)));
    }

    @GetMapping(value = "/getall")
    public List<PersonaDTO> getAll() {
        return personServiceImpl.getAllPersonas();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable int id)  {
            personServiceImpl.getPersonaById(id);
            personServiceImpl.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted correctly!");
    }
    @PutMapping(value = "/persona/{id}")
    public ResponseEntity<PersonaDTO> update(@PathVariable int id, @RequestBody PersonaDTO personaDto){
            return ResponseEntity.ok().body(personServiceImpl.updatePersona(personaDto,id));

    }

    @GetMapping(value = "/persona/{id}")
    public ResponseEntity<?> getStudentOrProfessorByIdPerson(@PathVariable int id, @RequestParam(required = false) String outputType){
        if(outputType !=null && !outputType.isBlank()){
            if(outputType.equals("simple")){
                return ResponseEntity.ok().body(Optional.ofNullable(personServiceImpl.getPersonaById(id)));
            } else if(outputType.equals("full")){
                return ResponseEntity.ok().body(Optional.ofNullable(personServiceImpl.getStudentOrProfessorByIdPersona(id)));
            }
        }
        return ResponseEntity.ok().body(Optional.ofNullable(personServiceImpl.getPersonaById(id)));
    }

     @GetMapping("/persona/profesor/{id}")
    public ResponseEntity<ProfessorDTO> getProfesor(@PathVariable int id){
        return ResponseEntity.ok(personServiceImpl.getProfessorById(id));
    }

    @GetMapping("/persona/profesorFeign/{id}")
    public ResponseEntity<ProfessorDTO> getProfesorByFeign(@PathVariable int id){
        return ResponseEntity.ok(personServiceImpl.getProfessorByIdFeign(id));
    }
}