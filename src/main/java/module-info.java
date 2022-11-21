module com.example.quizkampen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quizkampen to javafx.fxml;
    exports com.example.quizkampen;
}