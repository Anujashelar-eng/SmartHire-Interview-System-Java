package com.smartf;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Thirdpage extends Application {

    @Override
    public void start(Stage stage) {
        Label title = new Label("Prepare for your interview on the go");
        title.setFont(new Font("Arial", 20));
        title.setTextFill(Color.web("White"));

        Button categoryBtn = new Button("Categories");
        categoryBtn.setStyle("-fx-background-color: white; -fx-text-fill: #2575fc; -fx-font-weight: bold;");
        categoryBtn.setPrefWidth(150);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(20);
        grid.setHgap(20);
        grid.setAlignment(Pos.CENTER);

        String[] categories = {
                "Preparation", "Quiz","Resume",
                "Coompanywise Interview Question", "Mock Test",
                "Feedback"
        };

        for (int i = 0; i < categories.length; i++) {
            VBox card = createCategoryCard(categories[i]);
            grid.add(card, i % 2, i / 2);
        }

        VBox mainLayout = new VBox(20, title, categoryBtn, grid);
        mainLayout.setPadding(new Insets(30));
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setStyle("-fx-background-color: linear-gradient(to bottom right, #8A2BE2, #FF00FF");

        Scene scene = new Scene(mainLayout, 400, 700);
        stage.setScene(scene);
        stage.setTitle("Interview Preparation App");
        stage.show();
    }

    private VBox createCategoryCard(String title) {
        Label label = new Label(title);
        label.setFont(new Font("Arial", 14));
        label.setWrapText(true);
        label.setAlignment(Pos.CENTER);

        Button viewBtn = new Button("View");
        viewBtn.setStyle("-fx-background-color: #2575fc; -fx-text-fill: white; -fx-font-weight: bold;");

        VBox vb = new VBox(10, label, viewBtn);
        vb.setPadding(new Insets(15));
        vb.setAlignment(Pos.CENTER);
        vb.setStyle("-fx-background-color: white; -fx-border-radius: 10; -fx-background-radius: 10;");
        vb.setPrefSize(150, 50);

       

        return vb;
    }

   
}
