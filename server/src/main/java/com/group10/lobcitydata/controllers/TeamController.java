package com.group10.lobcitydata.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group10.lobcitydata.models.rapidapi.ApiResponse;
import com.group10.lobcitydata.services.RapidApiAdaptor;
import com.group10.lobcitydata.models.rapidapi.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("teams")
public class TeamController  {
    @Autowired
    RapidApiAdaptor rapidApiAdaptor;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Team>> getTeams() throws IOException, InterruptedException {
        HttpResponse<String> response = rapidApiAdaptor.getTeams();
        if (!HttpStatus.valueOf(response.statusCode()).is2xxSuccessful()) {
            return ResponseEntity
                    .internalServerError()
                    .build();
        }

        ApiResponse<Team> teams = new ObjectMapper()
                .readerFor(ApiResponse.class)
                .readValue(response.body());

        return ResponseEntity.ok(teams.getResponse());
    }

    @GetMapping(path ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getPlayerById(@PathVariable int id) {
        var map = new HashMap<String, String>();
        map.put("hello", String.valueOf(id));
        return map;
    }
}