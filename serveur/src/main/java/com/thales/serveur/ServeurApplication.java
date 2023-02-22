package com.thales.serveur;

import com.thales.serveur.model.Login;
import com.thales.serveur.socket.ReceiverAuthentication;
import com.thales.serveur.socket.server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServeurApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ServeurApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Launch (messages) server
		server messageServer = new server();
		new Thread(messageServer).start();

//		// instantiate authentication service
//		AuthenticationService authService = new AuthenticationService();

/*		// Launch authentication server
		ReceiverAuthentication receiverAuthentication = new ReceiverAuthentication();
//		// Get mail and login from receiver
		Login loginToCheck = receiverAuthentication.receiveLogin();*/

//
//		// launch method to check if login (mail+password) is in db and get associated user
//		User userConnected = authService.checkAuthenticationWithMailAndPassword(loginToCheck);
//
//		System.out.println("Utilisateur connecté : " + userConnected);


	}
}
