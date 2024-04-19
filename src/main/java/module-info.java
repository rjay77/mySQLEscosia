module com.example.mysqlescosia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.mysqlescosia to javafx.fxml;
    exports com.example.mysqlescosia;
}