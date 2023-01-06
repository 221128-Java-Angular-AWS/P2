package com.revature.Squawk.controllers;

import com.revature.Squawk.models.Comment;
import com.revature.Squawk.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody List<Comment> getComments(@RequestBody Integer postId){
        return commentService.getComments(postId);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Comment updateComment(@RequestBody Comment comment){
        return commentService.updateComment(comment);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteComment(@RequestBody Comment comment){
        commentService.deleteComment(comment);

    }

}
