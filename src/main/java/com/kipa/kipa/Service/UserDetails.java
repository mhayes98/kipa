package com.kipa.kipa.Service;

import com.kipa.kipa.Model.User;
import com.kipa.kipa.Model.UserPrincipal;
import com.kipa.kipa.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetails implements UserDetailsService{

    @Autowired
    UserRepository userRepo;

    @Override
        public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userRepo.findByUsername(username);
            if(user == null) {
                throw new UsernameNotFoundException("User not found.");
            }
            return new UserPrincipal(user);
        }
}
