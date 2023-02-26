package com.group10.lobcitydata.controllers;

import com.group10.lobcitydata.models.rapidapi.Standing;
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
@RequestMapping("standings")
public class StandingController {
    @Autowired
    RapidApiAdaptor rapidApiAdaptor;

     @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Standing>> getStandings() throws Exception {
        List<Standing> standings = rapidApiAdaptor.getStandings();
        if (standings.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "request found no standings");
        }

        return ResponseEntity.ok(standings);
    }

    @GetMapping(path ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getPlayerById(@PathVariable int id) {
        var map = new HashMap<String, String>();
        map.put("hello", String.valueOf(id));
        return map;
    }
}
