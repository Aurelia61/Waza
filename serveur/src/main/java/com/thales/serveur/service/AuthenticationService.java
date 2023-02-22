package com.thales.serveur.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.thales.serveur.model.Login;
import com.thales.serveur.model.User;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class AuthenticationService {

    Login connectedLogin = null;
//    RestService restService;

    public User checkAuthenticationWithMailAndPassword(Login loginToCheck) throws IOException {
//        restService.openConnectionToAPI("/logins");

        // Open connection to API
        URL urlRequest = new URL("http://localhost:8080/waza/api/logins/");
        HttpURLConnection httpRequest = (HttpURLConnection) urlRequest.openConnection();

        ObjectMapper objectMapper = new ObjectMapper();

        // both lines below are to avoid null properties error
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

        // Map datas from API (json) with class attributs
        List<Login> dbLogins = objectMapper.readValue(urlRequest, new TypeReference<List<Login>>() {});

        // Instantiate user to check in db
        User userInDb = null;

        // For each mail and associated password in db, check if entered mail and password exist
        for (Login login : dbLogins) {
            // Check if the password and the email entered are the correct ones in the bdd (via the API)
            //todo change code : with mail check if password is the same
            if (!(login.getMail().equals(loginToCheck.getMail())) || (!login.getPassword().equals(loginToCheck.getPassword()))) {
                System.out.println("Login non correct");
                continue;
            } else
            //todo Check if user exists. Is it usefull ????
            //System.out.println(dbLogin.getUser().getPseudo());
            userInDb = login.getUser();
        }
        return userInDb;
    }
}
