package it.develhope.develhopeMusic.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "songs")
public class Song {
    private int id;
    private String songTitle;
    private LocalDate duration;
    private LocalDate relaseDate;
    private int listenings;

    public Song() {
    }

    public Song(int id, String songTitle, LocalDate duration, LocalDate relaseDate, int listenings) {
        this.id = id;
        this.songTitle = songTitle;
        this.duration = duration;
        this.relaseDate = relaseDate;
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

    public LocalDate getDuration() {
        return duration;
    }

    public void setDuration(LocalDate duration) {
        this.duration = duration;
    }

    public LocalDate getRelaseDate() {
        return relaseDate;
    }

    public void setRelaseDate(LocalDate relaseDate) {
        this.relaseDate = relaseDate;
    }

    public int getListenings() {
        return listenings;
    }

    public void setListenings(int listenings) {
        this.listenings = listenings;
    }
}