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

public class Cognizant{

    public Scene creatScene(Stage mainStage,Runnable backAction){
        mainStage.setTitle("Cognizant Technical Questions");

        Label header = new Label(" Cognizant Technical Interview Questions");
        header.setFont(new Font("Arial", 20));
        header.setStyle("-fx-padding: 15; -fx-font-weight: bold; -fx-text-fill: #2a2a2a;");

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll(getQuestions());
        listView.setStyle("-fx-font-size: 14; -fx-padding: 10;");

        // Back button
        Button backButton = new Button("⬅ Back");
        backButton.setStyle("-fx-font-size: 14; -fx-padding: 8 16; -fx-background-color: #7364e2ff;");
        backButton.setOnAction(e->backAction.run());

        // Layout setup
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
            "1. What are the storage specifiers in C?",
            "2. Explain pointers and dangling pointers in C.",
            "3. Describe memory leaks and garbage collection.",
            "4. What is the difference between interpreter and compiler?",
            "5. Define data types in Java and explain int vs Integer.",
            "6. What is an array? Discuss common operations.",
            "7. Four pillars of OOP: encapsulation, inheritance, polymorphism, abstraction.",
            "8. Difference between object-oriented and object-based programming.",
            "9. What is a class? Explain access modifiers.",
            "10. Explain constructor, constructor overloading vs overriding.",
            "11. What are virtual functions?",
            "12. What are static vs dynamic binding?",
            "13. Implement Bubble Sort.",
            "14. Implement Binary Search.",
            "15. Implement Merge Sort.",
            "16. Fibonacci series (both iterative and recursive).",
            "17. Reverse a string or number.",
            "18. Find largest/smallest or second-largest in array.",
            "19. Find missing number in array.",
            "20. Palindromic array or count zeros.",
            "21. Stack vs queue; implement stack using array.",
            "22. Explain and implement linked list reversal.",
            "23. What is a binary tree? Implement DFS.",
            "24. What is graph and difference from tree.",
            "25. What is dynamic programming?",
            "26. Difference between process and thread.",
            "27. Purpose and benefits of multithreading.",
            "28. What is preemptive multitasking?",
            "29. Explain DDL vs DML.",
            "30. What is indexing (primary, secondary, clustered)?",
            "31. Types of SQL joins (inner, outer, etc.).",
            "32. Write SQL queries (e.g., find duplicates, max salary).",
            "33. What is normalization?",
            "34. What is SDLC? Explain models (Waterfall, Agile, etc).",
            "35. Explain MVC architecture and REST APIs.",
            "36. Why are macros faster than functions in C?",
            "37. Explain exception handling; try-catch blocks.",
            "38. Explain difference between object and class instantiation.",
            "39. Explain Java closures and string builder functions.",
            "40. What is REST API, and how does it work?",
            "41. Explain stages of machine learning model development.",
            "42. What are different regularization techniques?",
            "43. What is Poisson distribution?",
            "44. Explain formula for gradient descent.",
            "45. Explain PCA (Principal Component Analysis).",
            "46. Describe a clustering algorithm (e.g., K-Means).",
            "47. ReactJS: component lifecycle, hooks, props vs state.",
            "48. Walk me through your project: challenges, solutions.",
            "49. How would you explain a technical concept to non-technical person?",
            "50. How do you ensure your code is maintainable and scalable?"
        );
    }

   
}

