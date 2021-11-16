module com.example.f21comp1011lhw10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;


    opens com.example.f21comp1011lhw10 to javafx.fxml, com.google.gson;
    exports com.example.f21comp1011lhw10;
}