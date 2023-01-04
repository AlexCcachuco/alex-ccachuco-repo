package com.example.cloudclienttrip;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class CloudClientTripApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudClientTripApplication.class, args);
	}


}
