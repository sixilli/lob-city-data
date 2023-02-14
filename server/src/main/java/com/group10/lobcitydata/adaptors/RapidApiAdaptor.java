package com.group10.lobcitydata.adaptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group10.lobcitydata.configs.RapidApiConfig;
import com.group10.lobcitydata.models.rapidapi.ApiResponse;
import com.group10.lobcitydata.models.rapidapi.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

    public List<Team> getTeams() throws IOException, InterruptedException {
        StringBuilder reqBuilder = new StringBuilder();
        reqBuilder.append(config.getUrlBase());
        reqBuilder.append("/teams");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(reqBuilder.toString()))
                .header("X-RapidAPI-Key", config.getApiKey())
                .header("X-RapidAPI-Host", config.getHost())
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        ApiResponse<Team> responseData = new ObjectMapper()
                                    .readerFor(ApiResponse.class)
                                    .readValue(response.body());

        return responseData.getResponse();
    }

    public void printConfig() {
        System.out.println(config);
    }
}
