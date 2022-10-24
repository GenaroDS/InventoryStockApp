package com.example;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ModifyItemController implements Initializable {
    private static String itemName;
    private static String itemQuantity;
    private static String itemPrice;
    private static String itemId;
    public static ItemsSceneController controller;

    static void setItemName(String str) {
        itemName = str;
    }

    static void setItemQuantity(String str) {
        itemQuantity = str;
    }

    static void setItemPrice(String str) {
        itemPrice = str;
    }

    static void setItemId(String str) {
        itemId = str;
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
    void cancelButtonOnAction(ActionEvent event) throws IOException {
        App.setRoot("ItemsScene");

    }

    @FXML
    void modifyButtonOnAction(ActionEvent event) {
        Connection connection = SqlConnection.usersConection();
        String query;
        try {
            java.sql.Statement statement = connection.createStatement();
            if (!itemNameField.getText().equals(itemName)) {

                query = "UPDATE items SET item_name = '" + itemNameField.getText() + "' WHERE id='" + itemId
                        + "';";
                statement.executeUpdate(query);

            }
            if (!itemPriceField.getText().equals(itemPrice)) {
                query = "UPDATE items SET item_price = '" + itemPriceField.getText() + "' WHERE id='" + itemId
                        + "';";
                statement.executeUpdate(query);
            }
            if (!itemQuantityField.getText().equals(itemQuantity)) {
                query = "UPDATE items SET item_amount = '" + itemQuantityField.getText() + "' WHERE id='" + itemId
                        + "';";
                statement.executeUpdate(query);
            }
            App.setRoot("ItemsScene");

        } catch (Exception e) {

        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        itemNameField.setText(itemName);
        itemQuantityField.setText(itemQuantity);
        itemPriceField.setText(itemPrice);

    }


}
