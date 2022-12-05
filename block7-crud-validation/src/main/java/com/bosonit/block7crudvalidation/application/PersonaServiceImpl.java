package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.IFeignProfessor;
import com.bosonit.block7crudvalidation.controller.dto.PersonaDTO;
import com.bosonit.block7crudvalidation.controller.dto.PersonaProfessorListDTO;
import com.bosonit.block7crudvalidation.controller.dto.ProfessorDTO;
import com.bosonit.block7crudvalidation.domain.Persona;
import com.bosonit.block7crudvalidation.domain.Professor;
import com.bosonit.block7crudvalidation.domain.Student;
import com.bosonit.block7crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.bosonit.block7crudvalidation.application.mapper.PersonaMapper;
import com.bosonit.block7crudvalidation.application.mapper.ProfessorMapper;
import com.bosonit.block7crudvalidation.application.mapper.StudentMapper;
import com.bosonit.block7crudvalidation.repository.PersonaRepository;
import com.bosonit.block7crudvalidation.repository.ProfessorRepository;
import com.bosonit.block7crudvalidation.repository.StudentRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository personaRepo;
    @Autowired
    StudentRepository studentRepo;
    @Autowired
    ProfessorRepository professorRepo;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    IFeignProfessor feignProfessor;

    PersonaMapper mapper = Mappers.getMapper(PersonaMapper.class);
    StudentMapper mapperStudent= Mappers.getMapper(StudentMapper.class);
    ProfessorMapper mapperProfessor = Mappers.getMapper(ProfessorMapper.class);

    public PersonaDTO addPersona(PersonaDTO personaDto)   {
        checkInputData(personaDto);
        Persona persona = mapper.personaDtoToPersona(personaDto);
        personaRepo.save(persona);
        return mapper.personaToPersonaDTO(persona);
    }

    public PersonaDTO getPersonaById(int id){
        Persona persona = personaRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Person not found! Try another id"));
        return mapper.personaToPersonaDTO(persona);
    }

    public PersonaDTO getPersonaByName(String name){
        Persona persona = personaRepo.findByName(name).orElseThrow(()-> new EntityNotFoundException("Person not found! Try another name"));
        return mapper.personaToPersonaDTO(persona);
    }

    public List<PersonaDTO> getAllPersonas(){
        return mapper.map(personaRepo.findAll());
    }

    public void deleteById(int id){
        personaRepo.deleteById(id);
    }

    public PersonaDTO updatePersona(PersonaDTO personaInputDto, int id){
        personaRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Person not found! Try another id"));
        checkInputData(personaInputDto);
        Persona persona = mapper.personaDtoToPersona(personaInputDto);
        persona.setId_persona(id);
        personaRepo.save(persona);
        return mapper.personaToPersonaDTO(persona);
    }

    public void checkInputData(PersonaDTO persona){
        if(Objects.isNull(persona.getUsuario()) || persona.getUsuario().isBlank()){
            throw new UnprocessableEntityException("Username cant be null or empty");
        } else if(persona.getUsuario().length() > 10){
            throw new UnprocessableEntityException("Username length cannot be more than 10");
        }
    }


    public Optional<?> getStudentOrProfessorByIdPersona(int id){
        //Obtengo student o professor mediante su id
        Student student = studentRepo.findStudentByIdPersona(id);
        Professor professor = professorRepo.findProfessorByIdPersona(id);
        // Si estudiante no es null, mapea y envia sus datos
        // Si estudiante es null, mapea y envia professor
        return (!Objects.isNull(student)) ?
                Optional.ofNullable(mapperStudent.studentToPersonaStudentDTO(student)) :
                Optional.ofNullable(mapperProfessor.studentToPersonaProfessorDTO(professor));
    }

    public Optional<?> getStudentOrProfessorByName(String name){
        //Obtengo student o professor mediante su id
        Student student = studentRepo.findByName(name);
        Professor professor = professorRepo.findByName(name);
        // Si estudiante no es null, mapea y envia sus datos
        // Si estudiante es null, mapea y envia professor
        return (!Objects.isNull(student)) ?
                Optional.ofNullable(mapperStudent.studentToPersonaStudentDTO(student)) :
                Optional.ofNullable(mapperProfessor.studentToPersonaProfessorDTO(professor));
    }


    public ProfessorDTO getProfessorById(int id){
        ProfessorDTO professor = restTemplate.getForObject("http://localhost:8080/profesor/{id}", ProfessorDTO.class, id);
        return professor;
    }
    public ProfessorDTO getProfessorByIdFeign(int id){
        ProfessorDTO professorDTO = feignProfessor.callProfessor(id);
        return professorDTO;
    }
}
