package com.example.examen_JPA_cascade.domain.application;

import com.example.examen_JPA_cascade.controller.dto.FacturaDTO;
import com.example.examen_JPA_cascade.controller.dto.LineaInputDTO;
import com.example.examen_JPA_cascade.domain.CabeceraFra;
import com.example.examen_JPA_cascade.domain.LineasFra;
import com.example.examen_JPA_cascade.domain.application.mapper.FacturaMapper;
import com.example.examen_JPA_cascade.respository.CabeceraFraRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabeceraFraImpl implements CabeceraFraService{

    @Autowired
    CabeceraFraRepository cabeceraFraRepository;

    FacturaMapper mapper = Mappers.getMapper(FacturaMapper.class);

    public void addFactura(CabeceraFra cabeceraFra){
        cabeceraFraRepository.save(cabeceraFra);
    }

    //Eliminar factura por ID
    public boolean deleteFactura(int id){
        if(cabeceraFraRepository.findById(id) == null) return false;
        cabeceraFraRepository.deleteById(id);
        return true;
    }

    //Obtener todas las facturas
    public List<FacturaDTO> getFacturas(){
       return  mapper.map(cabeceraFraRepository.findAll());
    }

    //Añadir una linea nueva a una factura indicada por id
    public FacturaDTO addLineaToFactura(LineaInputDTO linea, int id) {
                CabeceraFra factura = cabeceraFraRepository.findById(id).orElseThrow();
                //Obtener todas las lineas de una factura
                List<LineasFra> lineas = factura.getLineas();
                // Añadir nueva linea ya mapeada
                lineas.add(mapper.lineaInputDtoToLineasFra(linea));
                //Calculo el importe total de la factura
                updatePrice(factura);
                // Guardo la factura de nuevo en la bd
                cabeceraFraRepository.save(factura);
                return mapper.cabeceraFraToFacturaDTO(factura);
    }

    //Actualizar importe total de factura
    public CabeceraFra updatePrice(CabeceraFra cabeceraFra){
        List<LineasFra> lineas = cabeceraFra.getLineas();
        double total = 0;
        // Suma de todos los precios por las cantidades de cada linea
        for(LineasFra linea : lineas){
             total += linea.getPrecio()*linea.getCantidad();
        }
        cabeceraFra.setImporteFra(total);
        return cabeceraFra;
    }


}
