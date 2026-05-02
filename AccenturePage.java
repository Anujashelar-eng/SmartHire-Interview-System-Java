package com.smartf;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class AccenturePage {

   public Scene creatScene(Stage mainStage,Runnable backAction){
        mainStage.setTitle("Accenture Technical Interview Questions");

        Label header = new Label("Accenture Technical Interview Questions");
        header.setFont(new Font("Arial", 20));
        header.setStyle("-fx-padding: 15; -fx-font-weight: bold; -fx-text-fill: #2a2a2a;");

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll(getQuestions());
        listView.setStyle("-fx-font-size: 14; -fx-padding: 10;");

        Button backButton = new Button("⬅ Back");
        backButton.setStyle("-fx-font-size: 14; -fx-padding: 8 16; -fx-background-color: #7364e2;");
        backButton.setOnAction(e -> {
            backAction.run();
        });

        BorderPane root = new BorderPane();
        root.setTop(header);
        root.setCenter(listView);
        root.setBottom(backButton);
        BorderPane.setMargin(backButton, new Insets(10));
        root.setStyle("-fx-background-color: #f9f9f9;");

        Scene scene = new Scene(root, 800, 600);
        return scene;
    }

    private List<String> getQuestions() {
        return List.of(
            "1. What is the difference between C and C++?",
            "2. Explain the difference between Java and Python.",
            "3. What are arrays and how are they different from linked lists?",
            "4. What is a stack and how is it used?",
            "5. Implement a queue using two stacks.",
            "6. What is a linked list? Types?",
            "7. Write a program to reverse a string.",
            "8. Explain recursion with an example.",
            "9. What is the difference between call by value and call by reference?",
            "10. Write a program to check for a palindrome string.",
            "11. What is the time complexity of binary search?",
            "12. Explain bubble sort with its complexity.",
            "13. Write a program for factorial (recursively and iteratively).",
            "14. What is dynamic programming? Give an example.",
            "15. Explain backtracking with an example.",
            "16. Difference between BFS and DFS.",
            "17. Write code for finding GCD of two numbers.",
            "18. Solve the Fibonacci problem using memoization.",
            "19. What are the four pillars of Object-Oriented Programming?",
            "20. Difference between class and object.",
            "21. What is inheritance? Types of inheritance?",
            "22. What is polymorphism? Compile time vs run time?",
            "23. Difference between abstraction and encapsulation.",
            "24. What are constructors? Types of constructors?",
            "25. What is method overloading and overriding?",
            "26. Difference between interface and abstract class.",
            "27. What is the use of super and this keyword in Java?",
            "28. Difference between SQL and NoSQL.",
            "29. What is normalization? Explain 1NF, 2NF, 3NF.",
            "30. Write a query to fetch the second highest salary.",
            "31. Difference between WHERE and HAVING clause.",
            "32. What are joins? Types of joins?",
            "33. What is a primary key and a foreign key?",
            "34. Explain indexing in SQL.",
            "35. What are triggers and stored procedures?",
            "36. What is process and thread? Difference?",
            "37. What is deadlock? How to avoid it?",
            "38. Explain memory management in OS.",
            "39. Difference between TCP and UDP.",
            "40. What is the OSI model?",
            "41. Explain context switching.",
            "42. What is REST API?",
            "43. Difference between GET and POST request.",
            "44. What is MVC architecture?",
            "45. Difference between HTML and XML.",
            "46. What is JavaScript and how is it different from Java?",
            "47. What is unit testing? Tools used?",
            "48. Explain SDLC and STLC.",
            "49. What are Agile and Scrum methodologies?",
            "50. Explain a project you worked on and the technologies used. What challenges did you face?"
        );
    }

   
}

