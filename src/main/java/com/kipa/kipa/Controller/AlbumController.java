package com.kipa.kipa.Controller;

import com.kipa.kipa.Model.Album;
import org.springframework.web.bind.annotation.*;

// ****
// API paths will need to be refactored --> Obsidian / Kipa / API Endpoint Security / Refactoring Plan
// ***

@RestController
public class AlbumController {

    @GetMapping("/albums")
    public String getAlbumDetails() {
        // Placeholder - Get album details from Spotify / Discogs API (?)
        return "GOOD";
    }
}
