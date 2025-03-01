package com.kipa.kipa.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

// Security configuration for API calls
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(request -> request
                        .requestMatchers("register", "login").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(customizer -> customizer.disable())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    /*
        Below contains the logic for user authentication - NOTE: This will need to be refactored

        Logic:
            - User submits login credentials
            - AuthenticationManager delegates the request to DaoAuthenticationProvider
            - DaoAuthenticationProvider does the following:
                    - Calls UserDetailsService to load the user from the DB
                    - Compares hashed password to what is in the DB
                    - Verifies the users role(s)
            - AuthenticationManager verifies or denies the login request
            - *** CONTINUED ***
        _________________________________________________________________________
         Thoroughly comment this process and the below functions when revisiting
        _________________________________________________________________________
    */

    @Autowired
    private UserDetailsService userDetailsService;

    // Instantiates DaoAuthenticationObject for authorization comparison
    // Sets hashing algorithim to BCrypt
    // userDetailsService retrieves user from the DB
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        authProvider.setUserDetailsService(userDetailsService);
        return authProvider;
    }


    // Retrieves default AuthenticationManager configuration
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
