package com.kipa.kipa.Controller;

import com.kipa.kipa.Model.User;
import com.kipa.kipa.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
// Testing purposes
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@Valid @RequestBody User user) { return service.registerUser(user); }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        return service.verifyUser(user);
    }


}