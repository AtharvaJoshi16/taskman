package com.api.taskman.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue
    private UUID taskId;
    private String taskImage;
    @Column(columnDefinition = "TEXT", unique = true)
    private String title;
    @Lob
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int priority;
    private boolean starred;
    private int eta;
    private List<String> attachments;
    private TaskStatus status;
    @ManyToOne
    @JoinColumn(name = "epicId")
    private Epic epic;
    @OneToMany(mappedBy = "task")
    private List<Subtask> subtasks;
}
