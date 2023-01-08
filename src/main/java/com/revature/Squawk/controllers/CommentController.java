package com.revature.Squawk.controllers;

import com.revature.Squawk.models.Comment;
import com.revature.Squawk.models.Post;
import com.revature.Squawk.services.CommentService;
import com.revature.Squawk.services.LikeService;
import com.revature.Squawk.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/post")
public class CommentController {
    private final PostService postService;
    private final CommentService commentService;
    private final LikeService likeService;

    @Autowired
    public CommentController(PostService postService, CommentService commentService, LikeService likeService) {
        this.postService = postService;
        this.commentService = commentService;
        this.likeService = likeService;
    }

    @GetMapping(value = "/{postId}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Post getPost(@PathVariable Integer postId){
        return postService.getPost(postId);
    }

    @PostMapping(value = "/{postId}/comments")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Comment addComment(@PathVariable Integer postId, @RequestBody Comment comment) {
        System.out.println("doing addcomment 1");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        Post post = postService.getPost(postId);
        comment.setPost(post);
        comment.setPostedDate(now);
        System.out.println("doing addcomment 2");
        return commentService.createComment(comment);
    }

    @GetMapping(value = "/{postId}/comments")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Comment> getCommentsByPostId(@PathVariable Integer postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @PutMapping(value = "/{postId}/comments")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Comment updateCommentById(@PathVariable Integer postId, @RequestBody Comment newComment) {
        Comment comment = commentService.getCommentById(newComment.getCommentId());
        if (comment != null && Objects.equals(comment.getPost().getPostId(), postId)) {
            comment.setMessage(newComment.getMessage());
            return commentService.updateComment(comment);
        }

        return null;
    }

    @DeleteMapping(value = "/{postId}/comments")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCommentById(@PathVariable Integer postId, @RequestBody Comment deleteComment) {
        Comment comment = commentService.getCommentById(deleteComment.getCommentId());
        if (comment != null && Objects.equals(comment.getPost().getPostId(), postId)) {
            commentService.deleteComment(comment);
        }
    }
}
