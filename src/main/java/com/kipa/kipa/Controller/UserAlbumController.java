package com.kipa.kipa.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kipa.kipa.Model.*;
import com.kipa.kipa.Repo.AlbumRepository;
import com.kipa.kipa.Repo.UserAlbumRepository;
import com.kipa.kipa.Service.AlbumService;
import com.kipa.kipa.Service.UserAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserAlbumController {

    @Autowired
    UserAlbumService userAlbumService;

    @Autowired
    AlbumRepository albumRepo;
    @Autowired
    AlbumService albumService;
    @Autowired
    UserAlbumRepository userAlbumRepo;


    @PostMapping("/useralbum-save")
    public void saveUserAlbum(@RequestBody UserAlbumDTO userAlbumDTO) throws JsonProcessingException {
        if(albumRepo.findAlbumByAlbumID(userAlbumDTO.getAlbum().getAlbumID()) == null) {
            userAlbumDTO.getAlbum().convertArrayToRawJson();
            albumService.addAlbum(userAlbumDTO.getAlbum());
        }
        userAlbumService.addUserAlbum(userAlbumDTO.getUserAlbum());
    }

    @PutMapping("/useralbum-update")
    public void updateUserAlbum(@RequestBody UserAlbum userAlbum) throws JsonProcessingException {
        userAlbumService.addUserAlbum(userAlbum);
    }


    @GetMapping("/{userID}/{albumID}")
    public UserAlbumDTO getUserAlbum(@PathVariable String userID, @PathVariable Integer albumID) {
        UserAlbumDTO response = new UserAlbumDTO();

        Optional<UserAlbum> userAlbum = userAlbumRepo.findByIdUserIDAndIdAlbumID(userID, albumID);
        Album album = albumRepo.findAlbumByAlbumID(albumID);

        userAlbum.ifPresent(u -> {
            response.setUserAlbum(u);
            response.setAlbum(album);
        });

        return response;
    }

    @PostMapping("/status")
    public void editStatus(@RequestBody UserAlbumStatusRequest userAlbumStatusRequest) {
        userAlbumService.editStatus(userAlbumStatusRequest);
    }

    @PutMapping("/tag")
    public void editTags(@RequestBody UserAlbumStatusRequest userAlbumStatusRequest) {
        userAlbumService.editTags(userAlbumStatusRequest);
    }

    @PutMapping("/notes")
    public void editNotes(@RequestBody UserAlbumStatusRequest userAlbumStatusRequest) {
        userAlbumService.editNotes(userAlbumStatusRequest);
    }

    @GetMapping("/user-albums/{username}")
    public List<JoinedAlbumUserAlbumDTO> getMySavedAlbums(@PathVariable String username) {
        return userAlbumService.getMySavedAlbums(username);
    }

    // Debugging function to output the DB pull of a specific users UserAlbums
    @GetMapping("/debug/{username}")
    public void debugSavedAlbumReturnData(@PathVariable String username) {
        List<JoinedAlbumUserAlbumDTO> albumList = userAlbumService.getMySavedAlbums(username);
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
