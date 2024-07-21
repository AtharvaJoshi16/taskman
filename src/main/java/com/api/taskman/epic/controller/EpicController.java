package com.api.taskman.epic.controller;

import com.api.taskman.StatusCodes;
import com.api.taskman.entity.Epic;
import com.api.taskman.epic.model.EpicResponse;
import com.api.taskman.epic.service.EpicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/epic")
public class EpicController {

    @Autowired
    EpicService epicService;

    @GetMapping(params = "userId")
    public ResponseEntity<Object> getAllEpics(@RequestParam String userId) {
        return epicService.getAllEpicsOfUser(userId);
    }

    @GetMapping(params = {"userId", "epicId"})
    public ResponseEntity<Object> getEpicByUserId(@RequestParam String userId, @RequestParam String epicId) {
        return epicService.getEpic(userId, epicId);
    }

    @PutMapping
    public ResponseEntity<Object> updateEpic(@RequestParam String userId, @RequestBody Epic epic) {
        return epicService.updateEpic(userId, epic);
    }

    @PostMapping
    public ResponseEntity<Object> addEpic(@RequestParam String userId, @RequestBody Epic epic) {
        return epicService.addEpic(userId, epic);
    }

    @DeleteMapping(params = {"userId", "epicId"})
    public ResponseEntity<Object> updateEpic(@RequestParam String userId, @RequestParam String epicId) {
        return epicService.deleteEpic(userId, epicId);
    }
}
