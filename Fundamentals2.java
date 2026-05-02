package com.smartf;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Fundamentals2{

    
    public Scene createScene(Stage mainStage) {
      //  this.mainStage = mainStage;
       Label name =new Label("Fundamentals");
       name.setStyle("-fx-font-size: 30px;-fx-text-fill: white;");
        Button  osButton=new Button("Operating System");
         osButton.setOnAction(e -> {
            Os2 osPage = new Os2();
            Scene osScene = osPage.createScene(mainStage);
            mainStage.setScene(osScene);
        });

        // aptiButton.setStyle("-fx-background-color: #2196F3;");
        Button dbButton = new Button("DBMS");
        dbButton.setOnAction(e -> {
            Dbms2 dbmsPage = new Dbms2();
            Scene dbmsScene = dbmsPage.createScene(mainStage);
            mainStage.setScene(dbmsScene);
        });

        Button cnsButton = new Button("Computer Networks and Security");
        cnsButton.setOnAction(e -> {
            Cns2 cnsPage = new Cns2();
            Scene cnsScene = cnsPage.createScene(mainStage);
            mainStage.setScene(cnsScene);
        });

        Button backButton =new Button("Back");
        backButton.setOnAction(e -> {
        PrepInstaStyledPage prepPage = new PrepInstaStyledPage();
        prepPage.show(mainStage);
        });

        
    dbButton.setStyle(
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

     osButton.setStyle(
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

     cnsButton.setStyle(
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

     osButton.setPrefWidth(300);  // Preferred width in pixels
     osButton.setPrefHeight(100);
     cnsButton.setPrefWidth(300);  // Preferred width in pixels
     cnsButton.setPrefHeight(100);
     dbButton.setPrefWidth(300);  // Preferred width in pixels
     dbButton.setPrefHeight(100);
     backButton.setPrefHeight(50);
     backButton.setPrefWidth(100);




        VBox vb =new VBox(60,name,osButton,dbButton,cnsButton,backButton);
        vb.setAlignment(Pos.CENTER);
        vb.setStyle("-fx-background-color: linear-gradient(to bottom right,rgb(55, 134, 225),rgb(174, 200, 229));");
        Scene sc =new Scene(vb,500,500);
        return sc;


        
    }
    
}