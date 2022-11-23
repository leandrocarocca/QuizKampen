package com.example.quizkampen;

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

public class HelloController {
    @FXML
    private Label choiceOfCategoryScreen;
    private Label text;

    @FXML
    protected void choiceOfCategoryButtonClick() {
        choiceOfCategoryScreen.setText("Sport");
        choiceOfCategoryScreen.setText("Geography");
        choiceOfCategoryScreen.setText("Animals");
        choiceOfCategoryScreen.setText("Food");
        choiceOfCategoryScreen.setText("Swedish History");
        choiceOfCategoryScreen.setText("Music");
    }
    int currentRound = 0;
    Scene scene;
    Stage stage;
    public void switchToQuizScene(ActionEvent event) throws IOException
    {
        Button button = (Button) event.getSource();
        String category = button.getText();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("quizScene.fxml"));
        Parent parent = loader.load();
        scene = new Scene(parent);
        gameController controller = loader.getController();
        controller.startQuiz(category, currentRound);
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void setRound(int round)
    {
        this.currentRound = round;
    }
}