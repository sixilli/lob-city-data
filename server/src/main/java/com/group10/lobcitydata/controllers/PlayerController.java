package com.group10.lobcitydata.controllers;

import com.group10.lobcitydata.models.rapidapi.Player;
import com.group10.lobcitydata.services.RapidApiAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("players")
public class PlayerController {
    @Autowired
    RapidApiAdaptor rapidApiAdaptor;

     @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Player>> getPlayers() throws Exception {
        List<Player> players = rapidApiAdaptor.getPlayers();
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