package com.kipa.kipa.Repo;

import com.kipa.kipa.Model.Album;
import com.kipa.kipa.Model.User;
import com.kipa.kipa.Model.UserAlbum;
import com.kipa.kipa.Model.UserAlbumID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAlbumRepository extends JpaRepository<UserAlbum, UserAlbumID> {
    //List<UserAlbumID> findByIdUserID(String userID);
    //List<UserAlbumID> findByAlbumID(String albumID);
}
