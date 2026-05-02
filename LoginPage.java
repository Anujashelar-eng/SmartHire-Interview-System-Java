package com.smartf;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
// import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPage  {

    
    public void show(Stage stage) {
        // --- LEFT PANEL ---
        VBox leftPane = new VBox(15);
        leftPane.setPadding(new Insets(60));
        leftPane.setAlignment(Pos.CENTER_LEFT);
        leftPane.setStyle("-fx-background-color: white;");
        leftPane.setPrefWidth(500);

        Label logo = new Label("SmartHire");
        logo.setFont(Font.font("Arial", 28));
        logo.setTextFill(Color.web("#0096FF"));

        Label welcomeText = new Label("Welcome to SmartHire\nSign into your account");
        welcomeText.setFont(Font.font("Arial", 20));
        welcomeText.setTextFill(Color.web("#222222"));

        TextField emailField = new TextField();
        emailField.setPromptText("Phone or Email address");
        emailField.setStyle("-fx-background-radius: 10; -fx-border-radius: 10;");
        emailField.setPrefHeight(40);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setStyle("-fx-background-radius: 10; -fx-border-radius: 10;");
        passwordField.setPrefHeight(40);

        Button loginBtn = new Button("Login");
        loginBtn.setPrefHeight(40);
        loginBtn.setPrefWidth(80);
        loginBtn.setStyle("-fx-background-color: #0096FF; -fx-text-fill: white; -fx-background-radius: 10;");
        loginBtn.setAlignment(Pos.CENTER);
        Label resultLabel=new Label();

        Button backButton = new Button("← Back");
        backButton.setPrefHeight(40);
        backButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #0096FF; -fx-font-size: 14;");
                    backButton.setOnAction(e -> {
                try {
                    new Explore().start(new Stage()); // Navigate back to Explore
                    stage.close();                    // Close the current Login window
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

       
        loginBtn.setOnAction(e -> {
    String email = emailField.getText();
    String password = passwordField.getText();
    boolean success = signInWithEmailAndPassword(email, password);

    if (success) {
        resultLabel.setText("Login successful");
        PrepInstaStyledPage prepPage = new PrepInstaStyledPage();
        prepPage.show(new Stage()); // Launch PrepInstaStyledPage
        stage.close();              // Close Login page
    } else {
        resultLabel.setText("Login failed. Please try again.");
    }
});


        Region spacer = new Region();
        spacer.setMinHeight(5);
       
        

        Text text1 = new Text("Don't have an account? ");
       text1.setFill(Color.web("#777777"));
       text1.setStyle("-fx-font-size: 14px;");

     Text signUpText = new Text("Sign Up");
     signUpText.setFill(Color.web("#0096FF"));
     signUpText.setStyle("-fx-font-size: 14px; -fx-underline: true;");

     TextFlow signUpFlow = new TextFlow(text1, signUpText);
     Stage primaryStage = stage;
signUpFlow.setOnMouseClicked(e -> {
    try {
        new  Signup().show(new Stage()); // open SignUp window
        primaryStage.close();            // close Login window
    } catch (Exception ex) {
        ex.printStackTrace();
    }
});

    

         leftPane.getChildren().addAll(
                logo,
                welcomeText,
                emailField,
                passwordField,
                loginBtn,
                signUpFlow,
                resultLabel,
                backButton

        );

        // --- RIGHT PANEL ---
        StackPane rightPane = new StackPane();
        rightPane.setPrefWidth(800);
        rightPane.setStyle("-fx-background-color: linear-gradient(to bottom right, #2193b0, #6dd5ed);");

        try {
            Image image = new Image(getClass().getResource("/Assets/Image/exploreBg.png").toExternalForm());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(600); 
            imageView.setPreserveRatio(true);
            rightPane.getChildren().add(imageView);
        } catch (Exception e) {
            Label placeholder = new Label("Image not found!");
            placeholder.setTextFill(Color.WHITE);
            placeholder.setFont(Font.font(24));
            rightPane.getChildren().add(placeholder);
        }

        // --- MAIN LAYOUT ---
        HBox root = new HBox(leftPane, rightPane);
        int WIDTH = 1265;
         int HEIGHT = 1002;
        Scene scene = new Scene(root,  WIDTH, HEIGHT);

        stage.setTitle(" Login");
        stage.setScene(scene);
        stage.show();
    }
private boolean signInWithEmailAndPassword(String email,String password){
        try{
            URL url =new URL("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyAQmv2DmmBZFkm5rk_JWSNKi0dxQLWMQvQ");
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            String payLoad =String.format("{\"email\":\"%s\",\"password\":\"%s\",\"returnSecureToken\":true}",email,password);
            OutputStream os =null;
            os=conn.getOutputStream();
            os.write(payLoad.getBytes());

            int responseCode=conn.getResponseCode();
            if(responseCode==200){
                return true;
            }else{
                try (BufferedReader br =new BufferedReader(new InputStreamReader(conn.getErrorStream()))){
                    String line;
                    while ((line=br.readLine())!=null) {
                        System.out.println(line);   
                    }
                }
                return false;
            }


        }
        catch(Exception e){
             e.printStackTrace();
             return false;
        }
        
    }

    
}
