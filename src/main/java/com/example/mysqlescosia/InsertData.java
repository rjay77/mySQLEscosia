package com.example.mysqlescosia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection()) {
            try (PreparedStatement statement = c.prepareStatement(
                    "INSERT INTO users (name, email) VALUES (?,?)"
            )) {
                String name = "Raphael Jay Escosia";
                String email = "raphaeljay.escosia@cit.edu";
                statement.setString(1, name);
                statement.setString(2, email);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("User data inserted successfully");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertSupply(String supplyName, int quantity, Date dateAdded) {
        String sql = "INSERT INTO supplies (name, quantity, date_added) VALUES (?, ?, ?)";
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, supplyName);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setDate(3, new java.sql.Date(dateAdded.getTime()));
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Supply data inserted successfully");
            } else {
                System.out.println("No new supply was added.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
