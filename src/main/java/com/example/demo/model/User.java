package com.example.demo.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
public class User {
    @Null
    private Integer id;
    @NotBlank
    private String login;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 8)
    private String password;
}
