package com.kipa.kipa.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kipa.kipa.Model.DiscogsTrack;
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

    @PostMapping("/useralbum-save")
    public void saveUserAlbum(@RequestBody UserAlbumDTO userAlbumDTO) throws JsonProcessingException {
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
    public List<JoinedAlbumUserAlbumDTO> getMySavedAlbums(@PathVariable String username) {
        return service.getMySavedAlbums(username);
    }

    // Debugging function to output the DB pull of a specific users UserAlbums
    @GetMapping("/debug/{username}")
    public void debugSavedAlbumReturnData(@PathVariable String username) {
        List<JoinedAlbumUserAlbumDTO> albumList = service.getMySavedAlbums(username);
        int counter = 1;
        // Cycle through each Album retrieved, then cycle through each Track per Album
        for (JoinedAlbumUserAlbumDTO album : albumList) {
            System.out.println("\n\n_____________________________\n" +
                    "Album #" + counter + ": " + album.getTitle() + " by " + album.getArtist() +
                    "\n_____________________________");
            for (DiscogsTrack trackName : album.getTracklist()) {
                System.out.println("\n" + trackName.gettrackName() + " : " + trackName.getDuration());
            }
            System.out.println("\n\n_____________END________________");
            counter++;
        }
    }
}
