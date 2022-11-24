package com.example.quizkampen;

import Server.Player;
import Server.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController
{
    Player player1;
    Player player2;
    int currentRound = 1;
    public void switchToQuizScene(ActionEvent event) throws IOException
    {
        Button button = (Button) event.getSource();
        String category = button.getText();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("quizScene.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        gameController controller = loader.getController();
        controller.startQuiz(category, currentRound,player1, player2);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void setRound(int round)
    {
        this.currentRound = round;
    }
    public void setPlayer1(Player p1){
        this.player1 = p1;
    }
    public void setPlayer2(Player p2){
        this.player2 = p2;
    }


}