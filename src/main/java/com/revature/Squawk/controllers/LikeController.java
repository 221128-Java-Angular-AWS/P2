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

    // allow a user to like a post, maybe return like count to update the view
    // TODO: remove commented code when confirmed no errors
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody Like likePost(@RequestBody Like like){
        // instead probably change to either return like count or -1
        like = likeService.likePost(like);
//        Integer likeCount = likeService.getLikeCount(like.getPost().getPostId());
//        System.out.println(likeCount);
        return likeService.likePost(like);
    }

    // check to see if a user has liked a post
    @GetMapping(value = "/{userId}/{postId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Boolean getLike(@PathVariable Integer userId, @PathVariable Integer postId){
        // returns boolean, not currently used
        return likeService.getLikeStatus(userId, postId);
    }

    // return the like count for a post to add to the post information
    @GetMapping(value = "/count/{postId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Integer getLikeCount(@PathVariable Integer postId){
        // NOTE the request body has to be an object type in order to be deserialized
        return likeService.getLikeCount(postId);
    }

    @DeleteMapping(value = "/{userId}/{postId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Boolean deleteLike(@PathVariable Integer userId, @PathVariable Integer postId){
        return(likeService.deleteLike(userId, postId));
    }
}
