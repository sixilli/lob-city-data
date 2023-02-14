package com.group10.lobcitydata.controllers;

import com.group10.lobcitydata.adaptors.RapidApiAdaptor;
import com.group10.lobcitydata.models.rapidapi.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("teams")
public class TeamController  {
    @Autowired
    RapidApiAdaptor rapidApiAdaptor;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Team> getTeams() throws IOException, InterruptedException {
        return rapidApiAdaptor.getTeams();
    }

    @GetMapping(path ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getPlayerById(@PathVariable int id) {
        var map = new HashMap<String, String>();
        map.put("hello", String.valueOf(id));
        rapidApiAdaptor.printConfig();
        return map;
    }
}