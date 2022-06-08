package it.develhope.develhopeMusic.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.develhope.develhopeMusic.entities.Album;
import it.develhope.develhopeMusic.entities.Song;
import it.develhope.develhopeMusic.repositories.SongRepository;
import it.develhope.develhopeMusic.services.SongService;
import org.apache.catalina.ThreadBindingListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private SongService songService;

    @GetMapping("")
    public List<Song> list() { return songService.listAllSongs(); }

    @GetMapping("/{id}")
    public ResponseEntity<Song> get(@PathVariable Integer id) {
        try {
            Song song = songService.getSong(id);
            song.setListenings(song.getListenings() + 1);
            songService.saveSong(song);
            return new ResponseEntity<Song>(song,HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Song song) {
        songService.saveSong(song);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Song song, @PathVariable Integer id) {
        try {
            Song existSong = songService.getSong(id);
            song.setId(id);
            songService.saveSong(song);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { songService.deleteSong(id); }

    }

