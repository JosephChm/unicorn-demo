package com.unicorn.springbootdemojpa.dao;

import com.unicorn.springbootdemojpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    void deleteById(Long id);

}
