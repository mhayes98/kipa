package com.kipa.kipa.Service;

import com.kipa.kipa.Model.User;
import com.kipa.kipa.Repo.UserRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;


// General service class for User related functions
@Service
public class UserService{

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    UserRepository userRepo;
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    private JWTService jwtService;

    public void registerUser(User user) throws BadRequestException {
        checkUniqueUsername(user.getUsername());
        checkUniqueEmail(user.getEmail());
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
    }


    public ResponseEntity<String> verifyUser(User user) {
        Authentication authentication =
                authManager.authenticate
                        (new UsernamePasswordAuthenticationToken
                                (user.getUsername(), user.getPassword()));


        if (authentication.isAuthenticated()) {
            String jwt = jwtService.generateToken(user.getUsername());

            if (jwt != null) {
                ResponseCookie cookie = ResponseCookie.from("token", jwt)
                        .httpOnly(true)
                        .secure(true)
                        .path("/")
                        .maxAge(Duration.ofDays(7))
                        .sameSite("Strict")
                        .build();

                return ResponseEntity.ok()
                        .header(HttpHeaders.SET_COOKIE, cookie.toString())
                        .body("Kipa cookie");
            }
        }

        // Failed login
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    public void deleteUser(int userID) {
        userRepo.deleteById(userID);
    }

    public void checkUniqueUsername(String username) throws BadRequestException {
        if (userRepo.existsByUsernameIgnoreCase(username)) {
            throw new BadRequestException("Username already taken.");
        }
    }

    public void checkUniqueEmail(String email) throws BadRequestException {
        if (userRepo.existsByEmailIgnoreCase(email)) {
            throw new BadRequestException("Email already in use.");
        }
    }
}
