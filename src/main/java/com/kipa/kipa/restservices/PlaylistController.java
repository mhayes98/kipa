package com.kipa.kipa.restservices;

import org.springframework.web.bind.annotation.*;

// ****
// API paths will need to be refactored --> Obsidian / Kipa / API Endpoint Security / Refactoring Plan
// ***

@RestController
public class PlaylistController {
    @PostMapping("users/{userID}/playlists/generate-playlist")
    public String addPlaylist(@RequestParam String playlistID, @RequestParam String playlist_name) {
        // Placeholder - Generate playlist from Spotify -> Also add to profile, potentially second call
        return playlist_name + " has been added to your profile.";
    }

    @DeleteMapping("users/{userID}/playlists/delete-playlist")
    public String removePlaylist(@RequestParam String playlistID, @RequestParam String playlist_name) {
        // Placeholder - Remove playlist from profile
        return playlist_name + " has been removed from your profile.";
    }
}
