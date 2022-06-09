package it.develhope.develhopeMusic.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String albumTitle;
    private String genre;
    private LocalDate releaseDate;
    private int idArtist;

    @OneToMany(mappedBy = "artist")
    private List<Song> songList;

    public Album() {
    }

    public Album(int albumId, String albumTitle, String genre, LocalDate releaseDate, int idArtist) {
        this.id = albumId;
        this.albumTitle = albumTitle;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.idArtist =idArtist;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setIdArtist(int idArtist) {
        this.idArtist = idArtist;
    }

    public int getIdArtist() {
        return idArtist;
    }

}