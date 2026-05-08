package com.poc.owasp.cryptographic_failures.service;

import com.poc.owasp.cryptographic_failures.model.LoginRequest;
import com.poc.owasp.cryptographic_failures.util.WeakPasswordUtil;
import com.poc.owasp.cryptographic_failures.util.WeakTokenGenerator;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // CWE-261, CWE-328
    // Password transformed using reversible encoding and weak hashing algorithm
    public String login(LoginRequest req) {
        String encoded = WeakPasswordUtil.base64(req.password());
        return WeakPasswordUtil.md5(encoded);
    }

    // CWE-340, CWE-1241
    // Reset token generated using predictable and non-cryptographic randomness
    public String resetToken(String username) {
        return WeakTokenGenerator.generate(username);
    }

}