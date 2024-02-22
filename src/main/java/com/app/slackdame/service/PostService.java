package com.app.slackdame.service;

import com.app.slackdame.entity.Channel;
import com.app.slackdame.entity.Post;
import com.app.slackdame.entity.User;
import com.app.slackdame.repository.ChannelRepository;
import com.app.slackdame.repository.PostRepository;
import com.app.slackdame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChannelRepository channelRepository;

    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);
        return posts;
    }

    public Post getPostById(long id) {
        return postRepository.findById(id).orElse(null);
    }

    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    public Post addPost(Post post) {
        Optional<Channel> existingChannel = channelRepository.findById(post.getIdChannel());

        if (existingChannel.isPresent()) {
//            User user = existingUser.get();
            Channel channel = existingChannel.get();
        System.out.println("channel : "+ channel);

//            post.setUser(user);
            post.setChannel(channel);
            post.setDatePost(new Date());
            postRepository.save(post);
            return post;
        }else {
            System.out.println("La personne n'existe pas pas");
            return null; // or throw an exception, depending on your application's requirements
        }
    }

    public Post updatePost(Post post, long id) {
//        System.out.println("id mis a jour : "+ id);
//        System.out.println("post : "+ post);
        Optional<Channel> existingChannelUpdate = channelRepository.findById(post.getIdChannel());

//        return post;

        if (existingChannelUpdate.isPresent()) {
//            User user = existingUser.get();
            Channel channel = existingChannelUpdate.get();
            System.out.println("channel upda : "+ channel);

//            post.setUser(user);
            post.setChannel(channel);
            post.setDatePost(new Date());
            post.setId(id);
            postRepository.save(post);
            return post;
        }else {
            System.out.println("La personne n'existe pas pas");
            return null; // or throw an exception, depending on your application's requirements
        }
    }
}
