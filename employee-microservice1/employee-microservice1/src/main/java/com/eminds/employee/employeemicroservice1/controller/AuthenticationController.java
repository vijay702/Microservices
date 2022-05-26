package com.eminds.employee.employeemicroservice1.controller;

import com.eminds.employee.employeemicroservice1.dto.JwtAuthResponseDto;
import com.eminds.employee.employeemicroservice1.dto.LoginDto;
import com.eminds.employee.employeemicroservice1.dto.RegisterDto;
import com.eminds.employee.employeemicroservice1.exception.DataAlreadyExistsException;
import com.eminds.employee.employeemicroservice1.security.JwtTokenProvider;
import com.eminds.employee.employeemicroservice1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public ResponseEntity<RegisterDto> registerUser(@RequestBody RegisterDto registerDto) throws DataAlreadyExistsException {

      return new  ResponseEntity <> (userService.registerUser(registerDto), HttpStatus.CREATED);

    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponseDto> authenticateUser( @RequestBody LoginDto loginDto){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                (loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // get a token from token provider
        String token = jwtTokenProvider.generateToken(authentication);

        return   ResponseEntity.ok(new JwtAuthResponseDto(token));
    }




}
