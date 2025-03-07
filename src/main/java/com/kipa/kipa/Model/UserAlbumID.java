package com.kipa.kipa.Model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class UserAlbumID implements Serializable {
    private String userID;
    private String albumID;

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
}
