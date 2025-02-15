package com.kipa.kipa.User;

import jakarta.persistence.*;

@Entity // Turns class into a database entity/table
@Table(name="users")
public class User {
    @Id // Primary key designation <> internal unique identifier
    @GeneratedValue(strategy=GenerationType.AUTO) // Auto-generates primary key value upon creation
    private long id;
    @Column(unique=true) // Human-readable unique identifier
    private String username;
    private String password;
    private String email;
    private String role;

    protected User() {}

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = "User";
    }

    @Override
    public String toString() {
        return String.format("ID=%d | Username=%s | Email=%s", id, username, email);
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
