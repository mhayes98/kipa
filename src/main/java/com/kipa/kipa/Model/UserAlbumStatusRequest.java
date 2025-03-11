package com.kipa.kipa.Model;


// This class exists for the API calls in UserAlbumController / UserAlbumService

import java.util.Arrays;
import java.util.List;

public class UserAlbumStatusRequest {

    private String userID;
    private String albumID;
    private String status;
    private List<String> tags;
    private String notes;

    public UserAlbumStatusRequest() {}

    @Override
    public String toString() {
        return "UserAlbumStatusRequest{" +
                "userID='" + userID + '\'' +
                ", albumID='" + albumID + '\'' +
                ", status='" + status + '\'' +
                ", tags=" + tags +
                ", notes='" + notes + '\'' +
                '}';
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAlbumID() {
        return albumID;
    }

    public void setAlbumID(String albumID) {
        this.albumID = albumID;
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
}
