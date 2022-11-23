package com.example.quizkampen;

import Server.Categories;
import Server.Question;
import Server.QuestionsDataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    Path p = Paths.get("src/main/java/Server/questions.txt");
    QuestionsDataBase db = new QuestionsDataBase(p);
    String category;
    Question currentQuestion;
    ArrayList<Question> questionsGenerated = new ArrayList<>();
    int questionsAnswered = 0;
    int currentTurn = 1;
    int numberOfTurnsPerRound = 2;
    int currentRound = 1;
    int numberOfRoundsPerGame = 2;
    int points = 0;
    boolean firstPlayerTurn = true;
    boolean secondPlayerTurn = false;



    public void checkAnswer(ActionEvent actionEvent)
    {
        Button button = (Button) actionEvent.getSource();
        // Hämta rätta svaret på frågan
        String correctAnswer = currentQuestion.getAnswers()[currentQuestion.getCorrectAnswerindex()];
        // kolla om spelaren har valt rätt svar
        if(button.getText().equals(correctAnswer)){
            System.out.println("KORREKT");
            questionsAnswered ++;
            points ++;
        }
        else{
            System.out.println("INKORREKT");
            questionsAnswered ++;
        }
        // kolla om ronden är slut
        if(currentTurn == numberOfTurnsPerRound){
            // kolla om man kan köra fler ronder
            if(currentRound == numberOfRoundsPerGame){
                System.out.println("Thanks for this round! \n Points: " + points);
                // ronden är slut så man byter spelare
                if(firstPlayerTurn){
                    points = 0;
                    currentTurn = 0;
                    currentRound = 1;
                    firstPlayerTurn = false;
                    secondPlayerTurn = true;
                    questionsAnswered = 0;
                    // rond 1, börja med första frågan
                    startTurn();
                }
                else{
                    QuestionLabel.setText("SLUT");
                }
            }
            // Om man kan köra flera ronder så väljer man en ny kategori
            else{
                // välj ny kategori
                category = "Food";
                // starta nya ronden med ny kategori
                startRound(category);
            }
        }
        else{
            startTurn();
        }

    }
    public void startRound(String category){
        currentTurn = 1;
        currentRound ++;
        // om det är den första personen som kör så slumpas frågorna
        if(firstPlayerTurn){
            currentQuestion = db.getRandomQuestionFromCategory(category);
            questionsGenerated.add(currentQuestion);
        }
        // om det är den andra personen som kör så tar man samma frågor som första personen körde
        else{
            currentQuestion = questionsGenerated.get(questionsAnswered);
        }
        QuestionLabel.setText(currentQuestion.getDescription());
        setButtons();
    }


    public void startTurn(){
        currentTurn ++;
        // om det är den första personen som kör så slumpas frågorna
        if(firstPlayerTurn){
            currentQuestion = db.getRandomQuestionFromCategory(category);
            questionsGenerated.add(currentQuestion);
        }
        // om det är den andra personen som kör så tar man samma frågor som första personen körde
        else{
            currentQuestion = questionsGenerated.get(questionsAnswered);
        }


        QuestionLabel.setText(currentQuestion.getDescription());
        setButtons();
    }

    public void reset(){
        // Se till så att man kan välja dessa frågor igen
        for(Question q : questionsGenerated){
            q.setTaken(false);
        }
    }

    public void setButtons(){
        answer1Button.setText(currentQuestion.getAnswers()[0]);
        answer2Button.setText(currentQuestion.getAnswers()[1]);
        answer3Button.setText(currentQuestion.getAnswers()[2]);
        answer4Button.setText(currentQuestion.getAnswers()[3]);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.category = "Sport";
        this.currentQuestion = db.getRandomQuestionFromCategory(category);
        this.QuestionLabel.setText(currentQuestion.getDescription());
        setButtons();
        questionsGenerated.add(currentQuestion);

    }
}