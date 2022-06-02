package it.develhope.develhopeMusic.entities;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "songs")
public class Song {
    private int id;
    private int idArtist;
    private int idAlbum;
    private String songTitle;
    private Time duration;
    private LocalDate relaseDate;
    private int listenings = 0;

    public Song() {
    }

    public Song(int id, int idArtist, int idAlbum, String songTitle, Time duration, LocalDate relaseDate, int listenings) {
        this.id = id;
        this.idArtist = idArtist;
        this.idAlbum = idAlbum;
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

    public int getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(int idArtist) {
        this.idArtist = idArtist;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
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