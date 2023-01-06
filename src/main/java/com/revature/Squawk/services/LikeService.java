package com.revature.Squawk.services;

import com.revature.Squawk.models.Like;
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

    public Like likePost(Integer postId, Integer userId){
        return new Like();
    }

    public Like getLike(Integer postId, Integer userId){
        return new Like();
    }

    public void deleteLike(Integer postId, Integer userId){

    }
}
