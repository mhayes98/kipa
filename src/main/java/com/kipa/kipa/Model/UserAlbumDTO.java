package com.kipa.kipa.Model;

public class UserAlbumDTO {
    private UserAlbum userAlbum;
    private Album album;

    public UserAlbum getUserAlbum() {
        return userAlbum;
    }

    public void setUserAlbum(UserAlbum userAlbum) {
        this.userAlbum = userAlbum;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
