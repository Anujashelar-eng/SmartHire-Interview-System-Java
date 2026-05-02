package com.smartf;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javafx.util.Duration;

public class Explore extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Get full screen dimensions
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double WIDTH = screenBounds.getWidth();
        double HEIGHT = screenBounds.getHeight();

        // Root pane with animated background
        StackPane root = new StackPane();
        
        // Animated background with floating elements
        Pane animatedBackground = createAnimatedBackground(WIDTH, HEIGHT);
        
        BorderPane contentLayer = new BorderPane();
        contentLayer.setPadding(new Insets(30));
        contentLayer.setStyle("-fx-background-color: transparent;");

        // --- Logo at top-left with fade-in animation ---
        HBox logoBox = new HBox();
        logoBox.setAlignment(Pos.TOP_LEFT);
        logoBox.setPadding(new Insets(5, 0, 0, 20));
        Image logoImage = new Image(getClass().getResourceAsStream("/Assets/Image/smrthirelogo.png"));
        ImageView logo = new ImageView(logoImage);
        logo.setFitHeight(200);
        logo.setPreserveRatio(true);
        logo.setOpacity(0);
        
        // Logo fade-in animation
        FadeTransition logoFade = new FadeTransition(Duration.seconds(1.5), logo);
        logoFade.setFromValue(0);
        logoFade.setToValue(1);
        logoFade.setDelay(Duration.seconds(0.3));
        
        logoBox.getChildren().add(logo);
        contentLayer.setTop(logoBox);

        // --- Center Text Content with staggered animations ---
        VBox centerBox = new VBox(15);
        centerBox.setAlignment(Pos.CENTER_LEFT);
        centerBox.setPadding(new Insets(0, 20, 20, 60));

        // Main heading with gradient effect
        Text quote = new Text("Improve Your Skills");
        quote.setFill(Color.WHITE);
        quote.setFont(Font.font("Arial", FontWeight.BOLD, 68));
        quote.setOpacity(0);
        
        // Add drop shadow for depth
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.rgb(0, 0, 0, 0.4));
        dropShadow.setRadius(15);
        dropShadow.setOffsetY(5);
        quote.setEffect(dropShadow);

        // Subtitle texts with better styling
        Text subText1 = new Text("Opportunities don't happen, you create them.");
        Text subText2 = new Text("Prepare today for a better tomorrow.");
        Text subText3 = new Text("Your all-in-one prep platform for coding, aptitude, and interviews.");

        for (Text t : new Text[]{subText1, subText2, subText3}) {
            t.setFill(Color.rgb(255, 255, 255, 0.95));
            t.setFont(Font.font("Arial", FontWeight.NORMAL, 24));
            t.setOpacity(0);
            
            DropShadow textShadow = new DropShadow();
            textShadow.setColor(Color.rgb(0, 0, 0, 0.3));
            textShadow.setRadius(8);
            t.setEffect(textShadow);
        }

        Region spacer = new Region();
        spacer.setMinHeight(35);

        // Enhanced button with hover effects
        Button exploreBtn = new Button("Start Your Journey");
        exploreBtn.setStyle(
            "-fx-font-size: 22px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 50;" +
            "-fx-background-color: white;" +
            "-fx-text-fill: #298dc7;" +
            "-fx-padding: 18 50 18 50;" +
            "-fx-cursor: hand;"
        );
        exploreBtn.setOpacity(0);
        
        // Button shadow
        DropShadow btnShadow = new DropShadow();
        btnShadow.setColor(Color.rgb(0, 0, 0, 0.3));
        btnShadow.setRadius(20);
        btnShadow.setOffsetY(8);
        exploreBtn.setEffect(btnShadow);

        // Button hover animation
        exploreBtn.setOnMouseEntered(e -> {
            ScaleTransition scaleUp = new ScaleTransition(Duration.millis(200), exploreBtn);
            scaleUp.setToX(1.08);
            scaleUp.setToY(1.08);
            scaleUp.play();
            
            exploreBtn.setStyle(
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 50;" +
                "-fx-background-color: #298dc7;" +
                "-fx-text-fill: white;" +
                "-fx-padding: 18 50 18 50;" +
                "-fx-cursor: hand;"
            );
        });

        exploreBtn.setOnMouseExited(e -> {
            ScaleTransition scaleDown = new ScaleTransition(Duration.millis(200), exploreBtn);
            scaleDown.setToX(1.0);
            scaleDown.setToY(1.0);
            scaleDown.play();
            
            exploreBtn.setStyle(
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 50;" +
                "-fx-background-color: white;" +
                "-fx-text-fill: #298dc7;" +
                "-fx-padding: 18 50 18 50;" +
                "-fx-cursor: hand;"
            );
        });

        exploreBtn.setOnAction(e -> {
            // Scale down animation on click
            ScaleTransition clickScale = new ScaleTransition(Duration.millis(100), exploreBtn);
            clickScale.setToX(0.95);
            clickScale.setToY(0.95);
            clickScale.setAutoReverse(true);
            clickScale.setCycleCount(2);
            clickScale.setOnFinished(event -> {
                try {
                    Stage loginStage = new Stage();
                    new LoginPage().show(loginStage);
                    primaryStage.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            clickScale.play();
        });

        centerBox.getChildren().addAll(quote, subText1, subText2, subText3, spacer, exploreBtn);
        contentLayer.setLeft(centerBox);

        // --- Right side image with animation ---
        ImageView rightImage = new ImageView(new Image(getClass().getResourceAsStream("/Assets/Image/exploreImg.png")));
        rightImage.setFitHeight(HEIGHT * 0.75);
        rightImage.setPreserveRatio(true);
        rightImage.setOpacity(0);

        StackPane rightWrapper = new StackPane();
        rightWrapper.setPadding(new Insets(0, 40, 0, 0));
        rightWrapper.setAlignment(Pos.CENTER);
        rightWrapper.getChildren().add(rightImage);
        contentLayer.setRight(rightWrapper);

        // Add layers to root
        root.getChildren().addAll(animatedBackground, contentLayer);

        // --- Staggered entrance animations ---
        SequentialTransition entranceSequence = new SequentialTransition();
        
        // Logo animation
        logoFade.play();
        
        // Main heading animation
        FadeTransition quoteFade = new FadeTransition(Duration.seconds(1), quote);
        quoteFade.setFromValue(0);
        quoteFade.setToValue(1);
        quoteFade.setDelay(Duration.seconds(0.5));
        
        TranslateTransition quoteSlide = new TranslateTransition(Duration.seconds(1), quote);
        quoteSlide.setFromY(30);
        quoteSlide.setToY(0);
        quoteSlide.setDelay(Duration.seconds(0.5));
        
        ParallelTransition quoteEntry = new ParallelTransition(quoteFade, quoteSlide);
        
        // Subtitle animations
        ParallelTransition sub1Entry = createTextEntryAnimation(subText1, 0.8);
        ParallelTransition sub2Entry = createTextEntryAnimation(subText2, 1.0);
        ParallelTransition sub3Entry = createTextEntryAnimation(subText3, 1.2);
        
        // Button animation
        FadeTransition btnFade = new FadeTransition(Duration.seconds(0.8), exploreBtn);
        btnFade.setFromValue(0);
        btnFade.setToValue(1);
        btnFade.setDelay(Duration.seconds(1.5));
        
        ScaleTransition btnScale = new ScaleTransition(Duration.seconds(0.8), exploreBtn);
        btnScale.setFromX(0.8);
        btnScale.setFromY(0.8);
        btnScale.setToX(1.0);
        btnScale.setToY(1.0);
        btnScale.setDelay(Duration.seconds(1.5));
        
        ParallelTransition btnEntry = new ParallelTransition(btnFade, btnScale);
        
        // Right image animation
        FadeTransition imgFade = new FadeTransition(Duration.seconds(1.2), rightImage);
        imgFade.setFromValue(0);
        imgFade.setToValue(1);
        imgFade.setDelay(Duration.seconds(0.8));
        
        TranslateTransition imgSlide = new TranslateTransition(Duration.seconds(1.2), rightImage);
        imgSlide.setFromX(50);
        imgSlide.setToX(0);
        imgSlide.setDelay(Duration.seconds(0.8));
        
        ParallelTransition imgEntry = new ParallelTransition(imgFade, imgSlide);
        
        // Play all animations
        quoteEntry.play();
        sub1Entry.play();
        sub2Entry.play();
        sub3Entry.play();
        btnEntry.play();
        imgEntry.play();

        // Add subtle floating animation to button
        Timeline floatingBtn = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(exploreBtn.translateYProperty(), 0)),
            new KeyFrame(Duration.seconds(2), new KeyValue(exploreBtn.translateYProperty(), -8)),
            new KeyFrame(Duration.seconds(4), new KeyValue(exploreBtn.translateYProperty(), 0))
        );
        floatingBtn.setCycleCount(Timeline.INDEFINITE);
        floatingBtn.setDelay(Duration.seconds(2));
        floatingBtn.play();

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("SmartHire - Your Career Transformation Starts Here");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    private Pane createAnimatedBackground(double width, double height) {
        Pane bgPane = new Pane();
        bgPane.setPrefSize(width, height);
        
        // Create gradient background
        Region gradientBg = new Region();
        gradientBg.setPrefSize(width, height);
        gradientBg.setStyle(
            "-fx-background-color: linear-gradient(to bottom right, #b6bdc6, #298dc7);"
        );
        
        bgPane.getChildren().add(gradientBg);
        
        // Add floating circles for visual interest
        for (int i = 0; i < 8; i++) {
            Circle circle = new Circle();
            circle.setRadius(Math.random() * 80 + 40);
            circle.setFill(Color.rgb(255, 255, 255, 0.05));
            circle.setCenterX(Math.random() * width);
            circle.setCenterY(Math.random() * height);
            
            GaussianBlur blur = new GaussianBlur(20);
            circle.setEffect(blur);
            
            bgPane.getChildren().add(circle);
            
            // Animate circles
            Timeline floatAnimation = new Timeline(
                new KeyFrame(Duration.ZERO, 
                    new KeyValue(circle.translateYProperty(), 0),
                    new KeyValue(circle.translateXProperty(), 0)),
                new KeyFrame(Duration.seconds(8 + Math.random() * 4), 
                    new KeyValue(circle.translateYProperty(), Math.random() * 100 - 50),
                    new KeyValue(circle.translateXProperty(), Math.random() * 100 - 50))
            );
            floatAnimation.setAutoReverse(true);
            floatAnimation.setCycleCount(Timeline.INDEFINITE);
            floatAnimation.setDelay(Duration.seconds(Math.random() * 2));
            floatAnimation.play();
        }
        
        return bgPane;
    }

    private ParallelTransition createTextEntryAnimation(Text text, double delay) {
        FadeTransition fade = new FadeTransition(Duration.seconds(0.8), text);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.setDelay(Duration.seconds(delay));
        
        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.8), text);
        slide.setFromX(-30);
        slide.setToX(0);
        slide.setDelay(Duration.seconds(delay));
        
        return new ParallelTransition(fade, slide);
    }
}