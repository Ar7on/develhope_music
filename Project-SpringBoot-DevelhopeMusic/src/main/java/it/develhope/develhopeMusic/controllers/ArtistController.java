package it.develhope.develhopeMusic.controllers;

import it.develhope.develhopeMusic.entities.Artist;
import it.develhope.develhopeMusic.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping("")
    public List<Artist> list() { return artistService.listAllArtists(); }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> get(@PathVariable Integer id) {
        try {
            Artist artist = artistService.getArtist(id);
            return new ResponseEntity<Artist>(artist, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Artist>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Artist artist) {
        artistService.saveArtist(artist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Artist artist, @PathVariable Integer id) {
        try {
            Artist existArtist = artistService.getArtist(id);
            artist.setId(id);
            artistService.saveArtist(artist);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { artistService.deleteArtist(id); }
}