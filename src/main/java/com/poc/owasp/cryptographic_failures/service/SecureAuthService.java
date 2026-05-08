package com.poc.owasp.cryptographic_failures.service;

import com.poc.owasp.cryptographic_failures.model.LoginRequest;
import com.poc.owasp.cryptographic_failures.util.StrongPasswordUtil;
import com.poc.owasp.cryptographic_failures.util.StrongTokenGenerator;
import org.springframework.stereotype.Service;

@Service
public class SecureAuthService {

    // CWE-261, CWE-328
    // Password protected using strong one-way hashing
    // Reversible encoding and weak hashing eliminated
    public String login(LoginRequest req) {
        return StrongPasswordUtil.hash(req.password());
    }

    // CWE-340, CWE-1241
    // Token generation uses cryptographically secure randomness
    // Predictable token generation eliminated
    public String resetToken(String username) {
        return StrongTokenGenerator.generate();
    }
}