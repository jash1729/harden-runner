# A03 – Injection

### Overview

This module demonstrates **Injection vulnerabilities** in a Spring Boot application.

Injection occurs when **untrusted input is interpreted as part of a command or query**, allowing attackers to manipulate backend execution.

The examples show how injection can occur due to:

* Direct string concatenation in queries
* Missing input validation
* Weak blacklist filtering
* Improper neutralization of special characters
* Unsafe handling of HTTP headers

Both **vulnerable and secure implementations** are provided.

This aligns with **OWASP Top 10 – A03: Injection**.

### CWEs Covered

CWE-20 – Improper Input Validation
CWE-138 – Improper Neutralization of Special Elements
CWE-184 – Incomplete List of Disallowed Inputs
CWE-564 – SQL Injection (Hibernate)
CWE-644 – Improper Neutralization of HTTP Headers
CWE-652 – XQuery Injection

### Vulnerable Endpoints

The following endpoints intentionally demonstrate injection flaws:

* `GET /injection/search`
* `GET /injection/header`

### What Goes Wrong

User input is directly used inside queries.

Problems include:

* Dynamic SQL query construction
* Missing validation
* Weak blacklist filters
* Improper header handling

These issues allow attackers to manipulate backend behavior.

### Secure Endpoints

The following endpoints demonstrate correct mitigation techniques:

* `GET /secure/injection/search`
* `GET /secure/injection/header`

### What Was Fixed

* Parameterized queries implemented
* Input validation enforced
* Allow-list validation applied
* CRLF characters sanitized in headers
* Unsafe query concatenation removed

### Key Takeaways

Injection vulnerabilities arise when **applications trust user input too much**.

Effective mitigation requires:

* Strict input validation
* Parameterized queries
* Proper output encoding
* Avoiding dynamic query construction
* Sanitizing data used in headers and commands

Injection vulnerabilities are **preventable through safe coding practices and framework features**.
