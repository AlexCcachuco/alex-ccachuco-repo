package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.application.mapper.AsignaturaMapper;
import com.bosonit.block7crudvalidation.application.mapper.StudentMapper;
import com.bosonit.block7crudvalidation.controller.dto.AsignaturaDTO;
import com.bosonit.block7crudvalidation.domain.Asignatura;
import com.bosonit.block7crudvalidation.domain.Persona;
import com.bosonit.block7crudvalidation.domain.Professor;
import com.bosonit.block7crudvalidation.domain.Student;
import com.bosonit.block7crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.block7crudvalidation.repository.AsignaturaRepository;
import com.bosonit.block7crudvalidation.repository.ProfessorRepository;
import com.bosonit.block7crudvalidation.repository.StudentRepository;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{

    @Autowired
    AsignaturaRepository asignaturaRepo;

    @Autowired
    ProfessorRepository professorRepo;

    @Autowired
    StudentRepository studentRepo;

    AsignaturaMapper mapper = Mappers.getMapper(AsignaturaMapper.class);


    public AsignaturaDTO addAsignatura(AsignaturaDTO asignaturaDTO){
        asignaturaDTO.setInitial_date((asignaturaDTO.getInitial_date() == null) ? new Date() : asignaturaDTO.getInitial_date());
        asignaturaDTO.setFinish_date((asignaturaDTO.getFinish_date() == null) ? new Date(): asignaturaDTO.getFinish_date());
        Asignatura asignatura = mapper.asignaturaDtoToAsignatura(asignaturaDTO);
        asignaturaRepo.save(asignatura);
        return mapper.asignaturaToAsignaturaDTO(asignatura);
    }

    public AsignaturaDTO getAsignaturaById(int id){
        Asignatura asignatura = asignaturaRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Person not found! Try another id"));
        return mapper.asignaturaToAsignaturaDTO(asignatura);
    }

    public List<AsignaturaDTO> getAll(){
        return mapper.map(asignaturaRepo.findAll());
    }

    public void deleteById(int id){
        asignaturaRepo.deleteById(id);
    }

    public AsignaturaDTO updateAsignatura(AsignaturaDTO asignaturaDTO, int id){
        asignaturaRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Person not found! Try another id"));
        Asignatura asignatura = mapper.asignaturaDtoToAsignatura(asignaturaDTO);
        asignatura.setId_study(id);
        asignaturaRepo.save(asignatura);
        return mapper.asignaturaToAsignaturaDTO(asignatura);
    }

    public List<AsignaturaDTO> getAllByStudentId(int id){
        return mapper.map(asignaturaRepo.asignaturasByStudentId(id));
    }

}
