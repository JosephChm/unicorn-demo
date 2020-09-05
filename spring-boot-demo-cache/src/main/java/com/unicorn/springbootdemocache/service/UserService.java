package com.unicorn.springbootdemocache.service;

import com.unicorn.springbootdemocache.entity.User;

public interface UserService {

    /**
     * 新增用户
     */
    public User insertUser(User user);

    /**
     * 通过id查找单个用户
     */
    public User getUserById(Integer id);

    /**
     * 通过id修改单个用户
     */
    public User updateUserById(User user);

    /**
     * 通过id删除单个用户
     */
    public void deleteUserById(Integer id);

}
