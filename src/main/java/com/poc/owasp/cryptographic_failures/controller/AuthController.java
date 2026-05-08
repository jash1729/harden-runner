package com.poc.owasp.cryptographic_failures.controller;

import com.poc.owasp.cryptographic_failures.model.LoginRequest;
import com.poc.owasp.cryptographic_failures.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crypto")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // CWE-319, CWE-523
    // Authentication endpoint exposed with improper handling of sensitive credentials
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    // CWE-340, CWE-1241
    // Token generation endpoint exposed with predictable cryptographic behavior
    @PostMapping("/reset-token")
    public String reset(@RequestBody LoginRequest request) {
        return authService.resetToken(request.username());
    }
}