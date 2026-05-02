package com.smartf;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
// import javafx.scene.text.Text;
// import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Signup  {

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

        Label welcomeText = new Label("Create your SmartHire Account");
        welcomeText.setFont(Font.font("Arial", 20));
        welcomeText.setTextFill(Color.web("#222222"));

        TextField nameField = new TextField();
        nameField.setPromptText("Full Name");
        nameField.setStyle("-fx-background-radius: 10; -fx-border-radius: 10;");
        nameField.setPrefHeight(40);

        TextField mobileField = new TextField();
        mobileField.setPromptText("Mobile Number");
        mobileField.setStyle("-fx-background-radius: 10; -fx-border-radius: 10;");
        mobileField.setPrefHeight(40);

        TextField emailField = new TextField();
        emailField.setPromptText("Email Address");
        emailField.setStyle("-fx-background-radius: 10; -fx-border-radius: 10;");
        emailField.setPrefHeight(40);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setStyle("-fx-background-radius: 10; -fx-border-radius: 10;");
        passwordField.setPrefHeight(40);

        Button signUpBtn = new Button("Sign Up");
        signUpBtn.setPrefHeight(40);
        signUpBtn.setPrefWidth(80);
        signUpBtn.setStyle("-fx-background-color: #0096FF; -fx-text-fill: white; -fx-background-radius: 10;");
        signUpBtn.setAlignment(Pos.CENTER);
        Label resultLabel=new Label();
     
        signUpBtn.setOnAction(e -> {
        String email = emailField.getText();
       String password = passwordField.getText();
       boolean success = signUpWithEmailAndPassword(email, password);
       if (success) {
        PrepInstaStyledPage prepPage = new PrepInstaStyledPage();
        prepPage.show(stage); // Navigate to the next page with the same stage
        resultLabel.setText("SignUp Succesfull");
        } else {
        resultLabel.setText("Signup failed");
        }
});
         leftPane.getChildren().addAll(
                        logo,
                        welcomeText,
                        nameField,
                        mobileField,
                        emailField,
                        passwordField,
                        signUpBtn,
                        resultLabel
                        
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
                Scene scene = new Scene(root, WIDTH, HEIGHT);
        
                stage.setTitle("Sign Up");
                stage.setScene(scene);
                stage.show();
            }
            
    private boolean signUpWithEmailAndPassword(String email,String password){
        try{
            URL url =new URL("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyAQmv2DmmBZFkm5rk_JWSNKi0dxQLWMQvQ");
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            String payLoad =String.format("{\"email\":\"%s\",\"password\":\"%s\",\"returnSecureToken\":true}",email,password);
            OutputStream os =null;
            
            os=conn.getOutputStream();
            os.write(payLoad.getBytes());
            System.out.println(os);
            System.out.println(payLoad);
            int responseCode=conn.getResponseCode();
            String response=conn.getResponseMessage();
            System.out.println(response);
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