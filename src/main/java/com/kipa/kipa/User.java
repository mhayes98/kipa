package com.kipa.kipa;

import jakarta.persistence.*;

@Entity // Turns class into a database entity/table
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


}
