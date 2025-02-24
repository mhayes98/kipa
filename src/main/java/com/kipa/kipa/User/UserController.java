package com.kipa.kipa.User;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
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

    @Autowired
    UserService service;

    /*
    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

     */

    @PostMapping("/users/add-user")
    public void addUser(@RequestBody User user) {
        service.addUser(user);
    }

    @DeleteMapping("/users/delete-user")
    public String deleteUser(@RequestParam String userID) {
        // Placeholder - Delete user from DB
        return userID + " has been deleted.";
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