package com.app.slackdame.service;

import com.app.slackdame.entity.Channel;
import com.app.slackdame.entity.User;
import com.app.slackdame.repository.ChannelRepository;
import com.app.slackdame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChannelRepository channelRepository;

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

//    public User addUser(User user) {
//        userRepository.save(user);
//        return user;
//    }

    public User addUser(User user) {
//        Optional<Channel> existingChannel = channelRepository.findById(user.getIdChannel());
//
//        if (existingChannel.isPresent()) {
//            Channel channel = existingChannel.get();

//            user.setChannels(channel);
        userRepository.save(user);

        return user;
//        } else {
//            System.out.println("Erreur");
//            return null; // or throw an exception, depending on your application's requirements
//        }
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User updatedUser) {
        System.out.println(id);
        updatedUser.setId(id);
            return userRepository.save(updatedUser);
        }

}
