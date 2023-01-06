package com.revature.Squawk.services;

import com.revature.Squawk.models.Comment;
import com.revature.Squawk.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepo;

    @Autowired
    public CommentService(CommentRepository commentRepo) {
        this.commentRepo = commentRepo;
    }

    public Comment createComment(Comment comment){
        return new Comment();
    }

    public List<Comment> getComments(Integer postId){
        return new ArrayList<Comment>();
    }

    public Comment updateComment(Comment comment){
        return new Comment();
    }

    public void deleteComment(Comment comment){

    }
}
