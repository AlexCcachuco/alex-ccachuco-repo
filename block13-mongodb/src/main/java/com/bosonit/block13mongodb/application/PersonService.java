package com.bosonit.block13mongodb.application;

import com.bosonit.block13mongodb.domain.Person;
import com.bosonit.block13mongodb.infrastructure.dto.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    PersonDTO createPerson(PersonDTO personDto);
    void deletePersonById(String id);
    PersonDTO getPersonById(String id);
    List<PersonDTO> getAllPersons();
    PersonDTO updatePerson(PersonDTO personDto, String id);
}
