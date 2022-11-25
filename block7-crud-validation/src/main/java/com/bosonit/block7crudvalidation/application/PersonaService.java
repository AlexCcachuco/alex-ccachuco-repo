package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.controller.dto.PersonaInputDto;

public interface PersonaService {
    void addPersona(PersonaInputDto personaInputDto) throws Exception;
}
