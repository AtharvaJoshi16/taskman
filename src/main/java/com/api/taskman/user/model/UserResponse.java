package com.api.taskman.user.model;

import com.api.taskman.StatusCodes;
import com.api.taskman.entity.Epic;
import com.api.taskman.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.List;

public class UserResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    private int code;

    private HttpStatus status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User user;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String err;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }


    public UserResponse(String message,String err, int code, HttpStatus status,  User user) {
        this.message = message;
        this.err = err;
        this.code = code;
        this.status = status;
        this.user = user;
    }
}
