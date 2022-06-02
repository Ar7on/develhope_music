package it.develhope.develhopeMusic.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "albums")
public class Album {
    private int id;
    private int idArtist;
    private String albumTitle;
    private String genre;
    private LocalDate relaseDate;

    public Album() {
    }

    public Album(int id, int idArtist, String albumTitle, String genre, LocalDate relaseDate) {
        this.id = id;
        this.idArtist = idArtist;
        this.albumTitle = albumTitle;
        this.genre = genre;
        this.relaseDate = relaseDate;
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

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getRelaseDate() {
        return relaseDate;
    }

    public void setRelaseDate(LocalDate relaseDate) {
        this.relaseDate = relaseDate;
    }
}