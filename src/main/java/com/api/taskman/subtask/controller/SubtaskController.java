package com.api.taskman.subtask.controller;

import com.api.taskman.entity.Subtask;
import com.api.taskman.subtask.service.SubtaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subtasks")
public class SubtaskController {


    @Autowired
    SubtaskService service;

    public SubtaskController(SubtaskService service) {
        this.service = service;
    }

    @GetMapping(params = "taskId")
    public ResponseEntity<Object> getAllSubtasks(@RequestParam String taskId){
        return service.getAllSubtasksByTaskID(taskId);
    }

    @GetMapping(params = {"subtaskId", "taskId"})
    public ResponseEntity<Object> getSubtask(@RequestParam String subtaskId, @RequestParam String taskId){
        return service.getSubtaskByID(subtaskId,taskId);
    }

    @PostMapping
    public ResponseEntity<Object> addSubtask(@RequestParam  String taskId, @RequestBody Subtask subtask) {
        return service.addSubtask(taskId, subtask);
    }

    @PutMapping
    public ResponseEntity<Object> updateSubtask(@RequestParam String taskId, @RequestBody Subtask subtask) {
        return service.updateSubtask(taskId, subtask);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteSubtask(@RequestParam String taskId, @RequestParam String subtaskId) {
        return service.deleteSubtask(taskId, subtaskId);
    }

}
