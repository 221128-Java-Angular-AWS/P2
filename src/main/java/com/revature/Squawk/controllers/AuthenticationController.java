package com.revature.Squawk.controllers;

import com.revature.Squawk.models.User;
import com.revature.Squawk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.revature.Squawk.models.UserAuth;

import java.util.List;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {
    private UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody User authenticateUser(@RequestBody UserAuth userAuth){
        System.out.println(userAuth.username + userService.authenticateUser(userAuth));
        return userService.authenticateUser(userAuth);
    }

    @GetMapping(value = "/ping")
    @ResponseStatus(value = HttpStatus.OK)
    public String ping() {
        return "pong!";
    }

    @GetMapping(value = "all")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody List<User> allUsers() {
        return userService.allUsers();
    }
}
