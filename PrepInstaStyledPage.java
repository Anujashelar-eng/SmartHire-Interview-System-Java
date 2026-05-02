package com.smartf;
import javafx.scene.control.Button;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;

public class PrepInstaStyledPage {

    VBox subMenuBox = new VBox(20);
    private Stage mainStage;
    
    public Scene show(Stage stage) {
        this.mainStage = stage;

        // Get screen dimensions for responsive design
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = screenBounds.getWidth();
        double screenHeight = screenBounds.getHeight();

        // ============ TOP HEADER BAR - Ultra Modern Design ============
        VBox topHeaderContainer = new VBox();
        topHeaderContainer.setStyle(
            "-fx-background-color: linear-gradient(to right, #667eea 0%, #764ba2 100%);" +
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 20, 0, 0, 5);"
        );
        
        // Main Header HBox
        HBox topHeader = new HBox();
        topHeader.setAlignment(Pos.CENTER);
        topHeader.setPadding(new Insets(20, 40, 20, 40));
        topHeader.setPrefHeight(95);

        // Back Button (Glass Morphism Style)
        Button backButton = new Button("← BACK");
        backButton.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.15);" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 15px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 30;" +
            "-fx-border-color: rgba(255, 255, 255, 0.3);" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 30;" +
            "-fx-padding: 14 30;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 8, 0, 0, 2);"
        );
        
        backButton.setOnMouseEntered(e -> {
            backButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-text-fill: #667eea;" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 30;" +
                "-fx-border-color: white;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 30;" +
                "-fx-padding: 14 30;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(gaussian, rgba(255, 255, 255, 0.8), 20, 0, 0, 0);"
            );
            ScaleTransition st = new ScaleTransition(Duration.millis(150), backButton);
            st.setToX(1.05);
            st.setToY(1.05);
            st.play();
        });
        
        backButton.setOnMouseExited(e -> {
            backButton.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.15);" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 30;" +
                "-fx-border-color: rgba(255, 255, 255, 0.3);" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 30;" +
                "-fx-padding: 14 30;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 8, 0, 0, 2);"
            );
            ScaleTransition st = new ScaleTransition(Duration.millis(150), backButton);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
        });

        backButton.setOnAction(e -> {
            try {
                Stage exploreStage = new Stage();
                new Explore().start(exploreStage);
                stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }  
        });

        // // Logo with Premium Container
        // ImageView logoImage = new ImageView(new Image(getClass().getResource("/Assets/Image/smrthirelogo.png").toExternalForm()));
        // logoImage.setFitHeight(60);
        // logoImage.setPreserveRatio(true);
        
        // // Premium logo container with gradient border
        // StackPane logoContainer = new StackPane(logoImage);
        // logoContainer.setAlignment(Pos.CENTER);
        // logoContainer.setStyle(
        //     "-fx-background-color: black;" +
        //     "-fx-background-radius: 18;" +
        //     "-fx-padding: 12 28;" +
        //     "-fx-effect: dropshadow(gaussian, rgba(255, 255, 255, 0.4), 15, 0, 0, 3);"
        // );

        // Title with Premium Styling
        VBox titleBox = new VBox(2);
        titleBox.setAlignment(Pos.CENTER_LEFT);
        
        Label titleLabel = new Label("SMARTHIRE");
        titleLabel.setStyle(
            "-fx-text-fill: white;" +
            "-fx-font-size: 38px;" +
            "-fx-font-weight: bold;" +
            "-fx-font-family: 'Segoe UI', 'Arial', sans-serif;" +
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.5), 8, 0, 0, 3);"
        );
        
        Label subtitleLabel = new Label("Interview Preparation Platform");
        subtitleLabel.setStyle(
            "-fx-text-fill: rgba(255, 255, 255, 0.9);" +
            "-fx-font-size: 13px;" +
            "-fx-font-weight: 600;" +
            "-fx-font-family: 'Segoe UI', 'Arial', sans-serif;"
        );
        
        titleBox.getChildren().addAll(titleLabel, subtitleLabel);

        HBox centerBox = new HBox(25, titleBox);
        centerBox.setAlignment(Pos.CENTER);

        // Right Side - Quick Access Buttons
        HBox rightButtons = new HBox(12);
        rightButtons.setAlignment(Pos.CENTER_RIGHT);
        
        // Profile/User Button
        Button profileButton = new Button("👤");
        profileButton.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.15);" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 18px;" +
            "-fx-background-radius: 50%;" +
            "-fx-min-width: 50;" +
            "-fx-min-height: 50;" +
            "-fx-max-width: 50;" +
            "-fx-max-height: 50;" +
            "-fx-cursor: hand;" +
            "-fx-border-color: rgba(255, 255, 255, 0.3);" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 50%;"
        );
        
        profileButton.setOnMouseEntered(e -> {
            profileButton.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.3);" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 18px;" +
                "-fx-background-radius: 50%;" +
                "-fx-min-width: 50;" +
                "-fx-min-height: 50;" +
                "-fx-max-width: 50;" +
                "-fx-max-height: 50;" +
                "-fx-cursor: hand;" +
                "-fx-border-color: white;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 50%;" +
                "-fx-effect: dropshadow(gaussian, rgba(255, 255, 255, 0.6), 15, 0, 0, 0);"
            );
        });
        
        profileButton.setOnMouseExited(e -> {
            profileButton.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.15);" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 18px;" +
                "-fx-background-radius: 50%;" +
                "-fx-min-width: 50;" +
                "-fx-min-height: 50;" +
                "-fx-max-width: 50;" +
                "-fx-max-height: 50;" +
                "-fx-cursor: hand;" +
                "-fx-border-color: rgba(255, 255, 255, 0.3);" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 50%;"
            );
        });
        
        rightButtons.getChildren().add(profileButton);

        Region leftSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
        Region rightSpacer = new Region();
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);

        topHeader.getChildren().addAll(backButton, leftSpacer, centerBox, rightSpacer, rightButtons);
        
        // Decorative bottom accent line
        HBox accentLine = new HBox();
        accentLine.setPrefHeight(4);
        accentLine.setStyle(
            "-fx-background-color: linear-gradient(to right, #f093fb 0%, #f5576c 50%, #ffd140 100%);"
        );
        
        topHeaderContainer.getChildren().addAll(topHeader, accentLine);

        // ============ LEFT SIDEBAR MENU - Enhanced Design ============
        VBox leftSidebar = new VBox(8);
        leftSidebar.setPadding(new Insets(25, 15, 25, 15));
        leftSidebar.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #667eea 0%, #764ba2 100%);" +
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.25), 12, 0, 2, 0);"
        );
        leftSidebar.setPrefWidth(290);
        leftSidebar.setMaxWidth(290);
        leftSidebar.setMinWidth(290);

        // Decorative top element
        VBox decorTop = new VBox();
        decorTop.setPrefHeight(4);
        decorTop.setStyle(
            "-fx-background-color: linear-gradient(to right, #f093fb 0%, #f5576c 100%);" +
            "-fx-background-radius: 3;"
        );
        leftSidebar.getChildren().add(decorTop);

        // Sidebar Header
        Label sidebarTitle = new Label("MENU");
        sidebarTitle.setStyle(
            "-fx-text-fill: rgba(255, 255, 255, 0.7);" +
            "-fx-font-size: 13px;" +
            "-fx-font-weight: bold;" +
            "-fx-padding: 10 20 5 20;" +
            "-fx-letter-spacing: 2px;"
        );
        leftSidebar.getChildren().add(sidebarTitle);

        // Menu Items
        Label prep = createSidebarLabel("📚  Preparation");
        prep.setOnMouseClicked(e -> setSubMenu("Aptitude", "Fundamentals", "Programming"));           

        Label quiz = createSidebarLabel("❓  Quiz");
        quiz.setOnMouseClicked(e -> setSubMenu("Aptitude Quiz", "Fundamentals Quiz", "Programming Quiz"));

        Label company = createSidebarLabel("🏢  Companies");
        company.setOnMouseClicked(e -> setSubMenu(
                "Accenture", "BNY", "Infosys", "Google", "Cognizant", "Colgate", "Dessult",
                "IBM", "Microsoft", "PTC", "TCS", "Tibco","HCL Technologies","Vmware","Capgemini",
                "Persistant System","Zensar","NovoSoft"));

        Label mock = createSidebarLabel("📝  Mock Test");
        mock.setOnMouseClicked(e -> setSubMenu("Start Test"));
        
        Label mockIN = createSidebarLabel("🎤  Mock Interview");
        mockIN.setOnMouseClicked(e -> setSubMenu("Start Mock Interview >"));

        Label resume = createSidebarLabel("📄  Resume Builder");
        resume.setOnMouseClicked(e -> setSubMenu("Create Your Resume"));

        Label interviewEX = createSidebarLabel("🌟  InterviewEX");
        interviewEX.setOnMouseClicked(e -> setSubMenu("InterviewEX >"));

        Label feedback = createSidebarLabel("💬  Feedback");
        feedback.setOnMouseClicked(e -> setSubMenu("Submit Feedback"));

        Label aboutUs = createSidebarLabel("ℹ️  About Us");
        aboutUs.setOnMouseClicked(e -> setSubMenu("About Us >"));

        Region menuSpacer = new Region();
        VBox.setVgrow(menuSpacer, Priority.ALWAYS);

        leftSidebar.getChildren().addAll(prep, quiz, company, mock, mockIN, resume, interviewEX, feedback, aboutUs, menuSpacer);

        // ============ MAIN CONTENT AREA - Enhanced with Better Scrolling ============
        subMenuBox.setPadding(new Insets(40));
        subMenuBox.setStyle(
            "-fx-background-color: transparent;"
        );

        // Enhanced ScrollPane with smooth scrolling
        ScrollPane scrollPane = new ScrollPane(subMenuBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle(
            "-fx-background: #f8f9fa;" +
            "-fx-background-color: #f8f9fa;" +
            "-fx-border-color: transparent;"
        );
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        // Smooth scrolling
        scrollPane.setVvalue(0);
        scrollPane.setPannable(true);

        VBox mainContent = new VBox(scrollPane);
        VBox.setVgrow(scrollPane, Priority.ALWAYS);
        mainContent.setStyle("-fx-background-color: #f8f9fa;");

        // ============ FOOTER - Modern Design ============
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(18));
        footer.setStyle(
            "-fx-background-color: linear-gradient(to right, #667eea 0%, #764ba2 100%);" +
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 12, 0, 0, -4);"
        );

        Label footerText = new Label("© 2025 SmartHire - Empowering Your Career Journey");
        footerText.setStyle(
            "-fx-text-fill: white;" +
            "-fx-font-size: 14px;" +
            "-fx-font-weight: 600;" +
            "-fx-font-family: 'Segoe UI', 'Arial', sans-serif;"
        );
        footer.getChildren().add(footerText);

        // ============ LAYOUT ASSEMBLY ============
        HBox mainLayout = new HBox(leftSidebar, mainContent);
        HBox.setHgrow(mainContent, Priority.ALWAYS);

        BorderPane root = new BorderPane();
        root.setTop(topHeaderContainer);
        root.setCenter(mainLayout);
        root.setBottom(footer);
        root.setStyle("-fx-background-color: #f8f9fa;");

        // Smooth fade in animation
        FadeTransition pageFade = new FadeTransition(Duration.seconds(0.6), root);
        pageFade.setFromValue(0.0);
        pageFade.setToValue(1.0);
        pageFade.play();

        // Set window to full screen
        stage.setX(screenBounds.getMinX());
        stage.setY(screenBounds.getMinY());
        stage.setWidth(screenWidth);
        stage.setHeight(screenHeight);

        Scene scene = new Scene(root, screenWidth, screenHeight);
        stage.setScene(scene);
        stage.setTitle("SmartHire - Professional Interview Preparation Platform");
        stage.show();
        return scene;
    }

    private Label createSidebarLabel(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 15));
        label.setPadding(new Insets(14, 18, 14, 18));
        label.setMaxWidth(Double.MAX_VALUE);
        label.setStyle(
            "-fx-text-fill: white;" +
            "-fx-background-radius: 12;" +
            "-fx-cursor: hand;" +
            "-fx-background-color: transparent;"
        );
        
        label.setOnMouseEntered(e -> {
            label.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.2);" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 12;" +
                "-fx-cursor: hand;" +
                "-fx-border-color: rgba(255, 255, 255, 0.4);" +
                "-fx-border-width: 0 0 0 4;" +
                "-fx-border-radius: 12;" +
                "-fx-effect: dropshadow(gaussian, rgba(255, 255, 255, 0.3), 12, 0, 0, 0);"
            );
            
            ScaleTransition st = new ScaleTransition(Duration.millis(150), label);
            st.setToX(1.02);
            st.setToY(1.02);
            st.play();
        });
        
        label.setOnMouseExited(e -> {
            label.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 12;" +
                "-fx-cursor: hand;"
            );
            
            ScaleTransition st = new ScaleTransition(Duration.millis(150), label);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
        });
        
        return label;
    }

    private void setSubMenu(String... options) {
        subMenuBox.getChildren().clear();

        // Modern Header with accent
        VBox headerBox = new VBox(8);
        Label headerLabel = new Label("Select an Option");
        headerLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 34));
        headerLabel.setStyle("-fx-text-fill: #2d3748;");
        
        Label subHeader = new Label("Choose from the options below to continue");
        subHeader.setStyle(
            "-fx-text-fill: #718096;" +
            "-fx-font-size: 15px;"
        );
        
        headerBox.getChildren().addAll(headerLabel, subHeader);
        headerBox.setPadding(new Insets(0, 0, 25, 0));
        subMenuBox.getChildren().add(headerBox);

        // Modern Grid Layout
        int columns = Math.min(options.length, 3);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(25);
        gridPane.setVgap(25);
        gridPane.setPadding(new Insets(10));

        int row = 0;
        int col = 0;

        for (String option : options) {
            VBox optionCard = createOptionCard(option);
            gridPane.add(optionCard, col, row);
            
            col++;
            if (col >= columns) {
                col = 0;
                row++;
            }
        }

        subMenuBox.getChildren().add(gridPane);
    }

    private VBox createOptionCard(String optText) {
        VBox card = new VBox(18);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(30));
        card.setPrefWidth(300);
        card.setPrefHeight(200);
        card.setStyle(
            "-fx-background-color: white;" +
            "-fx-background-radius: 20;" +
            "-fx-border-color: #e2e8f0;" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 20;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.08), 15, 0, 0, 5);"
        );

        ImageView logo = getLogoForOption(optText);
        
        if (logo != null) {
            logo.setFitWidth(75);
            logo.setFitHeight(75);
            logo.setPreserveRatio(true);
            
            // Add subtle animation on card
            StackPane logoContainer = new StackPane(logo);
            logoContainer.setPrefSize(90, 90);
            logoContainer.setStyle(
                "-fx-background-color: linear-gradient(135deg, #667eea 0%, #764ba2 100%);" +
                "-fx-background-radius: 50%;" +
                "-fx-padding: 10;" +
                "-fx-effect: dropshadow(gaussian, rgba(102, 126, 234, 0.3), 10, 0, 0, 4);"
            );
            card.getChildren().add(logoContainer);
        }
        
        Label optLabel = new Label(optText);
        optLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 17));
        optLabel.setStyle(
            "-fx-text-fill: #2d3748;" +
            "-fx-text-alignment: center;"
        );
        optLabel.setWrapText(true);
        optLabel.setMaxWidth(260);
        card.getChildren().add(optLabel);

        addClickHandler(card, optText);

        card.setOnMouseEntered(e -> {
            card.setStyle(
                "-fx-background-color: linear-gradient(135deg, #667eea 0%, #764ba2 100%);" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: transparent;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 20;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(gaussian, rgba(102, 126, 234, 0.5), 25, 0, 0, 10);"
            );
            optLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
            
            ScaleTransition st = new ScaleTransition(Duration.millis(200), card);
            st.setToX(1.05);
            st.setToY(1.05);
            st.play();
        });
        
        card.setOnMouseExited(e -> {
            card.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #e2e8f0;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 20;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.08), 15, 0, 0, 5);"
            );
            optLabel.setStyle("-fx-text-fill: #2d3748; -fx-font-weight: bold;");
            
            ScaleTransition st = new ScaleTransition(Duration.millis(200), card);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
        });

        return card;
    }

    private ImageView getLogoForOption(String optText) {
        ImageView logo = null;
        try {
            if (optText.equals("Accenture")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/Accenture-Logo.png").toExternalForm()));
            } else if (optText.equals("BNY")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/BNY.png").toExternalForm()));
            } else if (optText.equals("Infosys")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/infosys.png").toExternalForm()));
            } else if (optText.equals("Google")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/Google.png").toExternalForm()));
            } else if (optText.equals("Cognizant")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/Cognizant.png").toExternalForm()));
            } else if (optText.equals("Colgate")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/colgate.png").toExternalForm()));
            } else if (optText.equals("Dessult")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/dessult.png").toExternalForm()));
            } else if (optText.equals("IBM")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/IBM.png").toExternalForm()));
            } else if (optText.equals("Microsoft")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/microsoft.png").toExternalForm()));
            } else if (optText.equals("PTC")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/PTC.png").toExternalForm()));
            } else if (optText.equals("TCS")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/TCS.png").toExternalForm()));
            } else if (optText.equals("Tibco")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/tibco.jpeg").toExternalForm()));
            } else if (optText.equals("HCL Technologies")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/HCL_Technologies-Logo.wine.png").toExternalForm()));
            } else if (optText.equals("Persistant System")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/persistant.jpeg").toExternalForm()));
            } else if (optText.equals("Vmware")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/Vmware.png").toExternalForm()));
            } else if (optText.equals("Capgemini")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/capgemini.png").toExternalForm()));
            } else if (optText.equals("Zensar")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/Zensar.jpg").toExternalForm()));
            } else if (optText.equals("NovoSoft")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/Novosoft.png").toExternalForm()));
            } else if (optText.equals("Aptitude")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/apti.png").toExternalForm()));
            } else if (optText.equals("Programming")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/programming.png").toExternalForm()));
            } else if (optText.equals("Fundamentals")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/Prepeartion.png").toExternalForm()));
            } else if (optText.equals("Aptitude Quiz")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/atiQuiz.png").toExternalForm()));
            } else if (optText.equals("Programming Quiz")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/ProgramQuiz.png").toExternalForm()));
            } else if (optText.equals("Fundamentals Quiz")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/fund1Quiz.png").toExternalForm()));
            } else if (optText.equals("InterviewEX >")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/feedback1.png").toExternalForm()));
            } else if (optText.equals("Start Test")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/apti1mock.png").toExternalForm()));
            } else if (optText.equals("Submit Feedback")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/feedback1.png").toExternalForm()));
            } else if (optText.equals("About Us >")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/Aboutus.jpeg").toExternalForm()));
            } else if (optText.equals("Create Your Resume")) {
                logo = new ImageView(new Image(getClass().getResource("/Assets/Image/resume.png").toExternalForm()));
            }
        } catch (Exception e) {
            // Logo not found, return null
        }
        return logo;
    }

    private void addClickHandler(VBox card, String optText) {
        if (optText.equals("Aptitude Quiz")) {
            card.setOnMouseClicked(event -> openAptitude2Page());
        } else if (optText.equals("Programming Quiz")) {
            card.setOnMouseClicked(event -> openProgrammings2Page());
        } else if (optText.equals("Fundamentals Quiz")) {
            card.setOnMouseClicked(event -> openFundamental2Page());
        } else if (optText.equals("Aptitude")) {
            card.setOnMouseClicked(event -> openAptitudePage());
        } else if (optText.equals("Programming")) {
            card.setOnMouseClicked(event -> openProgrammingsPage());
        } else if (optText.equals("Fundamentals")) {
            card.setOnMouseClicked(event -> openFundamentalPage());
        } else if (optText.equals("About Us >")) {
            card.setOnMouseClicked(event -> openAboutUSPage());
        } else if (optText.equals("Start Mock Interview >")) {
            card.setOnMouseClicked(event -> openMockInterviewPage());
        } else if (optText.equals("Accenture")) {
            card.setOnMouseClicked(event -> openAccenturePage());
        } else if (optText.equals("PTC")) {
            card.setOnMouseClicked(event -> openPTCPage());
        } else if (optText.equals("Cognizant")) {
            card.setOnMouseClicked(event -> openCognizantPage());
        } else if (optText.equals("Capgemini")) {
            card.setOnMouseClicked(event -> openCapgeminiPage());
        } else if (optText.equals("Google")) {
            card.setOnMouseClicked(event -> openGooglePage());
        } else if (optText.equals("Start Test")) {
            card.setOnMouseClicked(event -> openMockTestPage());
        } else if (optText.equals("InterviewEX >")) {
            card.setOnMouseClicked(event -> openStudentEXPage());
        } else if (optText.equals("Submit Feedback")) {
            card.setOnMouseClicked(event -> openFeedbackPage());
        } else if (optText.equals("Create Your Resume")) {
            card.setOnMouseClicked(event -> openResumePage());
        }
    }

    // Navigation methods
    private void openMockInterviewPage() {
        Mock_Interview mi = new Mock_Interview();
        Scene InterviewScene = mi.creatScene(mainStage, () -> show(mainStage));
        mainStage.setScene(InterviewScene);
    }

    private void openAboutUSPage() {
        about as = new about();
        Scene AboutScene = as.createScene(mainStage, () -> show(mainStage));
        mainStage.setScene(AboutScene);
    }

    private void openAccenturePage() {
        AccenturePage accenturePage = new AccenturePage();
        Scene accentureScene = accenturePage.creatScene(mainStage, () -> show(mainStage));
        mainStage.setScene(accentureScene);
    }

    private void openPTCPage() {
        PTC ptcPage = new PTC();
        Scene PTCScene = ptcPage.creatScene(mainStage, () -> show(mainStage));
        mainStage.setScene(PTCScene);
    }

    private void openCapgeminiPage() {
        Capgemini cp = new Capgemini();
        Scene CapgeminiScene = cp.creatScene(mainStage, () -> show(mainStage));
        mainStage.setScene(CapgeminiScene);
    }

    private void openGooglePage() {
        Google gl = new Google();
        Scene GoogleScene = gl.creatScene(mainStage, () -> show(mainStage));
        mainStage.setScene(GoogleScene);
    }

    private void openCognizantPage() {
        Cognizant cg = new Cognizant();
        Scene CognizantScene = cg.creatScene(mainStage, () -> show(mainStage));
        mainStage.setScene(CognizantScene);
    }

    private void openStudentEXPage() {
        FresherEX ex = new FresherEX();
        Scene fresherExScene = ex.creatScene(mainStage, () -> show(mainStage));
        mainStage.setScene(fresherExScene);
    }

    private void openAptitudePage() {
        Aptitude aptitudePage = new Aptitude();
        try {
            Scene aptitudeScene = aptitudePage.createScene(mainStage);
            mainStage.setScene(aptitudeScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openProgrammingsPage() {
        programming pr = new programming();
        Scene programmingScene = pr.creatScene(mainStage);
        mainStage.setScene(programmingScene);
    }

    private void openFundamentalPage() {
        Fundamentals fundamentalsPage = new Fundamentals();
        Scene fundamentalsScene = fundamentalsPage.createScene(mainStage);
        mainStage.setScene(fundamentalsScene);
    }

    private void openAptitude2Page() {
        Aptitude2 aptitudePage = new Aptitude2();
        try {
            Scene aptitudeScene = aptitudePage.createScene(mainStage);
            mainStage.setScene(aptitudeScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openProgrammings2Page() {
        Programming2 pr = new Programming2();
        Scene programmingScene = pr.creatScene(mainStage);
        mainStage.setScene(programmingScene);
    }

    private void openFundamental2Page() {
        Fundamentals2 fundamentalsPage = new Fundamentals2();
        Scene fundamentalsScene = fundamentalsPage.createScene(mainStage);
        mainStage.setScene(fundamentalsScene);
    }

    private void openMockTestPage() {
        Mock_Test1 mockTestPage = new Mock_Test1();
        try {
            Scene mockTestScene = mockTestPage.creatScene(mainStage, () -> show(mainStage));
            mainStage.setScene(mockTestScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openResumePage() {
        Resume resumePage = new Resume(mainStage, () -> {
            show(mainStage);
        });
        Scene resumeScene = resumePage.createScene();
        mainStage.setScene(resumeScene);
    }

    private void openFeedbackPage() {
        Feedbackpage feedbackPage = new Feedbackpage();
        try {
            Scene feedbackScene = feedbackPage.createScene(mainStage, () -> show(mainStage));
            mainStage.setScene(feedbackScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Scene createMainScene(Stage mainStage2) {
        throw new UnsupportedOperationException("Unimplemented method 'createMainScene'");
    }
}