package com.group10.lobcitydata.configs;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
            try (Stream<Path> stream = Files.list(Paths.get("."))) {
                var s = stream
                        .filter(file -> !Files.isDirectory(file))
                        .map(Path::getFileName)
                        .map(Path::toString)
                        .collect(Collectors.toSet());
                System.out.println(s);
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
