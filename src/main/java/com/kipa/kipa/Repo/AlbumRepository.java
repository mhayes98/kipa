package com.kipa.kipa.Repo;

import com.kipa.kipa.Model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, String> {
    Album findAlbumByAlbumID(Integer albumID);
}
