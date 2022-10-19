package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class IncorrectCredentialsController {

    @FXML
    private Button confirmButton;

    @FXML
    void confirmButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

}
