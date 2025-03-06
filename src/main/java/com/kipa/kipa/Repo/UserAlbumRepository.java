package com.kipa.kipa.Repo;

import com.kipa.kipa.Model.Album;
import com.kipa.kipa.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAlbumRepository extends JpaRepository<Album, User> {
}
