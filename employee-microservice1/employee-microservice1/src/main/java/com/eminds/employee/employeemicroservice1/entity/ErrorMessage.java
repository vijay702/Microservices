package com.eminds.employee.employeemicroservice1.entity;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private HttpStatus httpStatus;
    private String message;


}
