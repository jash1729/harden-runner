package com.poc.owasp.injection.controller;

import com.poc.owasp.injection.service.SecureInjectionService;
import com.poc.owasp.injection.util.HeaderUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secure/injection")
public class SecureInjectionController {

    private final SecureInjectionService service;

    public SecureInjectionController(SecureInjectionService service) {
        this.service = service;
    }

    // Secure query
    @GetMapping("/search")
    public Object search(@RequestParam String category) {
        return service.searchProducts(category);
    }

    // Secure header handling
    @GetMapping("/header")
    public String header(@RequestParam String value, HttpServletResponse response) {

        HeaderUtil.addHeaderSecure(response, value);

        return "Header added (secure)";
    }
}