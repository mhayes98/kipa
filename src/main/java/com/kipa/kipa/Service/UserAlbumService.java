package com.kipa.kipa.Service;

import com.kipa.kipa.Model.UserAlbum;
import com.kipa.kipa.Model.UserAlbumID;
import com.kipa.kipa.Model.UserPrincipal;
import com.kipa.kipa.Repo.UserAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserAlbumService {

    @Autowired
    UserAlbumRepository userAlbumRepo;

    public void addUserAlbum(String albumID) {
        // Retrieves username of the current user, then creates the composite key object of username + albumID
        String userID = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        UserAlbumID userAlbumID = new UserAlbumID(userID, albumID);

        UserAlbum userAlbum = new UserAlbum();
        userAlbum.setId(userAlbumID);

        // Other values will be sent to this object in the form of a @RequestBody
        // These values will then be used to create a UserAlbum object
    }

    public void changeStatus(String albumID, String status){

    }
}
