package com.api.taskman.entity;

public enum TaskStatus {
    NEW("NEW"), ACTIVE("ACTIVE"), COMPLETED("COMPLETED"), REJECTED("REJECTED"), BLOCKED("BLOCKED");

    TaskStatus(String status) {
        this.status = status;
    }

    private String status;
}
