package com.poc.owasp.mishandling_of_exceptional_conditions.service;

import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.poc.owasp.mishandling_of_exceptional_conditions.model.Order;

@Service
@Profile("vulnerable")
public class OrderExceptionService {

    private static final Map<Long, Order> ORDERS = Map.of(
        1L, new Order(1L, "CREATED")
    );

    // CWE-476, CWE-248
    // Null dereference when order is missing
    public Order getOrder(Long id) {
        Order order = ORDERS.get(id); // may be null
        return new Order(order.getId(), order.getStatus());
    }

    // CWE-755, CWE-703, CWE-754
    // Exceptional condition swallowed
    public void closeOrder(Long id) {
        try {
            Order order = ORDERS.get(id);
            order.getStatus().equals("CREATED");
        } catch (Exception e) {
            // swallowed
        }
    }

    // CWE-396, CWE-215
    // Generic exception with sensitive info leakage
    public String debugOrder(Long id) {
        try {
            throw new RuntimeException("DB constraint violation for order " + id);
        } catch (Exception e) {
            return "ERROR: " + e.getMessage();
        }
    }
}