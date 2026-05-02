package com.smartf;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Mock_Test1 {

    private final String[][] questions = {
        // [25 questions omitted for brevity — unchanged]
        {"Which OS is open source?", "Windows", "macOS", "Linux", "iOS", "Linux"},
         {"Which algorithm avoids deadlock?", "Banker's Algorithm", "LRU", "SJF", "FCFS", "Banker's Algorithm"},
            {"Paging is a technique used in:", "Disk Scheduling", "Memory Management", "File Systems", "I/O Management", "Memory Management"},
            {"What is the purpose of a context switch?", "Increase CPU speed", "Save state of a process and load another", "Manage memory", "Handle user input", "Save state of a process and load another"},
            {"Which SQL command is used to remove a table from a database?", "REMOVE", "ERASE", "DELETE", "DROP", "DROP"},
            {"What is normalization?", "Decreasing number of tables", "Storing binary data", "Reducing data redundancy", "Increasing data size", "Reducing data redundancy"},
            {"A primary key must be:", "NULL", "Unique and NULL", "NOT NULL", "Unique and NOT NULL", "Unique and NOT NULL"},
            {"Which of the following is a valid transaction property in DBMS?", "ACID", "BASE", "SQL", "ODBC", "ACID"},
            {"Which join returns only matching rows?", "INNER JOIN", "RIGHT JOIN", "LEFT JOIN", "FULL JOIN", "INNER JOIN"},
            {"Which of the following is not a logical operator in most languages?", "AND", "OR", "NOT", "NOR", "NOR"},
            {"What is the output of: 3 + 2 * 2", "10", "7", "8", "5", "7"},
    };

    private int currentQuestionIndex = 0;
    private int score = 0, correct = 0, wrong = 0, attempted = 0;
    private ToggleGroup optionGroup;
    private Label questionLabel, timerLabel, feedbackLabel;
    private VBox optionsBox, resultBox;
    private Timeline timeline;
    private double timeLeft = 30;
    private ProgressBar progressBar;
    private Button nextBtn;
    private Runnable backAction;

    public Scene creatScene(Stage mainStage, Runnable backAction) {
        this.backAction = backAction;

        questionLabel = new Label();
        questionLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        timerLabel = new Label("\u23F1 Time: 30");
        timerLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: darkblue; -fx-font-weight: bold;");

        feedbackLabel = new Label();
        feedbackLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        progressBar = new ProgressBar(1);
        progressBar.setPrefWidth(500);
        progressBar.setStyle("-fx-accent: #2196f3;");

        optionGroup = new ToggleGroup();
        optionsBox = new VBox(10);
        optionsBox.setPadding(new Insets(10));

        nextBtn = new Button("Next");
        nextBtn.setDisable(true);
        nextBtn.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-font-size: 14px;");
        nextBtn.setOnAction(e -> {
            currentQuestionIndex++;
            loadQuestion();
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> backAction.run());

        resultBox = new VBox();
        resultBox.setAlignment(Pos.CENTER);
        resultBox.setPadding(new Insets(10));
        resultBox.setStyle("-fx-background-color: #e8f5e9; -fx-border-color: #66bb6a; -fx-border-radius: 10; -fx-background-radius: 10;");

        HBox topBar = new HBox(timerLabel);
        topBar.setAlignment(Pos.TOP_RIGHT);
        topBar.setPadding(new Insets(0, 10, 10, 0));

        VBox contentBox = new VBox(10,
                topBar,
                questionLabel,
                optionsBox,
                progressBar,
                feedbackLabel,
                nextBtn,
                resultBox,
                backButton
        );
        contentBox.setAlignment(Pos.CENTER_LEFT);
        contentBox.setPadding(new Insets(20));
        contentBox.setStyle("-fx-background-color: #ffffff; -fx-border-color: #90caf9; -fx-border-radius: 10; -fx-background-radius: 10; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 5);");

        VBox wrapper = new VBox(20, contentBox);
        wrapper.setAlignment(Pos.CENTER);
        wrapper.setPadding(new Insets(40));
        wrapper.setStyle("-fx-background-color: #e3f2fd;");

        Scene scene = new Scene(wrapper, 720, 470);

        loadQuestion();  // ✅ uses stored backAction internally

        return scene;
    }

    private void loadQuestion() {
        if (timeline != null) timeline.stop();

        if (currentQuestionIndex >= questions.length) {
            showFinalResult(backAction);  // ✅ fix: now passes stored Runnable
            return;
        }

        optionGroup.getToggles().clear();
        optionsBox.getChildren().clear();
        feedbackLabel.setText("");
        resultBox.getChildren().clear();
        timeLeft = 30;
        nextBtn.setDisable(true);

        String[] q = questions[currentQuestionIndex];
        questionLabel.setText((currentQuestionIndex + 1) + ". " + q[0]);

        for (int i = 1; i <= 4; i++) {
            RadioButton option = new RadioButton(q[i]);
            option.setToggleGroup(optionGroup);
            option.setStyle("-fx-font-size: 14px;");
            int finalI = i;
            option.setOnAction(e -> {
                evaluateAnswer(q[finalI]);
                nextBtn.setDisable(false);
            });
            optionsBox.getChildren().add(option);
        }

        startTimer();
    }

    private void startTimer() {
        timeLeft = 30;
        progressBar.setProgress(1.0);
        timerLabel.setText("\u23F1 Time: 30");

        timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            timeLeft -= 0.1;
            timerLabel.setText(String.format("\u23F1 Time: %.0f", timeLeft));
            progressBar.setProgress(timeLeft / 30.0);
            if (timeLeft <= 0) {
                timeline.stop();
                evaluateAnswer(null);
                nextBtn.setDisable(false);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void evaluateAnswer(String selectedAns) {
        timeline.stop();
        String correctAns = questions[currentQuestionIndex][5];

        if (selectedAns == null) {
            feedbackLabel.setText("\u26A0\uFE0F Time's up! Correct answer: " + correctAns);
            feedbackLabel.setStyle("-fx-text-fill: orange;");
        } else {
            attempted++;
            if (selectedAns.equals(correctAns)) {
                score++;
                correct++;
                feedbackLabel.setText("\u2705 Correct!");
                feedbackLabel.setStyle("-fx-text-fill: green;");
            } else {
                wrong++;
                feedbackLabel.setText("\u274C Incorrect! Correct: " + correctAns);
                feedbackLabel.setStyle("-fx-text-fill: red;");
            }
        }

        for (Toggle toggle : optionGroup.getToggles()) {
            ((RadioButton) toggle).setDisable(true);
        }
    }

    private void showFinalResult(Runnable backAction) {
        questionLabel.setText("\u2705 Quiz Completed!");
        optionsBox.getChildren().clear();
        feedbackLabel.setText("");
        progressBar.setProgress(0);
        nextBtn.setDisable(true);
        timerLabel.setText("");

        Label finalScore = new Label("\uD83C\uDFC6 Final Score: " + score + "/" + questions.length);
        Label correctLbl = new Label("\u2714\uFE0F Correct Answers: " + correct);
        Label wrongLbl = new Label("\u274C Wrong Answers: " + wrong);
        Label attemptLbl = new Label("\uD83D\uDCDD Attempted: " + attempted);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> backAction.run());

        for (Label label : new Label[]{finalScore, correctLbl, wrongLbl, attemptLbl}) {
            label.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        }

        PieChart pieChart = new PieChart();
        pieChart.getData().add(new PieChart.Data("Correct", correct));
        pieChart.getData().add(new PieChart.Data("Wrong", wrong));
        pieChart.getData().add(new PieChart.Data("Unattempted", questions.length - attempted));
        pieChart.setLegendVisible(true);
        pieChart.setLabelsVisible(true);

        Button restartBtn = new Button("Restart Quiz");
        restartBtn.setStyle("-fx-background-color: #d3dce3ff; -fx-text-fill: white;");
        restartBtn.setOnAction(e -> {
            currentQuestionIndex = 0;
            score = correct = wrong = attempted = 0;
            loadQuestion();
        });

        resultBox.getChildren().setAll(finalScore, correctLbl, wrongLbl, attemptLbl, pieChart, restartBtn, backButton);
    }
}
