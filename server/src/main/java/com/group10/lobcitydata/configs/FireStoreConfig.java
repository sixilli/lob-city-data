package com.group10.lobcitydata.configs;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;

// 2.5.1 Config loader that can handle both local and cloud configuration files
@Configuration
public class FireStoreConfig {
    @Bean
    public Firestore getFireStore() throws IOException {
        GoogleCredentials credentials;
        var fireStoreEnv = System.getenv("firestore-env");
        if (fireStoreEnv != null && fireStoreEnv.equals("prod")) {
            credentials = GoogleCredentials.fromStream(new ByteArrayInputStream(System.getenv("CREDS").getBytes()));
        } else {
            var fs = new FileInputStream("server/firestore/firestore.json");
            credentials = GoogleCredentials.fromStream(fs);
        }

        var options = FirestoreOptions.newBuilder().
                setCredentials(credentials);

        return options.build().getService();
    }
}
