package com.bosonit.block10dockerize.application;

import com.bosonit.block10dockerize.domain.Person;
import com.bosonit.block10dockerize.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    public void createPerson(Person person){
        personRepository.save(person);
    }

    public void delete(int id){
        personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);
    }

    public Person getPersonById(int id){
        return personRepository.findById(id).orElseThrow();
    }

    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }


    @Override
    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }
}
