package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.nio.file.Paths;
import java.util.Scanner;

public class SqlConection {
    private SqlConection() {
    }

    static Connection connection = null;
    
    public static Connection usersConection() {
        String password = "";
        try (Scanner scanner = new Scanner(Paths.get("C:/pass.txt"))) {
            while (scanner.hasNextLine()) {
                password = scanner.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_app", "root", password);
            System.out.println("Conection to the database succefully done...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

}