package com.app.slackdame.service;

import com.app.slackdame.entity.Post;
import com.app.slackdame.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

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
        postRepository.save(post);
        return post;
    }

    public Post updatePost(Post post, long id) {
        postRepository.save(post);
        return post;
    }
}
