package com.api.taskman.user.service.impl;

import com.api.taskman.StatusCodes;
import com.api.taskman.entity.User;
import com.api.taskman.user.model.UserResponse;
import com.api.taskman.user.repository.UserRepository;
import com.api.taskman.user.service.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;
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
        repo.save(user);
        UserResponse res = new UserResponse(String.format("User added with ID: %s", user.getUserId()), null , HttpStatus.CREATED.value(), HttpStatus.CREATED, null);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getUserById(String userId) {
        UserResponse res = new UserResponse(null, null, HttpStatus.OK.value(), HttpStatus.OK, repo.findById(userId).get());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getUserByUsername(String username) {
        UserResponse res = new UserResponse(null, null, HttpStatus.OK.value(), HttpStatus.OK, repo.findByUsername(username));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
