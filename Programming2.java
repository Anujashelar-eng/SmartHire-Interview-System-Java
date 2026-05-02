package com.smartf;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Programming2  {
    public Scene creatScene(Stage mainStage) {
       Label name =new Label("Programming");
       name.setStyle("-fx-font-size: 30px;-fx-text-fill: white;");
    
Button cppButton = new Button("C++");
cppButton.setOnAction(e -> {
    Cpp2 cppPage = new Cpp2();
    Scene cppScene = cppPage.createScene(mainStage);
    mainStage.setScene(cppScene);
});

// Java Button
Button javaButton = new Button("Java");
javaButton.setOnAction(e -> {
    Javaquizz2 javaPage = new Javaquizz2();
    Scene javaScene = javaPage.createScene(mainStage);
    mainStage.setScene(javaScene);
});

// Python Button
Button pythonButton = new Button("Python");
pythonButton.setOnAction(e -> {
    Python2 pythonPage = new Python2();
    Scene pythonScene = pythonPage.createScene(mainStage);
    mainStage.setScene(pythonScene);
});

    Button  backButton=new Button("Back");
    backButton.setOnAction(e->{
        PrepInstaStyledPage prepPage = new PrepInstaStyledPage();
        prepPage.show(mainStage);
    });
    pythonButton.setStyle(
      "-fx-background-color: linear-gradient(to right,rgb(243, 241, 247),rgb(236, 231, 240)); " +
      "-fx-text-fill: black; " +
       "-fx-font-size: 14px; " +
      "-fx-border-radius: 10px; " +
      "-fx-background-radius: 10px; " +
     "-fx-padding: 10px 20px; " +
     "-fx-cursor: hand;" +
     "-fx-effect: dropshadow(gaussian, blue, 3, 0.8, 3, 0.8);"+
     "-fx-opacity: 0.9;"
     );

     cppButton.setStyle(
      "-fx-background-color: linear-gradient(to right,rgb(243, 241, 247),rgb(236, 231, 240)); " +
      "-fx-text-fill: black; " +
       "-fx-font-size: 14px; " +
      "-fx-border-radius: 10px; " +
      "-fx-background-radius: 10px; " +
     "-fx-padding: 10px 20px; " +
     "-fx-cursor: hand;" +
     "-fx-effect: dropshadow(gaussian, blue, 3, 0.8, 3, 0.8);"+
     "-fx-opacity: 0.9;"
     );

     javaButton.setStyle(
      "-fx-background-color: linear-gradient(to right,rgb(243, 241, 247),rgb(236, 231, 240)); " +
      "-fx-text-fill: black; " +
       "-fx-font-size: 14px; " +
      "-fx-border-radius: 10px; " +
      "-fx-background-radius: 10px; " +
     "-fx-padding: 10px 20px; " +
     "-fx-cursor: hand;" +
     "-fx-effect: dropshadow(gaussian, blue, 3, 0.8, 3, 0.8);"+
     "-fx-opacity: 0.9;"
     );

     backButton.setStyle(
      "-fx-background-color: linear-gradient(to right,rgb(26, 95, 179),rgb(236, 231, 240)); " +
      "-fx-text-fill: white; " +
       "-fx-font-size: 14px; " +
      "-fx-border-radius: 10px; " +
      "-fx-background-radius: 10px; " +
     "-fx-padding: 10px 20px; " +
     "-fx-cursor: hand;" +
     "-fx-effect: dropshadow(gaussian, blue, 2, 0.8, 2, 0.8);"+
     "-fx-opacity: 0.9;"
     );

     cppButton.setPrefWidth(300);  // Preferred width in pixels
     cppButton.setPrefHeight(100);
     javaButton.setPrefWidth(300);  // Preferred width in pixels
     javaButton.setPrefHeight(100);
     pythonButton.setPrefWidth(300);  // Preferred width in pixels
     pythonButton.setPrefHeight(100);
     backButton.setPrefHeight(50);
     backButton.setPrefWidth(100);




        VBox vb =new VBox(60,name,cppButton,javaButton,pythonButton,backButton);
        vb.setAlignment(Pos.CENTER);
        vb.setStyle("-fx-background-color: linear-gradient(to bottom right,rgb(55, 134, 225),rgb(174, 200, 229));");
        Scene sc =new Scene(vb,500,500);
        return sc;


        
    }

    
        
    
}