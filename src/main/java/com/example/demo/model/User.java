package com.example.demo.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String login;
    private String email;
    private String password;
}
