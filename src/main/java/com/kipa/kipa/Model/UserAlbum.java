package com.kipa.kipa.Model;

import jakarta.persistence.*;


@Entity
@Table(name="user_albums")
public class UserAlbum {
    // Composite key made of userID & albumID - acts as separate values in the table (2 col)
    @EmbeddedId
    private UserAlbumID id;

    private String status;
    private String[] tags;
    private String notes;

    public UserAlbum(UserAlbumID id, String status, String[] tags, String notes) {
        this.id = id;
        this.status = status;
        this.tags = tags;
        this.notes = notes;
    }

    public UserAlbum() {}

    public UserAlbumID getId() {
        return id;
    }

    public void setId(UserAlbumID id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
