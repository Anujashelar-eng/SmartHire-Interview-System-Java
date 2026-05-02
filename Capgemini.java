package com.smartf;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.awt.Desktop;
import java.net.URI;

public class Capgemini {

    public Scene creatScene(Stage mainStage, Runnable backAction) {
        mainStage.setTitle("Capgemini - Career Path & Recruitment Process");

        Label header = new Label("🎯 Capgemini - Complete Career Guide for Freshers");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        header.setStyle("-fx-padding: 15; -fx-text-fill: #0070AD; -fx-background-color: #f0f8ff;");

        VBox contentBox = new VBox(15);
        contentBox.setPadding(new Insets(20));
        contentBox.setStyle("-fx-background-color: white;");

        // Official Website Section
        contentBox.getChildren().add(createSectionHeader("🌐 Official Career Portal"));
        VBox linksBox = new VBox(8);
        linksBox.getChildren().addAll(
            createClickableLink("Official Career Website", "https://www.capgemini.com/careers"),
            createClickableLink("India Careers Portal", "https://www.capgemini.com/in-en/careers"),
            createClickableLink("Fresher Jobs Portal", "https://www.capgemini.com/jobs"),
            createClickableLink("LinkedIn - Capgemini", "https://www.linkedin.com/company/capgemini")
        );
        contentBox.getChildren().add(linksBox);

        // About Capgemini
        contentBox.getChildren().add(createSectionHeader("🏢 About Capgemini"));
        contentBox.getChildren().add(createInfoText(
            "• Global leader in consulting, technology services, and digital transformation\n" +
            "• Founded: 1967 | Headquarters: Paris, France\n" +
            "• Presence in 50+ countries with 360,000+ employees\n" +
            "• Major service areas: Cloud, Data & AI, Digital Engineering, Cybersecurity"
        ));

        // Eligibility Criteria
        contentBox.getChildren().add(createSectionHeader("✅ Eligibility Criteria for Freshers"));
        contentBox.getChildren().add(createInfoText(
            "Academic Requirements:\n" +
            "• B.E./B.Tech/MCA/M.Sc (CS/IT) - 2024/2025 passouts\n" +
            "• Minimum 60% throughout (10th, 12th, and Graduation)\n" +
            "• No active backlogs at the time of interview\n" +
            "• Maximum 2 years gap in education accepted\n\n" +
            "Roles Available:\n" +
            "• Software Engineer\n" +
            "• Senior Analyst\n" +
            "• Associate Consultant\n" +
            "• Get & Apps (Digital & Cloud)"
        ));

        // Complete Recruitment Process
        contentBox.getChildren().add(createSectionHeader("📋 Complete Recruitment Process"));
        
        contentBox.getChildren().add(createStageHeader("Stage 1: Online Application"));
        contentBox.getChildren().add(createInfoText(
            "• Register on Capgemini careers portal\n" +
            "• Upload updated resume (PDF format recommended)\n" +
            "• Fill complete profile with academic details\n" +
            "• Apply for suitable job openings\n" +
            "• Track application status through portal"
        ));

        contentBox.getChildren().add(createStageHeader("Stage 2: Online Assessment Test (90-120 mins)"));
        contentBox.getChildren().add(createInfoText(
            "Section A - Aptitude & Reasoning (40 mins)\n" +
            "• Quantitative Aptitude: 15-20 questions\n" +
            "• Logical Reasoning: 15-20 questions\n" +
            "• Verbal Ability: 10-15 questions\n\n" +
            "Section B - Technical MCQs (30 mins)\n" +
            "• Programming fundamentals (C, C++, Java, Python)\n" +
            "• Data Structures & Algorithms\n" +
            "• DBMS & SQL queries\n" +
            "• Operating Systems basics\n" +
            "• OOPs concepts\n\n" +
            "Section C - Coding Round (30-40 mins)\n" +
            "• 2 coding problems (Easy to Medium level)\n" +
            "• Focus on arrays, strings, loops, patterns\n" +
            "• Must pass at least 50% test cases\n\n" +
            "Passing Criteria: Usually 60-65% overall"
        ));

        contentBox.getChildren().add(createStageHeader("Stage 3: Technical Interview (45-60 mins)"));
        contentBox.getChildren().add(createInfoText(
            "What to Expect:\n" +
            "• Introduction & Resume discussion\n" +
            "• Deep dive into projects mentioned in resume\n" +
            "• Programming questions (write code on paper/screen)\n" +
            "• DSA concepts: Arrays, LinkedList, Trees, Sorting\n" +
            "• OOPs pillars with real examples\n" +
            "• DBMS: Joins, Normalization, Indexes\n" +
            "• Problem-solving approach and logic building\n" +
            "• Questions on internships/certifications\n\n" +
            "Tips:\n" +
            "• Be thorough with your resume projects\n" +
            "• Explain your approach before coding\n" +
            "• Write clean, readable code\n" +
            "• Ask clarifying questions if needed"
        ));

        contentBox.getChildren().add(createStageHeader("Stage 4: HR Interview (20-30 mins)"));
        contentBox.getChildren().add(createInfoText(
            "Common Questions:\n" +
            "• Tell me about yourself\n" +
            "• Why Capgemini?\n" +
            "• Strengths and weaknesses\n" +
            "• Career goals (short-term & long-term)\n" +
            "• Willingness to relocate\n" +
            "• Expected salary (for experienced, not usually for freshers)\n" +
            "• Any questions for us?\n\n" +
            "What They Look For:\n" +
            "• Communication skills\n" +
            "• Confidence and positivity\n" +
            "• Cultural fit\n" +
            "• Flexibility and learning attitude"
        ));

        contentBox.getChildren().add(createStageHeader("Stage 5: Offer & Onboarding"));
        contentBox.getChildren().add(createInfoText(
            "• Results announced within 1-2 weeks\n" +
            "• Offer letter sent via email\n" +
            "• Document verification process\n" +
            "• Pre-joining formalities and background check\n" +
            "• Training period: 4-8 weeks (paid training)\n" +
            "• Project allocation based on performance & requirement"
        ));

        // Salary Package
        contentBox.getChildren().add(createSectionHeader("💰 Salary Package (2024-25)"));
        contentBox.getChildren().add(createInfoText(
            "Fresher Packages:\n" +
            "• Software Engineer: ₹3.5 - 4.0 LPA\n" +
            "• Senior Analyst: ₹4.5 - 5.5 LPA\n" +
            "• Get & Apps (Digital): ₹6.0 - 6.5 LPA\n\n" +
            "Additional Benefits:\n" +
            "• Performance bonuses\n" +
            "• Health insurance\n" +
            "• Learning & certification programs\n" +
            "• Work-from-home options (hybrid model)"
        ));

        // Preparation Tips
        contentBox.getChildren().add(createSectionHeader("📚 Preparation Strategy"));
        contentBox.getChildren().add(createInfoText(
            "Technical Preparation (4-6 weeks):\n" +
            "Week 1-2: Core Programming (C/C++/Java/Python)\n" +
            "• Master syntax, loops, functions, arrays\n" +
            "• Practice 50+ coding problems on HackerRank/LeetCode\n\n" +
            "Week 3-4: Data Structures & Algorithms\n" +
            "• Arrays, Strings, LinkedList, Stack, Queue\n" +
            "• Searching & Sorting algorithms\n" +
            "• Time & Space complexity\n\n" +
            "Week 5: DBMS & SQL\n" +
            "• SQL queries (SELECT, JOIN, GROUP BY)\n" +
            "• Normalization, Keys, Indexes\n" +
            "• Practice on W3Schools SQL editor\n\n" +
            "Week 6: OOPs & Projects\n" +
            "• 4 pillars with examples\n" +
            "• Revise all resume projects thoroughly\n\n" +
            "Aptitude & Reasoning:\n" +
            "• Practice on IndiaBix, PrepInsta\n" +
            "• Focus on: Percentages, Ratios, Time & Work\n" +
            "• Logical puzzles and patterns\n\n" +
            "Soft Skills:\n" +
            "• Prepare 2-min self introduction\n" +
            "• Practice common HR questions\n" +
            "• Research about Capgemini thoroughly"
        ));

        // Important Resources
        contentBox.getChildren().add(createSectionHeader("📌 Important Resources"));
        contentBox.getChildren().add(createInfoText(
            "Practice Platforms for Coding:"
        ));
        VBox codingLinks = new VBox(5);
        codingLinks.getChildren().addAll(
            createClickableLink("LeetCode - Practice Coding", "https://leetcode.com"),
            createClickableLink("HackerRank - Programming", "https://www.hackerrank.com"),
            createClickableLink("GeeksforGeeks - DSA", "https://www.geeksforgeeks.org")
        );
        contentBox.getChildren().add(codingLinks);
        
        contentBox.getChildren().add(createInfoText("\nAptitude & Reasoning:"));
        VBox aptitudeLinks = new VBox(5);
        aptitudeLinks.getChildren().addAll(
            createClickableLink("IndiaBix - Aptitude Questions", "https://www.indiabix.com"),
            createClickableLink("PrepInsta - Placement Prep", "https://prepinsta.com")
        );
        contentBox.getChildren().add(aptitudeLinks);
        
        contentBox.getChildren().add(createInfoText("\nSQL Practice:"));
        VBox sqlLinks = new VBox(5);
        sqlLinks.getChildren().addAll(
            createClickableLink("W3Schools SQL Tutorial", "https://www.w3schools.com/sql"),
            createClickableLink("SQLBolt - Interactive SQL", "https://sqlbolt.com"),
            createClickableLink("HackerRank SQL", "https://www.hackerrank.com/domains/sql")
        );
        contentBox.getChildren().add(sqlLinks);
        
        contentBox.getChildren().add(createInfoText("\nInterview Preparation:"));
        VBox interviewLinks = new VBox(5);
        interviewLinks.getChildren().addAll(
            createClickableLink("InterviewBit", "https://www.interviewbit.com"),
            createClickableLink("YouTube - Take U Forward", "https://www.youtube.com/@takeUforward")
        );
        contentBox.getChildren().add(interviewLinks);

        // Key Points to Remember
        contentBox.getChildren().add(createSectionHeader("⚡ Key Points to Remember"));
        contentBox.getChildren().add(createInfoText(
            "✓ Capgemini conducts drives throughout the year\n" +
            "✓ On-campus & off-campus opportunities available\n" +
            "✓ Bond period: Usually 2 years (check offer letter)\n" +
            "✓ Notice period: 60-90 days\n" +
            "✓ Work locations: Bangalore, Mumbai, Pune, Hyderabad, Chennai\n" +
            "✓ Great learning culture with global exposure\n" +
            "✓ Active employee resource groups and communities\n" +
            "✓ Clear growth path: Analyst → Consultant → Manager\n\n" +
            "⚠️ Beware of Fake Job Posts:\n" +
            "• Always apply through official website only\n" +
            "• Capgemini never charges any fee for recruitment\n" +
            "• Verify email domain: @capgemini.com"
        ));

        ScrollPane scrollPane = new ScrollPane(contentBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: white;");

        // Back button
        Button backButton = new Button("⬅ Back to Home");
        backButton.setStyle("-fx-font-size: 14; -fx-padding: 10 20; -fx-background-color: #0070AD; -fx-text-fill: white; -fx-cursor: hand;");
        backButton.setOnAction(e -> backAction.run());

        BorderPane root = new BorderPane();
        root.setTop(header);
        root.setCenter(scrollPane);
        root.setBottom(backButton);
        BorderPane.setMargin(backButton, new Insets(10));
        root.setStyle("-fx-background-color: #f5f5f5;");

        Scene scene = new Scene(root, 900, 700);
        return scene;
    }

    private Label createSectionHeader(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        label.setStyle("-fx-text-fill: #0070AD; -fx-padding: 10 0 5 0;");
        return label;
    }

    private Label createStageHeader(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        label.setStyle("-fx-text-fill: #2c5282; -fx-padding: 8 0 3 0;");
        return label;
    }

    private Text createInfoText(String text) {
        Text textNode = new Text(text);
        textNode.setFont(Font.font("Arial", 14));
        textNode.setStyle("-fx-fill: #2a2a2a; -fx-line-spacing: 1.5;");
        return textNode;
    }

    private Hyperlink createClickableLink(String displayText, String url) {
        Hyperlink hyperlink = new Hyperlink(displayText);
        hyperlink.setFont(Font.font("Arial", 14));
        hyperlink.setStyle("-fx-text-fill: #0070AD; -fx-underline: true;");
        hyperlink.setOnAction(e -> {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception ex) {
                System.err.println("Failed to open URL: " + url);
                ex.printStackTrace();
            }
        });
        return hyperlink;
    }
}