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

    public static void updateSupply(int supplyId, String newName, int newQuantity) {
        String sql = "UPDATE supplies SET name = ?, quantity = ? WHERE id = ?;";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newName);
            pstmt.setInt(2, newQuantity);
            pstmt.setInt(3, supplyId);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Supply was updated successfully!");
            } else {
                System.out.println("No supply was updated.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred during the update operation.");
            e.printStackTrace();
        }
    }
}
