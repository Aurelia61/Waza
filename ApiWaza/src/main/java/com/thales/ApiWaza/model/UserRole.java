package com.thales.ApiWaza.model;

public enum UserRole {
    ADMIN("admin"),
    CHATTER("chatter");

    private String name;

    UserRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
