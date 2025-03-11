package com.kipa.kipa.ControllerTest;

import com.kipa.kipa.Model.UserAlbum;
import com.kipa.kipa.ServiceTest.UserAlbumServiceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootTest
public class UserAlbumControllerTest {

    @Autowired
    UserAlbumServiceTest serviceTest;

    @PostMapping("/tag-test")
    @Test
    public void editTags(@RequestBody UserAlbum userAlbum) {
        serviceTest.addUserAlbum(userAlbum);
    }
}
