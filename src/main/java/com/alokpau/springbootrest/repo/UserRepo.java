package com.alokpau.springbootrest.repo;

import com.alokpau.springbootrest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}
