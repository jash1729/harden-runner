package com.poc.owasp.injection.service;

import com.poc.owasp.injection.repository.ProductRepository;
import com.poc.owasp.injection.util.InputValidator;
import org.springframework.stereotype.Service;

@Service
public class SecureInjectionService {

    private final ProductRepository repository;

    public SecureInjectionService(ProductRepository repository) {
        this.repository = repository;
    }

    // Secure version using validation + parameterized query
    public Object searchProducts(String category) {

        InputValidator.validateCategory(category);

        return repository.findByCategory(category);
    }
}