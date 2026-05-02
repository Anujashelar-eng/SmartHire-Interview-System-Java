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

public class PTC {

    public Scene creatScene(Stage mainStage,Runnable backAction) {
        mainStage.setTitle("PTC Technical Interview Questions");

        Label header = new Label(" PTC Technical Interview Questions");
        header.setFont(new Font("Arial", 20));
        header.setStyle("-fx-padding: 15; -fx-font-weight: bold; -fx-text-fill: #2a2a2a;");

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll(getPTCQuestions());
        listView.setStyle("-fx-font-size: 14; -fx-padding: 10;");

        Button backButton = new Button("⬅ Back");
        backButton.setStyle("-fx-font-size: 14; -fx-padding: 8 16; -fx-background-color: #7364e2; -fx-text-fill: white;");
        backButton.setOnAction(e->backAction.run());

        BorderPane root = new BorderPane();
        root.setTop(header);
        root.setCenter(listView);
        root.setBottom(backButton);
        BorderPane.setMargin(backButton, new Insets(10));
        root.setStyle("-fx-background-color: #f9f9f9;");

        Scene scene = new Scene(root, 800, 600);
        return scene;
    }

    private List<String> getPTCQuestions() {
        return List.of(
            "1. Tell me about yourself.",
            "2. What are the four pillars of OOP?",
            "3. Explain polymorphism with example.",
            "4. Difference between ArrayList and List.",
            "5. Difference between Set and List.",
            "6. Difference between static and dynamic binding.",
            "7. Difference between method overloading and overriding.",
            "8. Explain constructor overloading and chaining.",
            "9. Difference between interface and abstract class.",
            "10. Write code for binary search.",
            "11. Reverse a linked list.",
            "12. Detect a cycle in a linked list.",
            "13. Find middle element of a linked list.",
            "14. Common elements in three sorted arrays.",
            "15. Clone a linked list with random pointer.",
            "16. Implement a string class function (e.g. strlen).",
            "17. Implement a trie/dictionary for 1M words.",
            "18. Star-pattern logic/program.",
            "19. Bubble sort / descending sort.",
            "20. Explain lazy evaluation in Java Streams.",
            "21. Explain volatile variable in Java.",
            "22. Explain multithreading usage in Java.",
            "23. Write SQL queries like second highest salary.",
            "24. Explain normalization (1NF, 2NF, 3NF).",
            "25. Difference: DELETE vs DROP vs TRUNCATE.",
            "26. Indexing in SQL – clustered vs non-clustered.",
            "27. What is garbage collection in Java?",
            "28. Difference between JRE and JVM.",
            "29. Design singly linked list or clone graph.",
            "30. Explain design patterns – Singleton.",
            "31. What is threading? Where is it used?",
            "32. Explain Servlet & JSP lifecycle.",
            "33. How to load one webpage in another via JSP?",
            "34. Talk about your project in detail.",
            "35. Explain tools/frameworks used (e.g., Selenium).",
            "36. Financial puzzle: gain/loss percentages.",
            "37. Water jug puzzle (5L & 3L to measure 4L).",
            "38. Bells puzzle with 2, 3, 4‑min intervals over 2hrs.",
            "39. 10 sacks of coins puzzle.",
            "40. Difference between array and linked list.",
            "41. Difference between process and thread.",
            "42. What is context switching?",
            "43. Difference between TCP and UDP.",
            "44. Describe TCP 3-way handshake.",
            "45. Explain OSI model layers.",
            "46. What is deadlock? How to prevent it?",
            "47. Explain paging and segmentation.",
            "48. What is a foreign key constraint?",
            "49. Difference between primary key and unique key.",
            "50. Ask about workflows: Agile, CI/CD, Windchill QA."
        );
    }

   
}

