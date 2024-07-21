package com.api.taskman.task.model;

import com.api.taskman.entity.Epic;
import com.api.taskman.entity.Task;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.List;

public class TaskResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    private int code;
    private HttpStatus status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Task> tasks;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Task task;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String err;

    public TaskResponse(String message, int code, HttpStatus status, List<Task> tasks, Task task, String err) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.tasks = tasks;
        this.task = task;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
