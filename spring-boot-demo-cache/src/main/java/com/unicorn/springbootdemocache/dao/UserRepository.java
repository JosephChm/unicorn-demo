package com.unicorn.springbootdemocache.dao;

import com.unicorn.springbootdemocache.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
