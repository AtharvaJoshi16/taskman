package com.api.taskman.epic.service.impl;

import com.api.taskman.StatusCodes;
import com.api.taskman.entity.Epic;
import com.api.taskman.epic.model.EpicResponse;
import com.api.taskman.epic.repository.EpicRepository;
import com.api.taskman.epic.service.EpicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EpicImpl implements EpicService {

    @Autowired
    EpicRepository repo;

    public EpicImpl(EpicRepository repo) {
        this.repo = repo;
    }

    @Override
    public ResponseEntity<Object> getAllEpicsOfUser(UUID userId) {
        List<Epic> epics = repo.findEpicsByUserID(userId);
        EpicResponse res = new EpicResponse(null, StatusCodes.OK, HttpStatus.OK, epics, null);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getEpic(UUID userId, String epicId) {
        return null;
    }

    @Override
    public ResponseEntity<Object> updateEpic(UUID userId, Epic epic) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteEpic(UUID userId, String epicId) {
        return null;
    }

    @Override
    public ResponseEntity<Object> addEpic(UUID userId, Epic epic) {
        return null;
    }
}
