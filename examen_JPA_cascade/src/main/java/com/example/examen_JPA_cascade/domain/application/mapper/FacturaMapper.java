package com.example.examen_JPA_cascade.domain.application.mapper;

import com.example.examen_JPA_cascade.controller.dto.FacturaDTO;
import com.example.examen_JPA_cascade.controller.dto.LineaInputDTO;
import com.example.examen_JPA_cascade.controller.dto.LineaOutputDTO;
import com.example.examen_JPA_cascade.domain.CabeceraFra;
import com.example.examen_JPA_cascade.domain.LineasFra;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface FacturaMapper {

    @Mapping(source = "proNomb", target = "producto")
    @Mapping(source = "precio", target = "importe")
    LineaOutputDTO cabeceraFraToLineaOutputDto(LineasFra lineasFra);

    @Mapping(source = "cliente",target = "cliente")
    @Mapping(source = "lineas", target = "lineaOutputDTOList")
    FacturaDTO cabeceraFraToFacturaDTO(CabeceraFra cabeceraFra);

    @Mapping(source = "producto", target = "proNomb")
    @Mapping(source = "importe", target = "precio")
    LineasFra lineaInputDtoToLineasFra(LineaInputDTO lineaDto);

    List<FacturaDTO> map(List<CabeceraFra> listaFacturas);
}
