# **User Authentication** 

___

### High Level Overview

**1.** User inputs username and password, this information is sent to the backend.


**2.** Backend retrieves a stored user that matches the requested username


**3.** The provided password is hashed (12 strength BCrypt), and compared to the stored hashed password.


**4.** If the user input credentials match what is stored in the database, a JWT token is generated, then sent back to the user.


**5.** Further requests will include the JWT, and protected endpoints will check the JWT for validity or expiration.


**6.** If the JWT is valid, the request proceeds without needing to input the username and password. If the request is not valid, access is denied.

___

### Step-By-Step

___


All Kipa API's, except `/login`, and `/register`, will require authentication. Authentication can be accomplished by **login credentials** (username and password), or by **JWT**.

JWT will always be the prioritized authentication method; however, the user _**MUST**_ enter their login credentials on the first authentication request to generate a JWT.

The JWT will be sent back to the user and will be included in all future authentication requests. The JWT will still undergo a verification process, but it will be done without user intervention. 

If a JWT is not included in the authentication request, fails verification, or is found to have been expired, then the user will once again need to enter their username and password.

___

All Kipa API's, except `/login`, and `/register`, will require authentication. The first time a user attempts to reach any authorized endpoint, they will be prompted to enter their login credentials.

The credentials that the user enters will be sent to `@POST /login` in `UserController`, in the form of a `User` object, containing a username and password. While users are prompted to include an email in registration, this value is _not_ used in the login process.

The `User` object will be passed to `UserService.verifyUser()` to be authenticated.

___

