package com.labs.project.service.admin.model;

public class AdminCreationParameter {

    private final String username;

    private final String password;

    public AdminCreationParameter(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
