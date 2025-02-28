module com.example.snakladder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.snakladder to javafx.fxml;
    exports com.example.snakladder;
}