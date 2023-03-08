package com.group10.lobcitydata.configs;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class FireStoreConfig {
    @Bean
    public Firestore getFireStore() throws IOException {
        GoogleCredentials credentials;
        var fireStoreEnv = System.getenv("firestore-env");
        if (fireStoreEnv != null && fireStoreEnv.equals("prod")) {
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            String[] pathnames;
            File f = new File(".");
            pathnames = f.list();
            for (String pathname : pathnames) {
                System.out.println(pathname);
            }

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
