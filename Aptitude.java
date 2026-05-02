package com.smartf;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aptitude {

    public Scene createScene(Stage mainStage) {
        Label name = new Label("Aptitude");
        name.setStyle("-fx-font-size: 30px; -fx-text-fill: white;");

        Button quantbalbtn = new Button("Quantitative Aptitude");
        Button logbalbtn = new Button("Logical Reasoning");
        Button verbalbtn = new Button("Verbal");
        Button backButton = new Button("Back");

        String buttonStyle = "-fx-background-color: linear-gradient(to right,rgb(243, 241, 247),rgb(236, 231, 240)); " +
                             "-fx-text-fill: black; " +
                             "-fx-font-size: 14px; " +
                             "-fx-border-radius: 10px; " +
                             "-fx-background-radius: 10px; " +
                             "-fx-padding: 10px 20px; " +
                             "-fx-cursor: hand;" +
                             "-fx-effect: dropshadow(gaussian, blue, 3, 0.8, 3, 0.8);" +
                             "-fx-opacity: 0.9;";

        quantbalbtn.setStyle(buttonStyle);
        logbalbtn.setStyle(buttonStyle);
        verbalbtn.setStyle(buttonStyle);

        // Corrected button actions
        quantbalbtn.setOnAction(e -> {
            Quant quantPage = new Quant();
            Scene quantScene = quantPage.createScene(mainStage);
            mainStage.setScene(quantScene);
        });

        logbalbtn.setOnAction(e -> {
            Logical logicalPage = new Logical(); //  Correct class
            Scene logicalScene = logicalPage.createScene(mainStage);
            mainStage.setScene(logicalScene);
        });

        verbalbtn.setOnAction(e -> {
            Verbal verbalPage = new Verbal(); //  Correct class
           Scene verbalScene = verbalPage.createScene(mainStage);
            mainStage.setScene(verbalScene);
        });

        backButton.setStyle("-fx-background-color: linear-gradient(to right,rgb(26, 95, 179),rgb(236, 231, 240)); " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 14px; " +
                            "-fx-border-radius: 10px; " +
                            "-fx-background-radius: 10px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-cursor: hand;" +
                            "-fx-effect: dropshadow(gaussian, blue, 2, 0.8, 2, 0.8);" +
                            "-fx-opacity: 0.9;");

        quantbalbtn.setPrefSize(300, 100);
        logbalbtn.setPrefSize(300, 100);
        verbalbtn.setPrefSize(300, 100);
        backButton.setPrefSize(100, 50);

        backButton.setOnAction(e -> {
            PrepInstaStyledPage prepPage = new PrepInstaStyledPage();
            prepPage.show(mainStage);
        });

        VBox vb = new VBox(60, name, quantbalbtn, logbalbtn, verbalbtn, backButton);
        vb.setAlignment(Pos.CENTER);
        vb.setStyle("-fx-background-color: linear-gradient(to bottom right, rgb(55, 134, 225), rgb(174, 200, 229));");

        return new Scene(vb, 1100, 800); // Match your screen dimensions
    }
}
