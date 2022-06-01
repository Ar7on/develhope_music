package it.develhope.develhopeMusic.repositories;

import it.develhope.develhopeMusic.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}