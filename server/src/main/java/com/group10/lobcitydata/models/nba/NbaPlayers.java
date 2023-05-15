package com.group10.lobcitydata.models.nba;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

/*
    2.2.3 NBA data models
*/
public class NbaPlayers {
    public static final List<NbaPlayer> players = readInPlayers();

    public static List<NbaPlayer> readInPlayers() {
        List<NbaPlayer> players = null;
        try {
            File file = new ClassPathResource("players.json").getFile();
            var om = new ObjectMapper().setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());
            players = om.readValue(file, new TypeReference<>() {});
            if (players.isEmpty()) {
                throw new Exception ("failed to load players.json");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return players;
    }

    public static List<NbaPlayer> getActive() {
        return players.stream().filter(NbaPlayer::isActive).collect(Collectors.toList());
    }
}
