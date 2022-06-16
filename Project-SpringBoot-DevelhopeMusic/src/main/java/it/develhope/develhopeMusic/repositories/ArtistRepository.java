package it.develhope.develhopeMusic.repositories;

import it.develhope.develhopeMusic.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    List<Artist> findByName(String name);
}