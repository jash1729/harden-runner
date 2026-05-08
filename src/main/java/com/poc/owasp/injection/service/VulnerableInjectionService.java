package com.poc.owasp.injection.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VulnerableInjectionService {

    @PersistenceContext
    private EntityManager entityManager;

    // CWE-564
    // SQL Injection using dynamic query
    public List<?> searchProducts(String category) {

        String query = "SELECT * FROM product WHERE category = '" + category + "'";

        return entityManager.createNativeQuery(query).getResultList();
    }

    // CWE-184
    // Weak blacklist
    public boolean isSafe(String input) {
        return !input.contains("'");
    }
}