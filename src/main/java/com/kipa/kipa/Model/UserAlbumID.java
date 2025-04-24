package com.kipa.kipa.Model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAlbumID that = (UserAlbumID) o;
        return Objects.equals(userID, that.userID) && Objects.equals(albumID, that.albumID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, albumID);
    }

}
