module com.example.dsabootcamp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dsabootcamp to javafx.fxml;
    exports com.example.dsabootcamp;
}