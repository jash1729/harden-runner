package com.poc.owasp.injection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice(basePackages = "com.poc.owasp.injection")
public class ValidationExceptionHandler {

    // Convert validation errors to HTTP 400
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgument(IllegalArgumentException ex) {
        return ex.getMessage();
    }
}