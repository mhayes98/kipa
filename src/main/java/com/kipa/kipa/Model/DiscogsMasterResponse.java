package com.kipa.kipa.Model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DiscogsMasterResponse {
    @JsonProperty("title")
    private String title;
    private List<DiscogsTrack> tracklist;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DiscogsTrack> getTracklist() {
        return tracklist;
    }

    public void setTracklist(List<DiscogsTrack> tracklist) {
        this.tracklist = tracklist;
    }
}
