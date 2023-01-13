package com.revature.Squawk.controllers;

import com.revature.Squawk.models.Comment;
import com.revature.Squawk.models.Post;
import com.revature.Squawk.models.Reply;
import com.revature.Squawk.services.CommentService;
import com.revature.Squawk.services.PostService;
import com.revature.Squawk.services.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/posts")
public class ReplyController {
    private final PostService postService;
    private final CommentService commentService;
    private final ReplyService replyService;

    @Autowired
    public ReplyController(PostService postService, CommentService commentService, ReplyService replyService) {
        this.postService = postService;
        this.commentService = commentService;
        this.replyService = replyService;
    }

    @PostMapping(value = "/{postId}/comments/{commentId}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Reply addReply(@PathVariable Integer postId, @PathVariable Integer commentId, @RequestBody Reply reply) {
        LocalDateTime now = LocalDateTime.now();
        Post post = postService.getPost(postId);
        Comment comment = commentService.getCommentById(commentId);
        reply.setPost(post);
        reply.setComment(comment);
        reply.setPostedDate(now);
        System.out.println(reply.toString());
        return replyService.createReply(reply);
    }

    @GetMapping(value = "/{postId}/comments/{commentId}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Reply> getReplies(@PathVariable Integer postId, @PathVariable Integer commentId) {
        return replyService.getRepliesByCommentId(postId, commentId);
    }

    @PutMapping(value = "/{postId}/comments/{commentId}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Reply updateReply(@PathVariable Integer postId, @PathVariable Integer commentId, @RequestBody Reply newReply) {
        Reply reply = replyService.getByReplyId(newReply.getReplyId());
        if (reply != null && Objects.equals(reply.getPost().getPostId(), postId) && Objects.equals(reply.getComment().getCommentId(), commentId)) {
            reply.setMessage(newReply.getMessage());
            return replyService.updateReply(reply);
        }

        return null;
    }

    @DeleteMapping(value = "/{postId}/comments/{commentId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteReply(@PathVariable Integer postId, @PathVariable Integer commentId, @RequestBody Reply oldReply) {
        Reply reply = replyService.getByReplyId(oldReply.getReplyId());
        if (reply != null && Objects.equals(reply.getPost().getPostId(), postId) && Objects.equals(reply.getComment().getCommentId(), commentId)) {
            replyService.deleteReply(reply);
        }
    }
}
