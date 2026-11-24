module com.example.mytunesportfolio3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.mytunesportfolio3 to javafx.fxml;
    exports com.example.mytunesportfolio3;
}