package com.smartf;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

public class Cns2 {

    private final String[][] questions = {
        {"1. In TCP, what is the purpose of the sliding window protocol?", "Error detection", "Flow control", "Congestion control", "Encryption", "Flow control"},
        {"2. Which layer of the OSI model handles reliable transmission of data?", "Network Layer", "Session Layer", "Transport Layer", "Data Link Layer", "Transport Layer"},
        {"3. What is the size of an IPv6 address?", "32 bits", "64 bits", "128 bits", "256 bits", "128 bits"},
        {"4. Which protocol does HTTPS use for secure communication?", "FTP", "TLS/SSL", "HTTP", "SSH", "TLS/SSL"},
        {"5. Which protocol is used to find the MAC address corresponding to an IP address?", "IP", "ICMP", "ARP", "DNS", "ARP"},
        {"6. Which of the following is a distance vector routing protocol?", "OSPF", "RIP", "BGP", "IS-IS", "RIP"},
        {"7. What is the maximum size of a TCP segment?", "64 KB", "16 KB", "65,535 bytes", "1500 bytes", "65,535 bytes"},
        {"8. In which layer does IP operate?", "Transport", "Network", "Data Link", "Physical", "Network"},
        {"9. Which command is used to test the reachability of a host?", "ssh", "telnet", "ping", "ftp", "ping"},
        {"10. What kind of attack does a SYN flood exploit?", "DNS cache poisoning", "ARP spoofing", "TCP 3-way handshake", "IP fragmentation", "TCP 3-way handshake"},
        {"11. Which protocol is used for email retrieval?", "SMTP", "POP3", "SNMP", "FTP", "POP3"},
        {"12. Which protocol is responsible for assigning IP addresses dynamically?", "DNS", "DHCP", "ARP", "ICMP", "DHCP"},
        {"13. In CIDR notation, what does /24 mean?", "24 bits for host", "24 bits for network", "24 total bits", "24 subnets", "24 bits for network"},
        {"14. Which of these uses a connection-oriented protocol?", "UDP", "IP", "TCP", "HTTP", "TCP"},
        {"15. What is the main function of the data link layer?", "Packet routing", "Encryption", "Error detection and framing", "Email transfer", "Error detection and framing"},
        {"16. Which DNS record type maps a domain name to an IP address?", "MX", "A", "CNAME", "PTR", "A"},
        {"17. What is the function of ICMP?", "Data encryption", "Routing table updates", "Error and diagnostic reporting", "File transfer", "Error and diagnostic reporting"},
        {"18. Which protocol works at the application layer and supports file transfer?", "FTP", "ARP", "TCP", "BGP", "FTP"},
        {"19. What technique is used in TCP to avoid congestion?", "Subnetting", "Slow Start", "Flooding", "Token Ring", "Slow Start"},
        {"20. What is the main reason for using NAT (Network Address Translation)?", "Encrypt data", "Increase speed", "Allow multiple devices to share a single public IP", "Load balancing", "Allow multiple devices to share a single public IP"}
    };

    private final ToggleGroup[] toggleGroups = new ToggleGroup[questions.length];

