package com.thales.serveur.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    // try to have the same name attributs that in API

    private int id;
    private String pseudo;
    private String firstName;
    private String lastName;
    private String status;
    private String role;
    private Login login;
//    private List<Message> messages = new ArrayList<Message>();
//    private List<ChatRoom> chatRooms = new ArrayList<ChatRoom>();

    public User(@NonNull String pseudo, String firstName, String lastName) {
        this.pseudo = pseudo;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.status = status.getName();
//        this.role = role.getName();
    }
}
