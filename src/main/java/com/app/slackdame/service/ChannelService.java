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
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    UserRepository userRepository;

    public List<Channel> getAllChannels() {
        List<Channel> channels = new ArrayList<>();
        channelRepository.findAll().forEach(channels::add);
        return channels;
    }

    public Channel getChannelById(long id) {
        return channelRepository.findById(id).orElse(null);
    }

    public Channel addChannel(Channel channel) {
        Optional<User> existingUser = userRepository.findById(channel.getIdUser());

        if (existingUser.isPresent()) {
            User user = existingUser.get();

            channel.setUser(user);
            channelRepository.save(channel);

            return channel;
        } else {
            System.out.println("La personne n'existe pas");
            return null; // or throw an exception, depending on your application's requirements
        }
    }

    public void deleteChannel(long id) {
        channelRepository.deleteById(id);
    }

    public Channel updateChannel(Channel channel, long id) {
        channelRepository.save(channel);
        return channel;
    }
}
