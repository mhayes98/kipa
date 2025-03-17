# **Security Configuration**

___

### Endpoint Security

There are two open endpoints, `/login` and `/register`

All other Kipa endpoints require authentication to access.

___

### Security Filters

`sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))`

Stateless session management.

`.csrf(customizer -> customizer.disable())`

Cross-Site Forgery diabled.

___

### JWT Filter

By default, Kipa will priortize JWT for authentication over prompting the user to enter their login credentials.

If a JWT is detected and validated, then the user will be authenticated without any action taken by them. If a JWT is not detected or cannot be validated (tampered with, expired, etc..) then they will be prompted to entier their username and password again.

`JWTFilter.doFilterInternal()` will check for a JWT in the header of an HTTP request with the correct prefix. If detected, it will:

* Extract the username using `JWTService.extractUsername()`


* Checks `SecurityContext` for an authentication object for the extraced username. If one does not exist, the token will need to be validated.


* `JWTService.validateToken()` is called to validate the JWT (not expired, correctly signed, etc..)


* If the validation succeeds an authentication object, `UsernamePasswordAuthenticationToken`, is created and stored in `SecurityContext`


* Request is approved, and the user may proceed. All requests from that point until the JWT expires will be authenticated by the `UsernamePasswordAuthenticationToken`.