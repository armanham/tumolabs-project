package com.labs.project.service.user.exceptions;

public class UserNotFoundException extends RuntimeException {

    private final Long id;

    public UserNotFoundException(final Long id) {
        super("User not found for 'id': " + id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
