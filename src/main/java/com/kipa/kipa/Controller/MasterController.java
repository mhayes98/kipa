package com.kipa.kipa.Controller;

import com.kipa.kipa.Model.DiscogsTrack;
import com.kipa.kipa.Service.DiscogsMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;

@RestController
public class MasterController {

    @Autowired
    DiscogsMasterService service;

    @GetMapping("/master/{masterID}")
    public Mono<List<DiscogsTrack>> searchByMasterID(@PathVariable String masterID) {
        return service.getTracklistByMasterID(masterID);
    }
}
