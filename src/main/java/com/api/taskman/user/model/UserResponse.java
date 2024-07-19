package com.api.taskman.user.model;

import com.api.taskman.StatusCodes;
import com.api.taskman.entity.Epic;
import com.api.taskman.entity.User;
import org.springframework.http.HttpStatus;

import java.util.List;

public class UserResponse {
    private String message;
    private StatusCodes code;
    private HttpStatus status;
    private User user;
    private String err;

    public UserResponse(String message,String err, StatusCodes code, HttpStatus status,  User user) {
        this.message = message;
        this.err = err;
        this.code = code;
        this.status = status;
        this.user = user;
    }
}
