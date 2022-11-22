package com.example.quizkampen;

import Server.Categories;
import Server.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;

public class gameController implements Initializable
{
    @FXML
    private Button answer1Button;
    @FXML
    private Button answer2Button;
    @FXML
    private Button answer3Button;
    @FXML
    private Button answer4Button;
    @FXML
    private Label QuestionLabel;

    Question question;
    Categories c = new Categories();
    HashMap map = c.getCategoriesMap();
    ArrayList<Question> questionArray = (ArrayList<Question>) map.get("Sport");
    Random rand = new Random();

    public void checkAnswer(ActionEvent actionEvent)
    {
        Button button = (Button) actionEvent.getSource();
        if(button.getText().equals(question.getAnswers()[question.getCorrectAnswerindex()])){
            System.out.println("Rätt svar");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        int randomNumber = rand.nextInt(1); //satte bound 1 för vi har inte så många frågor än
        Question question = questionArray.get(randomNumber);
        QuestionLabel.setText(question.getDescription());
        answer1Button.setText(question.getAnswers()[0]);
        answer2Button.setText(question.getAnswers()[1]);
        answer3Button.setText(question.getAnswers()[2]);
        answer4Button.setText(question.getAnswers()[3]);

    }
}