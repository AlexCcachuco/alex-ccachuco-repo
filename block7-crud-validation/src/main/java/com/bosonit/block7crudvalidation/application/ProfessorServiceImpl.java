package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.controller.dto.ProfessorDTO;
import com.bosonit.block7crudvalidation.domain.Professor;
import com.bosonit.block7crudvalidation.application.mapper.ProfessorMapper;
import com.bosonit.block7crudvalidation.repository.ProfessorRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    ProfessorRepository professorRepo;

    ProfessorMapper mapper = Mappers.getMapper(ProfessorMapper.class);

    public ProfessorDTO addProfesor(ProfessorDTO profesorDto){
        Professor professor = mapper.profesorDtoToProfesor(profesorDto);
        professorRepo.save(professor);
        return mapper.profesorToProfesorDTO(professor);
    }

    public ProfessorDTO getProfessorById(int id){
        Professor professor = professorRepo.findById(id).orElseThrow();
        return mapper.profesorToProfesorDTO(professor);
    }

    public List<ProfessorDTO> getAllProfessor(){
        return mapper.map(professorRepo.findAll());
    }

    public void deleteById(int id){
        professorRepo.deleteById(id);
    }

    public ProfessorDTO updateProfessor(ProfessorDTO professorDto, int id){
        Professor professor = mapper.profesorDtoToProfesor(professorDto);
        professor.setId(id);
        professorRepo.save(professor);
        return mapper.profesorToProfesorDTO(professor);
    }


}
