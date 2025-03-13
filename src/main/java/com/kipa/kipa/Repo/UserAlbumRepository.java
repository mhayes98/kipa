package com.kipa.kipa.Repo;


import com.kipa.kipa.Model.UserAlbum;
import com.kipa.kipa.Model.UserAlbumID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAlbumRepository extends JpaRepository<UserAlbum, UserAlbumID> {
    // Id clarification necessary for composite key fields
    Optional<UserAlbum> findByIdUserIDAndIdAlbumID(String userId, String albumId);
    boolean existsByIdAlbumID(String albumId);
}
