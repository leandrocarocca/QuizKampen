package com.example.quizkampen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScene {

    @FXML
    public Button startNewButton;
    Scene scene;
    Stage stage;
    public void switchToGameScene(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("choiceOfCategoryScreen.fxml"));
        Parent parent = loader.load();

        scene = new Scene(parent);
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
