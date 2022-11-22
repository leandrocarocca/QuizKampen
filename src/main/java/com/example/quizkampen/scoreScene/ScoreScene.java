package com.example.quizkampen.scoreScene;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class ScoreScene implements Initializable {
    public Circle avatar1;
    public Circle avatar2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InputStream stream1 = null;
        InputStream stream2 = null;
        try {
            stream1 = new FileInputStream("src/main/java/com/example/quizkampen/scoreScene/img.png");
            stream2 = new FileInputStream("src/main/java/com/example/quizkampen/scoreScene/img_1.png");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Image img1 = new Image(stream1);
        Image img2 = new Image(stream2);
        avatar1.setFill(new ImagePattern(img1));
        avatar2.setFill((new ImagePattern(img2)));
    }
}
