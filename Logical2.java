package com.smartf;


import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

public class Logical2  {

    private final String[][] questions = {
        {"1. What comes next in the series: 2, 6, 12, 20, 30, ?", "36", "40", "42", "48", "42"},
        {"2. Find the odd one out: 3, 5, 7, 11, 13, 17, 21", "13", "17", "21", "5", "21"},
        {"3. Which number should replace the question mark: 4, 9, 16, 25, ?", "36", "30", "40", "49", "36"},
        {"4. Complete the analogy: Foot : Shoe :: Hand : ?", "Watch", "Ring", "Glove", "Sleeve", "Glove"},
        {"5. If CAT = 24, DOG = 26, then FOX = ?", "51", "48", "54", "45", "51"},
        {"6. What comes next in the pattern: Z, X, V, T, ?", "S", "Q", "R", "P", "R"},
        {"7. All roses are flowers. Some flowers fade quickly. Therefore?", "All roses fade quickly", "Some flowers are roses", "Some roses fade quickly", "None", "Some flowers are roses"},
        {"8. Which number does not belong: 121, 144, 169, 182, 196", "121", "182", "144", "196", "182"},
        {"9. What comes next: 1, 2, 6, 24, 120, ?", "720", "600", "840", "900", "720"},
        {"10. Which is the odd one out: Triangle, Square, Pentagon, Circle", "Square", "Triangle", "Circle", "Pentagon", "Circle"},
        {"11. If EDUCATION = 92, what is SCIENCE?", "66", "70", "73", "75", "73"},
        {"12. What is the missing number: 7, 14, 28, 56, ?", "84", "112", "96", "126", "112"},
        {"13. Which word does not belong: Apple, Banana, Grape, Carrot", "Apple", "Banana", "Carrot", "Grape", "Carrot"},
        {"14. Series completion: 1, 4, 9, 16, 25, ?", "30", "36", "34", "49", "36"},
        {"15. Which one is different: Iron, Copper, Gold, Plastic", "Iron", "Gold", "Copper", "Plastic", "Plastic"},
        {"16. Mirror Image of 3:20?", "9:40", "8:40", "9:20", "8:20", "8:40"},
        {"17. If MONDAY is coded as 513924, what is TUESDAY?", "296519", "296524", "296934", "296594", "296934"},
        {"18. What is the missing number: 5, 10, 20, 40, ?", "60", "70", "80", "100", "80"},
        {"19. Which number doesn't belong: 4, 9, 16, 23, 25", "9", "16", "23", "25", "23"},
        {"20. Next letter in sequence: A, C, F, J, O, ?", "Q", "S", "U", "V", "U"}
    };

    private final ToggleGroup[] toggleGroups = new ToggleGroup[20];

    public Scene createScene(Stage mainStage){
        VBox quizBox = new VBox(15);
        quizBox.setPadding(new Insets(20));

        for (int i = 0; i < questions.length; i++) {
            VBox qBox = new VBox(8);
            qBox.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 6; -fx-padding: 12; -fx-background-color: #fdfdfd; -fx-background-radius: 6;");
            Label qLabel = new Label(questions[i][0]);
            qLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
            ToggleGroup tg = new ToggleGroup();
            toggleGroups[i] = tg;

            for (int j = 1; j <= 4; j++) {
                RadioButton rb = new RadioButton(questions[i][j]);
                rb.setToggleGroup(tg);
                rb.setStyle("-fx-font-size: 13px;");
                qBox.getChildren().add(rb);
            }

            quizBox.getChildren().addAll(qLabel, qBox);
        }

        Button submitBtn = new Button("Submit Quiz");
        submitBtn.setStyle("-fx-background-color: #2a9df4; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 8 16; -fx-background-radius: 6;");
        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: darkblue;");
        resultLabel.setScaleX(0.9);
        resultLabel.setScaleY(0.9);

        // Score details label (new)
        Label scoreDetailsLabel = new Label();
        scoreDetailsLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #333;");

        GridPane statusGrid = new GridPane();
        statusGrid.setPadding(new Insets(15));
        statusGrid.setHgap(10);
        statusGrid.setVgap(10);
        statusGrid.setStyle("-fx-background-color: #f0f0f0; -fx-background-radius: 8;");
        Label statusLabel = new Label("Question Status:");
        statusLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        VBox statusContainer = new VBox(10, statusLabel, statusGrid, scoreDetailsLabel);
        statusContainer.setPadding(new Insets(15));

        List<Button> questionButtons = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            Button qButton = new Button("Q" + (i + 1));
            int finalI = i;
            qButton.setPrefSize(60, 40);
            qButton.setStyle("-fx-background-color: cream; -fx-border-color: gray; -fx-font-weight: bold;");
            qButton.setOnMouseEntered(e -> qButton.setScaleX(1.05));
            qButton.setOnMouseExited(e -> qButton.setScaleX(1.0));
            qButton.setOnMousePressed(e -> qButton.setScaleY(0.95));
            qButton.setOnMouseReleased(e -> qButton.setScaleY(1.0));
            qButton.setOnAction(e -> quizBox.getChildren().get(finalI * 2).requestFocus());
            questionButtons.add(qButton);
            statusGrid.add(qButton, i % 4, i / 4);
        }

