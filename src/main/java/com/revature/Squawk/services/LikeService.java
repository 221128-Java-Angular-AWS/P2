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

    public Integer getLikeCount(Integer postId) {
        return likeRepo.getLikeCount(postId);
    }

    // allow users to unlike a post, return true if successfull, false if not
    public boolean deleteLike(Like like){
        like = getLike(like);
        if (like.getLikeId() != null) {
            likeRepo.deleteById(like.getLikeId());
            return true;
        }
        return false;
    }
}
