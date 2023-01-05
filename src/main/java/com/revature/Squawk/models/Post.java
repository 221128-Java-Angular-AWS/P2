package com.revature.Squawk.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "Posts")
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column
    private String message;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "date_posted")
    private LocalDateTime datePosted;

    @Column(name = "user_id")
    private Integer userId;

    public Post() {
    }

    public Post(String message, String imageLink, LocalDateTime datePosted, Integer userId) {
        this.message = message;
        this.imageLink = imageLink;
        this.datePosted = datePosted;
        this.userId = userId;
    }

    public Post(Integer postId, String message, String imageLink, LocalDateTime datePosted, Integer userId) {
        this.postId = postId;
        this.message = message;
        this.imageLink = imageLink;
        this.datePosted = datePosted;
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public LocalDateTime getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postId, post.postId) && Objects.equals(message, post.message) && Objects.equals(imageLink, post.imageLink) && Objects.equals(datePosted, post.datePosted) && Objects.equals(userId, post.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, message, imageLink, datePosted, userId);
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", message='" + message + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", datePosted=" + datePosted +
                ", userId=" + userId +
                '}';
    }
}
