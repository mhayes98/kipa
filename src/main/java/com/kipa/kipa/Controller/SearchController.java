package com.kipa.kipa.Controller;

import com.kipa.kipa.Service.ExternalAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    ExternalAPIService service;

    @GetMapping("/search/master")
    public void searchByMaster(@RequestBody String master) {
         service.searchDiscogsByMaster(master);
    }

    @GetMapping("search/artist")
    public void searchByArtist(@RequestBody String artist) {
        service.searchDiscogsByArtist(artist);
    }
}
