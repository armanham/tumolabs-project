package com.labs.project.service.admin.model;

import com.labs.project.persistance.admin.PersistentAdmin;

import java.time.LocalDateTime;

public class AdminDetails {

    private final String username;

    private final LocalDateTime createdOn;

    private final LocalDateTime updatedOn;

    public AdminDetails(final PersistentAdmin admin) {
        this.username = admin.getUsername();
        this.createdOn = admin.getCreatedOn();
        this.updatedOn = admin.getUpdatedOn();
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }
}
