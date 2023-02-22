package com.thales.interfaceclient.socket;

import com.thales.interfaceclient.controller.AuthenticationController;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageConnection implements Runnable{

        // INTERACTIVE CONNECTION
        // Setup network
        String serverIp = "localhost";
        int serverPort = 8075;

        @SneakyThrows
        @Override
        public void run() {

            // Setup socket and communication
            Socket s = new Socket(serverIp, serverPort);

            ServerConnection serverConn = new ServerConnection(s);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            new Thread(serverConn).start();

            // Exchanges
            while (true) {
                String command = keyboard.readLine();
                if (command.equals("quit")) break;
                out.println(command);
            }

            s.close();
        }
    }

