package com.smartf;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

public class Javaquizz2 {

    private final String[][] questions = {
        {"1. Which memory area stores class metadata in Java 8 and above?", "PermGen", "Heap", "Metaspace", "Stack", "Metaspace"},
        {"2. What is the primary purpose of the `volatile` keyword in Java?", "To prevent serialization", "To improve performance", "To ensure visibility of changes to variables across threads", "To block threads", "To ensure visibility of changes to variables across threads"},
        {"3. Which design pattern restricts the instantiation of a class to one object?", "Factory", "Adapter", "Singleton", "Observer", "Singleton"},
        {"4. Which data structure is used internally by `HashMap` in Java 8 when collisions become too high?", "Linked List", "TreeMap", "Red-Black Tree", "AVL Tree", "Red-Black Tree"},
        {"5. Which interface allows an object to be executed by a thread and return a result?", "Runnable", "Callable", "Executor", "Future", "Callable"},
        {"6. How many objects are created with the following code? `String s = new String(\"Hello\");`", "0", "1", "2", "3", "2"},
        {"7. Which collection is best suited for LRU cache implementation?", "HashMap", "TreeMap", "LinkedHashMap", "ConcurrentHashMap", "LinkedHashMap"},
        {"8. What happens if `equals()` is overridden but `hashCode()` is not?", "Nothing changes", "Program crashes", "May break hash-based collections", "Code becomes faster", "May break hash-based collections"},
        {"9. What does the `join()` method do in multithreading?", "Terminates thread", "Pauses execution", "Waits for a thread to die", "Splits a thread", "Waits for a thread to die"},
        {"10. Which class is immutable in Java?", "StringBuilder", "String", "ArrayList", "HashMap", "String"},
        {"11. Which exception is thrown if a thread is interrupted while waiting or sleeping?", "ThreadDeath", "InterruptedException", "TimeoutException", "IllegalThreadStateException", "InterruptedException"},
        {"12. Which class is used for high-performance read/write locks in Java?", "ReentrantLock", "ReadWriteLock", "CountDownLatch", "Semaphore", "ReadWriteLock"},
        {"13. Which Java feature enables polymorphism during runtime?", "Method Overloading", "Method Overriding", "Abstraction", "Encapsulation", "Method Overriding"},
        {"14. Which annotation suppresses compiler warnings?", "@SafeVarargs", "@Override", "@SuppressWarnings", "@FunctionalInterface", "@SuppressWarnings"},
        {"15. In Java, which part of memory is garbage collected?", "Stack", "Heap", "Metaspace", "Code Cache", "Heap"},
        {"16. Which method checks if a thread holds a lock on an object?", "holdsLock(Object obj)", "ownsLock(Object obj)", "checkLock(Object obj)", "isLocked(Object obj)", "holdsLock(Object obj)"},
        {"17. Which keyword prevents inheritance in Java?", "static", "final", "abstract", "private", "final"},
        {"18. What implements dynamic method dispatch in Java?", "Method table", "Virtual function table", "Polymorphic table", "Dispatch pointer", "Virtual function table"},
        {"19. Which feature allows parallel stream processing in Java?", "ExecutorService", "ForkJoinPool", "ThreadGroup", "Runnable", "ForkJoinPool"},
        {"20. Which tool is used to monitor and troubleshoot Java applications?", "javap", "jstat", "javadoc", "javah", "jstat"}
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
        //bmitBtn.setOnMouseExited(e -> submitBtn.setStyle("-fx-background-color: #2a9df4; -fx-text-fill: white;"));

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
           Programming2 aptitudePage = new Programming2();
           Scene proScene = aptitudePage.creatScene(mainStage);
           mainStage.setScene(proScene);
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
