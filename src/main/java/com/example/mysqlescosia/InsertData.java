package com.example.mysqlescosia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement (
                     "INSERT INTO users (name, email) VALUES (?,?)"
             ))  {
            String name = "Raphael Jay Escosia";
            String email = "raphaeljay.escosia@cit.edu";
            statement.setString(1, name);
            statement.setString(2, email);
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) {
                System.out.println("Data inserted successfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
