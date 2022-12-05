package com.bosonit.block7crudvalidation.application.mapper;

import com.bosonit.block7crudvalidation.controller.dto.PersonaDTO;
import com.bosonit.block7crudvalidation.controller.dto.PersonaStudentDTO;
import com.bosonit.block7crudvalidation.domain.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PersonaMapper {

    @Mapping(target = "password", ignore = true)
    PersonaDTO personaToPersonaDTO(Persona persona);

    Persona personaDtoToPersona(PersonaDTO personaDTO);

    List<PersonaDTO> map(List<Persona> personas);

}
