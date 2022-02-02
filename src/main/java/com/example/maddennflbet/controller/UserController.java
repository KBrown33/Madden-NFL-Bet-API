package com.example.maddennflbet.controller;


import com.example.maddennflbet.service.UserService;

@RestController
@RequestMapping("/auth/users")
public class UserController {

    private UserService userService;


    @PostMapping("/register/")
    public User createUser(@RequestBody)
}
