package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private Button cancelButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private PasswordField repasswordField;

    @FXML
    private TextField usernameField;

    @FXML
    void cancelButtonOnAction(ActionEvent event) throws IOException {
        App.setRoot("LogInScene");
    }

    @FXML
    void registerButtonOnAction(ActionEvent event) throws IOException {
        Connection connection = SqlConnection.usersConection();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String rePassword = repasswordField.getText();
        if (rePassword.equals(password)) {
            String query = "INSERT INTO users (username,password) VALUES('" + username + "','"
                    + password + "');";
            try {
                java.sql.Statement statement = connection.createStatement();
                statement.executeUpdate(query);
                connection.close();
                successPopUp();
                App.setRoot("LogInScene");

            } catch (SQLException e) {
                usernameTakenPopUp();
            }

        } else {
            passwordPopUp();
        }
    }

    public void successPopUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane p = fxmlLoader.load(getClass().getResource("PopUp.fxml").openStream());
        PopUpController popUpController = (PopUpController) fxmlLoader.getController();
        Scene popUpScene = new Scene(p);
        Stage popUpStage = new Stage();
        popUpController.setLabel("You account was succesfully created!");
        popUpStage.setScene(popUpScene);
        popUpStage.setTitle("Success!");
        popUpStage.show();
    }

    public void usernameTakenPopUp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane p = fxmlLoader.load(getClass().getResource("PopUp.fxml").openStream());
        PopUpController popUpController = (PopUpController) fxmlLoader.getController();
        Scene popUpScene = new Scene(p);
        Stage popUpStage = new Stage();
        popUpController.setLabel("Username is already taken!");
        popUpStage.setScene(popUpScene);
        popUpStage.setTitle("Username error");
        popUpStage.show();
    }

    public void passwordPopUp()throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane p = fxmlLoader.load(getClass().getResource("PopUp.fxml").openStream());
        PopUpController popUpController = (PopUpController) fxmlLoader.getController();
        Scene popUpScene = new Scene(p);
        Stage popUpStage = new Stage();
        popUpController.setLabel("      Passwords don't match!");
        popUpStage.setScene(popUpScene);
        popUpStage.setTitle("Password error");
        popUpStage.show();
    }

}
