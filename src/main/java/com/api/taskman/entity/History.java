package com.api.taskman.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "history")
public class History {
    @Id
    private UUID actionId;

    public UUID getActionId() {
        return actionId;
    }

    public void setActionId(UUID actionId) {
        this.actionId = actionId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    private String action;
    private Timestamp timestamp;

    public History(UUID actionId, String action, Timestamp timestamp, String diff) {
        this.actionId = actionId;
        this.action = action;
        this.timestamp = timestamp;
        this.diff = diff;
    }

    @Lob
    private String diff;
}
