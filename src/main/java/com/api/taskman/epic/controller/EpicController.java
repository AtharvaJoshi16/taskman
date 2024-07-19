package com.api.taskman.epic.controller;

import com.api.taskman.StatusCodes;
import com.api.taskman.entity.Epic;
import com.api.taskman.epic.model.EpicResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/epic")
public class EpicController {

    @GetMapping
    public ResponseEntity<Object> getAllEpics(@RequestParam String userId) {
        EpicResponse resp = new EpicResponse("DEMO", StatusCodes.OK, HttpStatus.OK, null, null);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
