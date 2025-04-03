package com.kipa.kipa.Service;

import ch.qos.logback.core.helpers.CyclicBuffer;
import com.kipa.kipa.Model.User;
import com.kipa.kipa.Repo.UserRepository;
import org.apache.coyote.BadRequestException;
import org.apache.coyote.Response;
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

    public ResponseEntity<String> registerUser(User user) {
        if (checkUniqueUsername(user.getUsername()) != null) {
            return checkUniqueUsername(user.getUsername());
        }
        if (checkUniqueEmail(user.getEmail()) != null) {
            return checkUniqueEmail(user.getEmail());
        }
        user.setPassword(encoder.encode(user.getPasswordDTO()));
        userRepo.save(user);
        return new ResponseEntity<>("Registration complete", HttpStatus.OK);
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


                String username = user.getUsername();
                return ResponseEntity.ok()
                        .header(HttpHeaders.SET_COOKIE, cookie.toString())
                           .body("{\"username\":\"" + user.getUsername() + "\", \"message\":\"Login successful\"}");
            }
        }

        // Failed login
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    public void deleteUser(int userID) {
        userRepo.deleteById(userID);
    }

    /*
    public void checkUniqueUsername(String username) throws BadRequestException {
        if (userRepo.existsByUsernameIgnoreCase(username)) {
            throw new BadRequestException("Username already taken.");
        }
    }
    */

    public ResponseEntity<String> checkUniqueUsername(String username) {
        if (userRepo.existsByUsernameIgnoreCase(username)) {
            return new ResponseEntity<>("Username already taken", HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    public ResponseEntity<String> checkUniqueEmail(String email){
        if (userRepo.existsByEmailIgnoreCase(email)) {
            return new ResponseEntity<>("Email already in use", HttpStatus.BAD_REQUEST);
        }
        return null;
    }

}
