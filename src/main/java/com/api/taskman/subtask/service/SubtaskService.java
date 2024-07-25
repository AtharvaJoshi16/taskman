package com.api.taskman.subtask.service;


import com.api.taskman.entity.Subtask;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

public interface SubtaskService {
    public ResponseEntity<Object> getAllSubtasksByTaskID(String taskId);
    public ResponseEntity<Object> getSubtaskByID(String subtaskId, String taskId);
    public ResponseEntity<Object> updateSubtask(String taskId, Subtask subtask);
    public ResponseEntity<Object> deleteSubtask(String taskId, String subtaskId);
    public ResponseEntity<Object> addSubtask(String taskId, Subtask subtask);
}
