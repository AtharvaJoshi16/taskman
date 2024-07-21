package com.api.taskman.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    private String taskId;
    private String taskImage;
    @Column(columnDefinition = "TEXT", unique = true)
    private String title;
    @Lob
    private String description;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
    @Value("1")
    private int priority;
    @Value("false")
    private boolean starred;
    private int eta;
    private List<String> attachments;
    private TaskStatus status;
    @ManyToOne
    @JoinColumn(name = "epicId")
    @JsonIgnore
    private Epic epic;
    @OneToMany(mappedBy = "task")
    private List<Subtask> subtasks;
    @Value("false")
    private boolean completed;

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskImage() {
        return taskImage;
    }

    public void setTaskImage(String taskImage) {
        this.taskImage = taskImage;
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

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    public Task() {
    }

    public Task(Task task) {
        this.taskId = task.taskId;
        this.taskImage = task.taskImage;
        this.title = task.title;
        this.description = task.description;
        this.createdAt = task.createdAt;
        this.updatedAt = task.updatedAt;
        this.priority = task.priority;
        this.starred = task.starred;
        this.eta = task.eta;
        this.attachments = task.attachments;
        this.status = task.status;
        this.epic = task.epic;
        this.subtasks = task.subtasks;
        this.completed = task.completed;
    }

    public Task(String taskId, String taskImage, String title, String description, Timestamp createdAt, Timestamp updatedAt, int priority, boolean starred, int eta, List<String> attachments, TaskStatus status, Epic epic, List<Subtask> subtasks, boolean completed) {
        this.taskId = taskId;
        this.taskImage = taskImage;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.priority = priority;
        this.starred = starred;
        this.eta = eta;
        this.attachments = attachments;
        this.status = status;
        this.epic = epic;
        this.subtasks = subtasks;
        this.completed = completed;
    }


}
