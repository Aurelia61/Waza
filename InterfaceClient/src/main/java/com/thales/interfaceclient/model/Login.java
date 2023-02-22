package com.thales.interfaceclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login implements Serializable {
    private String mail;
    private String password;
    private User user;

    public Login(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

}
