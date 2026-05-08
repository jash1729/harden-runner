package com.poc.owasp.mishandling_of_exceptional_conditions.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.poc.owasp.mishandling_of_exceptional_conditions.model.Order;
import com.poc.owasp.mishandling_of_exceptional_conditions.service.SecureOrderExceptionService;

@RestController
@RequestMapping("/secure/exception/orders")
@Profile("secure")
public class SecureOrderExceptionController {

    private final SecureOrderExceptionService service;

    public SecureOrderExceptionController(SecureOrderExceptionService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return service.getOrder(id);
    }

    // FIX: explicit mapping so missing param = 400, not 404
    @GetMapping
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void missingParam() {
        
    }

    @PostMapping("/{id}/close")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void closeOrder(@PathVariable Long id) {
        service.closeOrder(id);
    }

    @GetMapping("/{id}/debug")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String debug(@PathVariable Long id) {
        return service.debugOrder(id);
    }
}