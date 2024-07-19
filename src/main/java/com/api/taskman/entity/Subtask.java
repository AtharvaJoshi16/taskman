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
@Table(name = "subtasks")
public class Subtask {

    @Id
    @GeneratedValue
    private UUID subtaskId;
    @Column(columnDefinition = "TEXT", unique = true)
    private String title;
    @Lob
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int priority;
    private int eta;
    private TaskStatus status;
    @ManyToOne
    @JoinColumn(name = "taskId")
    private Task task;
}
