package com.kipa.kipa.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @Column(columnDefinition = "TEXT")
    private String tracklist;
    @Transient
    private List<DiscogsTrack> tracklistAsArray;

    public Album() {}

    public Album(String tracklist, String thumbnail, List<String> style, List<String> genre, int year, String artist, String title, Integer albumID) {
        this.tracklist = tracklist;
        this.thumbnail = thumbnail;
        this.style = style;
        this.genre = genre;
        this.year = year;
        this.artist = artist;
        this.title = title;
        this.albumID = albumID;
    }

    public Album(String title, String artist, int year, List<String> genre, List<String> style, String thumbnail) {
    }

    public Album(Integer albumID, String title, String artist, int year, List<String> genre, List<String> style, String thumbnail, List<DiscogsTrack> tracklistAsArray) throws JsonProcessingException {
        this.albumID = albumID;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
        this.style = style;
        this.thumbnail = thumbnail;
        this.tracklistAsArray = tracklistAsArray;
        convertArrayToRawJson();
    }

    // Tracklist is received as an array, this function will convert that array to a raw JSON string to be stored in the database
    // The tracklist will only be displayed in the front end. This setup will need to be adjusted if interaction with the tracklist is ever implemented.
    public void convertArrayToRawJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        setTracklist(objectMapper.writeValueAsString(tracklistAsArray));
    }

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

    public String getTracklist() {
        return tracklist;
    }

    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }

    public List<DiscogsTrack> getTracklistAsArray() {
        return tracklistAsArray;
    }

    public void setTracklistAsArray(List<DiscogsTrack> tracklistAsArray) {
        this.tracklistAsArray = tracklistAsArray;
    }
}


