package com.example.examen_JPA_cascade.controller;

import com.example.examen_JPA_cascade.controller.dto.FacturaDTO;
import com.example.examen_JPA_cascade.controller.dto.LineaInputDTO;
import com.example.examen_JPA_cascade.domain.CabeceraFra;
import com.example.examen_JPA_cascade.domain.Cliente;
import com.example.examen_JPA_cascade.domain.LineasFra;
import com.example.examen_JPA_cascade.domain.application.CabeceraFraImpl;
import com.example.examen_JPA_cascade.domain.application.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacturaController {

    @Autowired
    ClienteServiceImpl clienteServiceImpl;

    @Autowired
    CabeceraFraImpl cabeceraFraImpl;

    @Bean
    public void run(){
        Cliente cliente = new Cliente(0, "Alvaro");
        clienteServiceImpl.addCliente(cliente);

        LineasFra lineaFra1 = new LineasFra(0 ,"Mesa", 1, 20.00);
        LineasFra lineaFra2 = new LineasFra(0 ,"Silla", 2, 10.00);

        CabeceraFra cabecera = new CabeceraFra(0, cliente, lineaFra1.getPrecio()+ lineaFra2.getPrecio());

        List<LineasFra> lineas_factura = cabecera.getLineas();
        lineas_factura.add(lineaFra1);
        lineas_factura.add(lineaFra2);

        cabecera.setLineas(lineas_factura);
        cabeceraFraImpl.addFactura(cabecera);

    }

    @GetMapping(value = "/factura")
    public List<FacturaDTO> getFacturas(){
        return cabeceraFraImpl.getFacturas();
    }

    @DeleteMapping(value = "/factura/{id}")
    public ResponseEntity deleteFactura(@PathVariable int id){
        try{
            cabeceraFraImpl.deleteFactura(id);
            return ResponseEntity.ok().body("Deleted Correctly");
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/factura/linea/{id}")
    public ResponseEntity<FacturaDTO> addLinea(@RequestBody LineaInputDTO linea, @PathVariable int id){
        try{
            return ResponseEntity.ok(cabeceraFraImpl.addLineaToFactura(linea, id));
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }

    }

}
