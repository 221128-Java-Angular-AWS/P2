package com.revature.Squawk.services;

import com.revature.Squawk.models.Post;
import com.revature.Squawk.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private PostRepository postRepo;

    @Autowired
    public PostService(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    public Post createPost(Post post){
        return postRepo.save(post);
    }

    public Post getPost(Integer postId){
        return postRepo.findById(postId).orElse(new Post());
    }

    public List<Post> getPosts(){
        return new ArrayList<Post>();
    }

    public List<Post> getPosts(Integer userId){
        return new ArrayList<Post>();
    }

    public Post updatePost(Post post){
        return new Post();
    }

    public void deletePost(Post post){

    }
}
