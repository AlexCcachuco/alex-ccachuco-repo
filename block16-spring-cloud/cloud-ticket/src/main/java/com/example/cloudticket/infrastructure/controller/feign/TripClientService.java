package com.example.cloudticket.infrastructure.controller.feign;

import com.example.cloudticket.domain.entity.Client;
import com.example.cloudticket.domain.entity.Trip;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "tripClientService", url = "http://localhost:8080/")
public interface TripClientService {

    @GetMapping("client/{id}")
    Client getClientById(@PathVariable("id") int id);

    @GetMapping("trip/{id}")
    Trip getTripById(@PathVariable("id") int id);

}
