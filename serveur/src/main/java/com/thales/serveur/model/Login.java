package com.thales.serveur.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Login implements Serializable {

    // try to have the same name attributs that in API

    private String mail;
    private String password;
    private User user;

    public Login(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public Login(String mail, String password, User user) {
        this.mail = mail;
        this.password = password;
        this.user = user;
    }
}
