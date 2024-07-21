package com.api.taskman.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "epics")
public class Epic {

    @Id
    private String epicId;
    private String epicImage;
    @Column(columnDefinition = "TEXT",unique = true)
    private String title;

    @OneToMany(mappedBy = "epic")
    private List<Task> tasks;
    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;
    @Lob
    private String description;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEpicId() {
        return epicId;
    }

    public void setEpicId(String epicId) {
        this.epicId = epicId;
    }

    public String getEpicImage() {
        return epicImage;
    }

    public void setEpicImage(String epicImage) {
        this.epicImage = epicImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public Epic(String epicId, String epicImage, String title, String description, Timestamp createdAt, Timestamp updatedAt, List<Task> tasks, User user) {
        this.epicId = epicId;
        this.epicImage = epicImage;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.tasks = tasks;
        this.user = user;
    }

    public Epic() {
    }

    public Epic(Epic e) {
        this.epicId = e.epicId;
        this.epicImage = e.epicImage;
        this.title = e.title;
        this.description = e.description;
        this.tasks = e.tasks;
        this.createdAt = e.createdAt;
        this.updatedAt = e.updatedAt;
        this.user = e.user;
    }
}
