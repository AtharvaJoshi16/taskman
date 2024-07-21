package com.api.taskman.task.controller;

import com.api.taskman.entity.Task;
import com.api.taskman.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    TaskService service;

    @GetMapping(params = "epicId")
    public ResponseEntity<Object> getTasks(@RequestParam String epicId) {
        return service.getAllTasksOfEpic(epicId);
    }

    @GetMapping(params = {"epicId", "taskId"})
    public ResponseEntity<Object> getTask(@RequestParam String epicId, @RequestParam String taskId) {
        return service.getTask(epicId, taskId);
    }

    @PostMapping(params = "epicId")
    public ResponseEntity<Object> addTask(@RequestParam String epicId, @RequestBody Task task) {
        return service.addTask(epicId, task);
    }

    @PutMapping
    public ResponseEntity<Object> updateTask(@RequestParam String epicId, @RequestBody Task task) {
        return service.updateTask(epicId, task);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteTask(@RequestParam String epicId, @RequestParam String taskId) {
        return service.deleteTask(epicId, taskId);
    }
}
