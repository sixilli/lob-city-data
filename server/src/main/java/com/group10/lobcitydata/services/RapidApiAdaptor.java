package com.group10.lobcitydata.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group10.lobcitydata.configs.RapidApiConfig;
import com.group10.lobcitydata.models.rapidapi.ApiResponse;
import com.group10.lobcitydata.models.rapidapi.Team;
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
        ApiResponse<Team> formattedResponse = new ObjectMapper()
                .readerFor(ApiResponse.class)
                .readValue(response.body());

        // Remove team that isn't playing, and fix LA to Los Angeles
        formattedResponse.setResponse(formattedResponse.getResponse()
                .stream()
                .filter(team -> !team.getName().equalsIgnoreCase("home"))
                .map(team -> {
                    if (team.getCity().equalsIgnoreCase("la"))  {
                        team.setCity("Los Angeles");
                    }
                    return team;
                })
                .collect(Collectors.toList())
        );

        return formattedResponse.getResponse();
    }
}
