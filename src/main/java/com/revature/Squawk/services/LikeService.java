package com.revature.Squawk.services;

import com.revature.Squawk.models.Like;
import com.revature.Squawk.models.Post;
import com.revature.Squawk.models.User;
import com.revature.Squawk.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    private LikeRepository likeRepo;

    @Autowired
    public LikeService(LikeRepository likeRepo) {
        this.likeRepo = likeRepo;
    }

    public Like likePost(Like like){
        // add logic to check for existing like here also disable on front end if user already liked post
        if (getLike(like) == null) {
            System.out.println(like.getPost().getPostId());
            System.out.println(like.getUser().getUserId());

            likeRepo.save(like);
            //likeRepo.likePost(like.getPost().getPostId(), like.getUser().getUserId());
            like = getLike(like);
            System.out.println(like.toString());
        }
        // set up an error to throw if the like already existed
        return like;
    }

    public Like getLike(Like like){
        return likeRepo.getLike(like.getPost().getPostId(), like.getUser().getUserId());
    }

    public Like getLike(Integer userId, Integer postId){
        System.out.println("@getLike in service user: " + userId + " post: " + postId);
        Like like = likeRepo.getLike(postId, userId);
        return like;
    }

    // TODO: getLikeId method causes NullPointerException, could just test for like being null
    // Overload for get request parameters, retruns boolean whether a user has liked a post or not
    public Boolean getLikeStatus(Integer userId, Integer postId){
        Like like = likeRepo.getLike(postId, userId);
        if (like.getLikeId() != null) {
            return true;
        }
        return false;
    }

    public Integer getLikeCount(Integer postId) {
        System.out.println("Made it to service");
        return likeRepo.getLikeCount(postId);
    }

    // allow users to unlike a post, return true if successfull, false if not
    public boolean deleteLike(Integer userId, Integer postId){
        Like like = getLike(userId, postId);
        System.out.println("@service: user: " + userId + " post: " + postId);
        if (like.getLikeId() != null) {
            likeRepo.deleteById(like.getLikeId());
            return true;
        }
        return false;
    }
}
