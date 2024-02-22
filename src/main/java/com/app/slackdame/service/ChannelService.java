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
        if (channel.getDeletable()==null){
        channel.setDeletable(true);
        }
            channelRepository.save(channel);

            return channel;

    }

    public void deleteChannel(long id) {
        channelRepository.deleteById(id);
    }

    public Channel updateChannel(Channel updatedChannel, long id) {
        // Récupérer le canal existant
        Channel existingChannel = channelRepository.findById(id).orElse(null);

        // Vérifier si le canal existe
        if (existingChannel != null) {
            // Mettre à jour les propriétés du canal existant
            if (updatedChannel.getNameChannel() != null && !updatedChannel.getNameChannel().isBlank()) {
                existingChannel.setNameChannel(updatedChannel.getNameChannel());
            }

            if (updatedChannel.getDeletable() != null) {
            existingChannel.setDeletable(updatedChannel.getDeletable());
            }

            // Enregistrer les modifications dans le repository
            channelRepository.save(existingChannel);

            return existingChannel;
        } else {
            // Canal non trouvé, renvoyer null ou gérer l'erreur selon vos besoins
            return null;
        }
    }

}
