package it.develhope.develhopeMusic.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String albumTitle;
    private String genre;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate releaseDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ID_artist")
    private Artist artist;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    public Album() {
    }

    public Album(Integer id, String albumTitle, String genre, LocalDate releaseDate, Artist artist) {
        this.id = id;
        this.albumTitle = albumTitle;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.artist =artist;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}