package com.kipa.kipa.Service;

import com.kipa.kipa.Model.UserAlbum;
import com.kipa.kipa.Repo.UserAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAlbumService {

    @Autowired
    UserAlbumRepository userAlbumRepo;

    public void addTag(String albumID){

    }
}
