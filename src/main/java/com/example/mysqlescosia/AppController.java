package com.example.mysqlescosia;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.io.IOException;

public class AppController {
    private int selectedSupplyId;
    @FXML private Label lblSupplyName;
    @FXML private Label lblQuantity;
    @FXML private Label lblDateAdded;
    @FXML private Label lblStatus;
    public static int supplyID;
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private TextField txtSupplyName;
    @FXML private TextField txtQuantity;
    @FXML private DatePicker datePicker;

    public void setSelectedSupplyId(int supplyId) {
        this.selectedSupplyId = supplyId;
    }

    @FXML
    private void onLoginClick(ActionEvent event) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        if (username.equals("admin") && password.equals("password")) {
            lblStatus.setText("Login successful!");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("home-page.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) txtUsername.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException e) {
                lblStatus.setText("Failed to load home page.");
                e.printStackTrace();
            }
        } else {
            lblStatus.setText("Login failed. Incorrect username or password.");
        }
    }

    @FXML
    protected void onAddSupplyClick() {
        try {
            String itemName = txtSupplyName.getText();
            int quantity = Integer.parseInt(txtQuantity.getText());
            LocalDate localDate = datePicker.getValue();
            if (localDate == null) {
                lblStatus.setText("Please select a valid date.");
                return;
            }
            Date dateAdded = Date.valueOf(localDate);
            InsertData.insertSupply(itemName, quantity, dateAdded);
            lblStatus.setText("Supply inserted successfully.");
        } catch (NumberFormatException e) {
            lblStatus.setText("Quantity must be a valid number.");
        } catch (Exception e) {
            lblStatus.setText("Failed to insert supply: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    protected void onReturnClick() {
        lblStatus.setText("Returning to previous screen...");
    }

    @FXML
    protected void onEditSupplyClick() {
        try {
            String supplyName = txtSupplyName.getText();
            int quantity = Integer.parseInt(txtQuantity.getText());
            if (supplyName.isEmpty() || quantity <= 0) {
                lblStatus.setText("Please enter valid values for all fields.");
                return;
            }
            boolean result = updateData.updateSupply(selectedSupplyId, supplyName, quantity);
            if (result) {
                lblStatus.setText("Supply updated successfully.");
            } else {
                lblStatus.setText("Failed to update supply.");
            }
        } catch (NumberFormatException e) {
            lblStatus.setText("Invalid quantity. Please enter a numeric value.");
        } catch (Exception e) {
            lblStatus.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    protected void onViewSupplyClick() {
        try {
            int supplyId = getSelectedSupplyId();
            Supply supply = ReadData.readSupply(supplyId);
            if (supply != null) {
                lblSupplyName.setText(supply.getName());
                lblQuantity.setText(String.valueOf(supply.getQuantity()));
                lblDateAdded.setText(supply.getDate().toString());
                lblStatus.setText("Supply details fetched successfully.");
            } else {
                lblStatus.setText("Supply not found.");
            }
        } catch (Exception e) {
            lblStatus.setText("Error fetching supply details: " + e.getMessage());
        }
    }

    private int getSelectedSupplyId() {
        return 1;
    }

    @FXML
    private void onDeleteSupplyClick() {
        if (DeleteData.deleteSupply(selectedSupplyId)) {
            lblStatus.setText("Supply successfully deleted.");
        } else {
            lblStatus.setText("Failed to delete supply.");
        }
    }
}
