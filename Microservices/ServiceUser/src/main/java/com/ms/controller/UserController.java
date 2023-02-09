package com.ms.controller;

import com.ms.entity.User;
import com.ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return this.userService.save(user);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return this.userService.getAll();
    }

    @GetMapping("/getById")
    public User getUserById(@RequestParam String userId){
        return this.userService.getById(userId);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam String userId){
        this.userService.delete(userId);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user, @RequestParam String userId){
        return this.userService.update(user,userId);
    }
}
