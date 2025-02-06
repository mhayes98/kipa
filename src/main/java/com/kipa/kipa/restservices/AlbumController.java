package com.kipa.kipa.restservices;

import org.springframework.web.bind.annotation.*;

@RestController
public class AlbumController {

    @GetMapping("/albums")
    public Album getAlbumDetails(@RequestParam Album albumID) {
        // Placeholder - Get album details from Spotify / Discogs API (?)
        return albumID;
    }
}
