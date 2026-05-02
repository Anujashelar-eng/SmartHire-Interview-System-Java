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

public class CNS  {

    VBox notesLayout;

    
    public Scene creatScene(Stage mainStage) {

        // Optional Icon + Title
        Label titleLabel = new Label("Complete Computer Networks Notes");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        titleLabel.setTextFill(Color.web("#2e86de"));

        // If you have a C++ icon image, uncomment the below:
        // ImageView icon = new ImageView(new Image("cpp_icon.png"));
        // icon.setFitHeight(40);
        // icon.setFitWidth(40);
        // HBox titleBox = new HBox(10, icon, titleLabel);

        // Notes Content
        String fullNotes = """
✅1. Introduction to Computer Networks 
• Definition: A computer network is a group of interconnected computers and devices 
that can communicate and share resources such as files, printers, or internet access. 
 
  Types of Networks 
Type 
Description 
Example 
LAN Covers a small area like office/school College lab 
MAN Covers a city-sized area 
Cable TV network 
WAN Covers large areas, even continents Internet 
 
  Network Topologies 
Topology 
Bus 
Ring 
Diagram (textual) 
A---B---C---D 
Features 
Single backbone, cheap 
A—B—C—D—A (circle) Data moves in a loop 
Star 
Mesh 
Tree 
A, B, C → Hub 
Fully connected 
Hierarchical star 
Central device (Hub/Switch) 
High redundancy 
Combination of star and bus 


  2. OSI Model (Open Systems Interconnection) 
The OSI Model has 7 layers, each with a specific function in network communication. 
 
  OSI Layers: 
1. Application Layer (Layer 7) 
o Interface for the user (web browsers, email) 
o Protocols: HTTP, FTP, SMTP 
2. Presentation Layer (Layer 6) 
o Data translation, encryption, compression 
o Formats data (JPEG, MP4, ASCII) 
3. Session Layer (Layer 5) 
o Establishes, maintains, terminates sessions 
o Example: Session between client and server in a web app 
4. Transport Layer (Layer 4) 
o Reliable transmission of data segments 
o Protocols: TCP (connection-oriented), UDP (connectionless) 
5. Network Layer (Layer 3) 
o Routing and forwarding of packets 
o IP Addressing, ICMP, Routers work here 
6. Data Link Layer (Layer 2) 
o Framing, MAC addressing, error detection 
o Devices: Switches 
7. Physical Layer (Layer 1) 
o Physical media (cables, signals) 
o Devices: Cables, Hubs 
Mnemonic: All People Seem To Need Data Processing 


  3. TCP/IP Model 
More practical than OSI, used in real networks. 
Layer 
Application 
Transport 
Internet 
OSI Equivalent 
Layer 5–7 
Layer 4 
Layer 3 
Network Access Layer 1–2 
Protocols 
HTTP, FTP, DNS 
TCP, UDP 
IP, ICMP 
Ethernet, Wi-Fi 



  4. IP Addressing 
 
  IPv4 
• 32-bit address: e.g., 192.168.1.1 
• Written in dotted decimal format 
 
  IPv4 Classes 
Class 
Range 
Usage 
A 0.0.0.0 – 127.255.255.255 Large networks 
B 128.0.0.0 – 191.255.255.255 Medium 
C 192.0.0.0 – 223.255.255.255 Small networks 
D 224.0.0.0 – 239.255.255.255 Multicasting 
E 
240.0.0.0 – 255.255.255.255 Experimental 
 
  IPv6 
• 128-bit address (e.g., 2001:0db8:85a3::8a2e:0370:7334) 
• Written in hexadecimal 



  5. Subnetting 
• Divides a large network into smaller networks. 
• Example: 192.168.1.0/24 
o /24 means 255.255.255.0 
o 256 IP addresses in that subnet 



  6. Protocols & Ports 
Protocol Port 
Description 
HTTP 80 Web communication 
HTTPS 443 Secure web 
FTP 
21 
SSH 
22 
File transfer 
Secure shell 
DNS 53 Domain resolution 
DHCP 67/68 Dynamic IP allocation 
SMTP 25 Send email 
POP3 110 Receive email 



  7. TCP vs UDP 
Feature 
TCP 
Connection Connection-oriented 
Reliability 
UDP 
Connectionless 
Reliable (ack, retransmission) Unreliable 
Speed 
Use Case 
Slower 
Email, HTTP, FTP 
Protocol Type Stream 
Faster 
Video, DNS, VoIP 
Datagram 



  8. DNS – Domain Name System 
• Translates domain names into IP addresses. 
• Steps: 
1. User types google.com 
2. Query sent to local DNS resolver 
3. Resolver checks cache or queries root → TLD → Authoritative servers 
4. IP address returned 



  9. HTTP vs HTTPS 
Feature 
HTTP 
HTTPS 
Secure? 
Port 
Encryption No 
Used in 
❌ 
80 
✅ 
443 
SSL/TLS 
Normal websites Secure websites (banking, login pages) 



  10. Network Devices 
Device 
Hub 
Description 
Broadcasts all data to all devices 
Switch Sends data to intended device using MAC address 
Router Connects multiple networks 
Bridge Connects two LANs 
Modem Modulates/demodulates for internet 
Repeater Regenerates signal strength 
Gateway Acts as translator between different protocols 



  11. Important Networking Concepts 
• MAC Address: Hardware address, unique for each device. 
• NAT (Network Address Translation): Converts private IP to public. 
• DHCP: Assigns IP addresses automatically. 
• Firewall: Protects network from unauthorized access. 
• Proxy Server: Mediator between client and real server. 
• Latency: Delay in data transmission. 
• Bandwidth: Maximum capacity of a communication link. 



  12. Cybersecurity in Networking 
Term 
Phishing 
Description 
Fake emails/websites for stealing data 
MITM Attack Attacker intercepts communication 
DDoS 
Overloading a server with requests 
Encryption 
SSL/TLS 
Converts data into unreadable form 
Secure communication protocol 



  13. Common Interview Questions 
1. Difference between TCP and UDP? 
2. What is subnetting? Why is it used? 
3. Explain the working of DNS. 
4. What happens when you type a URL in browser? 
5. Compare OSI and TCP/IP models. 
6. What is the purpose of MAC address? 
7. What are private vs public IP addresses? 
8. What is a router vs a switch? 
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

        // Buttons
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

        backButton.setOnMouseEntered(e -> backButton.setStyle(buttonStyle.replace("#2ecc71", "#c0392b")));
        backButton.setOnMouseExited(e -> backButton.setStyle(buttonStyle.replace("#2ecc71", "#e74c3c")));

        downloadBtn.setOnAction(e -> printToPDF());
        backButton.setOnAction(e -> {
            Fundamentals fundamentalsPage = new Fundamentals();
            Scene fundamentalsScene = fundamentalsPage.createScene(mainStage);
            mainStage.setScene(fundamentalsScene);
        });

        HBox buttonRow = new HBox(20, downloadBtn, backButton);
        buttonRow.setAlignment(Pos.CENTER);

        // Notes Layout with shadow effect
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

        // Root Layout
        VBox root = new VBox(notesLayout);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f0f0f0;");

        Scene scene = new Scene(root, 1000, 820);
        return scene;
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