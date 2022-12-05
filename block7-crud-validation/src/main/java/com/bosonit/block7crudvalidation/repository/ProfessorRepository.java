package com.bosonit.block7crudvalidation.repository;

import com.bosonit.block7crudvalidation.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Query(value = "SELECT pf.* FROM PERSONA p, PROFESSOR pf WHERE :id IN (SELECT pf.ID_PERSONA WHERE p.ID_PERSONA  = pf.ID_PERSONA )"
            , nativeQuery = true)
    Professor findProfessorByIdPersona(int id);

    @Query(value = "SELECT pf.* FROM PERSONA p, PROFESSOR pf WHERE :name IN (SELECT p.name WHERE p.ID_PERSONA = pf.ID_PERSONA)",
    nativeQuery = true)
    Professor findByName(String name);
}
