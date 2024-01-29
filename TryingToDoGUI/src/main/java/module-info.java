module com.example.tryingtodogui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tryingtodogui to javafx.fxml;
    exports com.example.tryingtodogui;
}