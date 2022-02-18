package com.labs.project.persistance.user;

import com.labs.project.persistance.common.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class PersistentUser extends AbstractEntity {

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Column(name = "surname", nullable = false, length = 32)
    private String surname;

    @Column(name = "username", nullable = false, unique = true, length = 16)
    private String username;

    @Column(name = "password", nullable = false, length = 16)
    private String password;


    protected PersistentUser() {
        super();
    }

    public PersistentUser(final String name,
                          final String surname,
                          final String username,
                          final String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }
}