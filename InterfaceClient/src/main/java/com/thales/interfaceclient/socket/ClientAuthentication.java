package com.thales.interfaceclient.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thales.interfaceclient.model.Login;
import com.thales.interfaceclient.model.User;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


@Data
public class ClientAuthentication implements Runnable{

    // Setup network
    String serverIp = "localhost";
    int serverPort = 8060;

    // Declare variables
    private String mailToSend;
    private String passwordToSend;
    private Login loginToCheck=null;

    private User connectedUser;

    // Constructor
    public ClientAuthentication(String mailToSend, String passwordToSend) {
        this.mailToSend = mailToSend;
        this.passwordToSend = passwordToSend;
    }

    @SneakyThrows
    @Override
    public void run() {

        // Create an ObjectMapper to serialize and deserialize objects to send or to receive
        ObjectMapper objectMapper = new ObjectMapper();

        // Create a socket and bind it to a specific address and port number
        Socket socketAuthentication = new Socket(serverIp, serverPort);

        // Get output and input streams from the socket
        OutputStream outputStream = socketAuthentication.getOutputStream();
        InputStream inputStream = socketAuthentication.getInputStream();

        // Create an instance of the class to send to the server
        loginToCheck = new Login(this.mailToSend, this.passwordToSend);

        // Serialize object Login in JSON
        byte[] jsonBytesLogin = objectMapper.writeValueAsBytes(loginToCheck);

        // Write the object to the socket
        outputStream.write(jsonBytesLogin);

        // Receiver a user from interface via input stream socket
        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
        connectedUser = objectMapper.readValue(buffer, 0, bytesRead, User.class);

        System.out.println("Utilisateur vérifié par le serveur : " + connectedUser.toString());

        // Close the socket connection
        socketAuthentication.close();

    }
}

