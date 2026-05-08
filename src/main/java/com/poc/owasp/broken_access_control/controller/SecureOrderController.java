package com.poc.owasp.broken_access_control.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.poc.owasp.broken_access_control.model.Order;
import com.poc.owasp.broken_access_control.service.SecureOrderService;

@RestController
@RequestMapping("/secure/orders")
public class SecureOrderController {

    private final SecureOrderService service;

    public SecureOrderController(SecureOrderService service) {
        this.service = service;
    }

    // CWE-862, CWE-863
    // Ownership enforced using authenticated principal
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return service.getOrderForCurrentUser(id);
    }

    // CWE-863, CWE-285
    // Authorization enforced before deletion
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteOrderForCurrentUser(id);
    }

    // CWE-283, CWE-285
    // Role-based restriction for administrative operation
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/admin/purge")
    public void purgeAll() {
        service.deleteAllOrders();
    }
}