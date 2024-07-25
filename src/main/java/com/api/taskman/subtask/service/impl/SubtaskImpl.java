package com.api.taskman.subtask.service.impl;

import com.api.taskman.entity.Epic;
import com.api.taskman.entity.Subtask;
import com.api.taskman.entity.Task;
import com.api.taskman.entity.User;
import com.api.taskman.epic.model.EpicResponse;
import com.api.taskman.subtask.model.SubtaskResponse;
import com.api.taskman.subtask.repository.SubtaskRepository;
import com.api.taskman.subtask.service.SubtaskService;
import com.api.taskman.task.model.TaskResponse;
import com.api.taskman.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubtaskImpl implements SubtaskService {

    @Autowired
    SubtaskRepository repo;
    TaskRepository taskRepo;

    public SubtaskImpl(SubtaskRepository repo, TaskRepository taskRepo) {
        this.repo = repo;
        this.taskRepo = taskRepo;
    }

    @Override
    public ResponseEntity<Object> getAllSubtasksByTaskID(String taskId) {
        Task t = taskRepo.findById(taskId).orElse(null);
        if(t==null) {
            SubtaskResponse res = new SubtaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, String.format("TASK NOT FOUND WITH ID: %s", taskId));
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        List<Subtask> subtasks = repo.getAllSubtasks(taskId);
        SubtaskResponse res = new SubtaskResponse("SUCCESS", HttpStatus.OK.value(), HttpStatus.OK, subtasks, null, null);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getSubtaskByID(String subtaskId, String taskId) {
        Task t = taskRepo.findById(taskId).orElse(null);
        Subtask s = repo.findById(subtaskId).orElse(null);
        if(t==null) {
            SubtaskResponse res = new SubtaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, String.format("TASK NOT FOUND WITH ID: %s", taskId));
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        if(s == null) {
            SubtaskResponse res = new SubtaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, String.format("SUBTASK NOT FOUND WITH ID: %s", subtaskId));
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        Subtask subtask = repo.getSubtaskByTaskId(taskId, subtaskId);
        SubtaskResponse res = new SubtaskResponse("SUCCESS", HttpStatus.OK.value(), HttpStatus.OK, null, subtask, null);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> updateSubtask(String taskId, Subtask subtask) {
        Task t = taskRepo.findById(taskId).orElse(null);
        if(t == null) {
            SubtaskResponse res = new SubtaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, String.format("TASK NOT FOUND WITH ID: %s", taskId));
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        if(subtask.getSubtaskId() == null) {
            SubtaskResponse res = new SubtaskResponse(null, HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY, null, null, "REQUEST BODY MUST PROVIDE subtaskId");
            return new ResponseEntity<>(res, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        Subtask s = repo.getSubtaskByTaskId(taskId, subtask.getSubtaskId());

        if(s==null) {
            SubtaskResponse res = new SubtaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, String.format("SUBTASK NOT FOUND WITH ID: %s", subtask.getSubtaskId()));
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        Subtask updated = new Subtask(subtask);
        updated.setSubtaskId(s.getSubtaskId());
        updated.setCreatedAt(s.getCreatedAt());
        updated.setTask(t);
        repo.save(updated);
        SubtaskResponse res = new SubtaskResponse(String.format("SUBTASK UPDATED WITH ID: %s", subtask.getSubtaskId()), HttpStatus.CREATED.value(), HttpStatus.CREATED, null, subtask, null);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteSubtask(String taskId, String subtaskId) {
        Task t = taskRepo.findById(taskId).orElse(null);
        Subtask s = repo.getSubtaskByTaskId(taskId, subtaskId);

        if(t==null) {
            String errMessage = String.format("TASK NOT FOUND WITH ID: %s", taskId);
            SubtaskResponse res = new SubtaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, errMessage);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        if(subtaskId == null) {
            String errMessage = String.format("SUBTASK NOT FOUND WITH ID: %s", subtaskId);
            SubtaskResponse res = new SubtaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, errMessage);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        if(s==null) {
            String errMessage = String.format("SUBTASK NOT FOUND WITH TASK_ID: %s AND SUBTASK_ID: %s", taskId, subtaskId);
            SubtaskResponse res = new SubtaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, errMessage);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        } else {
            repo.deleteSubtaskById(taskId, subtaskId);
            SubtaskResponse res = new SubtaskResponse(String.format("SUBTASK DELETED WITH ID: %s", subtaskId), HttpStatus.OK.value(), HttpStatus.OK, null, null, null);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Object> addSubtask(String taskId, Subtask subtask) {
        Task t = taskRepo.findById(taskId).orElse(null);

        if(t==null) {
            String errMessage = String.format("TASK NOT FOUND WITH ID: %s", taskId);
            TaskResponse res = new TaskResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, errMessage);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        Subtask s = new Subtask(subtask);
        s.setSubtaskId(UUID.randomUUID().toString());
        s.setTask(t);
        repo.save(s);
        SubtaskResponse res = new SubtaskResponse(String.format("SUBTASK ADDED WITH ID: %s", s.getSubtaskId()), HttpStatus.CREATED.value(), HttpStatus.CREATED, null, null, null);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
