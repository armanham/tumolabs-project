package com.labs.project.service.common.exception;

public class LongOrShortPasswordException extends RuntimeException {

    private final String password;

    public LongOrShortPasswordException(final String password) {
        super("Length of parameter 'password' must be great than 6 and less than 16. Passed password: " + password);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
