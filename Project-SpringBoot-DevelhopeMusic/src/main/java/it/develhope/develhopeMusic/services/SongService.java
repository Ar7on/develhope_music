package it.develhope.develhopeMusic.services;

import it.develhope.develhopeMusic.entities.Song;
import it.develhope.develhopeMusic.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public List<Song> listAllSongs() {
        return songRepository.findAll();
    }

    public void saveSong(Song song) { songRepository.save(song); }

    public Song getSong(Integer id) {return songRepository.findById(id).get();}

    public void deleteSong(Integer id) {
        songRepository.deleteById(id);
    }
}