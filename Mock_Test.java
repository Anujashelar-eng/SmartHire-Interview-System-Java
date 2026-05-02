package com.smartf;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;

public class Mock_Test extends Application {

    private final String[][] questions = {
                {"Which of the following protocols is used to send emails?", "SNMP", "HTTP", "SMTP", "FTP", "SMTP"},
            {"What layer of the OSI model is responsible for routing?", "Data Link", "Network", "Transport", "Application", "Network"},
            {"Which encryption algorithm is symmetric?", "AES", "RSA", "ECC", "DSA", "AES"},
            {"What does the term 'IP spoofing' refer to?", "Forging source IP address", "Using a proxy", "Encrypting IP packets", "Sending ICMP messages", "Forging source IP address"},
            {"Which of the following is NOT a characteristic of TCP?", "Reliable", "Connectionless", "Ordered", "Error-checked", "Connectionless"},
            {"A firewall operates at which OSI layers?", "Only Application", "Data Link and Physical", "Session and Presentation", "Application and Network", "Application and Network"},
            {"Which of the following is a non-preemptive scheduling algorithm?", "SJF (Preemptive)", "Round Robin", "Priority Scheduling", "FCFS", "FCFS"},
            {"What is a race condition?", "None of the above", "Two processes executing in parallel", "Deadlock between two processes", "Two processes trying to access shared data concurrently", "Two processes trying to access shared data concurrently"},
            {"What does fork() do in UNIX systems?", "Creates a new process", "Terminates a process", "Allocates memory", "Switches threads", "Creates a new process"},
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
            {"Which one is a correct binary representation of 13?", "1101", "1010", "1110", "1001", "1101"},
            {"What is the antonym of 'benevolent'?", "Kind", "Cruel", "Helpful", "Generous", "Cruel"},
            {"Choose the correct spelling:", "Definately", "Definetly", "Definitely", "Defanitely", "Definitely"},
            {"What does the idiom 'a blessing in disguise' mean?", "Something bad", "A hidden curse", "A good thing that seemed bad at first", "A magical item", "A good thing that seemed bad at first"},
            {"What is the synonym of 'abundant'?", "Scarce", "Plentiful", "Empty", "Rare", "Plentiful"},
            {"Find the odd one out:", "Apple", "Banana", "Mango", "Potato", "Potato"},
            {"What comes next in the series: 2, 4, 8, 16, ?", "20", "24", "32", "30", "32"},
            {"If 5x = 20, what is x?", "2", "3", "4", "5", "4"},
            {"What is the square root of 144?", "10", "11", "12", "13", "12"},
            {"Solve: (3 + 2)^2", "10", "25", "15", "20", "25"},
            {"What is the result of: 100 / (5 * 2)?", "5", "10", "20", "50", "10"},
            {"Which of the following is a valid C++ data type?", "string", "String", "char", "text", "char"},
            {"What is the correct syntax to create an object in Java?", "MyClass obj = new MyClass();", "new MyClass obj = MyClass();", "MyClass obj();", "obj = class MyClass();", "MyClass obj = new MyClass();"},
            {"Which of the following is not a valid Python keyword?", "def", "return", "class", "define", "define"},
            {"In C++, what does 'cin' do?", "Outputs data", "Reads input", "Declares a class", "Compiles program", "Reads input"},
            {"Which method is used to compare strings in Java?", "=", "equals()", "==", "compareTo()", "equals()"},
            {"What will be the output of: print(2**3)?", "6", "8", "9", "5", "8"},
            {"Which data structure uses FIFO?", "Stack", "Queue", "Array", "LinkedList", "Queue"},
            {"What is the size of int in C++?", "2 or 4 bytes", "Always 4 bytes", "1 byte", "8 bytes", "2 or 4 bytes"},
            {"Which operator is used for inheritance in C++?", "::", "->", "public", ":", ":"},
            {"What is garbage collection in Java?", "Cleaning RAM", "Releasing unused memory", "Erasing disk", "Copying files", "Releasing unused memory"},
            {"Which keyword is used to handle exceptions in Java?", "try", "throw", "catch", "finally", "try"},
            {"Which of these is not a Python data type?", "set", "map", "list", "dict", "map"},
            {"Which function is used to get length of list in Python?", "length()", "size()", "len()", "count()", "len()"},
            {"What will len(set('hello')) return?", "4", "5", "3", "Error", "4"},
            {"What does list[::-1] do in Python?", "Reverses list", "Sorts list", "Deletes list", "Skips every second element", "Reverses list"},
            {"Which of the following is mutable?", "tuple", "int", "list", "str", "list"}

    };

