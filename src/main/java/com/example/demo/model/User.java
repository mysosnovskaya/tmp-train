package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class User {
    @Null(groups = CreateGroup.class)
    @NotBlank(groups = UpdateGroup.class)
    private Integer id;
    @NotBlank(groups = {CreateGroup.class, UpdateGroup.class})
    private String login;
    @Email(groups = {CreateGroup.class, UpdateGroup.class})
    @NotBlank(groups = {CreateGroup.class, UpdateGroup.class})
    private String email;
    @NotBlank(groups = {CreateGroup.class, UpdateGroup.class})
    @Size(min = 8, groups = {CreateGroup.class, UpdateGroup.class})
    private String password;
}
