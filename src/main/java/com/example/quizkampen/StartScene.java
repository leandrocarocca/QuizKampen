package com.example.quizkampen;

import Server.Player;
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
    String name1 = "Leandro";
    String name2 = "Bertil";
    Player player1 = new Player(name1);
    Player player2 = new Player(name2);
    public void switchToGameScene(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("choiceOfCategoryScreen.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        HelloController controller = loader.getController();
        controller.setPlayer1(player1);
        controller.setPlayer2(player2);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
