package com.revature.Squawk.services;

import com.revature.Squawk.models.User;
import com.revature.Squawk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user){
        return userRepo.save(user);
    }

    public User authenticateUser(String username, String password){
        return new User();
    }

    public User getUser(Integer userId){
        return userRepo.findById(userId).orElseThrow();
    }

    public List<User> searchUsers(String filter){
        return userRepo.findByUsernameContains(filter);
    }

    public User updateUser(User user){

        User originalUser = userRepo.findById(user.getUserId()).orElseThrow();

        System.out.println("Updated: " + user.getUsername() + " to " + originalUser.getUsername());

        originalUser.setUsername(user.getUsername());
        originalUser.setFirstName(user.getFirstName());
        originalUser.setLastName(user.getLastName());
        originalUser.setBio(user.getBio());

        return userRepo.save(originalUser);
    }

    public void deleteUser(User user){

    }



}
