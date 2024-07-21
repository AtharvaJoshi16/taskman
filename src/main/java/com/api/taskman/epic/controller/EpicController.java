package com.api.taskman.epic.controller;

import com.api.taskman.StatusCodes;
import com.api.taskman.entity.Epic;
import com.api.taskman.epic.model.EpicResponse;
import com.api.taskman.epic.service.EpicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/epic")
public class EpicController {

    @Autowired
    EpicService epicService;

    @GetMapping
    public ResponseEntity<Object> getAllEpics(@RequestParam String userId) {
        return epicService.getAllEpicsOfUser(userId);
    }

    @PostMapping
    public ResponseEntity<Object> addEpic(@RequestParam String userId, @RequestBody Epic epic) {
        return epicService.addEpic(userId, epic);
    }
}
