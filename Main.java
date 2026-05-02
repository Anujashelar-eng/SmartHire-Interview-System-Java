package com.smartf;
import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Call the method to initialize Firebase and perform CRUD
        FirebaseInitializer.initialize();
        Application.launch(Explore.class,args);
    
    }
}