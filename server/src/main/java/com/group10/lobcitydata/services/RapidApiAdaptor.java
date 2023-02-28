package com.group10.lobcitydata.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group10.lobcitydata.builders.UrlBuilder;
import com.group10.lobcitydata.configs.RapidApiConfig;
import com.group10.lobcitydata.models.rapidapi.ApiResponse;
import com.group10.lobcitydata.models.rapidapi.Player;
import com.group10.lobcitydata.models.rapidapi.Team;
import com.group10.lobcitydata.models.rapidapi.TeamStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

@Service
public class RapidApiAdaptor {
    private final RapidApiConfig config;

    private static final String TEAMS_PATH = "/teams";
    private static final String TEAM_STATISTICS_PATH = "/teams/statistics";
    private static final String PLAYERS_PATH = "/players";

    @Autowired
    public RapidApiAdaptor(RapidApiConfig config) {
        this.config = config;
    }

    public List<Team> getTeams(Map<String, String> queryParams) throws Exception {
        UrlBuilder ub = new UrlBuilder(config.getUrlBase(), TEAMS_PATH);
        if (!queryParams.isEmpty()) {
            ub.addQueryParams(queryParams);
        }

        HttpResponse<String> response = makeGetRequest(ub);

        return mapResponse(Team.class, response.body()).getResponse();
    }

    public List<Player> getPlayers(Map<String, String> queryParams) throws Exception {
        UrlBuilder ub = new UrlBuilder(config.getUrlBase(), PLAYERS_PATH);
        if (!queryParams.isEmpty()) {
            ub.addQueryParams(queryParams);
        }

        HttpResponse<String> response = makeGetRequest(ub);

        return mapResponse(Player.class, response.body()).getResponse();
    }

    public List<TeamStatistic> getTeamStatistics(Map<String, String> queryParams, String teamId) throws Exception {
        UrlBuilder ub = new UrlBuilder(config.getUrlBase(), TEAM_STATISTICS_PATH);
        if (!queryParams.isEmpty()) {
            ub.addQueryParams(queryParams);
        }
        ub.addQueryParam("id", teamId);

        HttpResponse<String> response = makeGetRequest(ub);

        return mapResponse(TeamStatistic.class, response.body()).getResponse();
    }

    private HttpResponse<String> makeGetRequest(UrlBuilder url) throws Exception {
        // Build the request to the external API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url.toString()))
                .header("X-RapidAPI-Key", config.getApiKey())
                .header("X-RapidAPI-Host", config.getHost())
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response =  HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        if (!HttpStatus.valueOf(response.statusCode()).is2xxSuccessful()) {
            throw new Exception("Received a bad status code, Response: " + response.body());
        }

        return response;
    }

    private static <T> ApiResponse<T> mapResponse(Class<T> rawType, String body) throws JsonProcessingException {
        JavaType type = new ObjectMapper().getTypeFactory().
                constructParametricType(ApiResponse.class, rawType);

        ApiResponse<T> formattedResponse = new ObjectMapper()
                .readerFor(type)
                .readValue(body);


        return formattedResponse;
    }

}
