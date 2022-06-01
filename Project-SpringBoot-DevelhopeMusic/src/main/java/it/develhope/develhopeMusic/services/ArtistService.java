package it.develhope.develhopeMusic.services;

import it.develhope.develhopeMusic.entities.Artist;
import it.develhope.develhopeMusic.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> listAllArtists() {
        return artistRepository.findAll();
    }

    public void saveArtist(Artist artist) {
        artistRepository.save(artist);
    }

    public Artist getArtist(Integer id) {
        return artistRepository.findById(id).get();
    }

    public void deleteArtist(Integer id) {
        artistRepository.deleteById(id);
    }
}