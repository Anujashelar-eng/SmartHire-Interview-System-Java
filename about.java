package com.smartf;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class about{

    Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    double screenWidth = screenBounds.getWidth();
    double screenHeight = screenBounds.getHeight();

    boolean isDarkMode = false;


    public Scene createScene(Stage mainStage,Runnable backAction) {
        BorderPane root = new BorderPane();
        root.setStyle(isDarkMode
            ? "-fx-background-color: linear-gradient(to bottom right, #325ab9ff, #5a73e4ff);"
            : "-fx-background-color: linear-gradient(to bottom right, #327acdff,#d7ab70ff);"
        );

        HBox topLogos = new HBox();
        topLogos.setPadding(new Insets(15, 30, 15, 30));
        topLogos.setAlignment(Pos.CENTER_LEFT);
        topLogos.setSpacing(20);

        ImageView instituteLogoView = new ImageView(new Image("/Assets/Image/core2webLogo.png"));
        instituteLogoView.setFitHeight(100);
        instituteLogoView.setPreserveRatio(true);

        ImageView projectLogoView = new ImageView(new Image("/Assets/Image/smrthirelogo.png"));
        projectLogoView.setFitHeight(120);
        projectLogoView.setPreserveRatio(true);
        projectLogoView.setFitWidth(100);  // adjust as needed

        projectLogoView.setSmooth(true);
        projectLogoView.setStyle("-fx-background-color: transparent;");
        //projectLogoView.setFill(Color.TRANSPARENT);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        topLogos.getChildren().addAll(instituteLogoView, spacer, projectLogoView);
        root.setTop(topLogos);

        HBox mainLayout = new HBox(50);
        mainLayout.setPadding(new Insets(10, 30, 20, 30));

        Image teacherImage = new Image("/Assets/Image/shashi_Sir.jpg");
            ImageView teacherView = new ImageView(teacherImage);
            teacherView.setFitWidth(300); // optional: adjust size
            teacherView.setFitHeight(300);

// Create circular clip
            Circle clip = new Circle(150, 150, 150); // x, y center and radius
            teacherView.setClip(clip);

            // Optional: Add a border using a snapshot workaround
            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(Color.TRANSPARENT);
            WritableImage image = teacherView.snapshot(parameters, null);

            // Remove clip to show shadow/border
            teacherView.setClip(null);
            teacherView.setImage(image);
            teacherView.setStyle("-fx-effect: dropshadow(gaussian, gray, 10, 0.5, 2, 2);");

        Circle backgroundCircle = new Circle(250, 225, 230);
        backgroundCircle.setFill(Color.web("#45a1f733"));

        Label teacherInfo = new Label("Shashi Sir is a respected Teacher at Core2Web,\n"
                + "known for simplifying core CS topics.\n"
                + "His approachable teaching style inspires many Students.");
        teacherInfo.setWrapText(true);
        teacherInfo.setFont(Font.font("Arial", 18));
        teacherInfo.setStyle("-fx-text-fill: white;");
        teacherInfo.setPadding(new Insets(20, 0, 0, 0));

        VBox teacherContent = new VBox(new StackPane(backgroundCircle, teacherView), teacherInfo);
        teacherContent.setAlignment(Pos.TOP_CENTER);
        teacherContent.setSpacing(10);
        teacherContent.setPadding(new Insets(-50, 0, 0, 30));

        VBox leftBox = new VBox(teacherContent);
        leftBox.setAlignment(Pos.TOP_LEFT);
        VBox.setVgrow(teacherContent, Priority.ALWAYS);

        VBox rightBox = new VBox(25);
        rightBox.setAlignment(Pos.TOP_LEFT);
        rightBox.setPadding(new Insets(30, 30, 30, 30));
        rightBox.setStyle("-fx-background-color: transparent;");

        Label heading = new Label("About Us");
        heading.setFont(Font.font("Arial", 30));
        heading.setStyle("-fx-text-fill: #2373dbff; -fx-font-weight: bold;");

        StackPane headingBox = new StackPane(heading);
        headingBox.setAlignment(Pos.CENTER);
        headingBox.setPadding(new Insets(12));
        headingBox.setMaxWidth(300);
        headingBox.setStyle(
            "-fx-background-color: #f9fcffff;" +
            "-fx-background-radius: 10;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.6), 8, 0, 2, 2);"
        );

        VBox teacherBox = new VBox(6);
        teacherBox.setAlignment(Pos.TOP_LEFT);

        Label teacherLabel = new Label("Master:Shashi Bagal sir");
        Label teacher1Label = new Label("Prof. Sachin Patil sir");
        Label teacher2Label = new Label("Prof. Pramod sir");
        Label mentorLabel = new Label("Mentor: Shivkumar Tengse");
        Label mentorLabel2 = new Label("Mentor: Subodh Yelgandharwar");
        Label TeamLeader = new Label("Team Leader: Punam Khedkar");
    

        for (Label label : new Label[]{teacherLabel, teacher1Label, teacher2Label, mentorLabel,mentorLabel2,TeamLeader}) {
            label.setFont(Font.font("Arial", 20));
            label.setStyle("-fx-text-fill: white;");
        }

        teacherBox.getChildren().addAll(teacherLabel, teacher1Label, teacher2Label, mentorLabel,mentorLabel2,TeamLeader);

        VBox projectCard = new VBox(15);
        projectCard.setPadding(new Insets(20));
        projectCard.setPrefWidth(600);
        projectCard.setStyle(
            "-fx-background-color: #fbfbfbff;" +
            "-fx-background-radius: 15;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.6), 12, 0, 4, 4);"
        );

        Label aboutProjectLabel = new Label("About Project:");
        aboutProjectLabel.setFont(Font.font("Arial", 22));
        aboutProjectLabel.setStyle("-fx-text-fill: #234feddb; -fx-font-weight: bold;");

        Label projectDesc = new Label(
            "SmartHire is a Java-based desktop application built to support job seekers in getting ready for technical interviews. The system provides a clean and interactive platform to prepare, practice, and build confidence before attending real interviews.\n" + //
                                "\n" + //
                                "🔹 Key Features:\n" + //
                                " Interview Preparation: Learn key topics like Data Structures, Algorithms, DBMS, OS, and OOPs through categorized question banks.\n" + //
                                "\n" + //
                                " Mock Tests: Take multiple-choice tests with timers to evaluate your readiness.\n" + //
                                "\n" + //
                                " Mock Interviews: Experience real-time AI-based mock interviews using voice interaction to simulate pressure and improve speaking confidence.\n" + //
                                "\n" + //
                                "Interview Experiences: Read real interview stories and tips shared by freshers.\n" + //
                                "\n" + //
                                " Resume Builder: Easily create and save professional resumes using built-in templates.."
        );
        projectDesc.setWrapText(true);
        projectDesc.setFont(Font.font("Arial", 16));
        projectDesc.setStyle("-fx-text-fill: #0c0c0cff;");

        projectCard.getChildren().addAll(aboutProjectLabel, projectDesc);

        VBox cardBox = new VBox(12);
        cardBox.setPadding(new Insets(25));
        cardBox.setPrefWidth(600);
        cardBox.setStyle(
            "-fx-background-color: #eceef3ff;" +
            "-fx-background-radius: 15;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.6), 12, 0, 4, 4);"
        );

        Label teamLabel = new Label("Team Members:");
        teamLabel.setFont(Font.font("Arial", 20));
        teamLabel.setStyle("-fx-text-fill: #2f71d3ff; -fx-font-weight: bold;");

        VBox membersBox = new VBox(15);
        membersBox.setPadding(new Insets(10, 0, 0, 0));

        Object[][] teamData = {
            {"Anuja Shelar", "Group Lead, passionate about UI/UX.", "/Assets/Image/anuja.jpg"},
            {"Akanksha Pokharkar","Developer and Firebase integration.", "/Assets/Image/akanksha.jpg"},
            {"Shubhangi Sapate", "UI Designer and responsible for testing modules.", "/Assets/Image/shubhangii.jpg"},
            {"Nandini Doke", "Frontend Developer and JavaFX lead.", "/Assets/Image/nandini.jpg"}
        };

        for (Object[] member : teamData) {
            ImageView memberImage = new ImageView(new Image((String) member[2]));
            memberImage.setFitHeight(80);
            memberImage.setFitWidth(80);
            memberImage.setClip(new Circle(40, 40, 40));
            memberImage.setStyle("-fx-effect: dropshadow(gaussian, white, 4, 0.3, 1, 1);");

            VBox textBox = new VBox(5);
            Label nameLabel = new Label((String) member[0]);
            nameLabel.setFont(Font.font("Arial", 16));
            nameLabel.setStyle("-fx-text-fill: #3b3a3a; -fx-font-weight: bold;");

            Label descLabel = new Label((String) member[1]);
            descLabel.setFont(Font.font("Arial", 14));
            descLabel.setStyle("-fx-text-fill: #080808ff;");
            descLabel.setWrapText(true);

            textBox.getChildren().addAll(nameLabel, descLabel);

            HBox memberBox = new HBox(15, memberImage, textBox);
            memberBox.setAlignment(Pos.CENTER_LEFT);

            membersBox.getChildren().add(memberBox);
        }

        cardBox.getChildren().addAll(teamLabel, membersBox);

        Button backButton = new Button("\u2190 Back to Home");
        backButton.setStyle("-fx-background-color: #6c6f72ff; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-background-radius: 6;");
        backButton.setOnAction(e -> backAction.run());
           

        HBox backBtnBox = new HBox(backButton);
        backBtnBox.setAlignment(Pos.CENTER_LEFT);
        backBtnBox.setPadding(new Insets(10, 0, 0, 10));

        rightBox.getChildren().addAll(headingBox, teacherBox, projectCard, cardBox, backBtnBox);

        ScrollPane rightScrollPane = new ScrollPane(rightBox);
        rightScrollPane.setFitToWidth(true);
        rightScrollPane.setPannable(true);
        rightScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        rightScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        rightScrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent;");
        VBox.setVgrow(rightScrollPane, Priority.ALWAYS);

        HBox.setHgrow(rightScrollPane, Priority.ALWAYS);
        mainLayout.getChildren().addAll(leftBox, rightScrollPane);
        mainLayout.setFillHeight(true);

        root.setCenter(mainLayout);

        Scene scene = new Scene(root, screenWidth, screenHeight);
        return scene;
    }
}



