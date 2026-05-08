package com.poc.owasp.broken_access_control.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.poc.owasp.broken_access_control.model.Order;
import com.poc.owasp.broken_access_control.repository.OrderRepository;

@Service
public class SecureOrderService {

    private final OrderRepository repository;

    public SecureOrderService(OrderRepository repository) {
        this.repository = repository;
    }

    // CWE-862, CWE-863
    // Ownership validated against authenticated user
    public Order getOrderForCurrentUser(Long id) {
        Order order = repository.findById(id).orElseThrow();
        String user = currentUser();

        if (!user.equals(order.getCreatedBy())) {
            throw new RuntimeException("Access denied");
        }
        return order;
    }

    // CWE-863, CWE-285
    // Authorization enforced before deletion
    public void deleteOrderForCurrentUser(Long id) {
        Order order = repository.findById(id).orElseThrow();
        String user = currentUser();

        if (!user.equals(order.getCreatedBy())) {
            throw new RuntimeException("Access denied");
        }
        repository.deleteById(id);
    }

    // CWE-283
    // Protected by role at controller layer
    public void deleteAllOrders() {
        repository.deleteAll();
    }

    private String currentUser() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
    }
}