package com.app.slackdame.controller;


import com.app.slackdame.entity.User;
import com.app.slackdame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
    public void updateUser(@RequestBody User user, @PathVariable long id) {
        userService.updateUser(user, id);
    }
}

