module com.example.dsabootcamp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dsabootcamp to javafx.fxml;
    exports com.example.dsabootcamp;
}