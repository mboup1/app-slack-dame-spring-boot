package com.app.slackdame.service;

import com.app.slackdame.entity.User;
import com.app.slackdame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user, long id) {
        userRepository.save(user);
        return user;
    }
}
