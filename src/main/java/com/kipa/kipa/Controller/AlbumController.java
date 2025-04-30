package com.kipa.kipa.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kipa.kipa.Model.Album;
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

    @PostMapping("/album")
    public void saveAlbum(@RequestBody Album album) throws JsonProcessingException {
        album.convertArrayToRawJson();
        service.addAlbum(album);
    }


    @DeleteMapping("/album")
    public void deleteAlbum(@RequestBody Album album) throws JsonProcessingException {
        //album.convertArrayToRawJson();
        service.deleteAlbum(album);
    }
}
