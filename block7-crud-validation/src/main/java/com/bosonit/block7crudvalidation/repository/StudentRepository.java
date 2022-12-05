package com.bosonit.block7crudvalidation.repository;

import com.bosonit.block7crudvalidation.controller.dto.StudentFullDTO;
import com.bosonit.block7crudvalidation.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = ("SELECT e.* FROM PERSONA p, ESTUDIANTES e WHERE :id IN (SELECT e.ID_PERSONA WHERE p.ID_PERSONA = e.ID_PERSONA)")
    , nativeQuery = true)
    Student findStudentByIdPersona(int id);

    @Query(value = ("SELECT e.* FROM PERSONA p, ESTUDIANTES e WHERE :name IN (SELECT p.name WHERE p.ID_PERSONA = e.ID_PERSONA)")
            , nativeQuery = true)
    Student findByName(String name);
}
