package com.api.taskman.entity;


import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "subtasks")
public class Subtask {

    @Id
    private String subtaskId;
    @Column(columnDefinition = "TEXT", unique = true)
    private String title;
    private Timestamp updatedAt;
    private int priority;
    private int eta;
    private TaskStatus status;
    @ManyToOne
    @JoinColumn(name = "taskId")
    private Task task;
    @Lob
    private String description;
    private Timestamp createdAt;

    public String getSubtaskId() {
        return subtaskId;
    }

    public void setSubtaskId(String subtaskId) {
        this.subtaskId = subtaskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }



    public Subtask(String subtaskId, String title, String description, Timestamp createdAt, Timestamp updatedAt, int priority, int eta, TaskStatus status, Task task) {
        this.subtaskId = subtaskId;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.priority = priority;
        this.eta = eta;
        this.status = status;
        this.task = task;
    }


}
