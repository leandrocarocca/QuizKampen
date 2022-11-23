package com.example.quizkampen;

import Server.Categories;
import Server.Question;
import Server.QuestionsDataBase;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
    @FXML
    private GridPane gameGridPane;

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


    public void nextTurn(){
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
        // om ronden ännu inte är slut så startar en ny turn
        else{
            startTurn();
        }
    }

    public void checkAnswer(ActionEvent actionEvent) throws InterruptedException
    {
        Button button = (Button) actionEvent.getSource();
        // Hämta rätta svaret på frågan
        String correctAnswer = currentQuestion.getAnswers()[currentQuestion.getCorrectAnswerindex()];
        if(button.getText().equals(correctAnswer)){
            questionsAnswered ++;
            points ++;
        }
        else{
            questionsAnswered ++;
        }
        showCorrectAnswer();
        PauseTransition wait = new PauseTransition(Duration.seconds(2));
        wait.setOnFinished(event -> nextTurn());
        wait.play();
    }

    public void showCorrectAnswer(){
        String correctAnswer = currentQuestion.getAnswers()[currentQuestion.getCorrectAnswerindex()];
        for(Node n: gameGridPane.getChildren()){
            try{
                Button b = (Button) n;
                if(b.getText().equals(correctAnswer)){
                    b.setBackground(Background.fill(Color.LIMEGREEN));
                }
                else {
                    b.setBackground(Background.fill(Color.RED));
                }

            }
            catch (ClassCastException e){
                System.out.println("This is not a button");
            }
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
        int index = 0;
        for(Node n: gameGridPane.getChildren()){
            try{
                Button b = (Button) n;
                b.setBackground(Background.fill(Color.LIGHTSKYBLUE));
                b.setText(currentQuestion.getAnswers()[index]);
                index++;
            }
            catch (ClassCastException e){
                System.out.println("This is not a button");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        int counter = 0;
        for(Node n: gameGridPane.getChildren()){
            try{
                Button b = (Button) n;
            }
            catch (ClassCastException e){
                System.out.println("This is not a button");
            }
            counter++;
        }
        System.out.println(counter);
        this.category = "Sport";
        this.currentQuestion = db.getRandomQuestionFromCategory(category);
        this.QuestionLabel.setText(currentQuestion.getDescription());
        setButtons();
        questionsGenerated.add(currentQuestion);

    }
}