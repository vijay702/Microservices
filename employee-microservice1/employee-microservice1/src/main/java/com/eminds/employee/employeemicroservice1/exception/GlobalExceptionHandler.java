package com.eminds.employee.employeemicroservice1.exception;

import com.eminds.employee.employeemicroservice1.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler {



    @ExceptionHandler(DataAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> dataNotFoundException(DataAlreadyExistsException exception , WebRequest webRequest){

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.CONFLICT,exception.getMessage());

        return   ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);


    }


}
