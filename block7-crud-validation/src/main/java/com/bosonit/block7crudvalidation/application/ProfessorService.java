package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.controller.dto.ProfessorDTO;

import java.util.List;

public interface ProfessorService {

    public ProfessorDTO addProfesor(ProfessorDTO profesorDto);
    public ProfessorDTO getProfessorById(int id);
    public List<ProfessorDTO> getAllProfessor();
    public void deleteById(int id);
    public ProfessorDTO updateProfessor(ProfessorDTO professorDTO, int id);



}
