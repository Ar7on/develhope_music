package it.develhope.develhopeMusic.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String songTitle;
    private Time duration;
    private LocalDate releaseDate;
    private int listenings;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ID_artist")
    private Artist artist;



    public Song() {
    }

    public Song(int id, String songTitle, Time duration, LocalDate releaseDate, int listenings) {
        this.id = id;
        this.songTitle = songTitle;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.listenings = listenings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate relaseDate) {
        this.releaseDate = relaseDate;
    }

    public int getListenings() {
        return listenings;
    }

    public void setListenings(int listenings) {
        this.listenings = listenings;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}