package com.labs.project.service.common.exception;

public class UsernameNotFoundException extends RuntimeException {

    private final String username;

    public UsernameNotFoundException(String username) {
        super("Passed 'Username' do not exists: >" + username + "<. Try again.");
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
