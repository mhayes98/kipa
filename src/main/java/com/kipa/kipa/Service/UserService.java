package com.kipa.kipa.Service;

import com.kipa.kipa.Model.User;
import com.kipa.kipa.Repo.UserRepository;
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
import java.util.HashMap;
import java.util.Map;


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

    public ResponseEntity<Map<String, String>> registerUser(User user) {
        if (checkUniqueUsername(user.getUsername()) != null) {
            return checkUniqueUsername(user.getUsername());
        }
        if (checkUniqueEmail(user.getEmail()) != null) {
            return checkUniqueEmail(user.getEmail());
        }
        user.setPassword(encoder.encode(user.getPasswordDTO()));
        userRepo.save(user);
        Map<String, String> successResponse = new HashMap<>();
        successResponse.put("success", "Registration complete");
        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
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

    public ResponseEntity<Map<String, String>> checkUniqueUsername(String username) {
        if (userRepo.existsByUsernameIgnoreCase(username)) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "USERNAME_TAKEN");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        return null;
    }

    public ResponseEntity<Map<String, String>> checkUniqueEmail(String email){
        if (userRepo.existsByEmailIgnoreCase(email)) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "EMAIL_TAKEN");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        return null;
    }

}
