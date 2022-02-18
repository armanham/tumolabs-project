package com.labs.project.service.common.exception;

public class LongOrShortUsernameException extends RuntimeException {

    private final String username;

    public LongOrShortUsernameException(String username) {
        super("Length of parameter 'username' must be great than 6 and less than 16. Passed username: " + username);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
