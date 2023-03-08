package com.group10.lobcitydata.configs;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;

@Configuration
public class FireStoreConfig {
    @Bean
    public Firestore getFireStore() throws IOException {
        GoogleCredentials credentials;
        var fireStoreEnv = System.getenv("firestore-env");
        if (fireStoreEnv != null && fireStoreEnv.equals("prod")) {
            System.out.println(System.getenv("CREDS"));
            credentials = GoogleCredentials.fromStream(new ByteArrayInputStream(System.getenv("CREDS").getBytes()));
        } else {
            var fs = new FileInputStream("firestore/firestore.json");
            credentials = GoogleCredentials.fromStream(fs);
        }

        var options = FirestoreOptions.newBuilder().
                setCredentials(credentials);

        return options.build().getService();
    }
}
