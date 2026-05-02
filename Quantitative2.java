// ... (your package and imports remain unchanged)

package com.smartf;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

public class Quantitative2 {

    private final String[][] questions = {
        
        {"1. Solve: (x - 3)(x - 5)(x - 7)(x - 9) + 15 = 0. Smallest positive integer?", "4", "6", "8", "10", "8"},
        {"2. A man sells a chair at 20% profit. If sold for ₹60 more, profit is 30%. Cost price?", "₹600", "₹500", "₹550", "₹400", "₹500"},
        {"3. If x + 1/x = 3, find x³ + 1/x³.", "18", "24", "30", "27", "27"},
        {"4. Sum of natural numbers < 1000 divisible by 3 or 5?", "233168", "234168", "233263", "235000", "233168"},
        {"5. A train 120 m long crosses a pole in 8 seconds. Speed?", "54 km/h", "45 km/h", "60 km/h", "70 km/h", "60 km/h"},
        {"6. Bag has 5 red, 4 blue, 3 green balls. P(both red)?", "5/33", "2/11", "1/11", "10/33", "10/33"},
        {"7. If a + b + c = 0, then a² + b² + c² = ?", "2(ab + bc + ca)", "-2(ab + bc + ca)", "3(ab + bc + ca)", "-3(ab + bc + ca)", "-2(ab + bc + ca)"},
        {"8. 4-digit numbers with all digits different and divisible by 5?", "1440", "1368", "1280", "900", "1280"},
        {"9. A and B do work in 12 days. A alone in 20. B alone in?", "30", "60", "40", "25", "30"},
        {"10. Number that gives remainder 2 mod 5, and 4 mod 7?", "18", "24", "32", "39", "39"},
        {"11. Radius increased by 20%. % increase in area?", "44%", "40%", "42%", "36%", "44%"},
        {"12. Sum becomes 3× in 4 yrs (CI). When will it become 9×?", "8", "12", "6", "9", "8"},
        {"13. Difference between CI and SI on ₹10,000 at 10% for 2 yrs?", "₹100", "₹120", "₹90", "₹110", "₹100"},
        {"14. Number of trailing zeroes in 100!", "24", "20", "22", "25", "25"},
        {"15. A boat goes 60 km downstream in 1.5 hrs, returns in 2 hrs. Speed in still water?", "40 km/h", "36 km/h", "38 km/h", "34 km/h", "36 km/h"},
        {"16. Unit digit of 7^345?", "7", "9", "3", "1", "7"},
        {"17. Cube surface area = 150 cm². Find side length.", "5", "√25", "6", "5√2", "5"},
        {"18. Man rows 18 km downstream in 2 hrs, 12 km upstream in 3 hrs. Boat speed?", "6 km/h", "7 km/h", "8 km/h", "5 km/h", "6 km/h"},
        {"19. If log(x) + log(2x) = 3, then x = ?", "√10", "10", "100", "5", "10"},
        {"20. A square and circle have same perimeter. Which has more area?", "Square", "Circle", "Both equal", "Cannot determine", "Circle"}
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

        // ✅ Back Button
       Button backBtn = new Button("Back");
        backBtn.setStyle("-fx-background-color: #4a56dbff; -fx-font-size: 16px;");
        backBtn.setOnAction(e -> {
         Aptitude2 aptitudePage = new Aptitude2();
        Scene aptitudeScene = aptitudePage.createScene(mainStage);
        mainStage.setScene(aptitudeScene);
        });

        HBox bottomBox = new HBox(20, backBtn, submitBtn, resultLabel);
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
