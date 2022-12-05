package com.bosonit.block7crudvalidation.application.mapper;

import com.bosonit.block7crudvalidation.controller.dto.AsignaturaDTO;
import com.bosonit.block7crudvalidation.controller.dto.AsignaturaWithStudentsDTO;
import com.bosonit.block7crudvalidation.domain.Asignatura;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface AsignaturaMapper {

    AsignaturaDTO asignaturaToAsignaturaDTO(Asignatura asignatura);

    Asignatura asignaturaDtoToAsignatura(AsignaturaDTO asignaturaDTO);

    AsignaturaWithStudentsDTO asignaturaToAsignaturaWithStudentsDto(Asignatura asignatura);

    List<AsignaturaDTO> map(List<Asignatura> asignaturas);
}
