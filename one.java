package com.smartf;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class one extends Application {

    @Override
    public void start(Stage stage) {
        Label title = new Label("Prepare for your interview on the go");
        title.setFont(new Font("Arial", 22));
        title.setTextFill(Color.web("#ffffff"));

        Button categoryBtn = new Button("Categories");
        categoryBtn.setStyle("-fx-background-color: white; -fx-text-fill: Black; -fx-font-weight: bold;");
        categoryBtn.setPrefWidth(150);
        categoryBtn.setFont(new Font(20));

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(20);
        grid.setHgap(20);
        grid.setAlignment(Pos.CENTER);

        String[] categories = {
                "Preparation", "Quiz",
                "Resume", "Company Wise Question",
                "Mock Test","Feedback"
        };

        String[] images = {
                "D:\\Super\\signup2\\src\\main\\resources\\Assets\\Image\\Prepeartion.png",
                "D:\\Super\\signup2\\src\\main\\resources\\Assets\\Image\\Quiz4.jpg",
                "D:\\Super\\signup2\\src\\main\\resources\\Assets\\Image\\Resum2.jpg",
                "D:\\Super\\signup2\\src\\main\\resources\\Assets\\Image\\Interview.jpg",
                "D:\\Super\\signup2\\src\\main\\resources\\Assets\\Image\\Mock.jpg",
                "D:\\Super\\signup2\\src\\main\\resources\\Assets\\Image\\Feedback.jpg"
        };

        for (int i = 0; i < categories.length; i++) {
            VBox card = createCategoryCard(categories[i], images[i]);
            grid.add(card, i % 2, i / 2);
        }

        VBox mainLayout = new VBox(20, title, categoryBtn, grid);
        mainLayout.setPadding(new Insets(30));
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setStyle("-fx-background-color: linear-gradient(to bottom right, #8A2BE2, #FF00FF);");

        Scene scene = new Scene(mainLayout, 450, 700);
        stage.setScene(scene);
        stage.setTitle("SmartHire");
        stage.show();
    }
    private VBox createCategoryCard(String title, String imagePath) {
        Image topImage = new Image("file:" + imagePath);
        ImageView topImageView = new ImageView(topImage);
        topImageView.setFitWidth(50);
        topImageView.setFitHeight(50);

        Label label = new Label(title);
        label.setFont(new Font("Arial", 14));
        label.setWrapText(true);
        label.setAlignment(Pos.CENTER);
        label.setTextFill(Color.web("#000000"));

        Image buttonImage = new Image("file:Assets/Image/view.png");
        ImageView buttonImageView = new ImageView(buttonImage);
        buttonImageView.setFitWidth(16);
        buttonImageView.setFitHeight(16);

        Button viewBtn = new Button("View", buttonImageView);
        viewBtn.setStyle("-fx-background-color: #2575fc; -fx-text-fill: white; -fx-font-weight: bold;");
        viewBtn.setPrefWidth(100);

        VBox vb = new VBox(10, topImageView, label, viewBtn);
        vb.setPadding(new Insets(15));
        vb.setAlignment(Pos.CENTER);
        vb.setStyle("""
                -fx-background-color: white;
                -fx-border-radius: 15;
                -fx-background-radius: 15;
                -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 5);
                """);
        vb.setPrefSize(180, 160);

        return vb;
    }

}
