package com.revature.Squawk.controllers;

import com.revature.Squawk.models.User;
import com.revature.Squawk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {
    private UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody User authorizeUser(@RequestBody String username, String password){
        return userService.authenticateUser(username, password);
    }
}
