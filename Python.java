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

public class Python  {

    VBox notesLayout;

    
    public Scene creatScene(Stage mainStage) {

        // Optional Icon + Title
        Label titleLabel = new Label("Complete Python  Notes");
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
 
  1. Basics of Python 
• Comments: # Single-line and ''' Multi-line ''' 
• Variables: No need to declare type. 
x = 10 
name = "Akanksha" 
• Data Types: 
o int, float, str, bool 
o type checking: type(x) 
• Type Casting: 
int('5')     
str(5)       
float(5)     
# 5 
# '5' 
# 5.0 
 


  2. Control Structures 
✅ Conditional Statements: 
if a > b: 
print("A is greater") 
elif a == b: 
print("Equal") 
else: 
print("B is greater") 
 
  Loops: 
• for loop: 
for i in range(5):  # 0 to 4 
print(i) 
• while loop: 
while x < 10: 
print(x) 
x += 1 
• break, continue, pass 



  3. Data Structures 
✅ Lists 
fruits = ['apple', 'banana'] 
fruits.append('mango') 
fruits[1] = 'orange' 
• Slicing: fruits[1:3], fruits[::-1] 
✅ Tuples 
t = (1, 2, 3)  # Immutable 
✅ Sets 
s = {1, 2, 3, 3} 
s.add(4) 
✅ Dictionary 
person = {"name": "Alice", "age": 22} 
print(person["name"]) 



  4. Functions 
def greet(name): 
return f"Hello {name}" 
print(greet("Akanksha")) 
• Lambda Function: 
square = lambda x: x * x 
• Default / Keyword / Variable Args: 
def add(x=1, y=2): return x + y 
def args(*a): print(a) 
def kwargs(**k): print(k) 



  5. Object-Oriented Programming 
class Student: 
def __init__(self, name): 
self.name = name 
def greet(self): 
print(f"Hi, I am {self.name}") 
s1 = Student("Akanksha") 
s1.greet() 
• Inheritance: 
class A: pass 
class B(A): pass 
• Encapsulation: Use _protected or __private 


  6. Exception Handling 
try: 
x = 10 / 0 
except ZeroDivisionError: 
print("Can't divide by zero") 
finally: 
print("Done") 


  7. Important Built-in Functions 
• len() 
•  type() 
•  range() 
•  enumerate() 
• zip() sorted() 


  8. Modules and Packages 
python 
import math 
print(math.sqrt(25)) 
• Create module: myfile.py → import myfile 


  9. File Handling 
python 
with open("file.txt", "r") as f: 
content = f.read() 
with open("file.txt", "w") as f: 
f.write("Hello") 


  10. Important Python Libraries 
• NumPy – For numerical operations 
• Pandas – For data analysis 
• Matplotlib – For plotting 
• Requests – For HTTP requests 
• Tkinter / PyQt – GUI 


  11. Common Placement Questions 
Topic 
String 
Array 
Example 
Palindrome, Anagram, Reverse 
Max Sum Subarray (Kadane's), Sort, Search 
Recursion Factorial, Fibonacci 
OOPs 
Create class with methods 
File 
Count words, lines 
Linked List Custom implementation using class 



  12. Tips for Interviews 
• Write clean code. 
• Know time and space complexity. 
• Practice with LeetCode, HackerRank, GFG. 
• Understand real-world applications.  
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
            programming programmingPage = new programming();
            Scene programmingScene = programmingPage.creatScene(mainStage);
            mainStage.setScene(programmingScene);
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
