package com.smartf;


import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

public class Dbms2 {

    private final String[][] questions = {
        {"1. What is the difference between 2PL and Strict 2PL?", "Strict 2PL allows unlocking before commit", "2PL holds locks till the transaction ends", "Strict 2PL holds exclusive locks till commit", "2PL ensures cascading aborts", "Strict 2PL holds exclusive locks till commit"},
        {"2. Which of these is true for serializability in transactions?", "Conflict-serializable implies view-serializable", "View-serializable implies conflict-serializable", "All serializable schedules are recoverable", "Serializable schedules must be strict", "Conflict-serializable implies view-serializable"},
        {"3. In a B+ Tree of order m, what is max number of keys in a leaf node?", "m", "m - 1", "m + 1", "m - 2", "m - 1"},
        {"4. Which join performs best for large datasets with no indexes?", "Nested Loop Join", "Sort-Merge Join", "Hash Join", "Index Join", "Hash Join"},
        {"5. Which normal form eliminates transitive dependencies?", "1NF", "2NF", "3NF", "BCNF", "3NF"},
        {"6. Which of the following is not a transaction property?", "Atomicity", "Durability", "Concurrency", "Isolation", "Concurrency"},
        {"7. What does a Foreign Key constraint avoid?", "Insertion anomaly", "Deletion anomaly", "Update anomaly", "Referential integrity violation", "Referential integrity violation"},
        {"8. Which data structure is used for indexes in databases?", "Stack", "Linked List", "B+ Tree", "Trie", "B+ Tree"},
        {"9. Which schedule is NOT conflict serializable?", "No conflicting operations", "Can be transformed into serial", "Cycle in precedence graph", "View-equivalent to serial", "Cycle in precedence graph"},
        {"10. Which isolation level allows dirty reads?", "READ COMMITTED", "REPEATABLE READ", "SERIALIZABLE", "READ UNCOMMITTED", "READ UNCOMMITTED"},
        {"11. What causes a deadlock in transaction systems?", "No locking", "Timeout", "Cyclic wait", "Deadlock detection", "Cyclic wait"},
        {"12. What anomaly does multiversion concurrency control solve?", "Phantom read", "Dirty read", "Deadlock", "Lock starvation", "Phantom read"},
        {"13. Which property ensures DB changes survive failures?", "Atomicity", "Durability", "Isolation", "Consistency", "Durability"},
        {"14. Which is true about foreign keys?", "Reference unique column", "Can be NULL always", "Must reference a primary key", "Enforce domain constraints", "Must reference a primary key"},
        {"15. Which normal form gives lossless join and dep preservation?", "2NF", "3NF", "BCNF", "1NF", "3NF"},
        {"16. Best file org. for high-volume inserts?", "Heap file", "Sorted file", "Hashed file", "B-tree file", "Heap file"},
        {"17. What ensures ACID in distributed systems?", "2PC", "Lock escalation", "Replication", "Checkpointing", "2PC"},
        {"18. Which is not a concurrency control strategy?", "Timestamps", "Locking", "Shadow Paging", "Multi-versioning", "Shadow Paging"},
        {"19. What helps prevent starvation in concurrency control?", "Wait-die", "Priority aging", "Round-robin", "Preemptive priority", "Priority aging"},
        {"20. Which is a lossless-join decomposition?", "R1(A,B), R2(B,C)", "R1(A,B), R2(A,C)", "R1(A), R2(B,C)", "R1(B), R2(C)", "R1(A,B), R2(B,C)"}
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

        //bmitBtn.setOnMouseEntered(e -> submitBtn.setStyle("-fx-background-color: #1a8be4; -fx-text-fill: white;"));
       //ubmitBtn.setOnMouseExited(e -> submitBtn.setStyle("-fx-background-color: #2a9df4; -fx-text-fill: white;"));

        submitBtn.setOnAction(e -> {
            int score = 0, correct = 0, wrong = 0, attempted = 0;

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
          Fundamentals2 aptitudePage = new Fundamentals2();
          Scene funScene = aptitudePage.createScene(mainStage);
          mainStage.setScene(funScene);
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
