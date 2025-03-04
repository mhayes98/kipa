package com.kipa.kipa.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="albums")
public class Album {
    @Id
    private String albumID; // External ID from Spotify/Discogs API

    private String title;
    private String artist;
    private int year;
    private String tracklist;


    public String getAlbumID() {
        return albumID;
    }

    public void setAlbumID(String albumID) {
        this.albumID = albumID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTracklist() {
        return tracklist;
    }

    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }
}


