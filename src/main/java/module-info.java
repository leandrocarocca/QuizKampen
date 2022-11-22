module com.example.quizkampen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quizkampen to javafx.fxml;
    exports com.example.quizkampen;
    exports com.example.quizkampen.scoreScene;
    opens com.example.quizkampen.scoreScene to javafx.fxml;
}