package com.api.taskman.epic.service;

import com.api.taskman.entity.Epic;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface EpicService {
    public ResponseEntity<Object> getAllEpicsOfUser(String userId);
    public ResponseEntity<Object> getEpic(String userId, String epicId);
    public ResponseEntity<Object> updateEpic(String userId, Epic epic);
    public ResponseEntity<Object> deleteEpic(String userId, String epicId);
    public ResponseEntity<Object> addEpic(String userId, Epic epic);
}
