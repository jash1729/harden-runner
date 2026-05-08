package com.poc.owasp.cryptographic_failures.util;

import java.util.Random;

// CWE-340, CWE-1241
// Predictable token generation using non-cryptographic random number generator
// Token values are deterministic and guessable
public class WeakTokenGenerator {

    public static String generate(String username) {
        Random random = new Random(username.hashCode());
        return username + "-" + random.nextInt(10000);
    }
}