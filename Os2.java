package com.smartf;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

public class Os2  {

    private final String[][] questions = {

        {"1. Which of the following is responsible for context switching in an OS?", "Memory Manager", "File System", "Scheduler", "Device Driver", "Scheduler"},
    {"2. In a multiprogramming environment, the primary goal is to:", "Minimize CPU usage", "Increase I/O devices", "Maximize CPU utilization", "Provide real-time response", "Maximize CPU utilization"},
    {"3. Which of the following is NOT a valid process state?", "New", "Terminated", "Waiting", "Suspend-Ready", "Suspend-Ready"},
    {"4. Which scheduling algorithm can cause starvation?", "FCFS", "SJF", "Round Robin", "Multilevel Queue", "SJF"},
    {"5. Which of the following is a characteristic of a real-time OS?", "High throughput", "Fairness", "Predictable response time", "Non-deterministic output", "Predictable response time"},
    {"6. The fork() system call is used to:", "Replace current process image", "Create a new process", "Terminate a process", "Allocate memory", "Create a new process"},
    {"7. A page fault occurs when:", "Page is found in the TLB", "Page is present in RAM", "Page is not in main memory", "Page is being written to disk", "Page is not in main memory"},
    {"8. What is the key advantage of multithreading over multiprocessing?", "Lower memory footprint", "Higher power consumption", "Slower execution", "No resource sharing", "Lower memory footprint"},
    {"9. Which of the following is a deadlock prevention technique?", "Allow circular wait", "Hold and wait", "Preemption", "Mutual exclusion", "Preemption"},
    {"10. Which memory allocation strategy causes the most fragmentation?", "First Fit", "Best Fit", "Worst Fit", "Paging", "Best Fit"},
    {"11. In the readers-writers problem, starvation is avoided by:", "Giving priority to writers", "Giving priority to readers", "Using semaphores carefully", "Avoiding mutual exclusion", "Using semaphores carefully"},
    {"12. Which of the following is used for inter-process communication (IPC)?", "Signals", "Pipes", "Shared Memory", "All of the above", "All of the above"},
    {"13. Which of the following causes thrashing?", "High CPU utilization", "Low degree of multiprogramming", "High page fault rate", "Small process size", "High page fault rate"},
    {"14. Which system uses demand paging?", "Paging", "Segmentation", "Virtual memory", "Cache memory", "Virtual memory"},
    {"15. What does the exec() system call do?", "Terminates a process", "Creates a new thread", "Replaces the current process image with a new one", "Duplicates the process", "Replaces the current process image with a new one"},
    {"16. Which condition is NOT necessary for deadlock?", "Mutual exclusion", "Preemption", "Hold and wait", "Circular wait", "Preemption"},
    {"17. Which statement about kernel mode is true?", "It has limited access to hardware", "It runs user applications", "It can access privileged instructions", "It is slower than user mode", "It can access privileged instructions"},
    {"18. What is the role of MMU (Memory Management Unit)?", "Handles I/O", "Manages process states", "Translates virtual to physical addresses", "Schedules tasks", "Translates virtual to physical addresses"},
    {"19. What structure does OS use to track processes?", "File descriptor table", "Process Control Block (PCB)", "Page table", "Stack frame", "Process Control Block (PCB)"},
    {"20. The Banker’s algorithm is used to:", "Detect deadlock", "Recover from deadlock", "Avoid deadlock", "Prevent starvation", "Avoid deadlock"}

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

       //ubmitBtn.setOnMouseEntered(e -> submitBtn.setStyle("-fx-background-color: #1a8be4; -fx-text-fill: white;"));
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
