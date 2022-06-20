package it.develhope.develhopeMusic.controllers;

import it.develhope.develhopeMusic.entities.Album;
import it.develhope.develhopeMusic.entities.Artist;
import it.develhope.develhopeMusic.entities.Song;
import it.develhope.develhopeMusic.repositories.SongRepository;
import it.develhope.develhopeMusic.services.AlbumService;
import it.develhope.develhopeMusic.services.ArtistService;
import it.develhope.develhopeMusic.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private SongService songService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private AlbumService albumService;

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

    @GetMapping("/songTitle")
    public ResponseEntity<List<Song>> getSongBySongTitle(@RequestParam String songTitle) {
        return new ResponseEntity<List<Song>>(songRepository.findBySongTitle(songTitle), HttpStatus.OK);
    }

    @PostMapping("/")
    public void add(@RequestParam String songTitle,
                    @RequestParam Time duration,
                    @RequestParam String releaseDate,
                    @RequestParam Integer artistId,
                    @RequestParam Integer albumId) {

        Song song = new Song();

        song.setSongTitle(songTitle);
        song.setDuration(duration);

        LocalDate date = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        song.setReleaseDate(date);

        song.setListenings(0);

        Artist artist = artistService.getArtist(artistId);
        song.setArtist(artist);

        Album album = albumService.getAlbum(albumId);
        song.setAlbum(album);

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