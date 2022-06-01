package it.develhope.develhopeMusic.repositories;

import it.develhope.develhopeMusic.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}