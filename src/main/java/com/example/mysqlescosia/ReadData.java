package com.example.mysqlescosia;

import java.sql.*;
import java.time.LocalDate;

public class ReadData {
    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement()) {
            String query = "SELECT * FROM users";
            ResultSet res = statement.executeQuery(query);
            while(res.next()){
                int id = res.getInt("id");
                String name = res.getString("name");
                String email = res.getString("email");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static Supply readSupply(int supplyID) {
        Supply supply = null;
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement("SELECT supplyname, quantity, dateadded FROM supply WHERE id = ?")) {
            statement.setInt(1, supplyID);
            try (ResultSet res = statement.executeQuery()) {
                if (res.next()) {
                    String supplyName = res.getString("supplyname");
                    int quantity = res.getInt("quantity");
                    LocalDate dateAdded = res.getDate("dateadded").toLocalDate();

                    supply = new Supply(supplyName, quantity, dateAdded);
                }
            } catch (SQLException e) {
                System.err.println("Error reading from the database: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.println("Error establishing database connection: " + e.getMessage());
            e.printStackTrace();
        }
        return supply;
    }



}
