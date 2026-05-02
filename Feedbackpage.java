package com.smartf;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Feedbackpage {

    private int selectedRating = 0;
    private final Label[] starLabels = new Label[5];

    public Scene createScene(Stage mainStage,Runnable backAction){

        Image bgImage = new Image(getClass().getResource("/Assets/Image/background.jpg").toExternalForm());
        ImageView bgView = new ImageView(bgImage);
        bgView.setFitWidth(1920);
        bgView.setFitHeight(1080);
        bgView.setPreserveRatio(false);
        bgView.setEffect(new GaussianBlur(10));

        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        VBox card = new VBox(20);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(30));
        card.setStyle("-fx-background-color: white; -fx-background-radius: 10; "
                + "-fx-border-color: #ccc; -fx-border-width: 1; -fx-border-radius: 10; "
                + "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0.5, 0, 0);");

        Label header = new Label("SmartHire");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        header.setTextFill(Color.web("#008000"));

        Label subHeader = new Label("Leave Your Feedback");
        subHeader.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        HBox starsBox = new HBox(5);
        starsBox.setAlignment(Pos.CENTER);
        for (int i = 0; i < 5; i++) {
            Label star = new Label("☆");
            star.setFont(Font.font(28));
            star.setTextFill(Color.GOLD);
            int rating = i + 1;
            star.setOnMouseClicked(e -> updateStarRating(rating));
            starLabels[i] = star;
            starsBox.getChildren().add(star);
        }

        TextArea feedbackArea = new TextArea();
        feedbackArea.setPromptText("Enter your feedback");
        feedbackArea.setWrapText(true);
        feedbackArea.setPrefRowCount(4);
        feedbackArea.setPrefWidth(700);
        feedbackArea.setStyle("-fx-font-size: 14;");

        Button submitBtn = new Button("Submit");
        submitBtn.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-size: 14;");
        submitBtn.setOnAction(e -> {
            String feedback = feedbackArea.getText();
            if (selectedRating == 0 || feedback.trim().isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Please provide both a rating and comment.").showAndWait();
            } else {
                System.out.println("Rating: " + selectedRating);
                System.out.println("Feedback: " + feedback);
                new Alert(Alert.AlertType.INFORMATION, "Thank you for your feedback!").showAndWait();
                feedbackArea.clear();
                updateStarRating(0);
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setStyle("-fx-background-color: #dc3545; -fx-text-fill: white; -fx-font-size: 14;");
        backBtn.setOnAction(e -> backAction.run());
          

        HBox buttonBox = new HBox(20, submitBtn, backBtn);
        buttonBox.setAlignment(Pos.CENTER);

        card.getChildren().addAll(header, subHeader, starsBox, feedbackArea, buttonBox);
        root.getChildren().add(card);

        StackPane stackPane = new StackPane(bgView, root);
        return new Scene(stackPane, 1000, 600);
    }

    private void updateStarRating(int rating) {
        selectedRating = rating;
        for (int i = 0; i < 5; i++) {
            starLabels[i].setText(i < rating ? "★" : "☆");
        }
    }
}
