package com.kipa.kipa.Model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class UserAlbumID implements Serializable {
    private String userID;
    private Integer albumID;

    public UserAlbumID(String userID, Integer albumID) {
        this.userID = userID;
        this.albumID = albumID;
    }

    public UserAlbumID() {}

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Integer getAlbumID() {
        return albumID;
    }

    public void setAlbumID(Integer albumID) {
        this.albumID = albumID;
    }
}
