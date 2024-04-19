package com.example.mysqlescosia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateData {
    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "UPDATE users SET name =? WHERE id=?"
             )) {
            String name = "leparsh";
            int id = 1;
            statement.setInt(2, id);
            statement.setString(1, name);
            int rows = statement.executeUpdate();
            System.out.println("Rows updated: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
