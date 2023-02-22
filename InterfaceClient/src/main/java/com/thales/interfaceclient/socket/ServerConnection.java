package com.thales.interfaceclient.socket;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerConnection implements Runnable{
    private Socket server;
    private BufferedReader in;

    // Constructor
    public ServerConnection(Socket s) throws IOException {
        server = s;
        in = new BufferedReader(new InputStreamReader(server.getInputStream()));
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            System.out.println("Client -> ");
            String serverResponse = in.readLine();
            if (serverResponse == null) break;
            System.out.println("Serveur : " + serverResponse);
        }
        in.close();
    }
}
