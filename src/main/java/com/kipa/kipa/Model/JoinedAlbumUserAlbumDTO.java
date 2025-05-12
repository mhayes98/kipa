package com.kipa.kipa.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

// List<String> Values = Tags, Genre, Style
// List<DiscogsTrack> Value = Tracklist
public class JoinedAlbumUserAlbumDTO {
    private int userAlbumid;
    private String userid;
    private String notes;
    private String status;
    private String tags;
    private int albumAlbumid;
    private String artist;
    private List<String> genre;
    private List<String> style;
    private String thumbnail;
    private String title;
    private String tracklist;
    private int year;

    @Override
    public String toString() {
        return "JoinedUserAlbumDTO{" +
                "userAlbumid=" + userAlbumid +
                ", userid='" + userid + '\'' +
                ", notes='" + notes + '\'' +
                ", status='" + status + '\'' +
                ", tags=" + tags +
                ", albumAlbumid=" + albumAlbumid +
                ", artist='" + artist + '\'' +
                ", genre=" + genre +
                ", style=" + style +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", tracklist='" + tracklist + '\'' +
                ", year=" + year +
                '}';
    }

    // May need to use StringEscapeUtils.unescapeJson) to remove escaped quotes - verify
    // Implement null checker
    public List<DiscogsTrack> convertTracklist(String tracklist) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(tracklist, new TypeReference<List<DiscogsTrack>>() {});
    }

    // Split Genre & Style into a list
    // TESTING FOR NOW
    // Real object may be of type `java.sql.Array` -- need to convert
    public List<String> sqlArrayToListConverter(java.sql.Array sqlArray) throws SQLException {
        try{
            List<String> convertedList;
            return convertedList = Arrays.asList((String[]) sqlArray.getArray());
        } catch (SQLException e){
            return Collections.emptyList();
        }

//        String testStr = "{\"Indie Rock\",\"Classical\",\"Hip-Hop\",\"Country\"}";
//        String splitSequence = "\",\"";
//        String splitValues[] = testStr.split(splitSequence);
//        for (String index : splitValues) {
//            System.out.println(index);
//        }
    }

    public JoinedAlbumUserAlbumDTO(int userAlbumid, String userid, String notes,
                                   String status, String tags, int albumAlbumid,
                                   String artist, java.sql.Array genre, java.sql.Array style, String thumbnail,
                                   String title, String tracklist, int year) throws SQLException {
        this.userAlbumid = userAlbumid;
        this.userid = userid;
        this.notes = notes;
        this.status = status;
        this.tags = tags;
        this.albumAlbumid = albumAlbumid;
        this.artist = artist;
        this.genre = sqlArrayToListConverter(genre);
        this.style = sqlArrayToListConverter(style);
        this.thumbnail = thumbnail;
        this.title = title;
        this.tracklist = tracklist;
        this.year = year;
    }

    public int getUserAlbumid() {
        return userAlbumid;
    }

    public void setUserAlbumid(int userAlbumid) {
        this.userAlbumid = userAlbumid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getAlbumAlbumid() {
        return albumAlbumid;
    }

    public void setAlbumAlbumid(int albumAlbumid) {
        this.albumAlbumid = albumAlbumid;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTracklist() {
        return tracklist;
    }

    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
