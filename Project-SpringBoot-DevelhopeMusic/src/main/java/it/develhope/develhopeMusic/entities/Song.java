package it.develhope.develhopeMusic.entities;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "songs")
public class Song {
    private int id;
    private String songTitle;
    private Time duration;
    private LocalDate releaseDate;
    private int listenings;

    public Song() {
    }

    public Song(int id, String songTitle, Time duration, LocalDate releaseDate, int listenings) {
        this.id = id;
        this.songTitle = songTitle;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.listenings = listenings;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getListenings() {
        return listenings;
    }

    public void setListenings(int listenings) {
        this.listenings = listenings;
    }
}