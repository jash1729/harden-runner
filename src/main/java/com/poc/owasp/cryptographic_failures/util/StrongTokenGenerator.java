package com.poc.owasp.cryptographic_failures.util;

import java.security.SecureRandom;
import java.util.Base64;

public class StrongTokenGenerator {

    // CWE-340, CWE-1241
    // Cryptographically secure random number generator used
    public static String generate() {
        byte[] bytes = new byte[32];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}