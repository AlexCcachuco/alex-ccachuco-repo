package com.bosonit.block13mongodb.infrastructure.repository;

import com.bosonit.block13mongodb.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
