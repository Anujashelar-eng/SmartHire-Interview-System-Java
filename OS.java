package com.smartf;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class OS {

    VBox notesLayout;

    public Scene createScene(Stage mainStage) {

        Label titleLabel = new Label("Complete Operating System Notes");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        titleLabel.setTextFill(Color.web("#2e86de"));

        String fullNotes = """
✅✅  
1. Introduction to OS 
• OS is system software that manages computer hardware and software resources.
• Functions: Process, Memory, File, Device, Security, UI.
• Examples: Windows, Linux, macOS, Android.

2. Types of OS
• Batch, Time-Sharing, Distributed, Real-Time, Embedded.

3. Process Management
• Process states, PCB, Context Switching, Threads.

4. CPU Scheduling
• FCFS, SJF, Priority, Round Robin, Multilevel Queue.

5. IPC
• Shared Memory, Message Passing, Mutex, Semaphore, Monitors.

6. Deadlock
• 4 conditions, Banker's Algorithm, Prevention, Detection.

7. Memory Management
• Paging, Segmentation, Virtual Memory, FIFO, LRU, Thrashing.

8. File System
• File Ops, Directory Structures, Contiguous, Linked, Indexed.

9. Disk Scheduling
• FCFS, SSTF, SCAN, C-SCAN, LOOK, C-LOOK.

10. I/O Management
• Buffering, Caching, Spooling, Drivers.

11. Virtualization
• Hypervisor Type 1 & 2.

12. Security
• Authentication, Authorization, Encryption, ACL.

⭐ Interview Topics: Process vs Thread, Deadlock, Paging, Scheduling, Banker Algorithm, LRU vs FIFO.
""";

        TextArea notesArea = new TextArea(fullNotes);
        notesArea.setWrapText(true);
        notesArea.setEditable(false);
        notesArea.setFont(Font.font("Consolas", 14));
        notesArea.setStyle("""
            -fx-control-inner-background: #fefefe;
            -fx-font-family: 'Consolas';
            -fx-font-size: 14px;
            -fx-text-fill: black;
            -fx-border-color: lightgray;
            -fx-border-radius: 5;
            -fx-focus-color: transparent;
        """);

        ScrollPane scrollPane = new ScrollPane(notesArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setPrefViewportHeight(600);

        Button downloadBtn = new Button("Download PDF");
        Button backButton = new Button("← Back");

        String buttonStyle = """
            -fx-background-color: #2ecc71;
            -fx-text-fill: white;
            -fx-font-size: 14px;
            -fx-padding: 8 16 8 16;
            -fx-background-radius: 6;
        """;

        downloadBtn.setStyle(buttonStyle);
        backButton.setStyle(buttonStyle.replace("#2ecc71", "#e74c3c"));

        downloadBtn.setOnMouseEntered(e -> downloadBtn.setStyle(buttonStyle.replace("#2ecc71", "#27ae60")));
        downloadBtn.setOnMouseExited(e -> downloadBtn.setStyle(buttonStyle));

        backButton.setOnMouseEntered(e -> backButton.setStyle(buttonStyle.replace("#e74c3c", "#c0392b")));
        backButton.setOnMouseExited(e -> backButton.setStyle(buttonStyle.replace("#c0392b", "#e74c3c")));

        downloadBtn.setOnAction(e -> printToPDF());

        backButton.setOnAction(e -> {
            Fundamentals fundamentalsPage = new Fundamentals();
            Scene fundamentalsScene = fundamentalsPage.createScene(mainStage);
            mainStage.setScene(fundamentalsScene);
        });

        HBox buttonRow = new HBox(20, downloadBtn, backButton);
        buttonRow.setAlignment(Pos.CENTER);

        notesLayout = new VBox(20, titleLabel, scrollPane, buttonRow);
        notesLayout.setAlignment(Pos.TOP_CENTER);
        notesLayout.setPadding(new Insets(20));
        notesLayout.setMaxWidth(1000);
        notesLayout.setStyle("""
            -fx-background-color: white;
            -fx-border-color: #dcdde1;
            -fx-border-width: 1px;
            -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 8, 0, 0, 4);
            -fx-background-radius: 10;
            -fx-border-radius: 10;
        """);

        VBox root = new VBox(notesLayout);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f0f0f0;");

        return new Scene(root, 1000, 820);
    }

    public void printToPDF() {
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null && job.showPrintDialog(null)) {
            boolean success = job.printPage(notesLayout);
            if (success) {
                job.endJob();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "PDF Saved Successfully!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to save PDF.");
                alert.showAndWait();
            }
        }
    }
}
