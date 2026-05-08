package com.poc.owasp.security_misconfiguration.controller;

import com.poc.owasp.security_misconfiguration.service.SecureConfigService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/secure/config")
public class SecureConfigController {

    private final SecureConfigService service;

    public SecureConfigController(SecureConfigService service) {
        this.service = service;
    }

    @GetMapping("/debug")
    public Object debug() {
        return service.getDebugConfig();
    }

    @GetMapping("/file")
    public String readFile(@RequestParam String name) {
        return service.readFile(name);
    }

    @GetMapping("/admin/system-info")
    public Map<String,String> systemInfo() {
        return service.systemInfo();
    }

    @GetMapping("/test-error")
    public String error() {
        return service.triggerError();
    }
}