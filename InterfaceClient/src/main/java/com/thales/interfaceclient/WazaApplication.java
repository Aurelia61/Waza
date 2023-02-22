package com.thales.interfaceclient;

import com.thales.interfaceclient.socket.MessageConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class WazaApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WazaApplication.class.getResource("authentication-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("~~~ WAZA ~~~");  // not used because borderless
        stage.setScene(scene);

        // Display stage (window) borderless
        stage.initStyle(StageStyle.UNDECORATED);

        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}

