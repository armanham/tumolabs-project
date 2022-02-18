package com.labs.project.service.user.model;

import com.labs.project.persistance.user.PersistentUser;

import java.time.LocalDateTime;

public class UserDetails {

    private final String name;

    private final String surname;

    private final String username;

    private final LocalDateTime createdOn;

    private final LocalDateTime updatedOn;

    public UserDetails(final PersistentUser user) {
        this.name = user.getName();
        this.surname = user.getSurname();
        this.username = user.getUsername();
        this.createdOn = user.getCreatedOn();
        this.updatedOn = user.getUpdatedOn();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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

    @Override
    public String toString() {
        return "UserDetails{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                "}\n";
    }
}
