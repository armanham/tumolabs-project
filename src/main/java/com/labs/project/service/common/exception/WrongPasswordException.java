package com.labs.project.service.common.exception;

public class WrongPasswordException extends RuntimeException {

    private final String password;

    public WrongPasswordException(String password) {
        super("Wrong 'Username' input: >" + password + "<. Try again.");
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
