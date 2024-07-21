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
            TaskResponse resp = new TaskResponse(String.format("TASK ADDED WITH ID: %s", newTask.getTaskId()), HttpStatus.CREATED.value(), HttpStatus.CREATED, null, null, null);
            return new ResponseEntity<>(resp, HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<Object> updateTask(String epicId, Task task) {
        Epic e = epicRepo.findById(epicId).orElse(null);

        if(e==null) {
            TaskResponse resp = new TaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, String.format("EPIC NOT FOUND WITH ID: %s", epicId));
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }

        if(task.getTaskId() == null) {
            TaskResponse resp = new TaskResponse(null, HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY, null, null, "REQUEST BODY MUST CONTAIN taskId");
            return new ResponseEntity<>(resp, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        Task t = repo.getTaskByID(epicId, task.getTaskId());
        if(t==null) {
            TaskResponse resp = new TaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, String.format("TASK NOT FOUND WITH ID: %s", task.getTaskId()));
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
        Task updatedTask = new Task(task);
        updatedTask.setTaskId(t.getTaskId());
        updatedTask.setCreatedAt(t.getCreatedAt());
        updatedTask.setEpic(e);
        repo.save(updatedTask);
        TaskResponse resp = new TaskResponse(String.format("TASK UPDATED WITH ID: %s", t.getTaskId()), HttpStatus.OK.value(), HttpStatus.OK, null, null, null);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteTask(String epicId, String taskId) {
        Epic e = epicRepo.findById(epicId).orElse(null);

        if(e==null) {
            TaskResponse resp = new TaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, String.format("EPIC NOT FOUND WITH ID: %s", epicId));
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
        Task t = repo.findById(taskId).orElse(null);
        if(t==null) {
            TaskResponse resp = new TaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, String.format("TASK NOT FOUND WITH ID: %s", taskId));
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
        repo.deleteTaskByID(epicId, taskId);
        TaskResponse resp = new TaskResponse(String.format("TASK DELETED WITH ID: %s", taskId), HttpStatus.OK.value(), HttpStatus.OK, null, null, null);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
