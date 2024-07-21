package com.api.taskman.epic.service.impl;

import com.api.taskman.StatusCodes;
import com.api.taskman.entity.Epic;
import com.api.taskman.entity.User;
import com.api.taskman.epic.model.EpicResponse;
import com.api.taskman.epic.repository.EpicRepository;
import com.api.taskman.epic.service.EpicService;
import com.api.taskman.user.model.UserResponse;
import com.api.taskman.user.repository.UserRepository;
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

    @Autowired
    UserRepository userRepo;

    public EpicImpl(EpicRepository repo) {
        this.repo = repo;
    }

    @Override
    public ResponseEntity<Object> getAllEpicsOfUser(String userId) {
        List<Epic> epics = repo.findEpicsByUserID(userId);
        EpicResponse res = new EpicResponse(null, HttpStatus.OK.value(), HttpStatus.OK, epics, null, null);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getEpic(String userId, String epicId) {
        Epic e = repo.findEpicByUserID(userId, epicId);
        if(e==null) {
            String errMessage = String.format("EPIC NOT FOUND WITH USER_ID: %s AND EPIC_ID: %s", userId, epicId);
            EpicResponse res = new EpicResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, errMessage);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        } else {
            EpicResponse res = new EpicResponse(null, HttpStatus.OK.value(), HttpStatus.OK, null, e, null);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Object> updateEpic(String userId, Epic epic) {

        User u = userRepo.findById(userId).orElse(null);
        Epic e = repo.findEpicByUserID(userId, epic.getEpicId());

        if(u==null) {
            String errMessage = String.format("USER NOT FOUND WITH ID: %s", userId);
            EpicResponse res = new EpicResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, errMessage);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        if(epic.getEpicId() == null) {
            String errMessage = String.format("REQUEST BODY MUST CONTAIN epicId");
            EpicResponse res = new EpicResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, errMessage);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        if(e==null) {
            String errMessage = String.format("EPIC NOT FOUND WITH USER_ID: %s AND EPIC_ID: %s", userId, epic.getEpicId());
            EpicResponse res = new EpicResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, errMessage);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        } else {
            Epic updatedEpic = new Epic(epic);
            updatedEpic.setEpicId(e.getEpicId());
            updatedEpic.setCreatedAt(e.getCreatedAt());
            updatedEpic.setUser(u);
            repo.save(updatedEpic);
            EpicResponse res = new EpicResponse("EPIC UPDATED", HttpStatus.CREATED.value(), HttpStatus.CREATED, null, null, null);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<Object> deleteEpic(String userId, String epicId) {
        User u = userRepo.findById(userId).orElse(null);
        Epic e = repo.findEpicByUserID(userId, epicId);

        if(u==null) {
            String errMessage = String.format("USER NOT FOUND WITH ID: %s", userId);
            EpicResponse res = new EpicResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, errMessage);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        if(epicId == null) {
            String errMessage = String.format("EPIC NOT FOUND WITH ID: %s", epicId);
            EpicResponse res = new EpicResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, errMessage);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        if(e==null) {
            String errMessage = String.format("EPIC NOT FOUND WITH USER_ID: %s AND EPIC_ID: %s", userId, epicId);
            EpicResponse res = new EpicResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, errMessage);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        } else {
            repo.deleteEpic(userId, epicId);
            EpicResponse res = new EpicResponse(String.format("EPIC DELETED WITH ID: %s", epicId), HttpStatus.OK.value(), HttpStatus.OK, null, null, null);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Object> addEpic(String userId, Epic epic) {
        User u = userRepo.findById(userId).orElse(null);
        if(u==null) {
            EpicResponse e = new EpicResponse(null, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, null, null, "USER NOT FOUND WITH ID: "+ userId);
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        } else {
            Epic newEpic = new Epic(epic);
            newEpic.setEpicId(UUID.randomUUID().toString());
            newEpic.setUser(u);
            repo.save(newEpic);
            EpicResponse e = new EpicResponse("EPIC ADDED", HttpStatus.CREATED.value(), HttpStatus.CREATED, null, null, null);
            return new ResponseEntity<>(e, HttpStatus.CREATED);
        }
    }
}
