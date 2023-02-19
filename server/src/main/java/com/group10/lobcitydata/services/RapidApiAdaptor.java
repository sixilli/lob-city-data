package com.group10.lobcitydata.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group10.lobcitydata.configs.RapidApiConfig;
import com.group10.lobcitydata.models.rapidapi.ApiResponse;
import com.group10.lobcitydata.models.rapidapi.Player;
import com.group10.lobcitydata.models.rapidapi.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class RapidApiAdaptor {
    private final RapidApiConfig config;

    @Autowired
    public RapidApiAdaptor(RapidApiConfig config) {
        this.config = config;
    }

    public List<Team> getTeams() throws Exception {
        // Build URL for the request, I will probaby build something to make this nicer.
        StringBuilder reqBuilder = new StringBuilder();
        reqBuilder.append(config.getUrlBase());
        reqBuilder.append("/teams?id=1");

        // Build the request to the external API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(reqBuilder.toString()))
                .header("X-RapidAPI-Key", config.getApiKey())
                .header("X-RapidAPI-Host", config.getHost())
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        // Execute the request and if we recieve back a non 200 status code we will throw an error
        var response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        if (!HttpStatus.valueOf(response.statusCode()).is2xxSuccessful()) {
            throw new Exception("Received a bad status code, Response: " + response.body());
        }

        // Map the JSON string data to Java classes
        ApiResponse<Team> formattedResponse = new ObjectMapper()
                .readerFor(ApiResponse.class)
                .readValue(response.body());

        return formattedResponse.getResponse();
    }

    public List<Player> getPlayers() throws Exception {
        StringBuilder reqBuilder = new StringBuilder();
        reqBuilder.append(config.getUrlBase());
        reqBuilder.append("/players");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(reqBuilder.toString()))
                .header("X-RapidAPI-Key", config.getApiKey())
                .header("X-RapidAPI-Host", config.getHost())
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        var response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        if (!HttpStatus.valueOf(response.statusCode()).is2xxSuccessful()) {
            throw new Exception("Received a bad status code, Response: " + response.body());
        }

        ApiResponse<Player> formattedResponse = new ObjectMapper()
                .readerFor(ApiResponse.class)
                .readValue(response.body());

        return formattedResponse.getResponse();
    }
}
