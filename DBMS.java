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

public class DBMS {

    VBox notesLayout;


    public Scene creatScene(Stage mainStage) {

        // Optional Icon + Title
        Label titleLabel = new Label("Complete Database management System Notes");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        titleLabel.setTextFill(Color.web("#2e86de"));

        // If you have a C++ icon image, uncomment the below:
        // ImageView icon = new ImageView(new Image("cpp_icon.png"));
        // icon.setFitHeight(40);
        // icon.setFitWidth(40);
        // HBox titleBox = new HBox(10, icon, titleLabel);

        // Notes Content
        String fullNotes = """
✅ 
  1. Introduction to DBMS 
• Database: A collection of related data. 
• DBMS (Database Management System): Software that allows users to store, 
retrieve, and manage data efficiently. 
✅ Advantages of DBMS: 
• Reduces redundancy 
• Ensures data consistency 
• Provides security and backup 
• Supports multiple user access (concurrency) 
 
  Example: 
A library DBMS maintains tables like Books, Members, IssueRecords etc. 


  2. DBMS Architecture 
• 1-Tier: Direct access to database. 
• 2-Tier: Application communicates with DB. 
• 3-Tier: 
o Presentation Layer (UI) 
o Logic Layer (Application) 
o Data Layer (Database) 


  Example: 
Web app like Flipkart – frontend (UI) → backend (logic) → database. 


  3. Data Models 
• Relational Model: Uses tables (most common). 
• Hierarchical Model: Tree-like structure. 
• Network Model: Complex parent-child relationships. 
• Object-Oriented Model: Data stored as objects. 


  4. Keys in DBMS 
• Primary Key: Unique and not null 
• Foreign Key: Links two tables 
• Candidate Key: Can be primary key 
• Composite Key: Combination of columns 


  Example: 
CREATE TABLE Student ( 
RollNo INT PRIMARY KEY, 
Name VARCHAR(50), 
DeptID INT, 
FOREIGN KEY (DeptID) REFERENCES Department(DeptID) 
); 


  5. Normalization 
Goals: 
• Eliminate redundancy 
• Ensure data integrity 
Normal Form 
1NF 
Rule 
Atomic columns 
2NF 
3NF 
BCNF 


  Example: 
Split table: 
text 
No partial dependency 
No transitive dependency 
Every determinant is a candidate key 
Student(Roll, Name, DeptName, DeptLoc) 
→ Student(Roll, Name, DeptID) 
→ Department(DeptID, DeptName, DeptLoc) 



  6.  Basics 
✅ DDL (Data Definition Language) 
CREATE TABLE Student(ID INT, Name VARCHAR(100)); 
ALTER TABLE Student ADD Marks INT; 
DROP TABLE Student; 
✅ DML (Data Manipulation Language) 
INSERT INTO Student VALUES (1, 'Akash'); 
UPDATE Student SET Name = 'Anu' WHERE ID = 1; 
DELETE FROM Student WHERE ID = 1; 
✅ TCL (Transaction Control Language) 
BEGIN; 
UPDATE Account SET Balance = Balance - 1000 WHERE ID = 1; 
COMMIT; 


  7. Joins in  
Join Type 
Description 
INNER JOIN Common records 
LEFT JOIN All from left, matched from right 
RIGHT JOIN All from right, matched from left 
FULL JOIN All records with NULLs where no match 


  Example: 
SELECT S.Name, D.DeptName 
FROM Student S 
INNER JOIN Department D ON S.DeptID = D.DeptID; 


  8. Transactions & ACID Properties 
• Atomicity: All or none 
• Consistency: Valid state transitions 
• Isolation: Concurrent transactions don’t conflict 
• Durability: Once committed, changes persist 


  9. Concurrency Control 
Problems: 
• Dirty reads 
• Lost updates 
• Phantom reads 
Solutions: 
• Locks (Shared/Exclusive) 
• 2PL (Two-Phase Locking) 
• Timestamps 


  10. ER Model 
Components: 
• Entity: Object (e.g., Student) 
• Attribute: Property (e.g., Name) 
• Relationship: Association (e.g., Enrolls) 


  Example: 
• Student(StudentID, Name) 
• Course(CourseID, Title) 
• Enrolls(StudentID, CourseID) 


  11. Stored Procedures & Triggers 
✅ Stored Procedure 
CREATE PROCEDURE GetTopStudents() 
BEGIN 
SELECT * FROM Student WHERE Marks > 90; 
END; 
✅ Trigger 
CREATE TRIGGER log_delete 
BEFORE DELETE ON Student 
FOR EACH ROW 
INSERT INTO DeletedLog VALUES (OLD.ID, NOW()); 



  12. Views 
• Virtual table created from query 
 
  Example: 
CREATE VIEW TopScorers AS 
SELECT Name, Marks FROM Student WHERE Marks > 90; 


  13. Indexing 
• Improves search performance 
• Types: Single-column, Composite, Unique 
 
  Example: 
CREATE INDEX idx_name ON Student(Name); 



  14. No vs  
Feature  
Schema Fixed 
Structure Tables 
Examples My, Oracle 
No 
Flexible 
Key-Value, JSON 
MongoDB, Cassandra 
ACID Fully supported Eventually consistent 


  15. Important Interview  Queries 
1. 2nd Highest Salary: 
SELECT MAX(Salary) 
FROM Employee 
WHERE Salary < (SELECT MAX(Salary) FROM Employee); 
2. Duplicate Records: 
SELECT Name, COUNT(*) 
FROM Student 
GROUP BY Name 
HAVING COUNT(*) > 1; 
3. Nth Highest Salary (Using LIMIT): 
SELECT DISTINCT Salary 
FROM Employee 
ORDER BY Salary DESC 
LIMIT 1 OFFSET 2; -- for 3rd highest 
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

        downloadBtn.setOnAction(e -> printToPDF());
        backButton.setOnAction(e -> {
            Fundamentals fundamentalsPage = new Fundamentals();
            Scene fundamentalsScene = fundamentalsPage.createScene(mainStage);
            mainStage.setScene(fundamentalsScene);
        });

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