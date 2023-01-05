package com.revature.Squawk.controllers;

import com.revature.Squawk.models.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    public PostController() {
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Post createNewPost(@RequestBody Post newPost){
        newPost.setDatePosted(LocalDateTime.now());
        System.out.println(newPost);
        return newPost;
    }

}
