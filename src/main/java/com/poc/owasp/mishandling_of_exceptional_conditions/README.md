# A10 – Mishandling of Exceptional Conditions

### Overview

This module demonstrates **Mishandling of Exceptional Conditions** using a simple **Order processing** flow.

It shows how applications can fail **even when error handling exists**, due to:

* Unchecked assumptions
* Swallowed exceptions
* Generic exception handling
* Missing or incorrect HTTP error mapping
* Leaking internal error details

The examples highlight how:

* Null conditions lead to runtime crashes
* Exceptional business states are ignored
* Errors are hidden instead of handled
* Internal system details are exposed to clients
* Incorrect status codes misrepresent failure conditions

This aligns with **OWASP Top 10 – A10:2021 (Security Logging and Monitoring Failures)** and common error-handling weaknesses.

### CWEs Covered

* **CWE-476** – Null Pointer Dereference
* **CWE-755** – Improper Handling of Exceptional Conditions
* **CWE-703** – Improper Check or Handling of Exceptional Conditions
* **CWE-754** – Improper Check for Unusual or Exceptional Conditions
* **CWE-396** – Catching Generic Exception
* **CWE-397** – Declaration of Throws for Generic Exception
* **CWE-394** – Unexpected Status Code or Return Value
* **CWE-248** – Uncaught Exception
* **CWE-215** – Insertion of Sensitive Information Into Debugging Code
* **CWE-234** – Failure to Handle Missing Parameter

### Domain Model

This module uses a minimal **Order domain** consisting of:

* Order ID
* Order status

The domain is intentionally simple to focus on **exceptional behavior**, not business complexity.

In-memory deterministic data is used to ensure **predictable and repeatable testing**.

### Application Profiles

### Vulnerable Profile

**Characteristics**

* Null assumptions instead of validation
* Exceptions used as control flow
* Generic `catch (Exception)` blocks
* Exceptional business conditions silently ignored
* Internal error messages returned to clients
* HTTP status codes misrepresent failures

Used to demonstrate **crash behavior, information disclosure, and silent failure scenarios**.

### Secure Profile

**Characteristics**

* Explicit validation of inputs and state
* Exceptional conditions handled intentionally
* Fail-fast behavior for invalid operations
* Correct HTTP status codes returned
* Internal system details not exposed to clients
* Error handling treated as a design concern

Used to demonstrate **proper remediation and predictable failure handling**.

### Vulnerable Endpoints

The following endpoints intentionally demonstrate improper exception handling:

* `GET /exception/orders/{id}`
* `GET /exception/orders`
* `POST /exception/orders/{id}/close`
* `GET /exception/orders/{id}/debug`

These endpoints appear functional but fail under unexpected or invalid conditions.

### What Goes Wrong

* Missing validation causes runtime crashes
* Errors are swallowed and execution continues
* Exceptional states are treated as success
* Internal system details leak through error messages
* HTTP responses do not reflect real failure conditions
* Clients cannot reliably distinguish success from failure

### Secure Endpoints

These endpoints demonstrate corrected exception handling behavior:

* `GET /secure/exception/orders/{id}`
* `GET /secure/exception/orders`
* `POST /secure/exception/orders/{id}/close`
* `GET /secure/exception/orders/{id}/debug`

The functionality remains the same, but error handling and response semantics differ.

### What Was Fixed

* Replaced null assumptions with explicit checks
* Eliminated exception-driven control flow
* Removed generic exception swallowing
* Introduced clear failure paths
* Corrected HTTP status codes
* Sanitized error responses
* Made exceptional conditions visible and intentional

### Security Areas Demonstrated

* Error handling design
* Exception propagation
* Business rule enforcement
* HTTP status code correctness
* Information disclosure via errors
* Fail-fast vs silent failure behavior

### Key Takeaways

Mishandling of exceptional conditions is **not caused by missing try/catch blocks**.

It occurs when errors are:

* Hidden
* Ignored
* Misclassified
* Used as control flow
* Exposed to untrusted clients

Exception handling must be:

* Intentional
* Explicit
* Predictable
* Aligned with HTTP semantics
* Treated as a security boundary

Failing silently is often **more dangerous than failing loudly**.
