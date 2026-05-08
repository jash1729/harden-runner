package com.poc.owasp.mishandling_of_exceptional_conditions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// CWE-248
// Explicit HTTP mapping instead of uncaught exception
@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super("Order not found: " + id);
    }
}