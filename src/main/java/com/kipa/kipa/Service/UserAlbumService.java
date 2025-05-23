package com.kipa.kipa.Service;

import com.kipa.kipa.Model.*;
import com.kipa.kipa.Repo.AlbumRepository;
import com.kipa.kipa.Repo.UserAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class UserAlbumService {

    @Autowired
    UserAlbumRepository userAlbumRepo;
    @Autowired
    AlbumRepository albumRepo;

    public void addUserAlbum(UserAlbum userAlbum) {
        userAlbumRepo.save(userAlbum);
    }

    public void editStatus(UserAlbumStatusRequest userAlbumStatusRequest) {
        userAlbumRepo.findByIdUserIDAndIdAlbumID(userAlbumStatusRequest.getUserID(), userAlbumStatusRequest.getAlbumID())
                .ifPresent(userAlbum -> {
                    if (Objects.equals(userAlbumStatusRequest.getStatus(), "")) {
                        userAlbumRepo.delete(userAlbum);
                        removeAlbumIfNoUsers(userAlbumStatusRequest.getAlbumID());
                    } else {
                        userAlbum.setStatus(userAlbumStatusRequest.getStatus());
                        userAlbumRepo.save(userAlbum);
                    }
                });
    }

    public void editTags(UserAlbumStatusRequest userAlbumStatusRequest) {
        userAlbumRepo.findByIdUserIDAndIdAlbumID(userAlbumStatusRequest.getUserID(), userAlbumStatusRequest.getAlbumID())
                .ifPresent(userAlbum -> {
                    userAlbum.setTags(userAlbumStatusRequest.getTags());
                    userAlbumRepo.save(userAlbum);
                });
    }

    public void editNotes(UserAlbumStatusRequest userAlbumStatusRequest) {
        userAlbumRepo.findByIdUserIDAndIdAlbumID(userAlbumStatusRequest.getUserID(), userAlbumStatusRequest.getAlbumID())
                .ifPresent(userAlbum -> {
                    userAlbum.setNotes(userAlbumStatusRequest.getNotes());
                    userAlbumRepo.save(userAlbum);
                });
    }

    // Delete an Album from the Albums table if no users currently Own/Want it
    public void removeAlbumIfNoUsers(Integer albumID) {
        if (!userAlbumRepo.existsByIdAlbumID(albumID)) {
            albumRepo.delete(albumRepo.findAlbumByAlbumID(albumID));
        }
    }

    public List<JoinedAlbumUserAlbumDTO> getMySavedAlbums(String username) {
        return userAlbumRepo.findAlbumsByUser(username);
    }

}