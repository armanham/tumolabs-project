package com.labs.project.service.common.exception;

public class UsernameAlreadyExistsException extends RuntimeException {

    private final String username;

    public UsernameAlreadyExistsException(final String username) {
        super("User for passed 'username' parameter already exists. Passed username: " + username);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
