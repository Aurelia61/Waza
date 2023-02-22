package com.thales.interfaceclient.controller;

import com.thales.interfaceclient.WazaApplication;
import com.thales.interfaceclient.socket.ClientAuthentication;
import com.thales.interfaceclient.socket.MessageConnection;
import com.thales.interfaceclient.socket.ServerConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Data;

import java.io.IOException;

@Data
public class AuthenticationController {

    @FXML
    private TextField mailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    // instantiate the program that manages the client socket
    private MessageConnection messageConnection = new MessageConnection();
    ;

    @FXML
    void sendLogin(ActionEvent event) throws IOException {
        // Launch socket
        Thread messageThread = new Thread(messageConnection);
        messageThread.start();

        // Check login with server
        ClientAuthentication clientAuthentication = new ClientAuthentication(mailField.getText(), passwordField.getText());
        new Thread(clientAuthentication).start();

        while (clientAuthentication.getConnectedUser() == null) {
        }

        // Load main view
        try {
            //
            FXMLLoader fxmlLoader = new FXMLLoader(WazaApplication.class.getResource("main-view.fxml"));
            //
            Parent mainScene = fxmlLoader.load();
            // set controller from the view that will appear after click on button
            MainViewController mainController = fxmlLoader.getController();
            // use a method of this controller
            mainController.displayMail(clientAuthentication.getConnectedUser().getPseudo());
            // get the window of the application (=Stage ) from the Scene associated with the loginButton
            Stage mainStage = (Stage) loginButton.getScene().getWindow();

//            mainStage.initStyle(StageStyle.DECORATED); //todo get back window border
//            mainStage.setTitle("Waza - main view"); // not used because borderless

            // create a scene
            Scene scene = new Scene(mainScene);
            // display main stage (= window)
            mainStage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
