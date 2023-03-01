package com.example.demo.controller;

import com.example.demo.model.CreateGroup;
import com.example.demo.model.UpdateGroup;
import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
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

@RestController
@RequestMapping(value = "/users")
@Slf4j
public class UserController {
    private final Map<Integer, User> usersById = new HashMap<>();
    private int idGenerator = 1;

    @PostMapping
    public User createUser(@RequestBody @Validated(CreateGroup.class) User user) {
        if (usersById.values().stream().noneMatch(u -> u.getLogin().equals(user.getLogin()))) {
            user.setId(idGenerator++);
            usersById.put(user.getId(), user);
            return user;
        }
        throw new RuntimeException("не уникальный login");
    }

    @GetMapping
    public List<User> getAllUsers() {
        return new ArrayList<>(usersById.values());
    }

    @PutMapping
    public User updateUser(@RequestBody @Validated(UpdateGroup.class) User user) {
        if (usersById.containsKey(user.getId())) {
            usersById.put(user.getId(), user);
            return user;
        } else {
            log.error("Пользователь с id = {} не найден", user.getId());
            throw new RuntimeException("Пользователь с таким id не существует");
        }
    }
}
