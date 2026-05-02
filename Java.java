package com.smartf;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Java  {

    VBox notesLayout;

   public Scene creatScene(Stage mainStage) {

        // Optional Icon + Title
        Label titleLabel = new Label("Complete Java Notes");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        titleLabel.setTextFill(Color.web("#2e86de"));

        // If you have a C++ icon image, uncomment the below:
        // ImageView icon = new ImageView(new Image("cpp_icon.png"));
        // icon.setFitHeight(40);
        // icon.setFitWidth(40);
        // HBox titleBox = new HBox(10, icon, titleLabel);

        // Notes Content
        String fullNotes = """
✅✅ 1. Java Basics 
➤ Java Features: 
• Platform Independent: Bytecode runs on JVM 
• Object-Oriented 
• Robust: Exception handling and garbage collection 
• Secure: No explicit pointer, bytecode verifier 
• Multithreaded, Distributed, Portable 

➤ Data Types: 
int a = 10;            
// 4 bytes 
float b = 20.5f;       // 4 bytes 
char c = 'A';          // 2 bytes 
boolean d = true;      // 1 bit 


➤ Type Casting: 
• Implicit: int → long 
• Explicit: double → int 


✅ 2. Object-Oriented Programming (OOPs) 
➤ Class & Object: 
class Car { 
int speed = 100; 
} 
public class Main { 
public static void main(String[] args) { 
Car obj = new Car(); // Object creation 
System.out.println(obj.speed); 
} 
} 


➤ Encapsulation: 
class Person { 
private String name; 
public void setName(String name) {  
this.name = name;  
} 
public String getName() { return name;  
} 
} 


➤ Inheritance: 
class Animal { 
void eat() { System.out.println("Eating"); } 
} 
class Dog extends Animal { 
void bark() { 
System.out.println("Barking");  
} 
} 


➤ Polymorphism: 
• Overloading (Compile Time): 
void display(int a) {} 
void display(String b) {} 
• Overriding (Run Time): 
class A { 
void show()  System.out.println("A"); } } 
class B extends A { 
void show() {  
System.out.println("B");  
}  
} 


➤ Abstraction: 
abstract class Shape { 
abstract void draw(); 
} 
class Circle extends Shape { 
void draw() { System.out.println("Drawing Circle"); } 
} 


➤ Interface: 
interface Animal { 
void sound(); 
} 
class Cat implements Animal { 
public void sound() { 
System.out.println("Meow");  
} 
} 


✅ 3. Exception Handling 
➤ Structure: 
java 
CopyEdit 
try { 
int a = 5/0; 
} catch (ArithmeticException e) { 
System.out.println("Cannot divide by zero"); 
} finally { 
System.out.println("Always executed"); 
} 


➤ Types: 
• Checked: IOException, SQLException 
• Unchecked: ArithmeticException, NullPointerException 


➤ Throw vs Throws: 
throw new ArithmeticException("Divided by 0"); 
void method() throws IOException {} 


✅ 4. Collections Framework 
➤ List: 
List<String> list = new ArrayList<>(); 
list.add("A"); 
list.add("B"); 


➤ Set: 
Set<Integer> set = new HashSet<>(); 
set.add(10);  
set.add(10); // No duplicates 

➤ Map: 
Map<String, Integer> map = new HashMap<>(); 
map.put("A", 1); map.put("B", 2); 

➤ Iterator: 
Iterator<String> it = list.iterator(); 
while(it.hasNext()) { 
System.out.println(it.next()); 
} 


✅ 5. String Handling 
➤ String vs StringBuilder vs StringBuffer 
Feature 
String StringBuilder StringBuffer 
Mutable 
Thread-Safe No 
No Yes 
No 
Yes 
Yes 
StringBuilder sb = new StringBuilder("Hello"); 
sb.append(" Java"); // Hello Java 


➤ Common Methods: 
• length() 
• charAt(i) 
•  substring() 
• toUpperCase()  
• replace() 
• split() 


✅ 6. Multithreading 
➤ By Extending Thread: 
class MyThread extends Thread { 
public void run() { 
System.out.println("Running..."); 
} 
} 
➤ By Implementing Runnable: 
class MyRunnable implements Runnable { 
public void run() { 
System.out.println("Runnable running..."); 
} 
} 


➤ Thread Methods: 
• start() 
•  sleep(ms) 
• join() 
• isAlive() 
• synchronized 


✅ 7. File Handling 
➤ Using File Class: 
File file = new File("data.txt"); 
if(file.exists()) 
System.out.println("File exists"); 
➤ Reading File: 
Scanner sc = new Scanner(new File("data.txt")); 
while(sc.hasNextLine()) { 
System.out.println(sc.nextLine()); 
} 
➤ Writing File: 
FileWriter writer = new FileWriter("output.txt"); 
writer.write("Hello World"); 
writer.close(); 


✅ 8. Java 8 Features 
➤ Lambda Expression: 
Runnable r = () -> System.out.println("Run"); 
➤ Stream API: 
List<Integer> list = Arrays.asList(1,2,3,4); 
list.stream().filter(x -> x%2==0).forEach(System.out::println); 
➤ Default & Static Methods in Interface: 
interface MyInterface { 
default void sayHi() { System.out.println("Hi"); } 
static void sayHello() { System.out.println("Hello"); } 
} 


✅ 9. Important Keywords 
Keyword 
this 
super 
final 
static 
Refers to current object 
Use 
Refers to parent class 
Constant / method not overridden / class not inherited 
Shared across all objects 
synchronized Thread-safe method 
Prevents serialization 
transient 
volatile 
Ensures visibility of changes in multithread 


✅ 10. Memory Management 
• Stack: Primitive types, method calls 
• Heap: Objects and instances 
• Method Area: Class structures 
• GC (Garbage Collector): Auto memory management 
System.gc(); // Suggests GC to run 


✅ 11. Frequently Asked Interview Questions 
Question 
Topic 
What is the difference between == and .equals()? Strings, Objects 
What is the JVM, JRE, and JDK? 
Java Fundamentals 
How does Java achieve platform independence? 
Difference between ArrayList and LinkedList? 
Explain abstraction and encapsulation 
What is a deadlock? 
How is HashMap internally implemented? 
Difference between throw and throws 
When to use interfaces over abstract classes? 
What are functional interfaces? 
JVM & Bytecode 
Collections 
OOPs 
Threads 
Collections 
Exceptions 
OOPs 
Java 8 
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