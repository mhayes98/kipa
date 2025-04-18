package com.kipa.kipa.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="albums")
public class Album {
    @Id
    @JsonProperty("id")
    private Integer albumID; // External ID from Spotify/Discogs API

    private String title;
    private String artist;
    private int year;
    private List<String> genre;
    private List<String> style;
    private String thumbnail;
    @ElementCollection
    private List<DiscogsTrack> tracklist;

    public Album() {}

    public Integer getAlbumID() {
        return albumID;
    }

    public void setAlbumID(Integer albumID) {
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

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<String> getStyle() {
        return style;
    }

    public void setStyle(List<String> style) {
        this.style = style;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<DiscogsTrack> getTracklist() {
        return tracklist;
    }

    public void setTracklist(List<DiscogsTrack> tracklist) {
        this.tracklist = tracklist;
    }
}


