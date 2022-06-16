package it.develhope.develhopeMusic.repositories;

import it.develhope.develhopeMusic.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
    List<Album> findByAlbumTitle(String albumTitle);
}