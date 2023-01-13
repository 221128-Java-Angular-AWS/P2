package com.revature.Squawk.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity(name = "Users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String bio;

    // adding in password reset functionality
    @Column(name = "security_question", length = 500)
    private String securityQuestion;

    @Column(name = "security_answer", length = 500)
    private String securityAnswer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference(value = "post_user")
    List<Post> posts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference(value = "like_user")
    List<Like> likes;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }
    
    public User(String firstName, String lastName, String username, String password, String email, String bio) {
        System.out.println("most args no id hit");
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.bio = bio;
    }

    public User(Integer userId, String firstName, String lastName, String username, String password, String email, String bio) {
        System.out.println("most args hit");
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.bio = bio;
    }

    // updated all args constructor with password reset required fields
    public User(Integer userId, String firstName, String lastName, String username, String password, String email, String bio, String securityQuestion, String securityAnswer) {
        System.out.println("all args hit");
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.bio = bio;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }

    /*
    // constructor to create a user from the password reset request, no security answer for security reasons
    public User(Integer userId, String securityQuestion) {
        System.out.println("id, question hit");
        this.userId = userId;
        this.securityQuestion = securityQuestion;
    }

    // constructor for validating the user's security question and updating password
    public User(Integer userId, String password, String securityAnswer) {
        System.out.println("answer constructor hit");
        this.userId = userId;
        this.password = password;
        this.securityAnswer = securityAnswer;
    }*/

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    // adding in getters and setters for password reset functionality
    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    // TODO: do we actually need to update equals and hashcode to include password reset security question/answer
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(bio, user.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, username, password, email, bio);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}