package com.thales.ApiWaza.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "toChatRoom")
    private List<Message> messagesReceived = new ArrayList<Message>();

    @ManyToMany(mappedBy = "chatRooms")
    @JsonIgnoreProperties("chatRooms")
    private List<User> users = new ArrayList<User>();

}
