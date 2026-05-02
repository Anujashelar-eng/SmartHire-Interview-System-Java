package com.smartf;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class preparation extends Application {

    @Override
    public void start(Stage stage) {

        ImageView background = new ImageView(new Image(getClass().getResource("/Assets/Image/second.jpg").toExternalForm()));
        background.setPreserveRatio(false);
      //  background.setFitWidth(500);
        //background.setFitHeight(600);

        GaussianBlur blur = new GaussianBlur(18); 
        background.setEffect(blur);

        Label header = new Label("Placement Preparation");
        header.setTextFill(Color.BLACK);
        header.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        header.setAlignment(Pos.CENTER);

        
        Button aptitudeButton = createCardButton("Aptitude\n• Quantitative Aptitude\n• Logical Reasoning\n• Verbal Ability");
        Button programmingButton = createCardButton("Programming\n• Programming Languages\n• Data Structures\n• Algorithms");
        Button fundamentalsButton = createCardButton("Fundamentals\n• Database Management\n• Operating System\n• Computer Network");

        String defaultStyle =
                "-fx-background-color: linear-gradient(to right, #4a00e0, #8e2de2); " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 14px; " +
                "-fx-border-radius: 15px; " +
                "-fx-background-radius: 10px; " +
                "-fx-padding: 10px 20px; " +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(gaussian, purple, 10, 0.8, 10, 0.8);" +
                "-fx-opacity: 0.9;";

        aptitudeButton.setStyle(defaultStyle);
        programmingButton.setStyle(defaultStyle);
        fundamentalsButton.setStyle(defaultStyle);

        addHoverEffect(aptitudeButton, defaultStyle);
        addHoverEffect(programmingButton, defaultStyle);
        addHoverEffect(fundamentalsButton, defaultStyle);

        aptitudeButton.setPrefSize(300, 150);
        programmingButton.setPrefSize(300, 150);
        fundamentalsButton.setPrefSize(300, 150);

        
        VBox vb = new VBox(40, header, aptitudeButton, programmingButton, fundamentalsButton);
        vb.setAlignment(Pos.CENTER);

        
        StackPane root = new StackPane(background, vb);
        Scene scene = new Scene(root, 500, 600);

        stage.setScene(scene);
        stage.setTitle("Preparation Page");
        stage.show();
    }

    private Button createCardButton(String text) {
        return new Button(text);
    }

    private void addHoverEffect(Button button, String defaultStyle) {
        button.setOnMouseEntered(e -> {
            button.setScaleX(1.05);
            button.setScaleY(1.05);
        });
        button.setOnMouseExited(e -> {
            button.setScaleX(1.0);
            button.setScaleY(1.0);
            button.setStyle(defaultStyle);
        });
    }

}
