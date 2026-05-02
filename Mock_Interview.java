package com.smartf;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;

public class Mock_Interview{

    private VBox chatBox;
    private TextField inputField;
    private Button sendButton;
    private Label timerLabel;
    private Label scoreLabel;

    private int questionIndex = 0;
    private int totalScore = 0;
    private Timeline timer;
    private int timeLeft = 30;

    private final List<String> questions = Arrays.asList(
            "Hello! Welcome to SmartHire. Let's start your mock interview.",
            "Tell me about yourself.",
            //"What is polymorphism in OOP?",
            "Can you explain normalization in DBMS?",
            "Why should we hire you?",
            "Great! This concludes your mock interview. Good luck!"
    );

    private final Map<Integer, List<String>> keywordMap = Map.of(
            1, Arrays.asList("student", "internship", "project", "passion", "developer"),
           // 2, Arrays.asList("overriding", "runtime", "compile", "inheritance", "method"),
            3, Arrays.asList("normal", "form", "1nf", "2nf", "3nf", "redundancy", "dependency"),
            4, Arrays.asList("team", "skills", "adapt", "motivated", "hire", "hardworking")
    );

    
    public Scene creatScene(Stage mainStage,Runnable backAction) {
        mainStage.setTitle("🧠 SmartHire - Timed Chat Interview");

        chatBox = new VBox(10);
        chatBox.setPadding(new Insets(15));
        chatBox.setStyle("-fx-background-color: #f0f4f8;");
        chatBox.setPrefWidth(600);

        ScrollPane scrollPane = new ScrollPane(chatBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setStyle("-fx-background: transparent; -fx-border-color: transparent;");

        inputField = new TextField();
        inputField.setPromptText("Type your answer...");
        inputField.setFont(Font.font("Segoe UI", 14));
        inputField.setPrefWidth(320);
        inputField.setStyle("-fx-background-radius: 10; -fx-padding: 5 10; -fx-border-color: lightgray;");

        sendButton = new Button("📤 Send");
        sendButton.setDefaultButton(true);
        sendButton.setStyle(buttonStyle("#4CAF50"));
        sendButton.setOnAction(e -> handleUserAnswer());

        timerLabel = new Label("⏱ Time: 30");
        timerLabel.setFont(Font.font("Segoe UI", 14));
        timerLabel.setStyle("-fx-text-fill: #d32f2f; -fx-font-weight: bold;");

        scoreLabel = new Label("⭐ Score: 0");
        scoreLabel.setFont(Font.font("Segoe UI", 14));
        scoreLabel.setStyle("-fx-text-fill: #0277bd; -fx-font-weight: bold;");

        Button refreshButton = new Button("🔄 Refresh");
        refreshButton.setStyle(buttonStyle("#1976D2"));
        refreshButton.setOnAction(e -> resetChat());

        Button backButton = new Button("⬅ Back");
        backButton.setStyle("-fx-font-size: 14; -fx-padding: 8 16; -fx-background-color: #7364e2;");
        backButton.setOnAction(e -> {
            backAction.run();
        });

        HBox topBar = new HBox(20, timerLabel, scoreLabel, refreshButton,backButton);
        topBar.setPadding(new Insets(10));
        topBar.setAlignment(Pos.CENTER);
        topBar.setStyle("-fx-background-color: #e3f2fd;");

        HBox inputArea = new HBox(10, inputField, sendButton);
        inputArea.setPadding(new Insets(12));
        inputArea.setAlignment(Pos.CENTER);
        inputArea.setStyle("-fx-background-color: #eeeeee;");

        BorderPane root = new BorderPane();
        root.setTop(topBar);
        root.setCenter(scrollPane);
        root.setBottom(inputArea);
        askNextQuestion();
        Scene scene = new Scene(root, 700, 540);
        return scene;

        
    }

    private void handleUserAnswer() {
        String answer = inputField.getText().trim();
        if (answer.isEmpty()) return;

        stopTimer();

        addUserMessage(answer);
        evaluateAnswer(answer);
        inputField.clear();

        askNextQuestion();
    }

    private void askNextQuestion() {
        if (questionIndex < questions.size()) {
            String question = questions.get(questionIndex);
            simulateTyping(question, () -> {
                if (questionIndex > 0 && questionIndex < questions.size() - 1) {
                    startTimer();
                }
                questionIndex++;
            });
        } else {
            showFinalScore();
        }
    }

    private void simulateTyping(String message, Runnable onFinish) {
        Label typingLabel = new Label("Typing...");
        typingLabel.setStyle("-fx-font-style: italic; -fx-text-fill: gray;");
        HBox typingBox = new HBox(typingLabel);
        typingBox.setAlignment(Pos.CENTER);
        chatBox.getChildren().add(typingBox);
        scrollToBottom();

        PauseTransition pause = new PauseTransition(Duration.seconds(1.2));
        pause.setOnFinished(e -> {
            chatBox.getChildren().remove(typingBox);
            addBotMessage(message);
            onFinish.run();
        });
        pause.play();
    }

    private void addBotMessage(String text) {
        Label message = new Label(text);
        message.setFont(Font.font("Segoe UI", 14));
        message.setWrapText(true);
        message.setStyle("-fx-background-color: #328cd1ff; -fx-padding: 10; -fx-background-radius: 12; -fx-effect: dropshadow(one-pass-box, rgba(0,0,0,0.1), 4, 0.0, 2, 2);");
        message.setMaxWidth(420);
        message.setAlignment(Pos.CENTER);

        HBox messageBox = new HBox(message);
        messageBox.setAlignment(Pos.CENTER);
        animateMessage(messageBox);
        chatBox.getChildren().add(messageBox);
        scrollToBottom();
    }

    private void addUserMessage(String text) {
        Label message = new Label(text);
        message.setFont(Font.font("Segoe UI", 14));
        message.setWrapText(true);
        message.setStyle("-fx-background-color: #40b746ff; -fx-padding: 10; -fx-background-radius: 12; -fx-effect: dropshadow(one-pass-box, rgba(0,0,0,0.1), 4, 0.0, 2, 2);");
        message.setMaxWidth(420);
        message.setAlignment(Pos.CENTER);

        HBox messageBox = new HBox(message);
        messageBox.setAlignment(Pos.CENTER);
        animateMessage(messageBox);
        chatBox.getChildren().add(messageBox);
        scrollToBottom();
    }

    private void animateMessage(HBox box) {
        FadeTransition fade = new FadeTransition(Duration.millis(400), box);
        fade.setFromValue(0);
        fade.setToValue(1);

        TranslateTransition slide = new TranslateTransition(Duration.millis(300), box);
        slide.setFromY(20);
        slide.setToY(0);

        new ParallelTransition(fade, slide).play();
    }

    private void scrollToBottom() {
        Platform.runLater(() -> {
            chatBox.layout();
            ((ScrollPane) chatBox.getParent()).setVvalue(1.0);
        });
    }

    private void evaluateAnswer(String answer) {
        int questionNumber = questionIndex - 1;
        int localScore = 0;
        if (keywordMap.containsKey(questionNumber)) {
            for (String keyword : keywordMap.get(questionNumber)) {
                if (answer.toLowerCase().contains(keyword.toLowerCase())) {
                    localScore++;
                }
            }
        }
        totalScore += localScore;
        scoreLabel.setText("⭐ Score: " + totalScore);
    }

    private void startTimer() {
    timeLeft = 90; // ⏱ 90 seconds per question
    timerLabel.setText("⏱ Time: " + timeLeft);
    timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
        timeLeft--;
        timerLabel.setText("⏱ Time: " + timeLeft);
        if (timeLeft <= 0) {
            stopTimer();
            autoSubmitAnswer();
        }
    }));
    timer.setCycleCount(Timeline.INDEFINITE);
    timer.play();
}


    private void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }

    private void autoSubmitAnswer() {
        String autoAnswer = "(No answer submitted)";
        addUserMessage(autoAnswer);
        evaluateAnswer("");
        askNextQuestion();
    }

    private void showFinalScore() {
        stopTimer();
        Label result = new Label("✅ Interview Finished!\nYour Score: " + totalScore);
        result.setFont(Font.font("Segoe UI", 16));
        result.setStyle("-fx-text-fill: green; -fx-padding: 15;");
        HBox resultBox = new HBox(result);
        resultBox.setAlignment(Pos.CENTER);
        chatBox.getChildren().add(resultBox);
        scrollToBottom();
    }

    private void resetChat() {
        stopTimer();
        chatBox.getChildren().clear();
        inputField.clear();
        questionIndex = 0;
        timerLabel.setText("⏱ Time: 30");
        askNextQuestion();
    }

    private String buttonStyle(String color) {
        return "-fx-background-color: " + color + "; " +
               "-fx-text-fill: white; " +
               "-fx-font-weight: bold; " +
               "-fx-background-radius: 10; " +
               "-fx-padding: 6 14;";
    }

}
