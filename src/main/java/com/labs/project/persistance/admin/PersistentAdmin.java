package com.labs.project.persistance.admin;

import com.labs.project.persistance.common.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class PersistentAdmin extends AbstractEntity {

    @Column(name = "username", nullable = false, unique = true, length = 16)
    private String username;

    @Column(name = "password", nullable = false, length = 16)
    private String password;

    protected PersistentAdmin() {
        super();
    }

    public PersistentAdmin(final String username, final String password) {
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
