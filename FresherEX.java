package com.smartf;

import com.google.cloud.firestore.QueryDocumentSnapshot;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FresherEX{

    FlowPane submissionContainer = new FlowPane(); // Holds cards in rows

   public Scene creatScene(Stage mainStage,Runnable backAction) {
        FirebaseInitializer.initialize(); // ✅ Initialize Firebase

        // 🔽 Load submissions from Firestore
        FirebaseInitializer.fetchAllInterviewSubmissions(doc -> {
            String name = doc.getString("name");
            String company = doc.getString("company");
            String question = doc.getString("question");

            VBox card = createStudentCard(name, company, question);
            submissionContainer.getChildren().add(card);
        });

        Label titleLabel = new Label("Interview Experience Submission");
        titleLabel.setStyle("-fx-font-size: 22px; -fx-text-fill: #333; -fx-font-weight: bold;");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        nameField.setStyle(inputStyle());

        TextField companyField = new TextField();
        companyField.setPromptText("Enter company name");
        companyField.setStyle(inputStyle());

        TextArea questionArea = new TextArea();
        questionArea.setPromptText("Enter the question asked in the interview");
        questionArea.setPrefRowCount(3);
        questionArea.setStyle(textAreaStyle());

        Button submitButton = new Button("Submit");
        submitButton.setStyle(buttonStyle());
        submitButton.setOnMouseEntered(e -> submitButton.setStyle(buttonHoverStyle()));
        submitButton.setOnMouseExited(e -> submitButton.setStyle(buttonStyle()));

        submitButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            String company = companyField.getText().trim();
            String question = questionArea.getText().trim();

            if (!name.isEmpty() && !company.isEmpty() && !question.isEmpty()) {
                VBox card = createStudentCard(name, company, question);
                submissionContainer.getChildren().add(0, card); // Add to top

                FirebaseInitializer.addInterviewSubmission(name, company, question);

                nameField.clear();
                companyField.clear();
                questionArea.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill all fields.", ButtonType.OK);
                alert.showAndWait();
            }
        });

        VBox formLayout = new VBox(10, titleLabel, nameField, companyField, questionArea, submitButton);
        formLayout.setPadding(new Insets(20));
        formLayout.setStyle("-fx-background-color: #f0f8ff; -fx-background-radius: 10;");
        formLayout.setAlignment(Pos.CENTER);
        formLayout.setMaxWidth(400);

        submissionContainer.setHgap(15);
        submissionContainer.setVgap(15);
        submissionContainer.setPadding(new Insets(20));
        submissionContainer.setPrefWrapLength(900);

        ScrollPane scrollPane = new ScrollPane(submissionContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent;");

        Button backButton = new Button("← Back");
        backButton.setStyle("-fx-background-color: #eeeeee; -fx-text-fill: #333; -fx-font-weight: bold; -fx-padding: 8 16; -fx-background-radius: 6; -fx-cursor: hand;");
        backButton.setOnAction(e -> backAction.run());

        VBox contentLayout = new VBox(20, backButton, formLayout, new Label("Submitted Interview Questions:"), scrollPane);
        contentLayout.setAlignment(Pos.TOP_CENTER);
        contentLayout.setPadding(new Insets(20));
        contentLayout.setStyle("-fx-background-color: linear-gradient(to bottom right, #e0f7fa, #fce4ec);");

        Scene scene = new Scene(contentLayout, 960, 700);
        return scene;
    }

    private VBox createStudentCard(String name, String company, String question) {
        Label nameLabel = new Label("👤 Name: " + name);
        Label companyLabel = new Label("🏢 Company: " + company);
        Label questionLabel = new Label("❓ Question: " + question);
        questionLabel.setWrapText(true);

        nameLabel.setStyle("-fx-font-weight: bold;");
        companyLabel.setStyle("-fx-font-weight: bold;");

        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");

        editButton.setStyle("-fx-background-color: #4caf50; -fx-text-fill: white; -fx-cursor: hand;");
        deleteButton.setStyle("-fx-background-color: #e53935; -fx-text-fill: white; -fx-cursor: hand;");

        HBox buttonBox = new HBox(10, editButton, deleteButton);
        buttonBox.setPadding(new Insets(10, 0, 0, 0));

        VBox card = new VBox(5, nameLabel, companyLabel, questionLabel, buttonBox);
        card.setPadding(new Insets(10));
        card.setPrefWidth(280);
        card.setStyle(
                "-fx-background-color: #ffffff;" +
                "-fx-border-color: #ce93d8;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 4, 0, 0, 2);"
        );

        deleteButton.setOnAction(e -> submissionContainer.getChildren().remove(card));

        editButton.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog(questionLabel.getText().replace("❓ Question: ", ""));
            dialog.setTitle("Edit Question");
            dialog.setHeaderText("Edit the interview question:");
            dialog.setContentText("New Question:");

            dialog.showAndWait().ifPresent(newQuestion -> {
                if (!newQuestion.trim().isEmpty()) {
                    questionLabel.setText("❓ Question: " + newQuestion.trim());
                }
            });
        });

        return card;
    }

    private String inputStyle() {
        return "-fx-font-size: 14px;" +
                "-fx-padding: 8;" +
                "-fx-border-color: #b2ebf2;" +
                "-fx-border-radius: 5;" +
                "-fx-background-radius: 5;" +
                "-fx-background-color: #ffffff;";
    }

    private String textAreaStyle() {
        return "-fx-font-size: 14px;" +
                "-fx-padding: 8;" +
                "-fx-border-color: #ce93d8;" +
                "-fx-border-radius: 5;" +
                "-fx-background-radius: 5;" +
                "-fx-background-color: #ffffff;";
    }

    private String buttonStyle() {
        return "-fx-background-color: #7e57c2;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 20 10 20;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;";
    }

    private String buttonHoverStyle() {
        return "-fx-background-color: #9575cd;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 20 10 20;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;";
    }

    
}
