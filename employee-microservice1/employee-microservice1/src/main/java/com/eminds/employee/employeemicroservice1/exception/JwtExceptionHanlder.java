package com.eminds.employee.employeemicroservice1.exception;

import io.jsonwebtoken.JwtException;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JwtExceptionHanlder extends RuntimeException  {

    private HttpStatus httpStatus;
    private String message;


}
