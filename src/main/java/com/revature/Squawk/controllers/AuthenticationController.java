package com.revature.Squawk.controllers;

import com.revature.Squawk.models.User;
import com.revature.Squawk.services.LogService;
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
    private LogService logService;

    @Autowired
    public AuthenticationController(UserService userService, LogService logService) {
        this.logService = logService;
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody List<User> authenticateUser(@RequestBody UserAuth userAuth){
        List<User> auth = userService.authenticateUser(userAuth);
        if(!auth.isEmpty()) {
            Integer authUserId =auth.get(0).getUserId();
            logService.logMsg("Successfuly signed in", authUserId);
        }
        return auth;
    }

    @GetMapping(value = "/ping")
    @ResponseStatus(value = HttpStatus.OK)
    public String ping() {
        return "pong!";
    }

    @GetMapping(value = "/all")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody List<User> allUsers() {
        return userService.allUsers();
    }
}
