package com.example.mysqlescosia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement()) {
            String queryUsers = "CREATE TABLE IF NOT EXISTS users(" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "email VARCHAR(100) NOT NULL)";
            statement.execute(queryUsers);
            System.out.println("Users table created successfully");
        } catch (SQLException e) {
            System.out.println("Failed to create users table.");
            e.printStackTrace();
        }
        createSupplyTable();
    }

    public static void createTable() {
        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement()) {
            String query = "CREATE TABLE IF NOT EXISTS users(" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "email VARCHAR(100) NOT NULL)";
            statement.execute(query);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createSupplyTable() {
        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement()) {
            String query = "CREATE TABLE IF NOT EXISTS supplies (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "quantity INT NOT NULL," +
                    "date_added DATE NOT NULL)";
            statement.execute(query);
            System.out.println("Supplies table created successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to create supplies table.");
            e.printStackTrace();
        }
    }
}
