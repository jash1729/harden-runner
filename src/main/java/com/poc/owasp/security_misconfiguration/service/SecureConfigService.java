package com.poc.owasp.security_misconfiguration.service;

import com.poc.owasp.security_misconfiguration.model.SystemConfig;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SecureConfigService {

    public SystemConfig getDebugConfig() {
        return new SystemConfig(
                "secure",
                "hidden",
                "hidden"
        );
    }

    public String readFile(String name) {
        return "File access disabled";
    }

    public Map<String, String> systemInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("java", System.getProperty("java.version"));
        info.put("os", System.getProperty("os.name"));
        return info;
    }

    public String triggerError() {
        throw new RuntimeException("Internal server error");
    }
}