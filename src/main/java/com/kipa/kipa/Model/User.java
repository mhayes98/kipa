package com.kipa.kipa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity // Turns class into a database entity/table
@Table(name="users")
public class User {
    @Id // Primary key designation <> internal unique identifier
    @GeneratedValue(strategy=GenerationType.AUTO) // Auto-generates primary key value upon creation
    private long id;

    @NotNull(message="Username cannot be empty.")
    @Size(min=2, max=25, message="Username must be between 2 and 25 characters.")
    private String username;

    @Transient
    @NotNull(message="Password cannot be empty.")
    @Size(min=10, max=25, message="Password must be between 10 and 25 characters.")
    // This stores the raw password. Passwords that pass validation will be sent to "password"
    private String passwordDTO;

    // This stores the hashed password
    private String password;

    @NotNull(message="Email cannot be empty.")
    @Size(min=6, max=50, message="Invalid email detected.")
    @Email(message="You must enter a valid email address.")
    private String email;

    protected User() {}

    public User(String username, String passwordDTO, String email) {
        this.username = username;
        this.passwordDTO = passwordDTO;
        this.email = email;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwordDTO='" + passwordDTO + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotNull(message = "Username cannot be empty.") @Size(min = 2, max = 25, message = "Username must be between 2 and 25 characters.") String getUsername() {
        return username;
    }

    public void setUsername(@NotNull(message = "Username cannot be empty.") @Size(min = 2, max = 25, message = "Username must be between 2 and 25 characters.") String username) {
        this.username = username;
    }

    public @NotNull(message = "Password cannot be empty.") @Size(min = 10, max = 25, message = "Password must be between 10 and 25 characters.") String getPasswordDTO() {
        return passwordDTO;
    }

    public void setPasswordDTO(@NotNull(message = "Password cannot be empty.") @Size(min = 10, max = 25, message = "Password must be between 10 and 25 characters.") String passwordDTO) {
        this.passwordDTO = passwordDTO;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public @NotNull(message = "Email cannot be empty.") @Size(min = 6, max = 50, message = "Invalid email detected.") @Email(message = "You must enter a valid email address.") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "Email cannot be empty.") @Size(min = 6, max = 50, message = "Invalid email detected.") @Email(message = "You must enter a valid email address.") String email) {
        this.email = email;
    }
}
