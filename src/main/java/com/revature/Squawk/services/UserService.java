package com.revature.Squawk.services;

import com.revature.Squawk.repositories.LikeRepository;
import com.revature.Squawk.repositories.PostRepository;
import com.revature.Squawk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // initialize the repository objects
    // going to start keeping these alphabetized for consistency
    private LikeRepository likeRepo;
    private PostRepository postRepo;
    private UserRepository userRepo;

    @Autowired
    public UserService(LikeRepository likeRepo, PostRepository postRepo, UserRepository userRepo) {
        this.likeRepo = likeRepo;
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }
}
