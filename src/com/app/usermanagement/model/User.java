package com.app.usermanagement.model;

import com.app.usermanagement.config.DatabaseConfig;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
        DatabaseConfig.saveUser(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}