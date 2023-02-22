package com.thales.serveur.socket;

import com.thales.serveur.model.Login;
import com.thales.serveur.model.User;
import com.thales.serveur.service.AuthenticationService;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;

@Data
public class ReceiverAuthentication{

    private User connectedUser;

    @SneakyThrows
    public Login receiveLogin() {
        while (true) {
            // Create an ObjectMapper to serialize and deserialize objects to send or to receive
            ObjectMapper objectMapper = new ObjectMapper();

            // Create a server socket and bind it to a specific address and port number
            ServerSocket serverSocket = new ServerSocket(8060);

            // Accept (and wait) for incoming connections
            Socket socketFromInterface = serverSocket.accept();

            // Get input and output streams from the socket
            InputStream inputStream = socketFromInterface.getInputStream();
            OutputStream outputStream = socketFromInterface.getOutputStream();

            // Receive an object from the interface client via the socket input
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);

            // Deserialize this object in Login object
            Login receivedLogin = objectMapper.readValue(buffer, 0, bytesRead, Login.class);

            // Print the data from the object
            System.out.println("Mail reçu de l'interface: " + receivedLogin.getMail());
            System.out.println("ps reçu : " + receivedLogin.getPassword());

            // Instantiate authentication service
            AuthenticationService authService = new AuthenticationService();

            // Launch method to check if login (mail+password) is in db and get associated user
            connectedUser = authService.checkAuthenticationWithMailAndPassword(receivedLogin);
            System.out.println("Utilisateur connecté : " + connectedUser);

            // Serialize the object in JSON and send it via the socket output stream
            byte[] jsonBytes = objectMapper.writeValueAsBytes(connectedUser);
            outputStream.write(jsonBytes);

            // Close the sockets
            socketFromInterface.close();
            serverSocket.close();

            return receivedLogin;
        }
    }
}
