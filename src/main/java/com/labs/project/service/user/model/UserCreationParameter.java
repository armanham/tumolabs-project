package com.labs.project.service.user.model;

public class UserCreationParameter {

    private final String name;

    private final String surname;

    private final String username;

    private final String password;

    public UserCreationParameter(final String name,
                                 final String surname,
                                 final String username,
                                 final String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }
}
