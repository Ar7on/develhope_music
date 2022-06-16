package it.develhope.develhopeMusic.repositories;

import it.develhope.develhopeMusic.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Integer> {
    List<Song> findBySongTitle(String songTitle);
}