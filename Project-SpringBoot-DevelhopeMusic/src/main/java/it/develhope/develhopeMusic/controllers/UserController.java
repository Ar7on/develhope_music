package it.develhope.develhopeMusic.controllers;

import it.develhope.develhopeMusic.entities.user.User;
import it.develhope.develhopeMusic.repositories.UserRepository;
import it.develhope.develhopeMusic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<User> list() { return userService.listAllUsers(); }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
            User user = userService.getUser(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/username")
    public ResponseEntity<List<User>> getUserByUsername(@RequestParam String username) {
        return new ResponseEntity<List<User>>(userRepository.findByUsername(username), HttpStatus.OK);
    }

    @PostMapping("/")
    public void add(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
        try {
            User existUser = userService.getUser(id);
            user.setId(id);
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { userService.deleteUser(id); }
}