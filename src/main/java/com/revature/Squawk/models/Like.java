package com.revature.Squawk.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


// mark entity classes as @Entity, indicates this is a class that describes objects to persist in a database
// the @Table annotation is used to set attributes that control how the table schema will be built



@Entity(name = "likes")
@Table(schema = "public")
public class Like {
    // describing the table values while creating the object here
    @Id
    @Column(name = "like_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    //@Column(name = "post_id") this annotation cannot be used for ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    //@Column(name = "user_id")
    @JoinColumn(name = "user_id")
    private User user;

    public Like() {
    }

    public Like(Post post, User user) {
        this.post = post;
        this.user = user;
    }

    public Like(Integer id, Post post, User user) {
        this.id = id;
        this.post = post;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    // there probably will never be a reason to use this but why not have it
    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", post=" + post +
                ", user=" + user +
                '}';
    }
}
