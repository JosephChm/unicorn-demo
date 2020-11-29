package com.unicorn.demo.controller;

import com.unicorn.demo.domain.User;
import com.unicorn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/find")
    public Object find(Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping("/update")
    public Object update(Integer id, String name) {
        return userService.update(new User(id, name));
    }

    @GetMapping("/delete")
    public Object delete(Integer id) {
        userService.deleteById(new User(id));
        return "移除缓存 key = " + id;
    }

    @GetMapping("/deleteAll")
    public Object deleteAll() {
        userService.deleteAll();
        return "移除所有缓存";
    }
}
