package com.siges.controller;

import com.siges.model.UserModel;
import com.siges.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired(required = false)
    private UserRepository userRepository;

    @GetMapping("/homeUser")
    public String hello() {
        return "Hello World to SIGES APP!";
    }

    @PostMapping("/addUser")
    public String saveUser(@RequestBody UserModel user){
        userRepository.save(user);
        return "Added Successfully";
    }

    @GetMapping("/findAllUser")
    public List<UserModel> getUser() {
        return userRepository.findAll();
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
