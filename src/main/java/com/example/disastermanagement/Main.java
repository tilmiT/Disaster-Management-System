
package com.example.disastermanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            DatabaseUtil.initializeDatabase();
            // Load the initial complaint form
            FXMLLoader loader = new FXMLLoader(getClass().getResource("complain.fxml"));
            Parent root = loader.load();

            // Set up and show the primary stage
            primaryStage.setTitle("Disaster Management System");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}