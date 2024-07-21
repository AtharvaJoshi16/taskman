package com.api.taskman.user.repository;

import com.api.taskman.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u from User u WHERE u.username= :username")
    User findByUsername(String username);
}
