package com.kipa.kipa.Repo;


import com.kipa.kipa.Model.JoinedAlbumUserAlbumDTO;
import com.kipa.kipa.Model.UserAlbum;
import com.kipa.kipa.Model.UserAlbumID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAlbumRepository extends JpaRepository<UserAlbum, UserAlbumID> {
    // Id clarification necessary for composite key fields
    Optional<UserAlbum> findByIdUserIDAndIdAlbumID(String userId, Integer albumId);
    boolean existsByIdAlbumID(Integer albumId);

    @Query(
        value = "SELECT " +
            "    user_albums.albumid AS user_albumid, " +
            "    user_albums.userid, " +
            "    user_albums.notes, " +
            "    user_albums.status, " +
            "    user_albums.tags, " +
            "    albums.albumid AS album_albumid, " +
            "    albums.artist, " +
            "    albums.genre, " +
            "    albums.style, " +
            "    albums.thumbnail, " +
            "    albums.title, " +
            "    albums.tracklist, " +
            "    albums.year " +
            "FROM user_albums " +
            "INNER JOIN albums " +
            "    ON albums.albumid = user_albums.albumid " +
            "WHERE user_albums.userid = :userId",
        nativeQuery = true)
    List<JoinedAlbumUserAlbumDTO> findAlbumsByUser(@Param("userId") String username);


    @Query(
        value = "SELECT " +
            "    user_albums.albumid AS user_albumid, " +
            "    user_albums.userid, " +
            "    user_albums.notes, " +
            "    user_albums.status, " +
            "    user_albums.tags, " +
            "    albums.albumid AS album_albumid, " +
            "    albums.artist, " +
            "    albums.genre, " +
            "    albums.style, " +
            "    albums.thumbnail, " +
            "    albums.title, " +
            "    albums.tracklist, " +
            "    albums.year " +
            "FROM user_albums " +
            "INNER JOIN albums " +
            "    ON albums.albumid = user_albums.albumid " +
            "WHERE user_albums.userid = 'testuser'",
        nativeQuery = true)
        List<Object[]> debugQuery();
}
