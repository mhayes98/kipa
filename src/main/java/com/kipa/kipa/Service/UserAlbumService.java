package com.kipa.kipa.Service;

import com.kipa.kipa.Model.UserAlbum;
import com.kipa.kipa.Model.UserAlbumStatusRequest;
import com.kipa.kipa.Repo.UserAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class UserAlbumService {

    @Autowired
    UserAlbumRepository userAlbumRepo;

    public void addUserAlbum(UserAlbum userAlbum) {
        userAlbumRepo.save(userAlbum);
    }

    public void editStatus(UserAlbumStatusRequest userAlbumStatusRequest){
        userAlbumRepo.findByIdUserIDAndIdAlbumID(userAlbumStatusRequest.getUserID(), userAlbumStatusRequest.getAlbumID())
                .ifPresent(userAlbum -> {
                    if (Objects.equals(userAlbumStatusRequest.getStatus(), "")) {
                        userAlbumRepo.delete(userAlbum);
                    }
                    else {
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
}