    private final ToggleGroup[] toggleGroups = new ToggleGroup[questions.length];

    @Override
    public void start(Stage stage) {
        VBox quizBox = new VBox(15);
        quizBox.setPadding(new Insets(20));

        for (int i = 0; i < questions.length; i++) {
            VBox qBox = new VBox(8);
            qBox.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 6; -fx-padding: 12; -fx-background-color: #fdfdfd; -fx-background-radius: 6;");
            Label qLabel = new Label((i + 1) + ". " + questions[i][0]);
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

        submitBtn.setOnMouseEntered(e -> submitBtn.setStyle("-fx-background-color: #1a8be4; -fx-text-fill: white;"));
        submitBtn.setOnMouseExited(e -> submitBtn.setStyle("-fx-background-color: #2a9df4; -fx-text-fill: white;"));

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
                        animateButtonColor(qb, "#a8e6a1");
                    } else {
                        wrong++;
                        animateButtonColor(qb, "#f08080");
                    }
                } else {
                    animateButtonColor(qb, "#ffa500");
                }
            }

            resultLabel.setText("Your Score: " + score + " / " + questions.length);
            scoreDetailsLabel.setText("Correct: " + correct + " | Wrong: " + wrong + " | Attempted: " + attempted);
            animateLabelScale(resultLabel);
        });

        // Add Submit button and result area at the end of the quiz
        VBox resultBox = new VBox(5, resultLabel, scoreDetailsLabel);
        resultBox.setAlignment(Pos.CENTER_LEFT);
        resultBox.setPadding(new Insets(10, 0, 0, 0));

       HBox bottomBox = new HBox(20, submitBtn, resultBox);
       bottomBox.setAlignment(Pos.CENTER_LEFT);
       bottomBox.setPadding(new Insets(20, 0, 0, 0));

       quizBox.getChildren().add(bottomBox);

        ScrollPane scrollPane = new ScrollPane(quizBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefSize(800, 800);

        HBox mainLayout = new HBox(15, scrollPane, statusContainer);
        mainLayout.setPadding(new Insets(15));

        // Timer setup
        Label timerLabel = new Label("Time Left: 60:00");
        timerLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: red; -fx-font-weight: bold;");
        Integer[] timeLeft = {3600};

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            timeLeft[0]--;
            int min = timeLeft[0] / 60;
            int sec = timeLeft[0] % 60;
            timerLabel.setText(String.format("Time Left: %02d:%02d", min, sec));

            if (timeLeft[0] <= 0) {
                ((Timeline) ev.getSource()).stop();
                submitBtn.fire(); // Auto-submit
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Time's Up");
                alert.setHeaderText(null);
                alert.setContentText("Time is over! Your quiz has been submitted.");
                alert.showAndWait();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Back button
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #d9534f; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 6 12; -fx-background-radius: 6;");
        backButton.setOnAction(e -> stage.close()); // Replace with navigation logic if needed

        HBox topBox = new HBox(10, backButton, timerLabel);
        topBox.setPadding(new Insets(10));
        topBox.setSpacing(20);
        topBox.setStyle("-fx-alignment: center-left;");

        VBox fullLayout = new VBox(10, topBox, mainLayout, bottomBox);
        fullLayout.setPadding(new Insets(10));
        Scene scene = new Scene(fullLayout, 900, 600);
        stage.setScene(scene);
        stage.setTitle("Mock_Test - SmartHire Interview Preparation System");
        stage.show();
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