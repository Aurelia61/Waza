package com.thales.serveur.socket;

import com.thales.serveur.model.Login;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class server implements Runnable{

    // attribut to get login from the program for user interface
    Login loginToCheck = null;

    // define how many clients will be connected in same time
    private static int nbMaxConnectedClient = 10;

    // INTERACTIVE CONNECTION

    // Setup port
    private static int port = 8075;

    // Create a list of clients
    private static ArrayList<ClientHandler> clients = new ArrayList<>();

    // Create an executor service for 4 clients
    private static ExecutorService pool = Executors.newFixedThreadPool(nbMaxConnectedClient);

    @SneakyThrows
    @Override
    public void run() {
        // Setup socket
        ServerSocket listener = new ServerSocket(port);

        // Run an infinite loop to keep incoming requests
        while (true) {
            Socket clientSocket = listener.accept();
            System.out.println("[message server]Nouvelle personne connectée : " + clientSocket);

            // Create a new clienthandler connected to all the clients
            ClientHandler clientThread = new ClientHandler(clientSocket, clients);
            clients.add(clientThread);

            // Run executor
            pool.execute(clientThread);
        }

        //todo when listener (seversocket) closed, when client is disconnected
    }
}
