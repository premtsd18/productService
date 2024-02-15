package com.example.productservice.controllerAdvices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class controllerAdvice {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> arithmeticException(){
        return new ResponseEntity<>("Error Occured",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
