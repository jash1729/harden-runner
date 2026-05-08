# A04 – Cryptographic Failures

### Overview

This module demonstrates **Cryptographic Failures** using a simple **authentication and token generation** flow.

It shows how security can fail **even when cryptographic functions are present**, due to:

* Weak algorithms
* Reversible transformations
* Predictable randomness
* Incorrect use of cryptographic primitives

The examples highlight how:

* Encoding is mistaken for encryption
* Inappropriate hashing algorithms are used
* Tokens are generated predictably
* Non-cryptographic randomness is applied to security-critical data

This aligns with **OWASP Top 10 – A04: Cryptographic Failures**.

### CWEs Covered

* **CWE-319** – Cleartext Transmission of Sensitive Information
* **CWE-523** – Unprotected Transport of Credentials
* **CWE-261** – Weak Encoding for Password
* **CWE-328** – Reversible or Weak Hash
* **CWE-340** – Generation of Predictable Tokens
* **CWE-1241** – Use of Predictable Random Number Generator

### Domain Model

This module uses a simple **authentication domain** consisting of:

* Username
* Password
* Reset token

The flow is intentionally minimal to focus on **cryptographic behavior**, not business complexity.

### Application Profiles

### Vulnerable Profile

**Characteristics**

* Credentials accepted over insecure transport
* Passwords transformed using reversible encoding (Base64)
* Weak hashing algorithm used (MD5)
* Reset tokens generated using predictable randomness
* Token generation tied to user-controlled input

Used to demonstrate cryptographic misuse and exploitation scenarios.

### Secure Profile

**Characteristics**

* Cryptographic primitives used correctly
* Passwords hashed using a strong one-way algorithm (BCrypt)
* Randomness generated using `SecureRandom`
* Tokens generated with sufficient entropy
* Reversible and predictable operations eliminated

Used to demonstrate proper cryptographic remediation.

### Vulnerable Endpoints

The following endpoints intentionally demonstrate cryptographic failures:

* `POST /crypto/login`
* `POST /crypto/reset-token`

These endpoints are reachable without authentication to simulate real-world login and recovery flows.

### What Goes Wrong

* Encoding is incorrectly used as a security mechanism
* Weak hashing algorithms are applied to sensitive data
* Secrets are transformed but remain recoverable
* Token values are predictable and repeatable
* Randomness is unsuitable for security use
* Cryptographic intent is misunderstood or misapplied

### Secure Endpoints

These endpoints demonstrate corrected cryptographic behavior:

* `POST /secure/crypto/login`
* `POST /secure/crypto/reset-token`

The functionality remains the same, but cryptographic choices differ.

### What Was Fixed

* Replaced reversible encoding with one-way password hashing
* Eliminated weak hashing algorithms
* Introduced cryptographically secure randomness
* Removed predictability from token generation
* Ensured secrets cannot be derived or replayed
* Applied cryptography appropriate to the security context

### Security Areas Demonstrated

* Credential handling
* Password storage and transformation
* Token generation and entropy
* Random number generation
* Cryptographic misuse vs correct usage

### Key Takeaways

Cryptographic failures are **not caused by missing crypto**.

They occur when cryptography is:

* Misunderstood
* Misapplied
* Used with inappropriate algorithms
* Applied without considering threat models

Strong cryptography must be:

* One-way where required
* Non-reversible
* Unpredictable
* Purpose-built for security

Using cryptography incorrectly can be as dangerous as not using it at all.
