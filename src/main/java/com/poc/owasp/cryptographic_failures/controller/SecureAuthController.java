package com.poc.owasp.cryptographic_failures.controller;

import com.poc.owasp.cryptographic_failures.model.LoginRequest;
import com.poc.owasp.cryptographic_failures.service.SecureAuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secure/crypto")
public class SecureAuthController {

    private final SecureAuthService service;

    public SecureAuthController(SecureAuthService service) {
        this.service = service;
    }

    // CWE-319, CWE-523
    // Sensitive credentials processed using secure cryptographic primitives
    // Cleartext and weak handling eliminated
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return service.login(request);
    }

    // CWE-340, CWE-1241
    // Secure token generation endpoint
    // Unpredictable tokens returned
    @PostMapping("/reset-token")
    public String reset(@RequestBody LoginRequest request) {
        return service.resetToken(request.username());
    }
}