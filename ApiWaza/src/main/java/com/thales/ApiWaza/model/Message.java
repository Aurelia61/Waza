package com.thales.ApiWaza.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @ManyToOne
    private User fromUser;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("messagesReceived")
    private ChatRoom toChatRoom;

    @NonNull
    private byte[] content;

    private LocalDateTime sendTime = LocalDateTime.now();

    private boolean isRead;

    private MessageType type;

//    public Message(User fromUser, byte[] content) {
//        this.fromUser = fromUser;
//        this.content = content;
//    }
}
