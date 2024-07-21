package com.api.taskman.user.service;

import com.api.taskman.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UserService {
    public ResponseEntity<Object> registerUser(User user);
    public ResponseEntity<Object> getUserById(String userId);
    public ResponseEntity<Object> getUserByUsername(String username);
}
