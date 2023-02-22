package com.thales.ApiWaza.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="login")
public class Login {

    @Id
    @NonNull
    String mail;

    @NonNull
    String password;

    @OneToOne
    @JsonIgnoreProperties("login")
    private User user;

}
