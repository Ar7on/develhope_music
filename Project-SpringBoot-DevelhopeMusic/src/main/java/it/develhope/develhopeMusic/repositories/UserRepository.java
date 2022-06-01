package it.develhope.develhopeMusic.repositories;

import it.develhope.develhopeMusic.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}