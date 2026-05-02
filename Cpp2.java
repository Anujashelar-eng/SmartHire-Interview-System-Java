package com.smartf;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

public class Cpp2 {

    private final String[][] questions = {
        {"1. What will be the output of the following code?\nint x = 10;\ncout << ++x + x++;", "21", "22", "Undefined behavior", "Compiler error", "Undefined behavior"},
        {"2. Which of the following is not a type of inheritance in C++?", "Multilevel", "Multiple", "Parallel", "Hybrid", "Parallel"},
        {"3. What is the size of an empty class in C++?", "0 byte", "1 byte", "2 bytes", "Depends on compiler", "1 byte"},
        {"4. Which feature allows redefinition of base class methods in derived class?", "Overloading", "Inheritance", "Polymorphism", "Encapsulation", "Polymorphism"},
        {"5. Which C++ keyword is used for dynamic memory allocation?", "malloc", "calloc", "new", "memory", "new"},
        {"6. Which function is called when an object goes out of scope?", "Constructor", "Destructor", "Operator()", "finalize()", "Destructor"},
        {"7. Which one is the correct syntax to declare a pure virtual function?", "virtual void func() = 0;", "pure virtual void func();", "abstract void func();", "virtual void func() {};", "virtual void func() = 0;"},
        {"8. What does the explicit keyword do?", "Converts types automatically", "Prevents implicit conversions", "Declares public functions", "Declares abstract functions", "Prevents implicit conversions"},
        {"9. Which of the following is NOT true about virtual functions?", "They support runtime polymorphism", "They can be static", "They can be overridden in derived class", "They must be declared in base class", "They can be static"},
        {"10. What is the use of the mutable keyword in C++?", "Allows modification of const data members", "Declares constant variable", "Makes variable volatile", "Disables copy constructor", "Allows modification of const data members"},
        {"11. Which container allows fast insertions and deletions at both ends?", "vector", "deque", "stack", "list", "deque"},
        {"12. What does the following code snippet represent?\nstd::function<void(int)> f;", "Template", "Lambda", "Function pointer", "Function wrapper", "Function wrapper"},
        {"13. Which concept is used for resolving function call at runtime?", "Static binding", "Late binding", "Early binding", "Compile-time polymorphism", "Late binding"},
        {"14. Which C++11 feature provides automatic memory management?", "auto", "smart pointers", "threads", "virtual functions", "smart pointers"},
        {"15. Which of the following is true about std::map?", "Allows duplicate keys", "Keys are unordered", "Provides O(1) access", "Keys are sorted", "Keys are sorted"},
        {"16. Which operator cannot be overloaded?", "+", "[]", "::", "()", "::"},
        {"17. What is the default access specifier for class members?", "public", "private", "protected", "internal", "private"},
        {"18. Which of these is a shallow copy?", "Copies object recursively", "Copies pointers only", "Copies both data and pointers", "Uses copy constructor", "Copies pointers only"},
        {"19. What is the primary purpose of a virtual destructor?", "Allocate memory", "Avoid memory leak in inheritance", "Call static functions", "Prevent copy", "Avoid memory leak in inheritance"},
        {"20. What is decltype used for?", "Create pointer", "Determine type at runtime", "Determine type at compile time", "Copy object", "Determine type at compile time"}
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

        //mitBtn.setOnMouseEntered(e -> submitBtn.setStyle("-fx-background-color: #1a8be4; -fx-text-fill: white;"));
        //bmitBtn.setOnMouseExited(e -> submitBtn.setStyle("-fx-background-color: #2a9df4; -fx-text-fill: white;"));

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
