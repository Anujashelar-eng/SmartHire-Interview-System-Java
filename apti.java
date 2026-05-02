package com.smartf;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class apti extends Application {

    @Override
    public void start(Stage arg0) throws Exception {

        Button aptiButton = new Button("Java");
        aptiButton.setStyle("-fx-background-color: #2196F3;");
        Button programmingButton = new Button("C++");
        Button fundamentalButton = new Button("Python");

        // ✅ Corrected background image loading
        Image image = new Image(getClass().getResource("/Assets/Image/second.jpg").toExternalForm());
        ImageView background = new ImageView(image);
        background.setPreserveRatio(false);
        //background.setFitWidth(500);
        //background.setFitHeight(500);

        GaussianBlur blur = new GaussianBlur(18);
        background.setEffect(blur);

        fundamentalButton.setStyle(
                "-fx-background-color: linear-gradient(to right, #4a00e0, #8e2de2); " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 14px; " +
                        "-fx-border-radius: 10px; " +
                        "-fx-background-radius: 10px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(gaussian, purple, 10, 0.8, 10, 0.8);" +
                        "-fx-opacity: 0.9;"
        );

        aptiButton.setStyle(
                "-fx-background-color: linear-gradient(to right, #4a00e0, #8e2de2); " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 14px; " +
                        "-fx-border-radius: 10px; " +
                        "-fx-background-radius: 10px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(gaussian, purple, 10, 0.8, 10, 0.8);" +
                        "-fx-opacity: 0.9;"
        );

        programmingButton.setStyle(
                "-fx-background-color: linear-gradient(to right, #4a00e0, #8e2de2); " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 14px; " +
                        "-fx-border-radius: 10px; " +
                        "-fx-background-radius: 10px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(gaussian, purple, 10, 0.8, 10, 0.8);" +
                        "-fx-opacity: 0.9;"
        );

        aptiButton.setPrefWidth(300);
        aptiButton.setPrefHeight(100);
        programmingButton.setPrefWidth(300);
        programmingButton.setPrefHeight(100);
        fundamentalButton.setPrefWidth(300);
        fundamentalButton.setPrefHeight(100);

        VBox vb = new VBox(60, aptiButton, programmingButton, fundamentalButton);
        vb.setAlignment(Pos.CENTER);
       // vb.setStyle("-fx-background-color: linear-gradient(to bottom right, #8A2BE2,#FF00FF);");

        StackPane root = new StackPane(background, vb);
        Scene sc = new Scene(root, 500, 500);
        arg0.setScene(sc);
        arg0.show();
    }
}
