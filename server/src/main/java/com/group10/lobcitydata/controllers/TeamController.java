package com.group10.lobcitydata.controllers;

import com.group10.lobcitydata.models.ErrorMessage;
import com.group10.lobcitydata.models.rapidapi.TeamStatistic;
import com.group10.lobcitydata.services.RapidApiAdaptor;
import com.group10.lobcitydata.models.rapidapi.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@RestController
@RequestMapping("teams")
public class TeamController  {
    @Autowired
    RapidApiAdaptor rapidApiAdaptor;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Team>> getTeams(@RequestParam Map<String,String> queryParams) throws Exception {
        Set<String> validQueryParameters = new HashSet<>(Arrays.asList("id", "name", "code", "league",
                "conference", "division", "search"));

        queryParams.entrySet().removeIf(e -> !validQueryParameters.contains(e.getKey()));

        List<Team> teams = rapidApiAdaptor.getTeams(queryParams);
        if (teams.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "request found no teams");
        }

        return ResponseEntity.ok(teams);
    }

    @GetMapping(path = "/{id}/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TeamStatistic>> getTeamStatistics(@RequestParam Map<String, String> queryParams, @PathVariable String id) throws Exception {
        Set<String> validQueryParameters = new HashSet<>(Arrays.asList("season"));
        queryParams.entrySet().removeIf(e -> !validQueryParameters.contains(e.getKey()));

        if (queryParams.size() < 1) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "teams statistics endpoint requires the season query parameter");
        }

        if (id.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "teams statistics endpoint requires a path variable");
        }

        try {
            Integer.parseInt(id);
        } catch (NumberFormatException ex) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "invalid team id: " + id);
        }

        List<TeamStatistic> teams = rapidApiAdaptor.getTeamStatistics(queryParams, id);
        if (teams.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "request found no stats for team with id: " + id);
        }

        return ResponseEntity.ok(teams);
    }

    @GetMapping(path ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getPlayerById(@PathVariable int id) {
        var map = new HashMap<String, String>();
        map.put("hello", String.valueOf(id));
        return map;
    }
}