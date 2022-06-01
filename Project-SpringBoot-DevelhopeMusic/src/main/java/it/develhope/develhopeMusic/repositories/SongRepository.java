package it.develhope.develhopeMusic.repositories;

import it.develhope.develhopeMusic.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Integer> {
}