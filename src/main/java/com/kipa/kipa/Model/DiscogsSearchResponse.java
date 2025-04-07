package com.kipa.kipa.Model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DiscogsSearchResponse {
    @JsonProperty("type") // Artist or Master (album)
    private String type;
    @JsonProperty("title") // Artist name or Master title
    private String title;
    @JsonProperty("genre")
    private List<String> genre;
    @JsonProperty("style")
    private List<String> style;
    @JsonProperty("thumb") // Potentially change this for better resolution image
    private String thumbnailURL;
    @JsonProperty("year") // May be 0 or null for Artists
    private int year;
    private List<DiscogsSearchResponse> results;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<DiscogsSearchResponse> getResults() {
        return results;
    }

    public void setResults(List<DiscogsSearchResponse> results) {
        this.results = results;
    }
}
