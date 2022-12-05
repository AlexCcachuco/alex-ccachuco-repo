package com.bosonit.block7crudvalidation;

import com.bosonit.block7crudvalidation.controller.dto.ProfessorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simpleFeign", url = "http://localhost:8080/")
public interface IFeignProfessor {

    @GetMapping("profesor/{id}")
    ProfessorDTO callProfessor(@PathVariable int id);
}
