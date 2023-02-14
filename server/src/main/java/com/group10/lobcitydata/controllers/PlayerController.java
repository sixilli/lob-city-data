package com.group10.lobcitydata.controllers;

import com.group10.lobcitydata.adaptors.RapidApiAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("players")
public class PlayerController {
    @Autowired
    RapidApiAdaptor rapidApiAdaptor;

    @GetMapping(path ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getPlayerById(@PathVariable int id) {
        var map = new HashMap<String, String>();
        map.put("hello", String.valueOf(id));
        rapidApiAdaptor.printConfig();
        return map;
    }
}