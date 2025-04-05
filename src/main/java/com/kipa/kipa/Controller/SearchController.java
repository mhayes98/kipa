package com.kipa.kipa.Controller;

import com.kipa.kipa.Model.DiscogsSearchResponse;
import com.kipa.kipa.Service.DiscogsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.util.Collection;
import java.util.List;


@RestController
public class SearchController {

    @Autowired
    DiscogsSearchService service;

    @GetMapping("/search/master")
    public Collection<DiscogsSearchResponse> searchByMaster(@RequestParam String q, @RequestParam String type) {
        return service.searchDiscogsByMaster(q);
    }

    @GetMapping("search/artist")
    public Collection<DiscogsSearchResponse> searchByArtist(@RequestParam String artist) {
        return service.searchDiscogsByArtist(artist);
    }
}
