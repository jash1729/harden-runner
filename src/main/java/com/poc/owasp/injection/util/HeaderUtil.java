package com.poc.owasp.injection.util;

import jakarta.servlet.http.HttpServletResponse;

public class HeaderUtil {

    // CWE-644
    // Improper Neutralization of HTTP Headers
    public static void addHeaderVulnerable(HttpServletResponse response, String value) {
        response.setHeader("X-Demo-User", value);
    }

    // Secure version
    public static void addHeaderSecure(HttpServletResponse response, String value) {

        if (value == null) {
            response.setHeader("X-Demo-User", "");
            return;
        }

        String sanitized = value.replace("\r", "").replace("\n", "");

        response.setHeader("X-Demo-User", sanitized);
    }
}