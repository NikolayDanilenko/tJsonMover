package com.example.jsonmover.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> findGroupById(NotFoundException ex) {
        log.error("Group not found: {}",ex.getMessage());

        return ResponseEntity
                .status(404)
                .header("za","lupa")
                .body(new ErrorDto(404,"Group not found"));
    }
}