package com.api.taskman.task.service;

import com.api.taskman.entity.Task;
import org.springframework.http.ResponseEntity;

public interface TaskService {

    public ResponseEntity<Object> getAllTasksOfEpic(String epicId);
    public ResponseEntity<Object> getTask(String epicId, String taskId);
    public ResponseEntity<Object> addTask(String epicId, Task task);
    public ResponseEntity<Object> updateTask(String epicId, Task task);
    public ResponseEntity<Object> deleteTask(String epicId, String taskId);
}
