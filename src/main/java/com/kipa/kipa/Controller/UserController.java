package com.kipa.kipa.Controller;

import com.kipa.kipa.Model.User;
import com.kipa.kipa.Service.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true") // Testing purposes
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public void register(@RequestBody User user) throws BadRequestException {
        service.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        return service.verifyUser(user);
    }


}