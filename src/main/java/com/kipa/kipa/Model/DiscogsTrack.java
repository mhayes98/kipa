package com.kipa.kipa.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;

@Embeddable
public class DiscogsTrack {
    @JsonProperty("title")
    private String trackName;
    private String duration;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String gettrackName() {
        return trackName;
    }

    public void settrackName(String trackName) {
        this.trackName = trackName;
    }
}
