package com.bosonit.block7crudvalidation.application.mapper;

import com.bosonit.block7crudvalidation.controller.dto.PersonaProfessorDTO;
import com.bosonit.block7crudvalidation.controller.dto.PersonaProfessorListDTO;
import com.bosonit.block7crudvalidation.controller.dto.PersonaStudentDTO;
import com.bosonit.block7crudvalidation.controller.dto.ProfessorDTO;
import com.bosonit.block7crudvalidation.domain.Professor;
import com.bosonit.block7crudvalidation.domain.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ProfessorMapper {


    @Mapping(source = "persona.id_persona", target = "id_persona")
    ProfessorDTO profesorToProfesorDTO(Professor profesor);

    @Mapping(source="id_persona", target ="persona.id_persona")
    Professor profesorDtoToProfesor(ProfessorDTO profesorDto);

    @Mapping(source = "persona", target = "persona")
    PersonaProfessorDTO studentToPersonaProfessorDTO(Professor professor);

    List<ProfessorDTO> map(List<Professor> profesores);

    @Mapping(source = "persona", target = "persona")
    List<PersonaProfessorListDTO> mapPersonProfessor(List<Professor> professors);

}
