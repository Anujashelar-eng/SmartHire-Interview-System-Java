package com.smartf;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Verbal {

    VBox notesLayout;

    public Scene createScene(Stage mainStage) {

        Label titleLabel = new Label("Complete Verbal Notes");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        titleLabel.setTextFill(Color.web("#2e86de"));

        String fullNotes = """
✅✅ Verbal Ability Notes for Placement Preparation 
(Your notes content remains the same) Verbal Ability Notes for Placement Preparation 
1. VOCABULARY BUILDING 
* Synonyms (Similar meaning): 
o Abundant → Plentiful 
o Benevolent → Kind 
o Candid → Honest 
o Diligent → Hardworking 
* Antonyms (Opposite meaning): 
o Generous → Stingy 
o Ancient → Modern 
o Frequent → Rare 
o Harsh → Gentle 
* Tips: 
o Use flashcards 
o Learn word families (root words, prefixes, suffixes) 

2. READING COMPREHENSION (RC) 
* Includes: 
o Factual questions 
o Inference-based questions 
o Vocabulary in context 
o Central idea or tone 
* Tips: 
o Skim the passage first 
o Read questions before reading passage (if allowed) 
o Eliminate wrong options 

3. GRAMMAR & SENTENCE CORRECTION 
* Subject-Verb Agreement: 
o She writes poems (Correct) 
o They write poems (Correct) 
* Tenses: 
o Present Simple: He goes 
o Past Simple: He went 
o Present Perfect: He has gone 
o Future: He will go 
* Articles: 
o Use “a” before consonant sounds: a university 
o Use “an” before vowel sounds: an apple 
* Prepositions: 
o Common: in, on, at, under, over 
o Example: She is good at singing 
* Common Errors: 
o Incorrect: He don’t know 
o Correct: He doesn’t know 


4. FILL IN THE BLANKS / SENTENCE COMPLETION 
* Choose based on context and grammar 
* Example: 
o She was very __ after the breakup. 
o (a) delighted (b) devastated (c) grateful (d) strong 
o ✅ Answer: (b) devastated 


5. PARA JUMBLES (Sentence Rearrangement) 
* Strategy: 
o Identify the introductory sentence 
o Use link words (then, because, however) 
o Maintain logical order 
* Example: 
o A. He went to the shop 
o B. He was hungry 
o C. He bought snacks 
o D. Then he returned home 
o ✅ Order: B-A-C-D 


6. ERROR SPOTTING 
* Example: 
o Incorrect: The team are going to win 
o Correct: The team is going to win 
* Focus Areas: 
o Tenses 
o Subject-verb agreement 
o Articles and prepositions 
o Pronouns 


7. IDIOMS AND PHRASES 
* Break the ice → Start conversation 
* Spill the beans → Reveal a secret 
* A blessing in disguise → Hidden advantage 
* Under the weather → Feeling sick 
* Once in a blue moon → Very rarely 


8. ONE WORD SUBSTITUTION 
* Lover of books → Bibliophile 
* One who knows everything → Omniscient 
* Study of human mind → Psychology 
* One who talks too much → Loquacious 
* One who is everywhere → Omnipresent 


9. ACTIVE AND PASSIVE VOICE 
* Active: Subject does the action 
o She writes a letter. 
* Passive: Subject receives the action 
o A letter is written by her. 


10. DIRECT AND INDIRECT SPEECH 
* Direct: He said, “I am tired.” 
* Indirect: He said that he was tired. 
Rules: 
* Change tense: present → past 
* Remove quotes 
* Adjust pronouns and time markers 


11. COMMON TOPIC-WISE WEIGHTAGE (TCS, INFOSYS, WIPRO) 
Topic 
Questions 
Reading Comprehension 2-3 
""";

        TextArea notesArea = new TextArea(fullNotes);
        notesArea.setWrapText(true);
        notesArea.setEditable(false);
        notesArea.setFont(Font.font("Consolas", 14));
        notesArea.setStyle("""
            -fx-control-inner-background: #fefefe;
            -fx-font-family: 'Consolas';
            -fx-font-size: 14px;
            -fx-text-fill: black;
            -fx-border-color: lightgray;
            -fx-border-radius: 5;
            -fx-focus-color: transparent;
        """);

        ScrollPane scrollPane = new ScrollPane(notesArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setPrefViewportHeight(600);

        // Buttons
        Button downloadBtn = new Button("Download PDF");
        Button backButton = new Button("← Back");

        String buttonStyle = """
            -fx-background-color: #2ecc71;
            -fx-text-fill: white;
            -fx-font-size: 14px;
            -fx-padding: 8 16 8 16;
            -fx-background-radius: 6;
        """;

        downloadBtn.setStyle(buttonStyle);
        backButton.setStyle(buttonStyle.replace("#2ecc71", "#e74c3c"));

        downloadBtn.setOnMouseEntered(e -> downloadBtn.setStyle(buttonStyle.replace("#2ecc71", "#27ae60")));
        downloadBtn.setOnMouseExited(e -> downloadBtn.setStyle(buttonStyle));

        backButton.setOnMouseEntered(e -> backButton.setStyle(buttonStyle.replace("#2ecc71", "#c0392b")));
        backButton.setOnMouseExited(e -> backButton.setStyle(buttonStyle.replace("#2ecc71", "#e74c3c")));

        // ✅ Working back button logic:
        backButton.setOnAction(e -> {
            Aptitude aptitudePage = new Aptitude();
            Scene aptitudeScene = aptitudePage.createScene(mainStage);
            mainStage.setScene(aptitudeScene);
        });

        downloadBtn.setOnAction(e -> printToPDF());

        HBox buttonRow = new HBox(20, downloadBtn, backButton);
        buttonRow.setAlignment(Pos.CENTER);

        notesLayout = new VBox(20, titleLabel, scrollPane, buttonRow);
        notesLayout.setAlignment(Pos.TOP_CENTER);
        notesLayout.setPadding(new Insets(20));
        notesLayout.setMaxWidth(1000);
        notesLayout.setStyle("""
            -fx-background-color: white;
            -fx-border-color: #dcdde1;
            -fx-border-width: 1px;
            -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 8, 0, 0, 4);
            -fx-background-radius: 10;
            -fx-border-radius: 10;
        """);

        VBox root = new VBox(notesLayout);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f0f0f0;");

        return new Scene(root, 1000, 820);
    }

    public void printToPDF() {
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null && job.showPrintDialog(null)) {
            boolean success = job.printPage(notesLayout);
            if (success) {
                job.endJob();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "PDF Saved Successfully!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to save PDF.");
                alert.showAndWait();
            }
        }
    }
}


