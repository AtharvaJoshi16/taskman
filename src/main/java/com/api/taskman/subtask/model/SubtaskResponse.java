package com.api.taskman.subtask.model;

import com.api.taskman.entity.Epic;
import com.api.taskman.entity.Subtask;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.List;

public class SubtaskResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    private int code;
    private HttpStatus status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Subtask> subtasks;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Subtask subtask;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String err;

    public SubtaskResponse(String message, int code, HttpStatus status, List<Subtask> subtasks, Subtask subtask, String err) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.subtasks = subtasks;
        this.subtask = subtask;
        this.err = err;
    }

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

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    public Subtask getSubtask() {
        return subtask;
    }

    public void setSubtask(Subtask subtask) {
        this.subtask = subtask;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
