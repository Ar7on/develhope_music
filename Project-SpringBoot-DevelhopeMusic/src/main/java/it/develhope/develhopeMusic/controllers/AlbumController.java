package it.develhope.develhopeMusic.controllers;

import it.develhope.develhopeMusic.entities.Album;
import it.develhope.develhopeMusic.entities.Artist;
import it.develhope.develhopeMusic.repositories.AlbumRepository;
import it.develhope.develhopeMusic.services.AlbumService;
import it.develhope.develhopeMusic.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistService artistService;

    @GetMapping("")
    public List<Album> list() { return albumService.listAllAlbums(); }

    @GetMapping("/{id}")
    public ResponseEntity<Album> get(@PathVariable Integer id) {
        try {
            Album album = albumService.getAlbum(id);
            return new ResponseEntity<Album>(album, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Album>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/albumTitle")
    public ResponseEntity<List<Album>> getAlbumByAlbumTitle(@RequestParam String albumTitle) {
        return new ResponseEntity<List<Album>>(albumRepository.findByAlbumTitle(albumTitle), HttpStatus.OK);
    }

    @PostMapping("/")
    public void add(  @RequestParam String albumTitle,
                      @RequestParam String albumGenre,
                      @RequestParam String releaseDate,
                      @RequestParam Integer artistId) {

        Album album = new Album();

        album.setAlbumTitle(albumTitle);
        album.setGenre(albumGenre);

        LocalDate date = LocalDate.parse(releaseDate,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        album.setReleaseDate(date);

        Artist artist = artistService.getArtist(artistId);
        album.setArtist(artist);

        albumService.saveAlbum(album);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Album album, @PathVariable Integer id) {
        try {
            Album existAlbum = albumService.getAlbum(id);
            album.setId(id);
            albumService.saveAlbum(album);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { albumService.deleteAlbum(id); }
}