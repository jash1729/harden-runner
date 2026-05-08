# A01 – Broken Access Control

### Overview

This module demonstrates **Broken Access Control** scenarios using a simple **Order** domain.

It shows how access control failures can occur at:

* Controller layer
* Service layer
* Security configuration layer

These issues can exist **even when authentication is enabled**.

The examples highlight how:

* Misconfiguration
* Missing ownership checks
* Incorrect authorization logic

can lead to critical security flaws.

This aligns with **OWASP Top 10 – A01: Broken Access Control**.

### CWEs Covered

* **CWE-862** – Missing Authorization
* **CWE-863** – Incorrect Authorization
* **CWE-283** – Unrestricted Administrative Access
* **CWE-284** – Improper Access Control
* **CWE-285** – Improper Authorization
* **CWE-749** – Exposed Dangerous Method

### Data Model

Each `Order` includes an ownership attribute:

* `createdBy`

This is used to demonstrate:

* IDOR (Insecure Direct Object Reference)
* Authorization failures

Data is initialized deterministically using:

* `schema.sql`
* `data.sql`

This ensures predictable and repeatable security testing.

### Application Profiles

### Vulnerable Profile

**Characteristics**

* Misconfigured `SecurityFilterChain`
* Protected endpoints exposed via configuration
* Missing ownership checks
* Admin operations accessible without proper role enforcement

Used to demonstrate exploitation scenarios.

### Secure Profile

**Characteristics**

* Correct `SecurityFilterChain`
* Authentication enforced for protected endpoints
* Role-based access control enabled
* Ownership validation enforced at the service layer
* Deny-by-default behavior restored

Used to demonstrate proper remediation.

### Vulnerable Endpoints

The following endpoints intentionally violate access control principles:

* `GET /orders/{id}`
* `POST /orders/{id}` (destructive action via incorrect HTTP method)
* `DELETE /orders/admin/purge`

### What Goes Wrong

* Authorization missing or incorrectly enforced
* Resource ownership not validated
* Administrative functionality publicly reachable
* Security decisions embedded incorrectly or skipped
* Misconfigured filter chain bypasses protections

### Secure Endpoints

These endpoints demonstrate correct access control enforcement:

* `GET /secure/orders/{id}`
* `DELETE /secure/orders/{id}`
* `DELETE /secure/orders/admin/purge` (admin only)

### What Was Fixed

* Authentication enforced via Spring Security
* Authorization enforced using roles and ownership checks
* Service-layer access control applied
* Dangerous operations explicitly restricted
* Deny-by-default behavior implemented
* Security configuration corrected

### Security Layers Demonstrated

* Controller layer — missing vs enforced authorization
* Service layer — ownership validation
* Configuration layer — misconfigured vs correct `SecurityFilterChain`
* Data layer — deterministic ownership for testing

### Key Takeaways

Broken Access Control is **not a framework issue**.
It is a **design, configuration, and responsibility issue**.

Authentication alone is insufficient.

Authorization must be:

* Explicit
* Centralized
* Enforced where business decisions are made
* Correctly configured at the framework level

Misconfiguration can be just as dangerous as missing code.
