package com.eminds.employee.employeemicroservice1.dto;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {


    private String usernameOrEmail;


    private String password;
}
