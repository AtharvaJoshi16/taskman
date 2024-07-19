package com.api.taskman.epic.model;

import com.api.taskman.StatusCodes;
import com.api.taskman.entity.Epic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter @Setter
public class EpicResponse {
    private String message;
    private StatusCodes code;
    private HttpStatus status;
    private List<Epic> epics;
    private Epic epic;


    public EpicResponse(String message, StatusCodes code, HttpStatus status, List<Epic> epics, Epic epic) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.epics = epics;
        this.epic = epic;
    }
}
