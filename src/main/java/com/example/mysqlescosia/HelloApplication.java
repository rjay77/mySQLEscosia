package com.example.mysqlescosia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
        @Override
        public void start(Stage stage) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-page.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 500.0, 500.0);
                stage.setTitle("Login");
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    public static void main(String[] args) {
            CreateTable.createTable();
            launch();
        }
}