package com.kipa.kipa.Service;

import com.kipa.kipa.Model.Album;
import com.kipa.kipa.Repo.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepo;
    //@Autowired
    //AlbumUserRepository albumUserRepo;


    // ____________________________________________________
    // Look up SecurityContextHolder to verify current user
    // ____________________________________________________

    public void tagAlbum(Album album, String tag) {
        /*
        Logic:
            Check if Album is in the DB, if not --> Add it
            If Album row not in UserAlbums --> Add it
            Add tag to Album in UserAlbum
         */
    }

    public void removeTag(Album album, String tag) {
    }

}
