package com.revature.Squawk.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "Comments")
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference (value = "comment_post")
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference (value = "comment_user")
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "posted_date")
    private LocalDateTime postedDate;

    @Column
    private String message;

    public Comment() {
    }

    public Comment(Post post, User user, LocalDateTime postedDate, String message) {
        this.post = post;
        this.user = user;
        this.postedDate = postedDate;
        this.message = message;
    }

    public Comment(Integer commentId, Post post, User user, LocalDateTime postedDate, String message) {
        this.commentId = commentId;
        this.post = post;
        this.user = user;
        this.postedDate = postedDate;
        this.message = message;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDateTime postedDate) {
        this.postedDate = postedDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId) && Objects.equals(post, comment.post) && Objects.equals(user, comment.user) && Objects.equals(postedDate, comment.postedDate) && Objects.equals(message, comment.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, post, user, postedDate, message);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", post=" + post +
                ", user=" + user +
                ", postedDate=" + postedDate +
                ", message='" + message + '\'' +
                '}';
    }
}
