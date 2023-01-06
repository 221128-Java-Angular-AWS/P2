package com.revature.Squawk.controllers;

import com.revature.Squawk.models.Like;
import com.revature.Squawk.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/likes")
public class LikeController {
    private LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody Like likePost(@RequestBody Integer postId, Integer userId){
        return likeService.likePost(postId, userId);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Like getLike(@RequestBody Integer postId, Integer userId){
        return likeService.getLike(postId, userId);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteLike(@RequestBody Integer postId, Integer userId){
        likeService.deleteLike(postId, userId);
    }
}
