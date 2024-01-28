package com.app.slackdame.controller;

import com.app.slackdame.entity.Channel;
import com.app.slackdame.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @GetMapping("/channels")
    public List<Channel> getAllChannels() {
        return channelService.getAllChannels();
    }

    @GetMapping("/channel/{id}")
    public Channel getChannel(@PathVariable long id) {
        return channelService.getChannelById(id);
    }

    @PostMapping("/channel")
    public void addChannel(@RequestBody Channel channel) {
        channelService.addChannel(channel);
    }

    @DeleteMapping("/channel/{id}")
    public void deleteChannel(@PathVariable long id) {
        channelService.deleteChannel(id);
    }

    @PutMapping("/channel/{id}")
    public void updateChannel(@RequestBody Channel channel, @PathVariable long id) {
        channelService.updateChannel(channel, id);
    }
}
