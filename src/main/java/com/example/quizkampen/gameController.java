package com.example.quizkampen;

import Server.Question;
import Server.QuestionsDataBase;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class gameController implements Initializable
{
    @FXML
    private Label playerLabel;
    @FXML
    private Label roundLabel;
    @FXML
    private Label turnLabel;
    @FXML
    private Button answer1Button;
    @FXML
    private Label questionLabel;
    @FXML
    private GridPane gameGridPane;

    Path p = Paths.get("src/main/java/Server/questions.txt");
    QuestionsDataBase db = new QuestionsDataBase(p);
    String category;
    Question currentQuestion;
    ArrayList<Question> questionsGenerated = new ArrayList<>();
    ArrayList<String> categoriesArray = new ArrayList<>();
    int questionsAnswered = 0;
    int currentTurn = 1;
    int numberOfTurnsPerRound = 2;
    int currentRound = 1;
    int numberOfRoundsPerGame = 2;
    int points = 0;
    boolean firstPlayerTurn = true;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    }

    public void startQuiz(String cat, int round, int qA, boolean player1, ArrayList<Question> questions)
    {
        this.firstPlayerTurn = player1;
        this.currentTurn = 1;
        this.category = cat;
        this.currentRound = round;
        this.questionsAnswered = qA;
        this.questionsGenerated = questions;
        if (player1)
        {
            this.currentQuestion = db.getRandomQuestionFromCategory(category);
        } else
        {
            this.currentQuestion = questionsGenerated.get(questionsAnswered);
        }
        questionLabel.setText(currentQuestion.getDescription());
        questionsGenerated.add(currentQuestion);
        categoriesArray.add(category);
        setButtons();
    }
    public void setButtons()
    {
        int index = 0;
        for (Node n : gameGridPane.getChildren())
        {
            try
            {
                Button b = (Button) n;
                b.setBackground(Background.fill(Color.LIGHTSKYBLUE));
                b.setText(currentQuestion.getAnswers()[index]);
                index++;
            } catch (ClassCastException e)
            {
                System.out.println("Fix");
            }
        }
        if(firstPlayerTurn){
            playerLabel.setText("Player 1");
        }
        else{
            playerLabel.setText("Player 2");
        }
        roundLabel.setText("Round: " + currentRound + "/" + numberOfRoundsPerGame);
        turnLabel.setText("Question: " + currentTurn + "/" + numberOfTurnsPerRound);
    }

    public void checkAnswer(ActionEvent actionEvent)
    {
        Button button = (Button) actionEvent.getSource();
        // Hämta rätta svaret på frågan
        String correctAnswer = currentQuestion.getAnswers()[currentQuestion.getCorrectAnswerindex()];
        if (button.getText().equals(correctAnswer))
        {
            points++;
        }
        questionsAnswered++; // questionsAnswered = 2
        showCorrectAnswer();
        PauseTransition wait = new PauseTransition(Duration.seconds(2));
        wait.setOnFinished(event ->
        {
            try
            {
                if (currentTurn < numberOfTurnsPerRound)
                {
                    nextTurn();
                }
                else
                {
                    nextRound();
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        });
        wait.play();
    }

    public void showCorrectAnswer()
    {
        String correctAnswer = currentQuestion.getAnswers()[currentQuestion.getCorrectAnswerindex()];
        for (Node n : gameGridPane.getChildren())
        {
            try
            {
                Button b = (Button) n;
                if (b.getText().equals(correctAnswer))
                {
                    b.setBackground(Background.fill(Color.LIMEGREEN));
                } else
                {
                    b.setBackground(Background.fill(Color.RED));
                }

            } catch (ClassCastException e)
            {
                System.out.println("This is not a button");
            }
        }
    }
    public void nextTurn()
    {
        currentTurn++;
        // om det är den första personen som kör så slumpas frågorna
        if (firstPlayerTurn)
        {
            currentQuestion = db.getRandomQuestionFromCategory(category);
            questionsGenerated.add(currentQuestion);
        }
        // om det är den andra personen som kör så tar man samma frågor som första personen körde
        else
        {
            currentQuestion = questionsGenerated.get(questionsAnswered);
        }
        questionLabel.setText(currentQuestion.getDescription());
        setButtons();
    }

    public void nextRound() throws IOException
    {
        if (currentRound < numberOfRoundsPerGame)
        {
            if(firstPlayerTurn){
                currentRound++;
                switchToChoiceOfCategoryScene();
            }
            else{
                currentTurn = 0;
                currentRound++;
                category = categoriesArray.get(currentRound - 1);
                nextTurn();
            }

        } else if (firstPlayerTurn)
        {
            switchPlayer();
        } else
        {
            endGame();
        }
    }

    public void reset()
    {
        // Se till så att man kan välja dessa frågor igen
        for (Question q : questionsGenerated)
        {
            q.setTaken(false);
        }
    }

    private void switchPlayer()
    {
        firstPlayerTurn = false;
        currentRound = 1;
        questionsAnswered = 0;
        category = categoriesArray.get(0);
        startQuiz(category, 1, 0, false, questionsGenerated);
    }

    private void endGame() throws IOException
    {
        switchToScoreScene();
        reset();
        questionLabel.setText("SLUT");
    }

    public void switchToChoiceOfCategoryScene() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("choiceOfCategoryScreen.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        HelloController controller = loader.getController();
        controller.setRound(currentRound);
        controller.setQuestionsAnswered(questionsAnswered);
        controller.setPlayer1(firstPlayerTurn);
        controller.setGeneratedQuestions(questionsGenerated);
        Stage stage = (Stage) answer1Button.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToStartScene() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("startScene.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = (Stage) answer1Button.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void switchToScoreScene() throws IOException
    {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("scoreScene.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = (Stage) answer1Button.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public String toString()
    {
        return ", category='" + category + '\'' +
                ", questionsGenerated=" + questionsGenerated +
                ", categoriesArray=" + categoriesArray +
                ", questionsAnswered=" + questionsAnswered +
                ", currentTurn=" + currentTurn +
                ", numberOfTurnsPerRound=" + numberOfTurnsPerRound +
                ", currentRound=" + currentRound +
                ", numberOfRoundsPerGame=" + numberOfRoundsPerGame +
                ", firstPlayerTurn=" + firstPlayerTurn +
                '}';
    }
}