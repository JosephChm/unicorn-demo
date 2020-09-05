package com.unicorn.springbootdemocache.controller;

import com.unicorn.springbootdemocache.entity.User;
import com.unicorn.springbootdemocache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public User saveUser() {
        User user = new User();
        user.setName("Adam");
        user.setAge(2);
        userService.insertUser(user);
        return user;
    }

    @RequestMapping("/get/{id}")
    public User getUser(@PathVariable(required = false) Integer id) {
        User user = userService.getUserById(id);
        return user;
    }

    @RequestMapping(value="/update/{id}")
    public User updateUser(@PathVariable(required = false) Integer id) {
        User user = userService.getUserById(id);
        if(user == null) {
            return null;
        }
        user.setName("Deft");
        user.setAge(2);
        userService.updateUserById(user);
        return user;
    }

    @RequestMapping("/delete/{id}")
    public Integer deleteUser(@PathVariable(required = false) Integer id) {
        userService.deleteUserById(id);
        return id;
    }

}
