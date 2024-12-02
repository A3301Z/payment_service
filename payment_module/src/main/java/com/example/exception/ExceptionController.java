package com.example.exception;

import lombok.RequiredArgsConstructor;
import org.example.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.naming.InsufficientResourcesException;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionController {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> notFoundException(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
    @ExceptionHandler(InsufficientResourcesException.class)
    public ResponseEntity<String> insufficientResourcesException(InsufficientResourcesException exception) {
        return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(exception.getMessage());
    }
}