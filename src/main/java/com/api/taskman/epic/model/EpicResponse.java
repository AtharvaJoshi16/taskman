package com.api.taskman.epic.model;

import com.api.taskman.StatusCodes;
import com.api.taskman.entity.Epic;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.List;

public class EpicResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    private int code;
    private HttpStatus status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Epic> epics;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Epic epic;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String err;

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<Epic> getEpics() {
        return epics;
    }

    public void setEpics(List<Epic> epics) {
        this.epics = epics;
    }

    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }

    public EpicResponse(String message, int code, HttpStatus status, List<Epic> epics, Epic epic, String err) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.epics = epics;
        this.epic = epic;
        this.err = err;
    }
}
