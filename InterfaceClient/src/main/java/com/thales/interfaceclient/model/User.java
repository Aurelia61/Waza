package com.thales.interfaceclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private int id;
    private String pseudo;
    private String firstName;
    private String lastName;
    private String status;
    private String role;
    private Login login;
//    private List<ChatRoom> chatRooms;
//    private List<Message> messages;

}
