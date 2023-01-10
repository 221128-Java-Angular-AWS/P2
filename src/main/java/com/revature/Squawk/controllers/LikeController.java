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

    // allow a user to like a post, maybe return like count to update the view
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody Like likePost(@RequestBody Like like){
        System.out.println(like.toString());
        // instead probably change to either return like count or -1
        like = likeService.likePost(like);
        Integer likeCount = likeService.getLikeCount(like.getPost().getPostId());
        System.out.println(likeCount);
        return likeService.likePost(like);
    }

    // check to see if a user has liked a post
    @GetMapping(value = "/{userId}/{postId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Boolean getLike(@PathVariable Integer userId, @PathVariable Integer postId){
        System.out.println("Like hit");
        // either test for null or change to boolean in service, this is to test if a user has liked a post already
        return likeService.getLikeStatus(userId, postId);
    }

    // return the like count for a post to add to the post information
    @GetMapping(value = "/count/{postId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Integer getLikeCount(@PathVariable Integer postId){
        // NOTE the request body has to be an object type in order to be deserialized
        System.out.println("Getting likes request body:");
        return likeService.getLikeCount(postId);
    }

    // update to reflect whether a like was successfully deleted or not
    @DeleteMapping(value = "/{userId}/{postId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Boolean deleteLike(@PathVariable Integer userId, @PathVariable Integer postId){
        System.out.println("Attempting to delete like:");
        System.out.println("user: " + userId + " post: " + postId);
        return(likeService.deleteLike(userId, postId));
    }
}
