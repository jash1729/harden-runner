package com.poc.owasp.security_misconfiguration.service;

import com.poc.owasp.security_misconfiguration.model.SystemConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Service
public class ConfigService {

    @Value("${spring.profiles.active:default}")
    private String profile;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    // CWE-215
    // Debug information exposed
    public SystemConfig getDebugConfig() {

        return new SystemConfig(
                profile,
                dbUrl,
                System.getProperty("java.version")
        );
    }

    // CWE-552
    // Arbitrary file read
    public String readFile(String name) throws IOException {

        return Files.readString(Path.of(name));
    }

    // CWE-284
    // Admin endpoint without authentication
    public Map<String, String> systemInfo() {

        Map<String, String> info = new HashMap<>();

        info.put("java", System.getProperty("java.version"));
        info.put("os", System.getProperty("os.name"));
        info.put("user", System.getProperty("user.name"));

        return info;
    }

    // CWE-209
    // Error leakage example
    public String triggerError() {

        throw new RuntimeException("Database connection failed at jdbc:h2:mem:testdb");
    }
}