package it.develhope.develhopeMusic.services;

import it.develhope.develhopeMusic.entities.Album;
import it.develhope.develhopeMusic.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> listAllAlbums() {
        return albumRepository.findAll();
    }

    public void saveAlbum(Album album) {
        albumRepository.save(album);
    }

    public Album getAlbum(Integer id) {
        return albumRepository.findById(id).get();
    }

    public void deleteAlbum(Integer id) {
        albumRepository.deleteById(id);
    }
}