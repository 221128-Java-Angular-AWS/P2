package com.revature.Squawk.controllers;

import com.revature.Squawk.models.Like;
import com.revature.Squawk.models.Post;
import com.revature.Squawk.models.User;
import com.revature.Squawk.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/likes")
public class LikeController {
    private LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    // allow a user to like a post
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody Like likePost(@RequestBody Like like){
        System.out.println(like.toString());
        return likeService.likePost(like);
    }

    // check to see if a user has liked a post
    @GetMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Like getLike(@RequestBody Like like){
        System.out.println("Like hit");
        System.out.println(like.getPost().getPostId());
        System.out.println(like.getUser().getUserId());
        // either test for null or change to boolean in service, this is to test if a user has liked a post already
        return likeService.getLike(like);
    }

    // return the like count for a post to add to the post information
    @GetMapping(value = "/count")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Integer getLikeCount(@RequestBody Post post){
        // NOTE the request body has to be an object type in order to be deserialized
        return likeService.getLikeCount(post.getPostId());
    }

    // update to reflect whether a like was successfully deleted or not
    @DeleteMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteLike(@RequestBody Like like){
        likeService.deleteLike(like);
    }
}
