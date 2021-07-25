package controller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;


public class Runner extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        new ApplicationWindow();
        mainStage.setOnCloseRequest(
                e -> {
                    Platform.exit();
                    System.exit(0);
                });
    }
}
