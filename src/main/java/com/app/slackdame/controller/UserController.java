package com.app.slackdame.controller;


import com.app.slackdame.entity.User;
import com.app.slackdame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public ResponseEntity<Object> addUser(@RequestBody User user) {

        // Vérification des champs vides ou nuls
        if (user.getName() == null || user.getName().isBlank() ||
                user.getEmail() == null || user.getEmail().isBlank() ||
                user.getPassword() == null || user.getPassword().isBlank()) {
            return new ResponseEntity<>("Tous les champs doivent être remplis, sauf avatar.", HttpStatus.BAD_REQUEST);
        }

        User userAdded = userService.addUser(user);
        return new ResponseEntity<>(userAdded, HttpStatus.CREATED);
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        User deletedUser = userService.getUserById(id);

        if (deletedUser != null) {
            userService.deleteUser(id);
            return new ResponseEntity<>("L'utilisateur avec Id " + id + " a été supprimé avec succès", HttpStatus.OK);
        } else {
            // If the user with the specified ID is not found, return a 404 Not Found status.
            return new ResponseEntity<>("L'utilisateur avec Id " + id + " n'existe pas", HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("user/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User existingUser = userService.getUserById(id);
        System.out.println("existingUser : " + existingUser);

        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }

        // Update only the non-collection fields if they are not null or blank
        if (updatedUser.getName() != null && !updatedUser.getName().isBlank()) {
            existingUser.setName(updatedUser.getName());
        }

        if (updatedUser.getEmail() != null && !updatedUser.getEmail().isBlank()) {
            existingUser.setEmail(updatedUser.getEmail());
        }

        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isBlank()) {
            existingUser.setPassword(updatedUser.getPassword());
        }

        if (updatedUser.getAvatar() != null && !updatedUser.getAvatar().isBlank()) {
            existingUser.setAvatar(updatedUser.getAvatar());
        }

        // Save the updated user
        userService.updateUser(existingUser);

        return ResponseEntity.noContent().build();
    }



}

