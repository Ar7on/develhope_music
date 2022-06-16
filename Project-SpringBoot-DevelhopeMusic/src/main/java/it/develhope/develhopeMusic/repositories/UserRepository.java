package it.develhope.develhopeMusic.repositories;

import it.develhope.develhopeMusic.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByUsername(String username);
}