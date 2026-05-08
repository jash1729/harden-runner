package com.poc.owasp.mishandling_of_exceptional_conditions.service;

import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.poc.owasp.mishandling_of_exceptional_conditions.exception.OrderNotFoundException;
import com.poc.owasp.mishandling_of_exceptional_conditions.model.Order;

@Service
@Profile("secure")
public class SecureOrderExceptionService {

    private static final Map<Long, Order> ORDERS = Map.of(
        1L, new Order(1L, "CREATED")
    );

    // CWE-476 FIXED, CWE-248 FIXED
    public Order getOrder(Long id) {
        Order order = ORDERS.get(id);
        if (order == null) {
            throw new OrderNotFoundException(id);
        }
        return order;
    }

    // CWE-755 FIXED
    public void closeOrder(Long id) {
        throw new IllegalStateException("Order cannot be closed");
    }

    // CWE-215 FIXED
    public String debugOrder(Long id) {
        throw new RuntimeException("Internal server error");
    }
}