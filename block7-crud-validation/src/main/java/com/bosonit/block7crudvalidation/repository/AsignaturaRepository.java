package com.bosonit.block7crudvalidation.repository;

import com.bosonit.block7crudvalidation.domain.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {

    @Query(value = "SELECT a.* FROM ASIGNATURAS_ESTUDIANTES ae JOIN ASIGNATURA a ON ae.ASIGNATURAS_ID_STUDY = a.ID_STUDY WHERE STUDENT_ID_STUDENT = :id", nativeQuery = true)
    List<Asignatura> asignaturasByStudentId(int id);
}
