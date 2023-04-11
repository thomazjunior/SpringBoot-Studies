package com.springboot.studies.springsecurity.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.studies.springsecurity.entities.User;
import com.springboot.studies.springsecurity.services.CustomUserDetailService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
    private final CustomUserDetailService customUserDetailService;

    @PostMapping("/user")
    public void saveUser(@RequestBody User user) {
        customUserDetailService.createUser(user);
    }
}
