package com.group10.lobcitydata.services;

import com.group10.lobcitydata.configs.RapidApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class RapidApiAdaptor {
    private final RapidApiConfig config;

    @Autowired
    public RapidApiAdaptor(RapidApiConfig config) {
        this.config = config;
    }

    public HttpResponse<String> getTeams() throws IOException, InterruptedException {
        StringBuilder reqBuilder = new StringBuilder();
        reqBuilder.append(config.getUrlBase());
        reqBuilder.append("/teams");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(reqBuilder.toString()))
                .header("X-RapidAPI-Key", config.getApiKey())
                .header("X-RapidAPI-Host", config.getHost())
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }
}
