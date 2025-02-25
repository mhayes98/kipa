package com.kipa.kipa.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

// ****
// API paths will need to be refactored --> Obsidian / Kipa / API Endpoint Security / Refactoring Plan
// ***

@RestController
public class AuthController {

        /*
    @PostMapping("/api/auth/spotify/login")
    public String spotifyAuthRequest() {
        // Placeholder - Authenticate user with Spotify
        return "Redirecting to: Spotify Auth URL";
    }

    @GetMapping("/ap/auth/spotify/callback")
    public String spotifyAuthCallback() {
        // Placeholder - Exchange auth code for access token
    return "Redirecting to: /user/profile";
    }
        */

    /*
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

     */

    /* Auth logic:
        - UsernamePasswordAuthenticationToken is sent to AuthenticationManager (abstracted)
        - AuthenticationManager uses DaoAuthenticationProvider for authentication
        - DaoAuthenticationProvider calls UserDetailsService to fetch user details from the DB
        - Authentication success/failure is sent back to this endpoint
     */

    /*
    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequest loginRequest) {
        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(), loginRequest.password());
        Authentication authenticationResponse =
                this.authenticationManager.authenticate(authenticationRequest);
        // Placeholder return value
        return null;
    }

    public record LoginRequest(String username, String password) {}

     */
}
