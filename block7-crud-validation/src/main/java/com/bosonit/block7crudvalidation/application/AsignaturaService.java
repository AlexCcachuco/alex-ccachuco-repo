package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.controller.dto.AsignaturaDTO;

import java.util.List;

public interface AsignaturaService {

    public AsignaturaDTO addAsignatura(AsignaturaDTO asignaturaDTO);
    public AsignaturaDTO getAsignaturaById(int id);
    public List<AsignaturaDTO> getAll();
    public void deleteById(int id);
    public AsignaturaDTO updateAsignatura(AsignaturaDTO asignaturaDTO, int id);

}
