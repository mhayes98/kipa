package com.kipa.kipa.Repo;

import com.kipa.kipa.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //List<User> findByRole(String role);
    User findByUsername(String username);
    boolean existsByUsernameIgnoreCase(String username);
}
