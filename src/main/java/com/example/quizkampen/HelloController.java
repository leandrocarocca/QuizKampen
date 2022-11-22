package com.example.quizkampen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
        choiceOfCategoryScreen.setText("Swedish history");
        choiceOfCategoryScreen.setText("Music");

    }
}