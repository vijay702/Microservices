package com.eminds.employee.employeemicroservice1.dto;

import com.eminds.employee.employeemicroservice1.entity.Role;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class RegisterDto {

    private String name;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles;


}
