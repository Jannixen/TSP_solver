package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertWindow {

    public AlertWindow(String error, String errorDescription) {
        start(error, errorDescription);
    }

    private void start(String error, String errorDescription) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog Box");
        alert.setHeaderText(error);
        alert.setContentText(errorDescription);
        alert.showAndWait();
    }

}