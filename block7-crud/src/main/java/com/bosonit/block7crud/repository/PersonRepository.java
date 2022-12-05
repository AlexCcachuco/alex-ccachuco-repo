package com.bosonit.block7crud.repository;

import com.bosonit.block7crud.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByName(String name);

}