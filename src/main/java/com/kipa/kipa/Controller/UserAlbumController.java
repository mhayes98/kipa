package com.kipa.kipa.Controller;

import com.kipa.kipa.Model.UserAlbum;
import com.kipa.kipa.Model.UserAlbumID;
import com.kipa.kipa.Model.UserPrincipal;
import com.kipa.kipa.Service.UserAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAlbumController {

    @Autowired
    UserAlbumService service;

    // Change call name/purpose - this adds the UserAlbum object
    @PostMapping("/tag")
    public void editTags(@RequestBody UserAlbum userAlbum) {
        service.addUserAlbum(userAlbum);
    }

}
