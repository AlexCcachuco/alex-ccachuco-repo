package com.bosonit.block7crudvalidation.controller;


import com.bosonit.block7crudvalidation.controller.dto.PersonaDTO;
import com.bosonit.block7crudvalidation.domain.Persona;
import com.bosonit.block7crudvalidation.repository.PersonaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonaControllerTest {

     @Autowired
     private PersonaRepository personaRepo;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    void addAsignatura() throws Exception {

        PersonaDTO p1 = new PersonaDTO();
        p1.setId_persona(1);
        p1.setUsuario("alex154");
        p1.setPassword("abc123");
        p1.setName("Alexander");
        p1.setSurname("Suarez");
        p1.setCompany_email("prueba");
        p1.setPersonal_email("prueba");
        p1.setCity("Santiago");
        p1.setImagen_url("imagen");
        p1.setCreated_date(new Date());

        RequestBuilder request = MockMvcRequestBuilders.post("/addperson")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(p1));

        mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    }

    @Test
    void getAll() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/getall")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    void deletePersona() throws Exception{

        Persona p2 = new Persona();
        p2.setId_persona(1);
        p2.setUsuario("alex154");
        p2.setPassword("abc123");
        p2.setName("Alexander");
        p2.setSurname("Suarez");
        p2.setCompany_email("prueba");
        p2.setPersonal_email("prueba");
        p2.setCity("Santiago");
        p2.setImagen_url("imagen");

        Persona persona = personaRepo.save(p2);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/"+ persona.getId_persona())
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());

    }

    @Test
    void update() throws Exception{

        Persona p1 = new Persona();
        p1.setId_persona(1);
        p1.setUsuario("alex154");
        p1.setPassword("abc123");
        p1.setName("Alexander");
        p1.setSurname("Suarez");
        p1.setCompany_email("prueba");
        p1.setPersonal_email("prueba");
        p1.setCity("Santiago");
        p1.setImagen_url("imagen");

        Persona persona = personaRepo.save(p1);
        p1.setName("Alex");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/persona/" + persona.getId_persona())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(p1));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    void allPersonByPage() throws Exception{


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/person/page")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("page","1")
                .param("pageSize", "1");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getById() throws Exception {

        Persona p1 = new Persona();
        p1.setId_persona(7);
        p1.setUsuario("alex154");
        p1.setPassword("abc123");
        p1.setName("Alexander");
        p1.setSurname("Suarez");
        p1.setCompany_email("prueba");
        p1.setPersonal_email("prueba");
        p1.setCity("Santiago");
        p1.setImagen_url("imagen");
        p1.setCreated_date(new Date());

        personaRepo.save(p1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/persona/" + p1.getId_persona())
                .accept(MediaType.APPLICATION_JSON);


        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();
    }

}