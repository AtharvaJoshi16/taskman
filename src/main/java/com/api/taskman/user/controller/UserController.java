package com.api.taskman.user.controller;


import com.api.taskman.StatusCodes;
import com.api.taskman.entity.User;
import com.api.taskman.user.model.UserResponse;
import com.api.taskman.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping (params = "userId")
    public ResponseEntity<Object> getUser(@RequestParam String userId) {
        return service.getUserById(userId);
    }

    @GetMapping(params = "username")
    public ResponseEntity<Object> getUserByUsername(@RequestParam String username) {
        return service.getUserByUsername(username);
    }

    @PostMapping
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return service.registerUser(user);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleException(DataIntegrityViolationException ex) {;
        UserResponse res = new UserResponse(null, "USER ALREADY EXISTS", HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, null);
        return new ResponseEntity<>(res, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleException(NoSuchElementException ex) {
        UserResponse res = new UserResponse(null, "USER NOT FOUND", HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null);
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
}
