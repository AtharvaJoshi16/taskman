package com.api.taskman.task.service.impl;

import com.api.taskman.entity.Epic;
import com.api.taskman.entity.Task;
import com.api.taskman.epic.repository.EpicRepository;
import com.api.taskman.task.model.TaskResponse;
import com.api.taskman.task.repository.TaskRepository;
import com.api.taskman.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaskImpl implements TaskService {

    @Autowired
    TaskRepository repo;
    @Autowired
    EpicRepository epicRepo;

    @Override
    public ResponseEntity<Object> getAllTasksOfEpic(String epicId) {
        Epic e = epicRepo.findById(epicId).orElse(null);
        if(e == null) {
            TaskResponse resp = new TaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, String.format("EPIC NOT FOUND WITH ID: %s", epicId));
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
        TaskResponse resp = new TaskResponse(null, HttpStatus.OK.value(), HttpStatus.OK, repo.getTasksByEpicID(epicId), null, null);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getTask(String epicId, String taskId) {
        Epic e = epicRepo.findById(epicId).orElse(null);
        Task t = repo.findById(taskId).orElse(null);
        if(e == null) {
            TaskResponse resp = new TaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, String.format("EPIC NOT FOUND WITH ID: %s", epicId));
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
        if(t==null) {
            TaskResponse resp = new TaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, String.format("TASK NOT FOUND WITH ID: %s", taskId));
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }

        TaskResponse resp = new TaskResponse(null, HttpStatus.OK.value(), HttpStatus.OK, null, repo.getTaskByID(epicId, taskId), null);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> addTask(String epicId, Task task) {
        Epic e = epicRepo.findById(epicId).orElse(null);
        if(e==null) {
            TaskResponse resp = new TaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, String.format("EPIC NOT FOUND WITH ID: %s", epicId));
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
        else {
            Task newTask = new Task(task);
            newTask.setEpic(e);
            newTask.setTaskId(UUID.randomUUID().toString());
            repo.save(newTask);
            TaskResponse resp = new TaskResponse("TASK ADDED", HttpStatus.CREATED.value(), HttpStatus.CREATED, null, null, null);
            return new ResponseEntity<>(resp, HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<Object> updateTask(String epicId, Task task) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteTask(String epicId, String taskId) {
        return null;
    }
}
