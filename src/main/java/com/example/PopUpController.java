package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PopUpController {

    @FXML
    private Button confirmButton;

    @FXML
    private Label popUpLabel;

    @FXML
    void confirmButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    public void setLabel(String label){
       popUpLabel.setText(label);
    }


}

