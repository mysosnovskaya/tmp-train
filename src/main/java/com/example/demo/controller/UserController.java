package com.example.demo.controller;

import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
@Slf4j
public class UserController {
    private final Map<Integer, User> usersById = new HashMap<>(
            Map.of(1,  new User(1, "admin", "admin@gamil.com", "123"))
    );
    private int idGenerator = 2;

    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setId(idGenerator++);
        usersById.put(user.getId(), user);
        return user;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return usersById.values().stream().filter(u -> u.getId() != 1).collect(Collectors.toList());
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        if (usersById.containsKey(user.getId())) {
            usersById.put(user.getId(), user);
            return user;
        } else {
            log.error("Пользователь с id = {} не найден", user.getId());
            throw new RuntimeException("Пользователь с таким id не существует");
        }
    }
}
