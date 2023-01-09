package com.revature.Squawk.services;

import com.revature.Squawk.models.User;
import com.revature.Squawk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user){
        return new User();
    }

    public User authenticateUser(String username, String password){
        return new User();
    }

    public User getUser(Integer userId){
        return userRepo.findById(userId).orElseThrow();
    }

    public User updateUser(User user){

        System.out.println("We got here!/////////////////////////////////////////////////////////");
        User originalUser = userRepo.findById(user.getUserId()).orElseThrow();
        originalUser.setUsername(user.getUsername());
        originalUser.setFirstName(user.getFirstName());
        originalUser.setLastName(user.getLastName());
        originalUser.setBio(user.getBio());

        return userRepo.save(originalUser);
    }

    public void deleteUser(User user){

    }



}
