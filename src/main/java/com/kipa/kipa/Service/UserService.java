package com.kipa.kipa.Service;

import com.kipa.kipa.Model.User;
import com.kipa.kipa.Model.UserPrincipal;
import com.kipa.kipa.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    UserRepository userRepo;
    @Autowired
    AuthenticationManager authManager;


    public void registerUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    public String verifyUser(User user) {
        Authentication authentication =
                authManager.authenticate
                        (new UsernamePasswordAuthenticationToken
                                (user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated()) {
            return "Pass";
        }
        else {
            return "Fail";
        }

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
