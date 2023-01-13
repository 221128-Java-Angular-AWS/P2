package com.revature.Squawk.controllers;

import com.revature.Squawk.models.Comment;
import com.revature.Squawk.models.User;
import com.revature.Squawk.services.CommentService;
import com.revature.Squawk.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {
    private CommentService commentService;
    private LogService logService;

    @Autowired
    public CommentController(CommentService commentService, LogService logService) {
        this.commentService = commentService;
        this.logService = logService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody Comment createComment(@RequestBody Comment comment) {
        Comment c = commentService.createComment(comment);
        logService.logMsg("Created a comment", c.getUser());
        return c;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody List<Comment> getComments(@RequestBody Integer postId){
        return commentService.getComments(postId);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody Comment updateComment(@RequestBody Comment comment){
        Comment c = commentService.updateComment(comment);
        logService.logMsg("Updated a comment", c.getUser());
        return c;
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteComment(@RequestBody Comment comment){
        User user = comment.getUser();
        commentService.deleteComment(comment);
        logService.logMsg("Deleted a comment", user);
    }

}
