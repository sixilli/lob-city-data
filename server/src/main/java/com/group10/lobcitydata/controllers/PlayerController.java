package com.group10.lobcitydata.controllers;

import com.group10.lobcitydata.models.nba.NbaPlayer;
import com.group10.lobcitydata.models.nba.NbaPlayers;
import com.group10.lobcitydata.models.rapidapi.Player;
import com.group10.lobcitydata.services.RapidApiAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

/*
    2.0.2 Players endpoint
*/
@RestController
@RequestMapping("players")
public class PlayerController {
    @Autowired
    RapidApiAdaptor rapidApiAdaptor;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NbaPlayer>> getPlayers(@RequestParam Map<String,String> queryParams) throws Exception {
        Set<String> validQueryParameters = new HashSet<>(List.of("active", "country"));

        queryParams.entrySet().removeIf(e -> !validQueryParameters.contains(e.getKey()));

        List<NbaPlayer> players;
        if (!queryParams.containsKey("active")) {
            players = NbaPlayers.getActive();
        } else {
            if (queryParams.get("active").equalsIgnoreCase("false")) {
                players = NbaPlayers.players;
            } else {
                players = NbaPlayers.getActive();
            }
        }

        return ResponseEntity.ok(players);
    }

    @GetMapping(path ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getPlayerById(@PathVariable int id) {
        var map = new HashMap<String, String>();
        map.put("hello", String.valueOf(id));
        return map;
    }
}