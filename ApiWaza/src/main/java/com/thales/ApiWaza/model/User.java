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
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String pseudo;
    private String firstName;
    private String lastName;
    private String status;
    private String role;

    @OneToOne(mappedBy = "user")
    @JoinColumn
    private Login login;

    @OneToMany(mappedBy = "fromUser")
    @JsonIgnoreProperties("fromUser")
    private List<Message> messages = new ArrayList<Message>();

    @ManyToMany
    @JoinTable(name="UsersInChatRoom",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="chatRoom_id"))
    private List<ChatRoom> chatRooms = new ArrayList<ChatRoom>();

    public User(@NonNull String pseudo, String firstName, String lastName, UserStatus status, UserRole role) {
        this.pseudo = pseudo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status.getName();
        this.role = role.getName();
    }

}
