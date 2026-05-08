# A05 – Security Misconfiguration

### Overview

This module demonstrates **Security Misconfiguration** scenarios using simple configuration and system endpoints.

It shows how security issues can occur due to:

* Incorrect framework configuration
* Exposed internal endpoints
* Improper access restrictions
* Unsafe error handling

These issues often arise **even when authentication and authorization mechanisms exist**, but are misconfigured.

The examples highlight how:

* Debug endpoints
* File access functionality
* Administrative operations
* Error responses

can expose sensitive information when security controls are not properly configured.

This aligns with **OWASP Top 10 – A05: Security Misconfiguration**.

### CWEs Covered

* **CWE-16** – Configuration
* **CWE-209** – Information Exposure Through Error Messages
* **CWE-215** – Information Exposure Through Debug Information
* **CWE-284** – Improper Access Control
* **CWE-552** – Files or Directories Accessible to External Parties

### Application Profiles

### Vulnerable Profile

**Characteristics**

* Internal configuration endpoints exposed publicly
* Debug information returned to users
* Arbitrary file access allowed
* Administrative endpoints accessible without proper role checks
* Error messages expose internal system details

Used to demonstrate common security misconfiguration scenarios.

### Secure Profile

**Characteristics**

* Access to configuration endpoints restricted
* Role-based access control applied to administrative operations
* File access functionality disabled
* Debug information removed
* Error messages sanitized to avoid leaking system details

Used to demonstrate proper remediation.

### Vulnerable Endpoints

The following endpoints intentionally expose sensitive functionality:

* `GET /config/debug`
* `GET /config/file`
* `GET /config/admin/system-info`
* `GET /config/test-error`

### What Goes Wrong

* Internal debugging information exposed to clients
* Sensitive files accessible via public endpoints
* Administrative operations reachable without proper restrictions
* Error responses reveal internal system behavior
* Security decisions left to application logic instead of configuration

These issues typically arise from **incorrect or incomplete security configuration**.

### Secure Endpoints

These endpoints demonstrate properly secured implementations:

* `GET /secure/config/debug`
* `GET /secure/config/file`
* `GET /secure/config/admin/system-info`
* `GET /secure/config/test-error`

### What Was Fixed

* Configuration endpoints protected by authentication
* Administrative operations restricted to specific roles
* File access functionality disabled
* Debug information removed from responses
* Error handling centralized and sanitized
* Security configuration updated to enforce correct access rules

### Security Layers Demonstrated

* Controller layer — exposed vs restricted endpoints
* Service layer — secure handling of system operations
* Configuration layer — misconfigured vs correct `SecurityFilterChain`
* Error handling layer — information leakage vs sanitized responses

### Key Takeaways

Security Misconfiguration is **one of the most common and dangerous application vulnerabilities**.

It often occurs when:

* Default configurations are left unchanged
* Internal functionality is exposed unintentionally
* Debug features remain enabled in production
* Security rules are incomplete or inconsistent

Security must be enforced through **correct configuration, restricted access, and careful error handling**.

Misconfiguration can expose critical system information **even when the application logic itself is correct**.