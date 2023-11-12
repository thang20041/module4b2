package com.example.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToMySql {
    private static String URL = "jdbc:mysql://localhost:3306/studentmana";
    private static String USERNAME = "root";
    private static String PASSWORD = "123456";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception ex) {
            return null;
        }
    }
}
