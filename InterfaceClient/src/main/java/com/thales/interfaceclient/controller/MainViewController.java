package com.thales.interfaceclient.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
        @FXML
        private Label mailLabel;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {}

        public void displayMail(String pseudo){
                mailLabel.setText("Bonjour " + pseudo +  " !");
        }
}
