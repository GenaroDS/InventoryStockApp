package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ItemsSceneController {

    @FXML
    private Button addItemButton;

    @FXML
    private Label currentUserField;

    @FXML
    private Button deleteItemButton;

    @FXML
    private TableView<?> itemsTable;

    @FXML
    private Button logOutButton;

    @FXML
    private Button modifyItemButton;

    @FXML
    private TextField newItemName;

    @FXML
    private TextField newItemPrice;

    @FXML
    private TextField newItemQty;

    @FXML
    void addItemOnAction(ActionEvent event) {

    }

    @FXML
    void deleteItemOnAction(ActionEvent event) {

    }

    @FXML
    void logOutOnAction(ActionEvent event) throws IOException{
        App.setRoot("LogInScene");
    }

    @FXML
    void modifyItemOnAction(ActionEvent event) {

    }

}

