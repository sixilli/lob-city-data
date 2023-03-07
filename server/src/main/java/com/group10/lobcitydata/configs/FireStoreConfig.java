package com.group10.lobcitydata.configs;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FireStoreConfig {
    @Bean
    public Firestore getFireStore() throws IOException {
        GoogleCredentials credentials;
        if (System.getProperty("firestore-env").equals("prod")) {
            credentials = GoogleCredentials.getApplicationDefault();
        } else {
            var fs = new FileInputStream("firestore/firestore.json");
            credentials = GoogleCredentials.fromStream(fs);
        }

        var options = FirestoreOptions.newBuilder().
                setCredentials(credentials);

        return options.build().getService();
    }
}
