package com.bosonit.block7crudvalidation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestContiguration {

    @Bean("restTemplate")
    public RestTemplate registerRestTemplate(){
        return new RestTemplate();
    }
}
