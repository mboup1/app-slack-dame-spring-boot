package com.app.slackdame.service;

import com.app.slackdame.entity.Channel;
import com.app.slackdame.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    public List<Channel> getAllChannels() {
        List<Channel> channels = new ArrayList<>();
        channelRepository.findAll().forEach(channels::add);
        return channels;
    }

    public Channel getChannelById(long id) {
        return channelRepository.findById(id).orElse(null);
    }

    public void deleteChannel(long id) {
        channelRepository.deleteById(id);
    }

    public Channel addChannel(Channel channel) {
        channelRepository.save(channel);
        return channel;
    }

    public Channel updateChannel(Channel channel, long id) {
        channelRepository.save(channel);
        return channel;
    }
}
