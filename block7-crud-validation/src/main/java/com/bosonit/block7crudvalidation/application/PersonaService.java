package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.controller.dto.PersonaDTO;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    PersonaDTO addPersona(PersonaDTO personaInputDto);
    PersonaDTO getPersonaById(int id);
    public PersonaDTO getPersonaByName(String name);
    public List<PersonaDTO> getAllPersonas();
    public void deleteById(int id);
    public PersonaDTO updatePersona(PersonaDTO personaInputDto, int id);
    public Optional<?> getStudentOrProfessorByIdPersona(int id);
    public Optional<?> getStudentOrProfessorByName(String name);

}
