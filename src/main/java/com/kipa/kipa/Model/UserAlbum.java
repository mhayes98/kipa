package com.kipa.kipa.Model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="user_albums")
public class UserAlbum {
    // Composite key made of userID & albumID - acts as separate values in the table (2 col)
    @EmbeddedId
    private UserAlbumID id;

    private String status;
    private List<String> tags;
    private String notes;

    @Transient
    private Integer albumID;

    public UserAlbum(UserAlbumID id, String status, String[] tags, String notes) {
        this.id = id;
        this.status = status;
        this.tags = List.of(tags);
        this.notes = notes;
    }

    // This constructor creates a UserAlbum object while only getting an albumID
    // Currently in place due to the editTag call in UserAlbumController
    public UserAlbum (Integer albumID, String status, String[] tags, String notes ) {
        this.albumID = albumID;
        this.status = status;
        this.tags = List.of(tags);
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getAlbumID() {
        return albumID;
    }

    public void setAlbumID(Integer albumID) {
        this.albumID = albumID;
    }
}
