package com.bosonit.block13mongodb.infrastructure.mapper;

import com.bosonit.block13mongodb.domain.Person;
import com.bosonit.block13mongodb.infrastructure.dto.PersonDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonDTO personToPersonDTO(Person person);

    Person personDtoToPerson(PersonDTO personDTO);

    List<PersonDTO> map(List<Person> listPerson);

}
