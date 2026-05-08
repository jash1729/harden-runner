package com.poc.owasp.cryptographic_failures.util;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.HexFormat;

// Weak password protection using reversible encoding and weak hashing
// Demonstrates misuse of Base64 encoding and MD5 for password handling
public class WeakPasswordUtil {

    // CWE-261, CWE-328
    public static String base64(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    // CWE-261, CWE-328
    public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return HexFormat.of().formatHex(md.digest(input.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}