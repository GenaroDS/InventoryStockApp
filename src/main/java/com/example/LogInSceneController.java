package com.example;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class LogInSceneController {

    @FXML
    private Button logInButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameField;

    @FXML
    private void logInOnActon(ActionEvent event) throws IOException {
        Connection connection = SqlConnection.usersConection();
        String username = usernameField.getText();
        String password = passwordField.getText();
        try {
            java.sql.Statement statement = connection.createStatement();
            String query = "SELECT id FROM users WHERE password='" + password + "' AND username='" + username
                    + "';";
            ResultSet data = statement.executeQuery(query);
            if (data.next()) {
                ItemsSceneController.setCurrentUserId(data.getString("id"));
                ItemsSceneController.setCurrentUser(username);
                App.setRoot("ItemsScene");

            } else {
                Scene popUpScene = new Scene(loadFXML("PopUp"));
                Stage popUpStage = new Stage();
                popUpStage.setScene(popUpScene);
                popUpStage.setTitle("Credentials error");
                popUpStage.show();
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void registerOnAction(ActionEvent event) throws IOException {
        App.setRoot("SignUp");
    }

    static void setRoot(String fxml) throws IOException {
        Scene scene = new Scene(null);
        scene.setRoot(loadFXML(fxml));
        scene.getWindow().sizeToScene();

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        
        return fxmlLoader.load();
    }

}
