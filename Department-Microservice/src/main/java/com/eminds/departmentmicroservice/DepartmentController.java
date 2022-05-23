package com.eminds.departmentmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DepartmentController {

	@Autowired
	private RestTemplate restTemplate;
	
	
	
@GetMapping("/department")
public String departmentDetail() {
	
	String user = restTemplate.getForObject("http://localhost:8080/user", String.class);
	
	return user;
	
}
	

}
