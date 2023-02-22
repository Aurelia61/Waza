package com.thales.serveur.socket;

import com.thales.serveur.model.Login;
import com.thales.serveur.model.User;
import com.thales.serveur.socket.ReceiverAuthentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    private Socket client;
    private BufferedReader in;
    private BufferedReader keyboard;
    private PrintWriter out;
    private ArrayList<ClientHandler> clients;
    private User connectedUser;

    // Constructor
    public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients) throws IOException {
        this.client = clientSocket;
        this.clients = clients;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }

    @Override
    public void run() {

        // Launch authentication server
        ReceiverAuthentication receiverAuthentication = new ReceiverAuthentication();

		// Get login from receiver
        Login connectedLogin = receiverAuthentication.receiveLogin();

        while (true) {
            String request = null;
            try {
                request = in.readLine();
                System.out.println(receiverAuthentication.getConnectedUser().getPseudo() + " : " + request);
                outToAll(request);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (request == null) {
                System.out.println("Le client s'est déconnecté.");
                break;
            }
        }

        out.close();
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void outToAll(String msg) {
        for (ClientHandler c : clients) {
            c.out.println(msg);
        }
    }
}
