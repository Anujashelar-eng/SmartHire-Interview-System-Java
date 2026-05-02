package com.smartf;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class FirebaseInitializer {

    private static Firestore db;

    public static void initialize() {
        try {
           InputStream serviceAccount = FirebaseInitializer.class.getClassLoader()
        .getResourceAsStream("firebase/myfxproject-94e8f-firebase-adminsdk-fbsvc-7d902fd0ce.json");

        if (serviceAccount == null) {
            throw new RuntimeException("❌ firebase-adminsdk.json not found in resources/firebase/");
        }

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://myfxproject-94e8f-default-rtdb.firebaseio.com")
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }

            db = FirestoreClient.getFirestore();
            System.out.println("✅ Firebase initialized.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addInterviewSubmission(String name, String company, String question) {
        if (db == null) {
            System.err.println("❌ Firestore not initialized.");
            return;
        }

        try {
            Map<String, Object> data = new HashMap<>();
            data.put("name", name);
            data.put("company", company);
            data.put("question", question);
            data.put("timestamp", System.currentTimeMillis());

            db.collection("interview-submissions").add(data);
            System.out.println("✅ Submission saved to Firestore.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fetchAllInterviewSubmissions(Consumer<QueryDocumentSnapshot> onDocument) {
    if (db == null) {
        System.err.println("❌ Firestore not initialized.");
        return;
    }

    try {
        ApiFuture<QuerySnapshot> future = db.collection("interview-submissions")
                                            .orderBy("timestamp", Query.Direction.DESCENDING)
                                            .get();

        for (QueryDocumentSnapshot doc : future.get().getDocuments()) {
            onDocument.accept(doc);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
