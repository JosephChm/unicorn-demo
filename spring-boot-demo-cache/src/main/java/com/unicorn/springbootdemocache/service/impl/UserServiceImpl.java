package com.unicorn.springbootdemocache.service.impl;

import com.unicorn.springbootdemocache.dao.UserRepository;
import com.unicorn.springbootdemocache.entity.User;
import com.unicorn.springbootdemocache.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    // 使用 slf4j 作为日志框架
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @CachePut(value = "user",key = "#user.id")
    // @CachePut 缓存新增的或更新的数据到缓存，其中缓存名称为 user 数据的 key 是 user 的 id
    public User insertUser(User user) {
        User s = userRepository.save(user);
        LOGGER.info("为id、key 为{}的数据做了缓存", s.getId());
        return s;
    }

    @Override
    @CacheEvict(value = "user")
    // @CacheEvict 从缓存 user 中删除 key 为 id 的数据
    public void deleteUserById(Integer id) {
        LOGGER.info("删除了id、key 为{}的数据缓存", id);
        //userRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "user",key = "#id")
    // @Cacheable 缓存 key 为 id 的数据到缓存 user 中
    public User getUserById(Integer id) {
        User s = userRepository.findById(id).get();
        LOGGER.info("为id、key 为{}的数据做了缓存", id);
        return  s;
    }

    /**
     * 通过id修改单个用户
     */
    @CachePut(key = "#user.id")
    public User updateUserById(User user) {
        return this.userRepository.save(user);
    }
}
