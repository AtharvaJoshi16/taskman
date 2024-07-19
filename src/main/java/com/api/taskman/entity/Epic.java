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
@Table(name = "epics")
public class Epic {

    @Id
    @GeneratedValue
    private UUID epicId;
    private String epicImage;
    @Column(columnDefinition = "TEXT",unique = true)
    private String title;
    @Lob
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "epic")
    private List<Task> tasks;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