// package com.smartf;

// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;
// import javafx.scene.layout.*;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.text.Font;
// import javafx.stage.Stage;

// public class AboutUs  {

//     public Scene createScene(Stage mainStage,Runnable backAction){

//         // ===== Root Layout =====
//         BorderPane root = new BorderPane();
//         root.setStyle("-fx-background-color:rgb(13, 25, 38);");
//         Button back=new Button("<-back");
//         back.setOnAction(e->backAction.run());
        

//         back.setStyle("-fx-background-color: rgba(11, 12, 12, 0.03); -fx-text-fill: white;");
   

//         // ===== Top: Logos =====
//         HBox topLogos = new HBox();
//         topLogos.setPadding(new Insets(15, 30, 15, 30));
//         topLogos.setAlignment(Pos.CENTER_LEFT);

//         ImageView instituteLogoView = new ImageView(new Image("/Assets/Images/core2webLogo.png"));
//         instituteLogoView.setFitHeight(100);
//         instituteLogoView.setPreserveRatio(true);

//         ImageView projectLogoView = new ImageView(new Image("/Assets/Images/Logo1.jpeg"));
//         projectLogoView.setFitHeight(150);
//         projectLogoView.setPreserveRatio(true);

//         Region spacer = new Region();
//         HBox.setHgrow(spacer, Priority.ALWAYS);

