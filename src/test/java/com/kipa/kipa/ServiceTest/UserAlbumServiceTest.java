package com.kipa.kipa.ServiceTest;

import com.kipa.kipa.Model.UserAlbum;
import com.kipa.kipa.Repo.UserAlbumRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserAlbumServiceTest {

    @Autowired
    UserAlbumRepository userAlbumRepo;

    @Test
    public void addUserAlbum(UserAlbum userAlbum) {
        userAlbumRepo.save(userAlbum);
    }
}
