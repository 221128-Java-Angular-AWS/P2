package com.revature.Squawk.services;


import com.revature.Squawk.models.User;
import com.revature.Squawk.models.UserAuth;
import com.revature.Squawk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.*;
import java.util.List;


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


    public User authenticateUser(UserAuth userAuth){
        // System.out.println(userAuth.username + userAuth.password);
        if(BCrypt.checkpw(userAuth.password, userRepo.authUser(userAuth.username).getPassword())){
            return userRepo.authUser(userAuth.username);
        }else{
            return null;
        }
    }

    public User getUser(Integer userId){
        return userRepo.findById(userId).orElseThrow();
    }

    public List<User> searchUsers(String filter){
        return userRepo.findByUsernameContainsIgnoreCase(filter);
    }

    public User updateUser(User user){
        User originalUser = userRepo.findById(user.getUserId()).orElseThrow();
        originalUser.setUsername(user.getUsername());
        originalUser.setFirstName(user.getFirstName());
        originalUser.setLastName(user.getLastName());
        originalUser.setBio(user.getBio());

        return userRepo.save(originalUser);
    }

    public void deleteUser(User user){

    }
    public List<User> allUsers(){
        return userRepo.allUsers();
    }


}
