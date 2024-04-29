package com.example.mysqlescosia;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.io.IOException;

public class AppController {
    public static int supplyID;

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtSupplyName;
    @FXML
    private TextField txtQuantity;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Label lblStatus;

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
        String supplyName =txtSupplyName.getText();
        Date date = Date.valueOf(datePicker.getValue());
        Integer quantity = Integer.valueOf(txtQuantity.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("add-supply.fxml"));
        try {
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Add New Supply");
            newStage.setScene(new Scene(root));
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.showAndWait();
            InsertData.insertSupply(supplyName, quantity, date); //call

        } catch (IOException e) {
            lblStatus.setText("Failed to load the Add Supply page.");
            e.printStackTrace();
        }
    }


    @FXML
    private void onEditSupplyClick() {
        lblStatus.setText("Edit Supply Clicked");
    }

    @FXML
    private void onViewSupplyClick() {
        lblStatus.setText("View Supply Clicked");
    }

    @FXML
    private void onDeleteSupplyClick() {
        lblStatus.setText("Delete Supply Clicked");
        DeleteData.deleteSupply(supplyID);
    }

    @FXML
    private void onLogoutClick() {
        lblStatus.setText("Logging out...");
        Stage stage = (Stage) lblStatus.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onReturnClick() {
        Stage stage = (Stage) lblStatus.getScene().getWindow();
        stage.close();
    }
}
