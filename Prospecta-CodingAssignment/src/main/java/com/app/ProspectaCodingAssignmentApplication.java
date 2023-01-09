package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProspectaCodingAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProspectaCodingAssignmentApplication.class, args);
	}
	
	
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate() ; 
	}
}
