package com.kipa.kipa.restservices;

import org.springframework.web.bind.annotation.*;

// ****
// API paths will need to be refactored --> Obsidian / Kipa / API Endpoint Security / Refactoring Plan
// ***

@RestController
public class UserController {

    // The line below is commented for future educational use.
    // An atomic long is a thread-safe way to handle frequent updates
        // ex. multiple clients updating the value at once if it were to track the number of times an API was called

    //private final AtomicLong counter = new AtomicLong();

    @PostMapping("/users/add-user")
    public String addUser(@RequestParam String userID) {
        // Placeholder - Add user to DB
        return "Hello, " + userID + "!";
    }

    @DeleteMapping("/users/delete-user")
    public String deleteUser(@RequestParam String userID) {
        // Placeholder - Delete user from DB
        return userID + " has been deleted.";
    }

    @GetMapping("/spotify-auth")
    public String spotifyAuthConnection() {
        // Placeholder - Authenticate user with Spotify OAuth
        return "Redirecting to: SpotifyAuthURL";
    }

    @GetMapping("/spotify-callback")
    public String spotifyAuthCallback() {
        // Placeholder - Exchange auth code for access token
    return "Redirecting to: /user/profile";
    }

    @PostMapping("/users/{userID}/albums/add-tag")
    public String addAlbumTag(@RequestParam String albumID) {
        // Placeholder - Add tag to album
        // Default features like "Owned", "Want", "Hot, etc.. will all be treated as tags
        return albumID + " added tp 'Owned'";
    }

    @DeleteMapping("/users/{userID}/albums/remove-tag")
    public String removeAlbumTag(@RequestParam String albumID) {
        // Placeholder - Remove tag from album
        // Default features like "Owned", "Want", "Hot, etc.. will all be treated as tags
        return albumID + " removed from 'Owned'";
    }

}