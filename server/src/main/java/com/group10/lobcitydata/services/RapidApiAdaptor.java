package com.group10.lobcitydata.services;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group10.lobcitydata.configs.RapidApiConfig;
import com.group10.lobcitydata.models.rapidapi.ApiResponse;
import com.group10.lobcitydata.models.rapidapi.Player;
import com.group10.lobcitydata.models.rapidapi.Team;
import com.group10.lobcitydata.models.rapidapi.Standing;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

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
        reqBuilder.append("/teams");

        // Build the request to the external API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(reqBuilder.toString()))
                .header("X-RapidAPI-Key", config.getApiKey())
                .header("X-RapidAPI-Host", config.getHost())
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        // Execute the request and if we receive back a non 200 status code we will throw an error
        var response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        if (!HttpStatus.valueOf(response.statusCode()).is2xxSuccessful()) {
            throw new Exception("Received a bad status code, Response: " + response.body());
        }

        // Map the JSON string data to Java classes
        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().
                constructParametricType(ApiResponse.class, Team.class);

        ApiResponse<Team> formattedResponse = new ObjectMapper()
                .readerFor(type)
                .readValue(response.body());

        return formattedResponse.getResponse();
    }

    public List<Player> getPlayers() throws Exception {
        StringBuilder reqBuilder = new StringBuilder();
        reqBuilder.append(config.getUrlBase());
        reqBuilder.append("/players?country=USA");

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
     public List<Standing> getStandings() throws Exception {
        StringBuilder reqBuilder = new StringBuilder();
        reqBuilder.append(config.getUrlBase());
        reqBuilder.append("/standings");

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

        ApiResponse<Standing> formattedResponse = new ObjectMapper()
                .readerFor(ApiResponse.class)
                .readValue(response.body());

        return formattedResponse.getResponse();
    }
}

