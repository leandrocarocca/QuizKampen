package com.example.quizkampen;

import Server.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    int currentRound = 1;
    int questionsAnswered = 0;
    ArrayList<Question> questions = new ArrayList<>();
    boolean player1 = true;
    Scene scene;
    Stage stage;
    // currentRound = 1
    public void switchToQuizScene(ActionEvent event) throws IOException
    {
        Button button = (Button) event.getSource();
        String category = button.getText();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("quizScene.fxml"));
        Parent parent = loader.load();
        scene = new Scene(parent);
        gameController controller = loader.getController();
        controller.startQuiz(category, currentRound, questionsAnswered, player1, questions);
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void setRound(int round)
    {
        this.currentRound = round;
    }

    public void setQuestionsAnswered(int qA)
    {
        this.questionsAnswered = qA;
    }
    public void setPlayer1(boolean b){
        this.player1 = b;
    }

    public void setGeneratedQuestions(ArrayList<Question> questionsGenerated)
    {
        this.questions = questionsGenerated;
    }
}