package com.poc.owasp.mishandling_of_exceptional_conditions.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import com.poc.owasp.mishandling_of_exceptional_conditions.model.Order;
import com.poc.owasp.mishandling_of_exceptional_conditions.service.OrderExceptionService;

@RestController
@RequestMapping("/exception/orders")
@Profile("vulnerable")
public class OrderExceptionController {

    private final OrderExceptionService service;

    public OrderExceptionController(OrderExceptionService service) {
        this.service = service;
    }

    // CWE-476, CWE-248
    // Null Pointer Dereference – missing order not handled
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return service.getOrder(id);
    }

    // CWE-234
    // Missing required parameter (framework rejects request)
    @GetMapping
    public Order find(@RequestParam Long id) {
        return service.getOrder(id);
    }

    // CWE-755, CWE-703
    // Exceptional condition swallowed, operation appears successful
    @PostMapping("/{id}/close")
    public void closeOrder(@PathVariable Long id) {
        service.closeOrder(id);
    }

    // CWE-396, CWE-215
    // Generic exception handling with sensitive information disclosure
    @GetMapping("/{id}/debug")
    public String debug(@PathVariable Long id) {
        return service.debugOrder(id);
    }
}