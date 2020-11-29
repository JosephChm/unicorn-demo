package com.unicorn.demo.service;

import com.unicorn.demo.domain.User;

public interface UserService {

    User findUserById(Integer id);

    User update(User user);

    void deleteById(User user);

    void deleteAll();
}