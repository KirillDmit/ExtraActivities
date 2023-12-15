package com.example.extraactivities.controllers;

import com.example.extraactivities.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.extraactivities.models.User;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
        User user = userService.findOne(id);
        if(user == null)
            throw new NoSuchElementException("There is no user with ID = " + id + " in Database");
        return user;
    }

    @PostMapping("/")
    public User addNewUser(@RequestBody User user){
        userService.save(user);
        return user;
    }

    @PutMapping("/")
    public User updateUser(@RequestBody User user){
        userService.save(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        User user = userService.findOne(id);
        if(user == null)
            throw new NoSuchElementException("There is no user with ID = " + id + " in Database");
        userService.delete(id);
        return String.format("User with ID = %d was deleted", id);
    }
}
