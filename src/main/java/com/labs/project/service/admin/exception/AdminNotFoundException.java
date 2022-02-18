package com.labs.project.service.admin.exception;

public class AdminNotFoundException extends RuntimeException {

    private final Long id;

    public AdminNotFoundException(final Long id) {
        super("Admin not found for 'id': " + id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
