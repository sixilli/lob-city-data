package com.group10.lobcitydata.controllers;

import com.group10.lobcitydata.models.rapidapi.Player;
import com.group10.lobcitydata.services.RapidApiAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@RestController
@RequestMapping("players")
public class PlayerController {
    @Autowired
    RapidApiAdaptor rapidApiAdaptor;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Player>> getPlayers(@RequestParam Map<String,String> queryParams) throws Exception {
        Set<String> validQueryParameters = new HashSet<>(Arrays.asList("id", "name", "team", "season",
                "country", "search"));

        queryParams.entrySet().removeIf(e -> !validQueryParameters.contains(e.getKey()));

        List<Player> players = rapidApiAdaptor.getPlayers(queryParams);
        if (players.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "request found no players");
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