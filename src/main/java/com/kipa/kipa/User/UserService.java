package com.kipa.kipa.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public void addUser(User user) {
        userRepo.save(user);
    }

    public void deleteUser(int userID) {
        userRepo.deleteById(userID);
    }

    public Optional<User> getUserByID(int userID) {
        return userRepo.findById(userID);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

}
