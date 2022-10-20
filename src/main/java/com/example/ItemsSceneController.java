package com.example;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ItemsSceneController implements Initializable {
    private static String user;
    private static String userId;

    static void setCurrentUser(String userFrom) {
        user = userFrom;
    }

    static void setCurrentUserId(String userIdFrom) {
        userId = userIdFrom;
    }

    @FXML
    private Button addItemButton;

    @FXML
    private Label currentUserField;

    @FXML
    private Button deleteItemButton;

    @FXML
    private TableColumn<ModelTable, String> itemIdColumn;

    @FXML
    private TableColumn<ModelTable, String> itemNameColumn;

    @FXML
    private TableColumn<ModelTable, String> itemPriceColumn;

    @FXML
    private TableColumn<ModelTable, String> itemQuantityColumn;

    @FXML
    private TableView<ModelTable> itemsTable;

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
    private Label usernameLabel;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
  
        usernameLabel.setText(user);
        itemIdColumn.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        itemPriceColumn.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        itemQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("itemQty"));
        Connection connection = SqlConnection.usersConection();
        String query = "SELECT * FROM items where user_id ='" + userId + "';";
        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                oblist.add(new ModelTable(rs.getString("id"), rs.getString("item_name"), rs.getString("item_amount"),
                        rs.getString("item_price")));
            }
            itemsTable.setItems(oblist);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void addItemOnAction(ActionEvent event) {
        Connection connection = SqlConnection.usersConection();
        String itemName = newItemName.getText();
        String itemQty = newItemQty.getText();
        String itemPrice = newItemPrice.getText();
        if (itemName.length() > 0 && itemQty.length() > 0 && itemPrice.length() > 0) {
            String query = "INSERT INTO items (user_id,item_name,item_amount,item_price) VALUES('" + userId + "','" + itemName + "','" + itemQty + "','"
                    + itemPrice + "');";
            try {
                java.sql.Statement statement = connection.createStatement();
                statement.executeUpdate(query);
                connection.close();
                itemsTable.getItems().clear();
                initialize(null, null);
            } catch (SQLException e) {
                System.out.println("error.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Please fill up all the fields");
        }

    }

    @FXML
    void deleteItemOnAction(ActionEvent event) {
    }

    @FXML
    void logOutOnAction(ActionEvent event) throws IOException {
        App.setRoot("LogInScene");
    }

    @FXML
    void modifyItemOnAction(ActionEvent event) {

    }

}
