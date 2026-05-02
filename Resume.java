package com.smartf;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDFont;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Resume {

    private static final String[] SECTIONS = {
            "Personal Information",
            "Professional Summary", 
            "Contact Details",
            "Education",
            "Professional Experience",
            "Skills",
            "Projects",
            "Certifications",
            "Internships",
            "Publications",
            "Awards & Achievements",
            "Languages",
            "Hobbies & Interests"
    };

    private final LinkedHashMap<String, String> sectionContent = new LinkedHashMap<>();
    private VBox previewBox;
    private Stage mainStage;
    private Runnable backAction;
    private Label statusLabel;
    private ComboBox<String> templateSelector;

    public Resume(Stage mainStage, Runnable backAction) {
        this.mainStage = mainStage;
        this.backAction = backAction;
    }

    public Scene createScene() {
        // Left Panel - Section Input
        VBox sectionBox = createSectionPanel();
        
        // Right Panel - Preview
        VBox previewPanel = createPreviewPanel();
        
        // Main Content Area
        HBox contentBox = new HBox(25, sectionBox, previewPanel);
        contentBox.setPadding(new Insets(20));
        contentBox.setAlignment(Pos.CENTER);
        
        // Header
        VBox header = createHeader();
        
        // Footer with status
        HBox footer = createFooter();
        
        // Main Layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(header);
        mainLayout.setCenter(contentBox);
        mainLayout.setBottom(footer);
        
        // Root with gradient background
        StackPane root = new StackPane(mainLayout);
        root.setStyle("-fx-background-color: linear-gradient(135deg, #667eea 0%, #764ba2 100%);");
        
        return new Scene(root, 1400, 850);
    }

    private VBox createHeader() {
        Label title = new Label("✨ Professional Resume Builder");
        title.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: white; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 10, 0, 0, 2);");
        
        Label subtitle = new Label("Create your perfect resume in minutes");
        subtitle.setStyle("-fx-font-size: 16px; -fx-text-fill: rgba(255,255,255,0.9);");
        
        // Template selector
        Label templateLabel = new Label("Resume Template:");
        templateLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");
        
        templateSelector = new ComboBox<>();
        templateSelector.getItems().addAll("Professional", "Modern", "Classic", "Minimal");
        templateSelector.setValue("Professional");
        templateSelector.setStyle("-fx-background-color: white; -fx-background-radius: 5;");
        
        HBox templateBox = new HBox(10, templateLabel, templateSelector);
        templateBox.setAlignment(Pos.CENTER);
        
        VBox headerBox = new VBox(8, title, subtitle, templateBox);
        headerBox.setAlignment(Pos.CENTER);
        headerBox.setPadding(new Insets(25, 20, 20, 20));
        
        return headerBox;
    }

    private VBox createSectionPanel() {
        VBox sectionBox = new VBox(12);
        sectionBox.setPadding(new Insets(25));
        sectionBox.setAlignment(Pos.TOP_CENTER);
        sectionBox.setMaxWidth(450);
        sectionBox.setStyle("-fx-background-color: white; -fx-background-radius: 15; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 15, 0, 0, 5);");

        Label sectionTitle = new Label("📝 Resume Sections");
        sectionTitle.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #667eea;");
        
        Separator separator = new Separator();
        
        VBox buttonsBox = new VBox(10);
        for (String section : SECTIONS) {
            Button btn = createSectionButton(section);
            buttonsBox.getChildren().add(btn);
        }

        ScrollPane scrollPane = new ScrollPane(buttonsBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setMaxHeight(500);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent;");
        
        // Action buttons
        HBox actionButtons = createActionButtons();
        
        sectionBox.getChildren().addAll(sectionTitle, separator, scrollPane, actionButtons);
        
        return sectionBox;
    }

    private HBox createActionButtons() {
        Button generateBtn = new Button("📄 Generate PDF");
        generateBtn.setStyle("-fx-background-color: #667eea; -fx-text-fill: white; " +
                "-fx-font-weight: bold; -fx-font-size: 16px; -fx-background-radius: 8; " +
                "-fx-padding: 12 25; -fx-cursor: hand;");
        generateBtn.setOnMouseEntered(e -> generateBtn.setStyle(
                "-fx-background-color: #5568d3; -fx-text-fill: white; " +
                "-fx-font-weight: bold; -fx-font-size: 16px; -fx-background-radius: 8; " +
                "-fx-padding: 12 25; -fx-cursor: hand; " +
                "-fx-effect: dropshadow(gaussian, #667eea, 10, 0.5, 0, 3);"));
        generateBtn.setOnMouseExited(e -> generateBtn.setStyle(
                "-fx-background-color: #667eea; -fx-text-fill: white; " +
                "-fx-font-weight: bold; -fx-font-size: 16px; -fx-background-radius: 8; " +
                "-fx-padding: 12 25; -fx-cursor: hand;"));
        generateBtn.setOnAction(e -> {
            if (validateResume()) {
                try {
                    generatePDFResume();
                } catch (IOException ex) {
                    showError("Failed to generate PDF: " + ex.getMessage());
                }
            }
        });

        Button clearBtn = new Button("🗑️ Clear All");
        clearBtn.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; " +
                "-fx-font-weight: bold; -fx-font-size: 16px; -fx-background-radius: 8; " +
                "-fx-padding: 12 25; -fx-cursor: hand;");
        clearBtn.setOnMouseEntered(e -> clearBtn.setStyle(
                "-fx-background-color: #c0392b; -fx-text-fill: white; " +
                "-fx-font-weight: bold; -fx-font-size: 16px; -fx-background-radius: 8; " +
                "-fx-padding: 12 25; -fx-cursor: hand; " +
                "-fx-effect: dropshadow(gaussian, #e74c3c, 10, 0.5, 0, 3);"));
        clearBtn.setOnMouseExited(e -> clearBtn.setStyle(
                "-fx-background-color: #e74c3c; -fx-text-fill: white; " +
                "-fx-font-weight: bold; -fx-font-size: 16px; -fx-background-radius: 8; " +
                "-fx-padding: 12 25; -fx-cursor: hand;"));
        clearBtn.setOnAction(e -> clearAllSections());

        HBox actionBox = new HBox(15, generateBtn, clearBtn);
        actionBox.setAlignment(Pos.CENTER);
        actionBox.setPadding(new Insets(15, 0, 0, 0));
        
        return actionBox;
    }

    private VBox createPreviewPanel() {
        Label previewTitle = new Label("👁️ Live Preview");
        previewTitle.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #667eea;");
        
        previewBox = new VBox(15);
        previewBox.setPadding(new Insets(20));
        previewBox.setStyle("-fx-background-color: #f8f9fa; -fx-background-radius: 10;");
        
        Label emptyLabel = new Label("Your resume preview will appear here");
        emptyLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #95a5a6; -fx-font-style: italic;");
        previewBox.getChildren().add(emptyLabel);

        ScrollPane previewScroll = new ScrollPane(previewBox);
        previewScroll.setFitToWidth(true);
        previewScroll.setPrefWidth(650);
        previewScroll.setStyle("-fx-background-color: transparent; -fx-background: transparent;");
        
        VBox previewContainer = new VBox(15, previewTitle, new Separator(), previewScroll);
        previewContainer.setPadding(new Insets(25));
        previewContainer.setStyle("-fx-background-color: white; -fx-background-radius: 15; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 15, 0, 0, 5);");
        previewContainer.setMaxWidth(700);
        
        return previewContainer;
    }

    private HBox createFooter() {
        Button backButton = new Button("← Back");
        backButton.setStyle("-fx-background-color: rgba(255,255,255,0.2); -fx-text-fill: white; " +
                "-fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 8; " +
                "-fx-padding: 10 20; -fx-cursor: hand;");
        backButton.setOnMouseEntered(e -> backButton.setStyle(
                "-fx-background-color: rgba(255,255,255,0.3); -fx-text-fill: white; " +
                "-fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 8; " +
                "-fx-padding: 10 20; -fx-cursor: hand;"));
        backButton.setOnMouseExited(e -> backButton.setStyle(
                "-fx-background-color: rgba(255,255,255,0.2); -fx-text-fill: white; " +
                "-fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 8; " +
                "-fx-padding: 10 20; -fx-cursor: hand;"));
        backButton.setOnAction(e -> backAction.run());

        statusLabel = new Label("Ready to create your resume");
        statusLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        HBox footer = new HBox(20, backButton, spacer, statusLabel);
        footer.setPadding(new Insets(15, 25, 15, 25));
        footer.setAlignment(Pos.CENTER_LEFT);
        
        return footer;
    }

    private Button createSectionButton(String section) {
        // Add icon based on section
        String icon = getSectionIcon(section);
        Button btn = new Button(icon + " " + section);
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setAlignment(Pos.CENTER_LEFT);
        btn.setStyle("-fx-font-size: 14px; -fx-background-color: #f8f9fa; " +
                "-fx-border-color: #dee2e6; -fx-border-radius: 8; -fx-background-radius: 8; " +
                "-fx-padding: 12 20; -fx-cursor: hand;");
        
        // Check if section has content
        if (sectionContent.containsKey(section)) {
            btn.setStyle("-fx-font-size: 14px; -fx-background-color: #d4edda; " +
                    "-fx-border-color: #28a745; -fx-border-width: 2; -fx-border-radius: 8; " +
                    "-fx-background-radius: 8; -fx-padding: 12 20; -fx-cursor: hand;");
        }
        
        btn.setOnMouseEntered(e -> {
            if (sectionContent.containsKey(section)) {
                btn.setStyle("-fx-font-size: 14px; -fx-background-color: #c3e6cb; " +
                        "-fx-border-color: #28a745; -fx-border-width: 2; -fx-border-radius: 8; " +
                        "-fx-background-radius: 8; -fx-padding: 12 20; -fx-cursor: hand; " +
                        "-fx-effect: dropshadow(gaussian, rgba(40,167,69,0.3), 8, 0, 0, 2);");
            } else {
                btn.setStyle("-fx-font-size: 14px; -fx-background-color: #e9ecef; " +
                        "-fx-border-color: #667eea; -fx-border-width: 2; -fx-border-radius: 8; " +
                        "-fx-background-radius: 8; -fx-padding: 12 20; -fx-cursor: hand; " +
                        "-fx-effect: dropshadow(gaussian, rgba(102,126,234,0.3), 8, 0, 0, 2);");
            }
        });
        
        btn.setOnMouseExited(e -> {
            if (sectionContent.containsKey(section)) {
                btn.setStyle("-fx-font-size: 14px; -fx-background-color: #d4edda; " +
                        "-fx-border-color: #28a745; -fx-border-width: 2; -fx-border-radius: 8; " +
                        "-fx-background-radius: 8; -fx-padding: 12 20; -fx-cursor: hand;");
            } else {
                btn.setStyle("-fx-font-size: 14px; -fx-background-color: #f8f9fa; " +
                        "-fx-border-color: #dee2e6; -fx-border-radius: 8; -fx-background-radius: 8; " +
                        "-fx-padding: 12 20; -fx-cursor: hand;");
            }
        });
        
        btn.setOnAction(e -> openInputDialog(section));
        return btn;
    }

    private String getSectionIcon(String section) {
        switch (section) {
            case "Personal Information": return "👤";
            case "Professional Summary": return "📋";
            case "Contact Details": return "📞";
            case "Education": return "🎓";
            case "Professional Experience": return "💼";
            case "Skills": return "⚡";
            case "Projects": return "🚀";
            case "Certifications": return "🏆";
            case "Internships": return "💡";
            case "Publications": return "📚";
            case "Awards & Achievements": return "🌟";
            case "Languages": return "🌍";
            case "Hobbies & Interests": return "🎨";
            default: return "📌";
        }
    }

    private void openInputDialog(String sectionTitle) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle(sectionTitle);
        dialog.setHeaderText("Enter information for: " + sectionTitle);
        
        TextArea inputArea = new TextArea();
        inputArea.setWrapText(true);
        inputArea.setPrefRowCount(10);
        inputArea.setPrefColumnCount(50);
        inputArea.setPromptText(getPromptText(sectionTitle));
        inputArea.setStyle("-fx-font-size: 14px; -fx-font-family: 'Segoe UI', Arial;");

        if (sectionContent.containsKey(sectionTitle)) {
            inputArea.setText(sectionContent.get(sectionTitle));
        }

        VBox content = new VBox(10);
        content.setPadding(new Insets(20));
        content.getChildren().addAll(
                new Label("Tip: " + getTip(sectionTitle)),
                inputArea
        );

        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.getDialogPane().setPrefWidth(600);

        dialog.showAndWait().ifPresent(result -> {
            if (result == ButtonType.OK) {
                String text = inputArea.getText().trim();
                if (!text.isEmpty()) {
                    sectionContent.put(sectionTitle, text);
                    updateStatus("Added: " + sectionTitle);
                } else {
                    sectionContent.remove(sectionTitle);
                    updateStatus("Removed: " + sectionTitle);
                }
                updatePreview();
                // Refresh the button panel to show updated status
                Scene scene = mainStage.getScene();
                if (scene != null) {
                    mainStage.setScene(createScene());
                }
            }
        });
    }

    private String getPromptText(String section) {
        switch (section) {
            case "Personal Information":
                return "Full Name\nDate of Birth\nNationality\nMarital Status";
            case "Professional Summary":
                return "Write a brief professional summary (2-3 sentences) highlighting your key strengths and career objectives...";
            case "Contact Details":
                return "Email: your.email@example.com\nPhone: +91 XXXXXXXXXX\nLinkedIn: linkedin.com/in/yourprofile\nAddress: City, State, Country";
            case "Education":
                return "Degree | University | Year | CGPA/Percentage\nExample:\nB.Tech Computer Science | IIT Delhi | 2020-2024 | 8.5 CGPA";
            case "Professional Experience":
                return "Job Title | Company Name | Duration\n• Achievement/Responsibility 1\n• Achievement/Responsibility 2";
            case "Skills":
                return "Technical Skills:\n• Programming: Java, Python, C++\n• Web: HTML, CSS, JavaScript\n• Databases: MySQL, MongoDB\n\nSoft Skills:\n• Leadership, Communication, Problem-solving";
            default:
                return "Enter details for " + section + "...";
        }
    }

    private String getTip(String section) {
        switch (section) {
            case "Professional Summary":
                return "Keep it concise and impactful. Highlight your unique value proposition.";
            case "Professional Experience":
                return "Use action verbs and quantify achievements where possible.";
            case "Skills":
                return "Categorize skills (Technical, Soft Skills, Tools, etc.) for better readability.";
            case "Education":
                return "List in reverse chronological order (most recent first).";
            default:
                return "Provide clear and relevant information.";
        }
    }

    private void updatePreview() {
        previewBox.getChildren().clear();
        
        if (sectionContent.isEmpty()) {
            Label emptyLabel = new Label("Your resume preview will appear here");
            emptyLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #95a5a6; -fx-font-style: italic;");
            previewBox.getChildren().add(emptyLabel);
            return;
        }
        
        for (String sec : SECTIONS) {
            if (sectionContent.containsKey(sec)) {
                VBox block = createPreviewBlock(sec, sectionContent.get(sec));
                previewBox.getChildren().add(block);
            }
        }
    }

    private VBox createPreviewBlock(String title, String content) {
        Label titleLabel = new Label(getSectionIcon(title) + " " + title.toUpperCase());
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #667eea;");
        
        Label contentLabel = new Label(content);
        contentLabel.setWrapText(true);
        contentLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #2c3e50; -fx-line-spacing: 2px;");
        
        Separator sep = new Separator();
        sep.setStyle("-fx-background-color: #667eea;");
        
        VBox block = new VBox(8, titleLabel, sep, contentLabel);
        block.setPadding(new Insets(15));
        block.setStyle("-fx-background-color: white; -fx-background-radius: 10; " +
                "-fx-border-color: #e9ecef; -fx-border-width: 1; -fx-border-radius: 10;");
        
        return block;
    }

    private boolean validateResume() {
        if (sectionContent.isEmpty()) {
            showError("Please add at least one section before generating the resume.");
            return false;
        }
        
        if (!sectionContent.containsKey("Personal Information") && 
            !sectionContent.containsKey("Contact Details")) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Missing Information");
            alert.setHeaderText("Important sections missing");
            alert.setContentText("Personal Information or Contact Details are recommended. Continue anyway?");
            return alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK;
        }
        
        return true;
    }

    private void generatePDFResume() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Resume As PDF");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        fileChooser.setInitialFileName("Resume_" + timestamp + ".pdf");
        
        File file = fileChooser.showSaveDialog(mainStage);
        if (file == null) return;
        
        updateStatus("Generating PDF...");
        
        PDDocument document = new PDDocument();
        createPDFContent(document);
        
        document.save(file);
        document.close();
        
        updateStatus("Resume saved successfully!");
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Resume Generated Successfully!");
        alert.setContentText("Your resume has been saved to:\n" + file.getAbsolutePath());
        alert.showAndWait();
    }

    private void createPDFContent(PDDocument document) throws IOException {
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        
        PDPageContentStream content = new PDPageContentStream(document, page);
        
        float margin = 50;
        float yPosition = 770;
        float pageWidth = PDRectangle.A4.getWidth();
        float contentWidth = pageWidth - 2 * margin;
        
        // Header with colored background
        content.setNonStrokingColor(102/255f, 126/255f, 234/255f);
        content.addRect(0, 750, pageWidth, 50);
        content.fill();
        
        // Title
        content.beginText();
        content.setNonStrokingColor(1, 1, 1);
        content.setFont(PDType1Font.HELVETICA_BOLD, 24);
        content.newLineAtOffset(margin, 765);
        
        String name = extractName();
        content.showText(name);
        content.endText();
        
        yPosition = 730;
        content.setNonStrokingColor(0, 0, 0);
        
        // Generate sections
        for (String section : SECTIONS) {
            if (!sectionContent.containsKey(section)) continue;
            
            if (yPosition < 100) {
                content.close();
                page = new PDPage(PDRectangle.A4);
                document.addPage(page);
                content = new PDPageContentStream(document, page);
                yPosition = 770;
            }
            
            // Section header with line
            content.setNonStrokingColor(102/255f, 126/255f, 234/255f);
            content.beginText();
            content.setFont(PDType1Font.HELVETICA_BOLD, 14);
            content.newLineAtOffset(margin, yPosition);
            content.showText(section.toUpperCase());
            content.endText();
            
            yPosition -= 5;
            content.setLineWidth(1.5f);
            content.moveTo(margin, yPosition);
            content.lineTo(pageWidth - margin, yPosition);
            content.stroke();
            
            yPosition -= 15;
            content.setNonStrokingColor(0, 0, 0);
            
            // Section content
            String text = sectionContent.get(section);
            yPosition = drawMultilineText(content, text, margin + 10, yPosition, 
                    contentWidth - 10, 12, document, page);
            
            yPosition -= 20;
        }
        
        // Footer
        content.setFont(PDType1Font.HELVETICA_OBLIQUE, 9);
        content.setNonStrokingColor(0.5f, 0.5f, 0.5f);
        content.beginText();
        content.newLineAtOffset(margin, 30);
        content.showText("Generated on " + LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        content.endText();
        
        content.close();
    }

    private float drawMultilineText(PDPageContentStream content, String text, 
            float x, float y, float maxWidth, int fontSize, 
            PDDocument document, PDPage currentPage) throws IOException {
        
        PDFont font = PDType1Font.HELVETICA;
        PDFont boldFont = PDType1Font.HELVETICA_BOLD;
        float leading = fontSize * 1.5f;
        
        String[] paragraphs = text.split("\n");
        
        for (String paragraph : paragraphs) {
            if (paragraph.trim().isEmpty()) {
                y -= leading / 2;
                continue;
            }
            
            // Check for bullet points
            boolean isBullet = paragraph.trim().startsWith("•") || 
                              paragraph.trim().startsWith("-") ||
                              paragraph.trim().startsWith("*");
            
            String processedParagraph = paragraph;
            if (isBullet && !paragraph.trim().startsWith("•")) {
                processedParagraph = "• " + paragraph.trim().substring(1).trim();
            }
            
            String[] words = processedParagraph.split(" ");
            StringBuilder line = new StringBuilder();
            
            for (String word : words) {
                String testLine = line.length() == 0 ? word : line + " " + word;
                float width = font.getStringWidth(testLine) / 1000 * fontSize;
                
                if (width > maxWidth && line.length() > 0) {
                    content.beginText();
                    content.setFont(font, fontSize);
                    content.newLineAtOffset(x, y);
                    content.showText(line.toString());
                    content.endText();
                    
                    y -= leading;
                    line = new StringBuilder(word);
                    
                    if (y < 80) {
                        return y; // Signal that new page is needed
                    }
                } else {
                    line = new StringBuilder(testLine);
                }
            }
            
            if (line.length() > 0) {
                content.beginText();
                content.setFont(font, fontSize);
                content.newLineAtOffset(x, y);
                content.showText(line.toString());
                content.endText();
                y -= leading;
            }
        }
        
        return y;
    }

    private String extractName() {
        if (sectionContent.containsKey("Personal Information")) {
            String info = sectionContent.get("Personal Information");
            String[] lines = info.split("\n");
            if (lines.length > 0) {
                return lines[0].trim();
            }
        }
        return "Professional Resume";
    }

    private void clearAllSections() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Clear All");
        alert.setHeaderText("Are you sure?");
        alert.setContentText("This will delete all entered information.");
        
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                sectionContent.clear();
                updatePreview();
                updateStatus("All sections cleared");
                mainStage.setScene(createScene());
            }
        });
    }

    private void updateStatus(String message) {
        if (statusLabel != null) {
            statusLabel.setText(message);
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        updateStatus("Error: " + message);
    }
}