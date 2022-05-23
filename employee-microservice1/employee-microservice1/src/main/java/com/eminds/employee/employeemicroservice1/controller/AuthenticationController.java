package com.eminds.employee.employeemicroservice1.controller;

import com.eminds.employee.employeemicroservice1.dto.RegisterDto;
import com.eminds.employee.employeemicroservice1.exception.DataAlreadyExistsException;
import com.eminds.employee.employeemicroservice1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {


    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterDto> registerUser(@RequestBody RegisterDto registerDto) throws DataAlreadyExistsException {

      return new  ResponseEntity <> (userService.registerUser(registerDto), HttpStatus.CREATED);

    }


}
