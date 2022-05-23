package com.eminds.usermicroservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserConrtoller {
	
	@GetMapping("/user")
	public String userDetails() {
		
		
		return "Hello Am User";
		
		
	}
	
	

}
