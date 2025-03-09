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

    @PostMapping("/tag")
    public String editTags(@RequestBody UserAlbum userAlbum) {
        /*
            Workflow:
                Mapping calls constructor that only includes a String albumID
                Manually create a UserAlbumID from this albumID
                Create a complete UserAlbum object using getters from original object
         */


        String userID = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        String albumID = userAlbum.getAlbumID();

        UserAlbumID userAlbumID = new UserAlbumID(userID, albumID);

        UserAlbum completeUserAlbum = new UserAlbum(
                userAlbumID,
                userAlbum.getStatus(),
                userAlbum.getTags(),
                userAlbum.getNotes());

        return service.addUserAlbum(completeUserAlbum);
    }

}
