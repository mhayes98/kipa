package com.kipa.kipa.Controller;

import com.kipa.kipa.Model.User;
import com.kipa.kipa.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// ****
// API paths will need to be refactored --> Obsidian / Kipa / API Endpoint Security / Refactoring Plan
// ***

@RestController
public class UserController {


    @Autowired
    UserService service;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        // Refactor to account for unique usernames
        // OR add ID to usernames (ex. Matt#1)
        service.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return service.verifyUser(user);
    }

    /*
    @PostMapping("/users/add-user")
    public void addUser(@RequestBody User user) {
        service.addUser(user);
    }

     */

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