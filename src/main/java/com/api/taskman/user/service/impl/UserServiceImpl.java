package com.api.taskman.user.service.impl;

import com.api.taskman.StatusCodes;
import com.api.taskman.entity.User;
import com.api.taskman.user.model.UserResponse;
import com.api.taskman.user.repository.UserRepository;
import com.api.taskman.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public ResponseEntity<Object> registerUser(User user) {
        System.out.println(user.getEmail());
        User existing = repo.findById(user.getUserId()).get();
        if(existing != null) {
            UserResponse res = new UserResponse(null, String.format("User already exists with ID: %s", user.getUserId().toString()), StatusCodes.UNAUTHORIZED, HttpStatus.CONFLICT, null);
            return new ResponseEntity<>(res, HttpStatus.CONFLICT);
        } else {
            repo.save(user);
            UserResponse res = new UserResponse(String.format("User added with ID: %s", user.getUserId().toString()), null , StatusCodes.CREATED, HttpStatus.CREATED, null);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<Object> getUser(UUID userId) {
        return null;
    }
}
