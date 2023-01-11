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
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody Post createNewPost(@RequestBody Post post){
        post.setDatePosted(LocalDateTime.now());
        System.out.println(post);
        Post returnPost = postService.createPost(post);
        System.out.println("Return: " + returnPost);
        return returnPost;
    }
    
    @GetMapping(value = "/{postId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Post getPost(@PathVariable Integer postId){
        Post post = postService.getPost(postId);
        System.out.println(post);
        return post;
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

    @DeleteMapping(value = "/{postId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deletePostById(@PathVariable Integer postId){
        postService.deletePostById(postId);
    }

}
