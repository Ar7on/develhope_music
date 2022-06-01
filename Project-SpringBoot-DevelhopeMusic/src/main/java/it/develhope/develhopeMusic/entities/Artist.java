package it.develhope.develhopeMusic.entities;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist {
    private int id;
    private String name;
    private String genre;

    public Artist() {
    }

    public Artist(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}