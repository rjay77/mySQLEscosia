package com.example.mysqlescosia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "DELETE FROM users WHERE id=? RETURNING *"
             )) {
            int id = 1;
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            ResultSet res = statement.getResultSet();
            if (res.next()) {
                System.out.println("Name: " + res.getString("name"));
                System.out.println("Email " + res.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteSupply(int supplyId) {
        String sql = "DELETE FROM supplies WHERE id = ?;";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, supplyId);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("A supply was deleted successfully!");
            } else {
                System.out.println("No supply was deleted.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred during deleting supply.");
            e.printStackTrace();
        }
    }

}
