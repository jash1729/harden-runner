package com.poc.owasp.broken_access_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.owasp.broken_access_control.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}