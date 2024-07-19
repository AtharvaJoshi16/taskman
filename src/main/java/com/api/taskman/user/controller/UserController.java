package com.api.taskman.user.controller;


import com.api.taskman.entity.User;
import com.api.taskman.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> getUser(@RequestParam String userId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
        return service.registerUser(user);
    }
}
