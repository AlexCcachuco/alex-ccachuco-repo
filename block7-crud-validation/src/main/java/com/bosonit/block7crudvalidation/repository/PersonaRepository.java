package com.bosonit.block7crudvalidation.repository;

import com.bosonit.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.bosonit.block7crudvalidation.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Optional<Persona> findByUsuario(String name);

}