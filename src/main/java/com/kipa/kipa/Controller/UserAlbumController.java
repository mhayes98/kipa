package com.kipa.kipa.Controller;

import com.kipa.kipa.Model.UserAlbumDTO;
import com.kipa.kipa.Model.UserAlbumStatusRequest;
import com.kipa.kipa.Repo.AlbumRepository;
import com.kipa.kipa.Service.AlbumService;
import com.kipa.kipa.Service.UserAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAlbumController {

    @Autowired
    UserAlbumService service;

    @Autowired
    AlbumRepository albumRepo;
    @Autowired
    AlbumService albumService;

    @PostMapping("/user-album")
    public void editTags(@RequestBody UserAlbumDTO userAlbumDTO) {
        if(albumRepo.findAlbumByAlbumID(userAlbumDTO.getAlbum().getAlbumID()) == null) {
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
}
