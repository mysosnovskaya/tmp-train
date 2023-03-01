package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final List<User> userList = new ArrayList<>();
    private int idGenerator = 1;

    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setId(idGenerator++);
        userList.add(user);
        return user;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userList;
    }
}