//         topLogos.getChildren().addAll(back,instituteLogoView, spacer, projectLogoView);
//         root.setTop(topLogos);

//         // ===== Main Layout =====
//         HBox mainLayout = new HBox(40);
//         mainLayout.setPadding(new Insets(0, 30, 10, 30));

//         // ===== Left: Teacher Photo =====
//         Image teacherImage = new Image("/Assets/Image/ShashiSir.png");
//         ImageView teacherView = new ImageView(teacherImage);
//         teacherView.setFitWidth(500);
//         teacherView.setFitHeight(450);
//         teacherView.setStyle("-fx-effect: dropshadow(gaussian, gray, 10, 0.5, 2, 2);");

//         VBox leftBox = new VBox(teacherView);
//         leftBox.setAlignment(Pos.TOP_LEFT);
//         leftBox.setPadding(new Insets(-50, 0, 0, 30));

//         // ===== Right: Text Info and Cards =====
//         VBox rightBox = new VBox(20);
//         rightBox.setAlignment(Pos.TOP_LEFT);
//         rightBox.setPadding(new Insets(-50, 0, 0, 0)); // shift About Us section upward

//         // About Us Heading in a styled box
//         // Label heading = new Label("About Us");
//         // heading.setFont(Font.font("Arial", 22));
//         // heading.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

