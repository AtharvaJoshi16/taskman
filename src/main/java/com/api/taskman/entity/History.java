package com.api.taskman.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "history")
public class History {
    @Id
    private UUID actionId;
    private String action;
    private Timestamp timestamp;
    @Lob
    private String diff;
}
