package com.group10.lobcitydata.controllers;

import com.group10.lobcitydata.models.nba.NbaTeam;
import com.group10.lobcitydata.models.nba.NbaTeamStatistic;
import com.group10.lobcitydata.models.nba.NbaTeams;
import com.group10.lobcitydata.repositories.Impl.TeamRepositoryImpl;
import com.group10.lobcitydata.repositories.Impl.TeamStatisticRepoImpl;
import com.group10.lobcitydata.services.NbaAdapter;
import com.group10.lobcitydata.models.rapidapi.Team;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@RestController
@RequestMapping("teams")
public class TeamController  {
    private final NbaAdapter nbaAdapter;
    private final TeamRepositoryImpl teamRepo;
    private final TeamStatisticRepoImpl teamStatisticRepo;

    public TeamController(TeamRepositoryImpl teamRepositoryImpl, TeamStatisticRepoImpl teamStatisticRepoImpl,
                          NbaAdapter nbaAdapter) {
        this.teamRepo = teamRepositoryImpl;
        this.teamStatisticRepo = teamStatisticRepoImpl;
        this.nbaAdapter = nbaAdapter;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NbaTeam>> getTeams() {
        return ResponseEntity.ok(NbaTeams.getTeams());
    }

    @GetMapping(path = "/{id}/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NbaTeamStatistic> getTeamStatistics(@RequestParam Map<String, String> queryParams, @PathVariable String id) throws Exception {
        HashSet<String> validQueryParameters = new HashSet<>(List.of("season"));
        queryParams.entrySet().removeIf(e -> !validQueryParameters.contains(e.getKey()));

        if (queryParams.size() < 1 || !queryParams.containsKey("season")) {
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

        var dbId = NbaTeamStatistic.getDbId(id, queryParams.get("season"));
        var teamStatisticBySeason = this.teamStatisticRepo.findItemByID(dbId);
        if (teamStatisticBySeason.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Could not find any statistics data for team: " + id + " during the season " + queryParams.get("season"));
        }

        return ResponseEntity.ok(teamStatisticBySeason.get());
    }

    @GetMapping(path ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getPlayerById(@PathVariable int id) {
        var map = new HashMap<String, String>();
        map.put("hello", String.valueOf(id));
        return map;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Team>> batchInsertTeams(@RequestBody List<Team> teams) {
        teamRepo.batch(teams);
        return ResponseEntity.ok(teams);
    }

    @PostMapping(path = "statistics/refresh", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> refreshStatistics() throws Exception {
        for (var team : NbaTeams.getTeams()) {
            var statistics = this.nbaAdapter.getAllTeamStatistics(Integer.toString(team.id));
            teamStatisticRepo.batchSet(statistics);
        }

        return ResponseEntity.ok("completed teams statistics refresh");
    }
}