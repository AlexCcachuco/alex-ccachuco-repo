package com.bosonit.block13mongodb.application;

import com.bosonit.block13mongodb.domain.Person;
import com.bosonit.block13mongodb.infrastructure.dto.PersonDTO;
import com.bosonit.block13mongodb.infrastructure.mapper.PersonMapper;
import com.bosonit.block13mongodb.infrastructure.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;
    PersonMapper mapper = Mappers.getMapper(PersonMapper.class);

    @Override
    public PersonDTO createPerson(PersonDTO personDto) {

        Person person = mapper.personDtoToPerson(personDto);
        return mapper.personToPersonDTO(personRepository.save(person));
    }

    @Override
    public void deletePersonById(String id) {
        System.out.println("gello");
        personRepository.deleteById(id);
    }

    @Override
    public PersonDTO getPersonById(String id) {

        Person person = personRepository.findById(id).orElseThrow();
        return mapper.personToPersonDTO(person);
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        return mapper.map(personRepository.findAll());
    }

    @Override
    public PersonDTO updatePerson(PersonDTO personDto, String id) {
        personRepository.findById(id).orElseThrow();
        Person newPerson = mapper.personDtoToPerson(personDto);
        newPerson.setId(id);
        personRepository.save(newPerson);
        return mapper.personToPersonDTO(newPerson);
    }
}
