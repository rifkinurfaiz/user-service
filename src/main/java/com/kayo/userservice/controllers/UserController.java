package com.kayo.userservice.controllers;

import com.kayo.userservice.dto.User;
import com.kayo.userservice.dto.request.UserRequest;
import com.kayo.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public User submitUser(@RequestBody UserRequest user) {
        return new User();
    }
}
