package com.revature.Squawk.services;

import com.revature.Squawk.models.User;
import com.revature.Squawk.models.UserAuth;
import com.revature.Squawk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<User> authenticateUser(UserAuth userAuth){
        System.out.println(userAuth.username + userAuth.password);
        return userRepo.authUser(userAuth.username, userAuth.password);
    }

    public User getUser(Integer userId){
        return new User();
    }

    public User updateUser(User user){
        return new User();
    }

    public void deleteUser(User user){

    }
    public List<User> allUsers(){
        return userRepo.allUsers();
    }

}