    public Scene createScene(Stage mainStage){
        VBox quizBox = new VBox(15);
        quizBox.setPadding(new Insets(20));

        for (int i = 0; i < questions.length; i++) {
            VBox qBox = new VBox(8);
            qBox.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 6; -fx-padding: 12; -fx-background-color: #fdfdfd; -fx-background-radius: 6;");
            Label qLabel = new Label(questions[i][0]);
            qLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
            ToggleGroup tg = new ToggleGroup();
            toggleGroups[i] = tg;

            for (int j = 1; j <= 4; j++) {
                RadioButton rb = new RadioButton(questions[i][j]);
                rb.setToggleGroup(tg);
                rb.setStyle("-fx-font-size: 13px;");
                qBox.getChildren().add(rb);
            }

            quizBox.getChildren().addAll(qLabel, qBox);
        }

        Button submitBtn = new Button("Submit Quiz");
        submitBtn.setStyle("-fx-background-color: #2a9df4; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 8 16; -fx-background-radius: 6;");
        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: darkblue;");
        resultLabel.setScaleX(0.9);
        resultLabel.setScaleY(0.9);

        Label scoreDetailsLabel = new Label();
        scoreDetailsLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #333;");

        GridPane statusGrid = new GridPane();
        statusGrid.setPadding(new Insets(15));
        statusGrid.setHgap(10);
        statusGrid.setVgap(10);
        statusGrid.setStyle("-fx-background-color: #f0f0f0; -fx-background-radius: 8;");
        Label statusLabel = new Label("Question Status:");
        statusLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        VBox statusContainer = new VBox(10, statusLabel, statusGrid, scoreDetailsLabel);
        statusContainer.setPadding(new Insets(15));

        List<Button> questionButtons = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            Button qButton = new Button("Q" + (i + 1));
            int finalI = i;
            qButton.setPrefSize(60, 40);
            qButton.setStyle("-fx-background-color: cream; -fx-border-color: gray; -fx-font-weight: bold;");
            qButton.setOnMouseEntered(e -> qButton.setScaleX(1.05));
            qButton.setOnMouseExited(e -> qButton.setScaleX(1.0));
            qButton.setOnMousePressed(e -> qButton.setScaleY(0.95));
            qButton.setOnMouseReleased(e -> qButton.setScaleY(1.0));
            qButton.setOnAction(e -> quizBox.getChildren().get(finalI * 2).requestFocus());
            questionButtons.add(qButton);
            statusGrid.add(qButton, i % 4, i / 4);
        }

       //ubmitBtn.setOnMouseEntered(e -> submitBtn.setStyle("-fx-background-color: #1a8be4; -fx-text-fill: white;"));
        //bmitBtn.setOnMouseExited(e -> submitBtn.setStyle("-fx-background-color: #2a9df4; -fx-text-fill: white;"));

        submitBtn.setOnAction(e -> {
            int score = 0, correct = 0, wrong = 0, attempted = 0;

            for (int i = 0; i < questions.length; i++) {
                Toggle selected = toggleGroups[i].getSelectedToggle();
                Button qb = questionButtons.get(i);
                if (selected != null) {
                    attempted++;
                    String selectedAnswer = ((RadioButton) selected).getText();
                    String correctAnswer = questions[i][5];

                    if (selectedAnswer.equals(correctAnswer)) {
                        score++;
                        correct++;
                        animateButtonColor(qb, "#a8e6a1"); // Green
                    } else {
                        wrong++;
                        animateButtonColor(qb, "#f08080"); // Red
                    }
                } else {
                    animateButtonColor(qb, "#ffa500"); // Orange
                }
            }

            resultLabel.setText("Your Score: " + score + " / " + questions.length);
            scoreDetailsLabel.setText("Correct: " + correct + " | Wrong: " + wrong + " | Attempted: " + attempted);
            animateLabelScale(resultLabel);
        });
        Button backBtn = new Button("Back");
        backBtn.setStyle("-fx-background-color: #4a56dbff; -fx-font-size: 16px;");
        backBtn.setOnAction(e -> {
          Fundamentals2 aptitudePage = new Fundamentals2();
        Scene funScene = aptitudePage.createScene(mainStage);
        mainStage.setScene(funScene);
        });

        HBox bottomBox = new HBox(20,backBtn, submitBtn, resultLabel);
        bottomBox.setPadding(new Insets(10));

        ScrollPane scrollPane = new ScrollPane(quizBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefSize(900, 900);

        HBox mainLayout = new HBox(15, scrollPane, statusContainer);
        mainLayout.setPadding(new Insets(15));

        Scene scene = new Scene(new VBox(mainLayout, bottomBox), 900, 600);
        return scene;
    }

    private void animateButtonColor(Button btn, String targetColor) {
        Platform.runLater(() -> btn.setStyle(
            "-fx-background-color: " + targetColor + "; -fx-border-color: gray; -fx-font-weight: bold;"
        ));
    }

    private void animateLabelScale(Label lbl) {
        new Thread(() -> {
            try {
                for (double s = 0.9; s <= 1.1; s += 0.02) {
                    Thread.sleep(10);
                    double fs = s;
                    Platform.runLater(() -> {
                        lbl.setScaleX(fs);
                        lbl.setScaleY(fs);
                    });
                }
                Platform.runLater(() -> {
                    lbl.setScaleX(1.0);
                    lbl.setScaleY(1.0);
                });
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
}
