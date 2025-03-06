package com.kipa.kipa.Controller;

import com.kipa.kipa.Model.Album;
import com.kipa.kipa.Model.User;
import com.kipa.kipa.Service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// ****
// API paths will need to be refactored --> Obsidian / Kipa / API Endpoint Security / Refactoring Plan
// ***

@RestController
public class AlbumController {

    @Autowired
    AlbumService service;

    @GetMapping("/albums")
    public String getAlbumDetails() {
        // Placeholder - Get album details from Spotify / Discogs API (?)
        return "GOOD";
    }

    @PostMapping("/album")
    public void tagAlbum(@RequestBody Album album) {
        service.addAlbum(album);
    }

    @DeleteMapping("/album")
    public void deleteAlbum(@RequestBody Album album) {
        service.deleteAlbum(album);
    }
}
