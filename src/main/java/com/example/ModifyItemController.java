package com.example;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ModifyItemController implements Initializable {
    private static String itemName;
    private static String itemQuantity;
    private static String itemPrice;

    static void setItemName(String str) {
        itemName = str;
    }

    static void setItemQuantity(String str) {
        itemQuantity = str;
    }

    static void setItemPrice(String str) {
        itemPrice = str;
    }

    @FXML
    private Button cancelButton;

    @FXML
    private TextField itemNameField;

    @FXML
    private TextField itemPriceField;

    @FXML
    private TextField itemQuantityField;

    @FXML
    private Button modifyButton;

    @FXML
    void cancelButtonOnAction(ActionEvent event) {

    }

    @FXML
    void modifyButtonOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        itemNameField.setText(itemName);
        itemQuantityField.setText(itemQuantity);
        itemPriceField.setText(itemPrice);

    }

}
