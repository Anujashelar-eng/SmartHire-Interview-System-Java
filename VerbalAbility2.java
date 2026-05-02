package com.smartf;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

public class VerbalAbility2 {

    private final String[][] questions = {
        {"1. What does the author most likely mean by \"cognitive dissonance\"?", "Emotional confusion", "Inconsistency between belief and behavior causing discomfort", "Lack of proper information", "Difficulty in language", "Inconsistency between belief and behavior causing discomfort"},
        {"2. Choose the best version: Despite the committee’s decision was unpopular, it was enforced strictly.", "Despite the committee’s decision was unpopular", "Despite that the committee’s decision was unpopular", "Although the committee’s decision was unpopular", "Even though the committee decision unpopular", "Although the committee’s decision was unpopular"},
        {"3. The word 'abstruse' most nearly means:", "Clear", "Complicated", "Irrelevant", "Humorous", "Complicated"},
        {"4. All hackers are intelligent. Some hackers are not ethical. Therefore:", "Some intelligent people are not ethical", "All intelligent people are hackers", "Some intelligent people are ethical", "Nothing can be definitively concluded", "Nothing can be definitively concluded"},
        {"5. Rearrange: P. First observed in the 1960s Q. Watched people act differently R. Known as Hawthorne effect S. Impacts research & ethics", "QPRA", "QPRC", "PQRS", "QPRS", "PQRS"},
        {"6. Although the professor was brilliant, his lectures were often so ______ students stayed sleepy.", "enthralling", "soporific", "engaging", "illuminating", "soporific"},
        {"7. What undermines that remote work increases productivity?", "Remote workers save commute time", "High remote worker satisfaction", "Managers can’t monitor output", "Tech companies hire remote", "Managers can’t monitor output"},
        {"8. What is the main point of the passage: AI lacks true understanding?", "AI has surpassed humans", "AI models understand language fully", "AI lacks consciousness", "AI is philosophical", "AI lacks consciousness"},
        {"9. The team of engineers, each with their own set of skills, __ crucial to success.", "were", "was", "have been", "being", "was"},
        {"10. The CEO gave a **trenchant** critique of the strategy.", "vague", "sharp", "outdated", "dull", "sharp"},
        {"11. Identify the odd sentence: Quantum computing, quantum bits, classical problem solving, spam detection", "Quantum computing", "Quantum bits", "Classical computing", "Spam detection", "Spam detection"},
        {"12. If all leaders are readers, and all readers are thinkers, then:", "All leaders are thinkers", "All thinkers are leaders", "Some thinkers are not readers", "Readers are not leaders", "All leaders are thinkers"},
        {"13. The manager, in addition to his assistants, __ the job is done.", "ensure", "ensures", "have ensured", "were ensuring", "ensures"},
        {"14. Series: Q. Inflation has fallen. S. Optimism rose. P. Market unstable. R. Prices erratic. Order?", "QSPR", "PQRS", "QSRP", "SRPQ", "QSPR"},
        {"15. Tone: The politician dodged questions, gave platitudes, evaded tough topics.", "Sympathetic", "Critical", "Objective", "Humorous", "Critical"},
        {"16. EPHEMERAL : PERMANENT :: ?", "Fragile : Delicate", "Transient : Brief", "Fluctuate : Steady", "Loud : Boisterous", "Fluctuate : Steady"},
        {"17. The scientist's theory gained ______ after confirmation.", "obsolescence", "traction", "anonymity", "obscurity", "traction"},
        {"18. Markets react to narratives; perception often outweighs data. Implication?", "Data always helps", "Perception drives market more", "Markets only rely on data", "Reality dominates", "Perception drives market more"},
        {"19. Which is correct?", "He don’t know", "Neither options are", "Each of the answers is", "There’s many reasons", "Each of the answers is"},
        {"20. Opposite of magnanimous?", "Generous", "Vindictive", "Forgiving", "Noble", "Vindictive"}
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
        

        HBox mainLayout = new HBox(15,scrollPane, statusContainer);
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
