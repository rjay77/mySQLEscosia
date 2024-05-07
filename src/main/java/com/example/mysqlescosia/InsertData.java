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

    public static void insertSupply(String itemName, int quantity, Date dateAdded) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "INSERT INTO supplies (item_name, quantity, date_added) VALUES (?, ?, ?)"
             )) {
            statement.setString(1, itemName);
            statement.setInt(2, quantity);
            statement.setDate(3, dateAdded);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Supply inserted successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
