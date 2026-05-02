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

public class Google {

   
    public Scene creatScene(Stage mainStage,Runnable backAction) {
        mainStage.setTitle("Google Interview Questions");

        // Header
        Label header = new Label(" Google Technical Interview Questions");
        header.setFont(new Font("Arial", 20));
        header.setStyle("-fx-padding: 15; -fx-font-weight: bold; -fx-text-fill: #2a2a2a;");

        // ListView for questions
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll(getGoogleQuestions());
        listView.setStyle("-fx-font-size: 14; -fx-padding: 10;");

        // Back Button
        Button backButton = new Button("⬅ Back");
        backButton.setStyle("-fx-font-size: 14; -fx-padding: 8 16; -fx-background-color: #7364e2; -fx-text-fill: white;");
        backButton.setOnAction(e -> {
           backAction.run();
        });

        // Layout
        BorderPane root = new BorderPane();
        root.setTop(header);
        root.setCenter(listView);
        root.setBottom(backButton);
        BorderPane.setMargin(backButton, new Insets(10));
        root.setStyle("-fx-background-color: #f9f9f9;");

        // Scene
        Scene scene = new Scene(root, 800, 600);
        return scene;
    }

    private List<String> getGoogleQuestions() {
        return List.of(
            "1. Implement LRU Cache.",
            "2. Detect cycle in a directed graph.",
            "3. Merge K sorted linked lists.",
            "4. Serialize and deserialize a binary tree.",
            "5. Find the median of two sorted arrays.",
            "6. Longest substring without repeating characters.",
            "7. Top K frequent elements in an array.",
            "8. Kth largest element in a stream.",
            "9. Word Ladder (Shortest transformation sequence).",
            "10. Trapping Rain Water problem.",
            "11. Implement regular expression matching.",
            "12. N-Queens problem.",
            "13. Longest palindromic substring.",
            "14. Minimum window substring.",
            "15. Generate all valid parentheses.",
            "16. Clone a graph.",
            "17. Implement Trie (Prefix Tree).",
            "18. Course schedule (Topological sort).",
            "19. Minimum spanning tree.",
            "20. Dijkstra's shortest path algorithm.",
            "21. Design YouTube or Netflix backend.",
            "22. Design Google Search autocomplete.",
            "23. Design a scalable URL shortener.",
            "24. Design WhatsApp backend.",
            "25. Design Google Maps routing system.",
            "26. Design a distributed cache system.",
            "27. Design Google Drive architecture.",
            "28. Design Uber backend system.",
            "29. Design Twitter feed system.",
            "30. Design API rate limiter.",
            "31. 8 balls: find heavier with 2 weighs.",
            "32. 100 doors problem: which are open?",
            "33. Goat, wolf, cabbage river crossing puzzle.",
            "34. 3 switches and 3 bulbs puzzle.",
            "35. Measure exactly 4 liters (jug problem).",
            "36. Measure 45 min with 2 60-min ropes.",
            "37. Angle between hour and minute at 3:15?",
            "38. 25 horses: find top 3 in minimum races.",
            "39. Bridge crossing in minimum time.",
            "40. Minimum weighs to find counterfeit coin.",
            "41. What happens when you enter a URL?",
            "42. How does DNS work?",
            "43. Explain deadlock and how to avoid it.",
            "44. Process vs thread?",
            "45. What are indexes in DB?",
            "46. Normalization in DBMS.",
            "47. TCP 3-way handshake.",
            "48. Inheritance types in OOP.",
            "49. What is a REST API?",
            "50. Explain CAP theorem."
        );
    }

    
}

