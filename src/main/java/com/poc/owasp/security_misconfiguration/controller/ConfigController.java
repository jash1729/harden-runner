package com.poc.owasp.security_misconfiguration.controller;

import com.poc.owasp.security_misconfiguration.model.SystemConfig;
import com.poc.owasp.security_misconfiguration.service.ConfigService;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@Profile("vulnerable")
@RequestMapping("/config")
public class ConfigController {

    private final ConfigService service;

    public ConfigController(ConfigService service) {
        this.service = service;
    }

    // CWE-215
    @GetMapping("/debug")
    public SystemConfig debug() {
        return service.getDebugConfig();
    }

    // CWE-552
    @GetMapping("/file")
    public String readFile(@RequestParam String name) throws IOException {
        return service.readFile(name);
    }

    // CWE-284
    @GetMapping("/admin/system-info")
    public Map<String, String> systemInfo() {
        return service.systemInfo();
    }

    // CWE-209
    @GetMapping("/test-error")
    public String error() {
        return service.triggerError();
    }
}