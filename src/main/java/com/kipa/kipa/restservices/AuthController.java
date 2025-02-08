package com.kipa.kipa.restservices;

import org.springframework.web.bind.annotation.*;

// ****
// API paths will need to be refactored --> Obsidian / Kipa / API Endpoint Security / Refactoring Plan
// ***

@RestController
public class AuthController {

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
}