//         Label heading = new Label("About Us");
//         heading.setFont(Font.font("Arial", 22));
//         heading.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

//         StackPane headingBox = new StackPane(heading);
//         headingBox.setAlignment(Pos.CENTER);
//         headingBox.setPadding(new Insets(10));
//         headingBox.setMaxWidth(200); // reduced visible width
//         headingBox.setStyle(
//     "-fx-background-color: #1f2e3e;" +
//     "-fx-background-radius: 10;" +
//     "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.6), 8, 0, 2, 2);"
// );



//         // Teacher & Mentor Labels
//         VBox teacherBox = new VBox(4); // reduced spacing
//         teacherBox.setAlignment(Pos.TOP_LEFT);

//         Label teacherLabel = new Label("Teacher: Prof. Shashi Bagal sir");
//         Label teacher1Label = new Label("Prof. Sachin Patil sir");
//         Label teacher2Label = new Label("Prof. Pramod sir");
//         Label mentorLabel = new Label("Mentor: Punam Khedkar");

//         for (Label label : new Label[]{teacherLabel, teacher1Label, teacher2Label, mentorLabel}) {
//             label.setFont(Font.font("Arial", 14));
//             label.setStyle("-fx-text-fill: white;");
//         }

//         teacherBox.getChildren().addAll(teacherLabel, teacher1Label, teacher2Label, mentorLabel);

//         // ===== Project Card =====
//         VBox projectCard = new VBox(10);
//         projectCard.setPadding(new Insets(20));
//         projectCard.setPrefWidth(400);
//         projectCard.setStyle(
//             "-fx-background-color: #1f2e3e;" +
//             "-fx-background-radius: 15;" +
//             "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.6), 12, 0, 4, 4);"
//         );

//         Label aboutProjectLabel = new Label("About Project:");
//         aboutProjectLabel.setFont(Font.font("Arial", 20));
//         aboutProjectLabel.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold;");

//         Label projectDesc = new Label(
//             "SmartHire is an intelligent interview preparation platform developed as part of the Core2Web training program. " +
//             "It helps students and job seekers prepare for technical and HR interviews with curated content, aptitude questions, and mock interview simulations."
//         );
//         projectDesc.setWrapText(true);
//         projectDesc.setFont(Font.font("Arial", 15));
//         projectDesc.setStyle("-fx-text-fill: #dce3ea;");

//         projectCard.getChildren().addAll(aboutProjectLabel, projectDesc);

//         // ===== Team Members Card =====
//         VBox cardBox = new VBox(10);
//         cardBox.setPadding(new Insets(20));
//         cardBox.setPrefWidth(400);
//         cardBox.setStyle(
//             "-fx-background-color: #1f2e3e;" +
//             "-fx-background-radius: 15;" +
//             "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.6), 12, 0, 4, 4);"
//         );

//         Label teamLabel = new Label("Team Members:");
//         teamLabel.setFont(Font.font("Arial", 18));
//         teamLabel.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold;");

//         Label members = new Label("1. Anuja Shelar\n2. Shubhangi Sapate\n3. Nandini Doke\n4. Akanksha Pokharkar");
//         members.setFont(Font.font("Arial", 15));
//         members.setStyle("-fx-text-fill: #dce3ea;");

//         cardBox.getChildren().addAll(teamLabel, members);

//         rightBox.getChildren().addAll(headingBox, teacherBox, projectCard, cardBox);

//         // Add left and right to main layout
//         mainLayout.getChildren().addAll(leftBox, rightBox);
//         root.setCenter(mainLayout);

//         // ===== Scene & Stage =====
//         Scene scene = new Scene(root, 1100, 650);
//         return scene;
// }
// }
