package com.poc.owasp.injection.util;

public class InputValidator {

    // CWE-20
    // Improper Input Validation
    public static void validateCategory(String category) {

        if (category == null || category.length() > 30) {
            throw new IllegalArgumentException("Invalid category");
        }

        if (!category.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Invalid characters");
        }
    }
}