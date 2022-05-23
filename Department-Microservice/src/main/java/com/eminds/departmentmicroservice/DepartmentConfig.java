package com.eminds.departmentmicroservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DepartmentConfig {
	
	@Bean
	public RestTemplate getRestTemplate() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		return restTemplate;
	}
	
	

}
