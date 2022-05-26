package com.eminds.employee.employeemicroservice1.dto;

import lombok.*;

@Getter
@Setter
@ToString
public class JwtAuthResponseDto {

    private String accessToken;
    private String tokenType =  "Bearer";


    public JwtAuthResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }
}
