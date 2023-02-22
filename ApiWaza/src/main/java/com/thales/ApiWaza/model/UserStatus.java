package com.thales.ApiWaza.model;


public enum UserStatus {
    ACTIVE("active"),
    DONOTDISTURB("disturb"),
    AWAY("away"),
    INVISIBLE("invisible");

    private String name;

    UserStatus(String name) { this.name=name;
    }

    public String getName() {
        return name;
    }
}