        //submitBtn.setOnMouseEntered(e -> submitBtn.setStyle("-fx-background-color: #1a8be4; -fx-text-fill: white;"));
        //submitBtn.setOnMouseExited(e -> submitBtn.setStyle("-fx-background-color: #2a9df4; -fx-text-fill: white;"));

        submitBtn.setOnAction(e -> {
            int score = 0;
            int correct = 0;
            int wrong = 0;
            int attempted = 0;

            for (int i = 0; i < questions.length; i++) {
                Toggle selected = toggleGroups[i].getSelectedToggle();
                Button qb = questionButtons.get(i);
                if (selected != null) {
                    attempted++;
                    String selectedAnswer = ((RadioButton) selected).getText();
                    String correctAnswer = questions[i][5];

                    if (selectedAnswer.equals(correctAnswer)) {
                        score++;
                        correct++;
                        animateButtonColor(qb, "#a8e6a1"); // Green
                    } else {
                        wrong++;
                        animateButtonColor(qb, "#f08080"); // Red
                    }
                } else {
                    animateButtonColor(qb, "#ffa500"); // Orange
                }
            }

            resultLabel.setText("Your Score: " + score + " / 20");
            scoreDetailsLabel.setText("Correct: " + correct + " | Wrong: " + wrong + " | Attempted: " + attempted);
            animateLabelScale(resultLabel);
        });
        Button backBtn = new Button("Back");
        backBtn.setStyle("-fx-background-color: #4a56dbff; -fx-font-size: 16px;");
        backBtn.setOnAction(e -> {
            
        Aptitude2 aptitudePage = new Aptitude2();
        Scene aptitudeScene = aptitudePage.createScene(mainStage);
        mainStage.setScene(aptitudeScene);
    

        });

        HBox bottomBox = new HBox(20,backBtn, submitBtn, resultLabel);
        bottomBox.setPadding(new Insets(10));

        ScrollPane scrollPane = new ScrollPane(quizBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefSize(900, 900);

        HBox mainLayout = new HBox(15, scrollPane, statusContainer);
        mainLayout.setPadding(new Insets(15));

        Scene scene = new Scene(new VBox(mainLayout, bottomBox), 900, 600);
        return scene;
    }

    private void animateButtonColor(Button btn, String targetColor) {
        Platform.runLater(() -> btn.setStyle(
            "-fx-background-color: " + targetColor + "; -fx-border-color: gray; -fx-font-weight: bold;"
        ));
    }

    private void animateLabelScale(Label lbl) {
        new Thread(() -> {
            try {
                for (double s = 0.9; s <= 1.1; s += 0.02) {
                    Thread.sleep(10);
                    double fs = s;
                    Platform.runLater(() -> {
                        lbl.setScaleX(fs);
                        lbl.setScaleY(fs);
                    });
                }
                Platform.runLater(() -> {
                    lbl.setScaleX(1.0);
                    lbl.setScaleY(1.0);
                });
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
}
