package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.controller.dto.PersonaInputDto;
import com.bosonit.block7crudvalidation.controller.dto.PersonaOutputDto;

public interface PersonaService {
    PersonaOutputDto addPersona(PersonaInputDto personaInputDto) throws Exception;
}
