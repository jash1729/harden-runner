package com.poc.owasp.cryptographic_failures.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class StrongPasswordUtil {

    // CWE-261, CWE-328
    // Strong one-way password hashing used
    // Reversible encoding and weak hashing prevented
    public static String hash(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}