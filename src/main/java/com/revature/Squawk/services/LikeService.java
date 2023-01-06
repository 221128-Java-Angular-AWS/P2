package com.revature.Squawk.services;

import com.revature.Squawk.models.Like;
import com.revature.Squawk.repositories.LikeRepository;
import com.revature.Squawk.repositories.PostRepository;
import com.revature.Squawk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    // initialize the repository objects
    // going to start keeping these alphabetized for consistency
    private LikeRepository likeRepo;
    private PostRepository postRepo;
    private UserRepository userRepo;

    @Autowired  // create beans for likeRepo, postRepo, and userRepo
    public LikeService(LikeRepository likeRepo, PostRepository postRepo, UserRepository userRepo) {
        this.likeRepo = likeRepo;
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    // need fake data in the tables but will test the findLikeByPost query here
    // TODO: this actually only needs to return a count and needs to be updated in the repository
    public List<Like> findLikesForPost(Integer postId) {
        return likeRepo.findLikesByPostId(postId);
    }

    /* TODO: Create methods to:
        get postId list by userId
        check if like with userId and postId exists
        add like to postId
        delete like by userId and PostId
    * */



}
