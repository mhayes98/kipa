package com.kipa.kipa.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kipa.kipa.Model.JoinedAlbumUserAlbumDTO;
import com.kipa.kipa.Model.UserAlbumDTO;
import com.kipa.kipa.Model.UserAlbumStatusRequest;
import com.kipa.kipa.Repo.AlbumRepository;
import com.kipa.kipa.Service.AlbumService;
import com.kipa.kipa.Service.UserAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserAlbumController {

    @Autowired
    UserAlbumService service;

    @Autowired
    AlbumRepository albumRepo;
    @Autowired
    AlbumService albumService;

    @PostMapping("/user-album")
    public void editTags(@RequestBody UserAlbumDTO userAlbumDTO) throws JsonProcessingException {
        if(albumRepo.findAlbumByAlbumID(userAlbumDTO.getAlbum().getAlbumID()) == null) {
            userAlbumDTO.getAlbum().convertArrayToRawJson();
            albumService.addAlbum(userAlbumDTO.getAlbum());
        }
        service.addUserAlbum(userAlbumDTO.getUserAlbum());
    }

    @PostMapping("/status")
    public void editStatus(@RequestBody UserAlbumStatusRequest userAlbumStatusRequest) {
        service.editStatus(userAlbumStatusRequest);
    }

    @PutMapping("/tag")
    public void editTags(@RequestBody UserAlbumStatusRequest userAlbumStatusRequest) {
        service.editTags(userAlbumStatusRequest);
    }

    @PutMapping("/notes")
    public void editNotes(@RequestBody UserAlbumStatusRequest userAlbumStatusRequest) {
        service.editNotes(userAlbumStatusRequest);
    }

    @GetMapping("/user-albums/{username}")
    public void getMySavedAlbums(@PathVariable String username) {
        //System.out.println(service.getMySavedAlbums(username));
        List<JoinedAlbumUserAlbumDTO> testing = service.getMySavedAlbums(username);
        int counter = 0;
        for (JoinedAlbumUserAlbumDTO x : testing) {
            System.out.println("\n\n___________TESTING_____________");
            // Displays first song from each album - Needs fixed
            System.out.println("TRACK #" + counter + "  --->  " + x.getTracklist().get(0).gettrackName() + " : " + x.getTracklist().get(0).getDuration());
            System.out.println("___________TESTING_____________\n\n");
            counter++;
        }
    }

    @GetMapping("/debug")
    public void getRawQueryResults() {
        service.debugServiceMethod();
    }
}
