package com.app.slackdame.controller;

import com.app.slackdame.entity.Post;
import com.app.slackdame.repository.PostRepository;
import com.app.slackdame.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }


    @GetMapping("/posts/channel/{id}")
    public List<Post> getPostsByChannelId(long id) {
        return postRepository.findByChannelId(id);
    }


    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable long id) {
        return postService.getPostById(id);
    }

    @PostMapping("/post")
    public void addPost(@RequestBody Post post) {
        postService.addPost(post);
    }

    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable long id) {
        postService.deletePost(id);
    }

    @PutMapping("/post/{id}")
    public void updatePost(@RequestBody Post post, @PathVariable long id) {
        postService.updatePost(post, id);
    }
}
