package com.poc.owasp.broken_access_control.controller;

import org.springframework.web.bind.annotation.*;

import com.poc.owasp.broken_access_control.model.Order;
import com.poc.owasp.broken_access_control.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    // CWE-862, CWE-863
    // No ownership or authorization check
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return service.getOrder(id);
    }

    // CWE-863, CWE-285
    // Destructive operation allowed via POST
    @PostMapping("/{id}")
    public void deleteViaPost(@PathVariable Long id) {
        service.deleteOrder(id);
    }

    // CWE-283, CWE-285
    // Admin operation without role enforcement
    @DeleteMapping("/admin/purge")
    public void purgeAll() {
        service.deleteAllOrders();
    }
}