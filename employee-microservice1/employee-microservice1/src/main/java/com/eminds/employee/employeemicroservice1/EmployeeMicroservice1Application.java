package com.eminds.employee.employeemicroservice1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeMicroservice1Application {


		@Bean
		public ModelMapper modelMapper (){
			return  new ModelMapper();

		}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMicroservice1Application.class, args);
	}

}
