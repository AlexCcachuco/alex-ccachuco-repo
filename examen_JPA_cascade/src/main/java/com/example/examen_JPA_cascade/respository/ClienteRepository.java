package com.example.examen_JPA_cascade.respository;

import com.example.examen_JPA_cascade.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
