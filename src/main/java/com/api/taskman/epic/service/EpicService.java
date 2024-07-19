package com.api.taskman.epic.service;

import com.api.taskman.entity.Epic;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface EpicService {
    public ResponseEntity<Object> getAllEpicsOfUser(UUID userId);
    public ResponseEntity<Object> getEpic(UUID userId, String epicId);
    public ResponseEntity<Object> updateEpic(UUID userId, Epic epic);
    public ResponseEntity<Object> deleteEpic(UUID userId, String epicId);
    public ResponseEntity<Object> addEpic(UUID userId, Epic epic);
}
