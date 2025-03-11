package com.kipa.kipa.Repo;


import com.kipa.kipa.Model.UserAlbum;
import com.kipa.kipa.Model.UserAlbumID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAlbumRepository extends JpaRepository<UserAlbum, UserAlbumID> {
    // --- Maybe because of the obj? Should be String?
    //List<String> findByUserID(String userID);
    //List<String> findByAlbumID(String albumID);

    // Id clarification necessary for each half of a composite key
    Optional<UserAlbum> findByIdUserIDAndIdAlbumID(String userId, String albumId);
}
