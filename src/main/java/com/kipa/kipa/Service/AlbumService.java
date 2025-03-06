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

    public void addAlbum(Album album) {
        albumRepo.save(album);
    }

    public void deleteAlbum(Album album) {
        albumRepo.delete(album);
    }

}
