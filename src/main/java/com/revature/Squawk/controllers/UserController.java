package com.revature.Squawk.controllers;

import com.revature.Squawk.models.User;
import com.revature.Squawk.services.UserService;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody User getUser(@RequestParam Integer userId){
        return userService.getUser(userId);
    }

    @GetMapping(value = "/search")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody List<User> searchUsers(@RequestParam String filter){
        return userService.searchUsers(filter);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }


}
