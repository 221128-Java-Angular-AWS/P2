package com.revature.Squawk.controllers;

import com.revature.Squawk.models.Post;
import com.revature.Squawk.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody Post createNewPost(@RequestBody Post post){
        post.setDatePosted(LocalDateTime.now());
        System.out.println(post);
        return postService.createPost(post);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Post getPost(@RequestBody Integer postId){
        return postService.getPost(postId);
    }

    @GetMapping(value = "/feed")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody List<Post> getPosts(){
        return postService.getPosts();
    }

    @GetMapping(value = "/user")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody List<Post> getUserPosts(@RequestBody Integer userId){
        return postService.getPosts(userId);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Post updatePost(@RequestBody Post post){
        return postService.updatePost(post);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deletePost(@RequestBody Post post){
        postService.deletePost(post);
    }

}
