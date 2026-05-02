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

public class Logical {

    VBox notesLayout;

    
    public Scene createScene(Stage mainStage) {

        // Optional Icon + Title
        Label titleLabel = new Label("Complete Logical Reasoning Notes");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        titleLabel.setTextFill(Color.web("#2e86de"));

        // If you have a C++ icon image, uncomment the below:
        // ImageView icon = new ImageView(new Image("cpp_icon.png"));
        // icon.setFitHeight(40);
        // icon.setFitWidth(40);
        // HBox titleBox = new HBox(10, icon, titleLabel);

        // Notes Content
        String fullNotes = """
✅✅  
  Logical Reasoning Notes for Placements 
 
  1. Introduction 
Logical Reasoning (LR) tests your ability to analyze patterns, deduce conclusions, and solve 
problems logically. It’s a key section in placement tests like TCS NQT, Wipro, Infosys, 
Capgemini, etc. 


  2. Topics Covered 
✅ 1. Number Series 
• Concept: Find the next number in a logical sequence. 
• Types: 
o Arithmetic (e.g., +2, +4, +6) 
o Geometric (×2, ÷2) 
o Alternating series 
• Example: 
2, 4, 8, 16, ? 
Ans: 32 (×2 pattern) 
✅ 2. Letter Series / Alphabet Test 
• Concept: Identify patterns in letters. 
• Example: 
AZ, BY, CX, ? 
Ans: DW (reverse letters of alphabet) 


✅ 3. Coding-Decoding 
• Concept: Letters or numbers coded using rules. 
• Types: 
o Letter shifting 
o Number substitution 
• Example: 
If CAT = DBU, then DOG = ? 
Rule: each letter +1 
Ans: EPH 


✅ 4. Blood Relations 
• Concept: Determine family relationships. 
• Tips: 
o Use family tree diagrams 
• Example: 
A is the brother of B. B is the sister of C. How is A related to C? 
Ans: Brother 


✅ 5. Directions and Distances 
• Concept: Track movement and final direction. 
• Tips: 
o Draw the path on paper 
• Example: 
A walks 10 m North, turns right and walks 10 m, then right again. Which direction is 
he facing? 
Ans: South 


✅ 6. Syllogisms 
• Concept: Deduce logical conclusions from statements. 
• Example: 
Statements: 
All dogs are animals. All animals are mammals. 
Conclusion: All dogs are mammals → True 


✅ 7. Seating Arrangement 
• Concept: Linear or circular arrangement problems. 
• Types: 
o Circular arrangement 
o Linear arrangement 
• Tips: Note left/right orientation carefully. 
• Example: 
5 people sitting in a circle facing center. Who is on the left of A? 


✅ 8. Puzzles 
• Concept: Logic-based problem-solving using clues. 
• Types: 
o Floor puzzles 
o Scheduling 
• Tip: Create a table or grid to track clues. 
• Example: 
5 people live on different floors. A lives above B, but below C. Who lives on top? 


✅ 9. Statement & Assumption / Conclusion 
• Concept: Understand what's logically implied or assumed. 
• Tips: 
o Don’t use outside knowledge 
• Example: 
Statement: All students passed the exam. 
Conclusion: Some students are brilliant. 
Ans: Can’t be concluded. 


✅ 10. Data Sufficiency 
• Concept: Check if given data is enough to answer a question. 
• Tip: Don’t solve; just check sufficiency. 
 
 
 ️ 3. Tips to Solve Logical Reasoning Quickly 
• Draw diagrams and flowcharts where needed. 
• Practice frequently to improve speed. 
• Read carefully – wording is key. 
• Use elimination to reduce options. 
• Time yourself for speed + accuracy. 
 

  4. Practice Resources 
• Books: 
o RS Aggarwal – Logical Reasoning 
o Arun Sharma – Logical Reasoning for CAT 
• Online Platforms: 
o IndiaBix 
o PrepInsta 
o GeeksforGeeks (Aptitude section) 
More Practice Questions:- 


1. Number Series 
Q1. What comes next in the series: 
3, 6, 11, 18, 27, ? 
A. 36  
B. 38  
C. 40  
D. 43 

  Ans: A. 38 

Explanation: Differences: +3, +5, +7, +9, +11 
Q2. Find the next number in the series: 
120, 60, 30, 15, ? 
A. 5  
B. 10  
C. 7.5  
D. 12 
 

  Ans: C. 7.5 
Explanation: Each number ÷2 


  2. Letter Series / Alphabet Test 
Q3. What comes next: 
D, F, I, M, R, ? 
A. V  
B. W  C. X  D. Y 
 
  Ans: C. X 
Explanation: +2, +3, +4, +5, +6 

Q4. Find the odd one out: 
ACE, BDF, GIK, MNO, MOQ 
 
  Ans: MNO 
Explanation: All others have alternate letters; MNO is continuous.


 
  3. Coding-Decoding 
Q5. If DOME is written as FQOG, how is TIME written? 
A. UKNG  B. VJOG  C. UKOG  D. UJOG 
 
  Ans: C. UKOG 
Explanation: +2 to each letter 


Q6. In a certain code, TRUTH is written as SUQSG, how is FALSE written? 
A. EZKRD  
B. EBKRD  
 
  Ans: B. EBKRD 
Explanation: Each letter -1 
C. EBKQD  
D. EZJQD 
👨 ‍👩
   

4. Blood Relations 
Q7. A is the father of B. C is the daughter of A. D is the brother of A. E is the son of D. How 
is E related to C? 
A. Cousin  
B. Brother  
 
C. Uncle  
D. Nephew 
  Ans: A. Cousin 
Q8. Pointing to a woman, Rohan says, “She is the only daughter of my father’s wife.” Who is 
the woman? 
 
  Ans: Sister 
 
  5. Direction Sense 
Q9. A man walks 20 m north, then turns right and walks 10 m, then turns right again and 
walks 20 m. What direction is he facing now? 
A. North  
B. East  
 
  Ans: C. South 
C. South  
D. West 
Q10. Ravi walks 10 m east, then turns left and walks 5 m, then left again and walks 10 m. 
How far is he from the starting point? 
 
  Ans: 5 m 
 
  6. Seating Arrangement 
Q11. 6 people A, B, C, D, E, F are sitting in a row. B is to the left of D but right of A. E is to 
the right of D. Who is in the middle? 
 
  Ans: D 
 
  7. Syllogisms 
Q12. Statements: 
1. All roses are flowers. 
2. Some flowers fade quickly. 
Conclusions: 
I. Some roses fade quickly. 
II. All flowers are roses. 
 
  Ans: Neither I nor II follows 
 
  8. Puzzle 
Q13. Five friends A, B, C, D, and E are sitting in a row. C is to the right of D but to the left 
of A. B is at the right end. Who is in the middle? 
 
  Ans: C 
❓ 9. Statement & Assumption 
Q14. Statement: 
“Children below 15 years of age should not be allowed to watch TV.” 
Assumption: 
I. Children below 15 are not mature. 
II. TV content may affect them. 
 
  Ans: Only II is implicit 
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
        backButton.setOnAction(e -> {
        Aptitude aptitudePage = new Aptitude();
        Scene aptitudeScene = aptitudePage.createScene(mainStage);
        mainStage.setScene(aptitudeScene);
        });


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

        downloadBtn.setOnAction(e -> printToPDF());
       
        HBox buttonRow = new HBox(20, downloadBtn, backButton);
        buttonRow.setAlignment(Pos.CENTER);

        // Notes Layout with shadow effect
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

        // Root Layout
        VBox root = new VBox(notesLayout);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f0f0f0;");

        Scene scene = new Scene(root, 1000, 820);
        return scene;
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