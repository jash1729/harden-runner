package com.poc.owasp.injection.controller;

import com.poc.owasp.injection.service.VulnerableInjectionService;
import com.poc.owasp.injection.util.HeaderUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/injection")
public class InjectionController {

    private final VulnerableInjectionService service;

    public InjectionController(VulnerableInjectionService service) {
        this.service = service;
    }

    // CWE-564 SQL Injection
    @GetMapping("/search")
    public Object search(@RequestParam String category) {
        return service.searchProducts(category);
    }

    // CWE-644 Header Injection
    @GetMapping("/header")
    public String header(@RequestParam String value, HttpServletResponse response) {

        HeaderUtil.addHeaderVulnerable(response, value);

        return "Header added (vulnerable)";
    }
}