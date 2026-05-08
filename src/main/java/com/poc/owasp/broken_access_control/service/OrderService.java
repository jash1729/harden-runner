package com.poc.owasp.broken_access_control.service;

import org.springframework.stereotype.Service;

import com.poc.owasp.broken_access_control.model.Order;
import com.poc.owasp.broken_access_control.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    // CWE-862, CWE-863
    // No authorization at service layer
    public Order getOrder(Long id) {
        return repository.findById(id).orElseThrow();
    }

    // CWE-863, CWE-285
    // Destructive action without access control
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }

    // CWE-283
    // Unrestricted administrative operation
    public void deleteAllOrders() {
        repository.deleteAll();
    }
}