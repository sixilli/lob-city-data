package com.group10.lobcitydata.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group10.lobcitydata.builders.UrlBuilder;
import com.group10.lobcitydata.models.nba.NbaApiResponse;
import com.group10.lobcitydata.models.nba.NbaTeamStatistic;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.GZIPInputStream;

@Service
public class NbaAdapter {

    private static final String BASE_PATH = "https://stats.nba.com/stats";
    private static final String TEAM_YEAR_BY_YEAR = "/teamyearbyyearstats";

    public NbaAdapter() {}


    //https://stats.nba.com/stats/teamyearbyyearstats?LeagueID=00&PerMode=Totals&SeasonType=Regular+Season&TeamID=1610612739
    public List<NbaTeamStatistic> getAllTeamStatistics(String teamId) throws Exception {
        var url = new UrlBuilder(BASE_PATH, TEAM_YEAR_BY_YEAR);
        url.addQueryParam("TeamID", teamId);
        url.addQueryParam("LeagueID", "00"); // Specifies NBA league
        url.addQueryParam("PerMode", "Totals");
        url.addQueryParam("SeasonType", "Regular+Season");

        var body = makeGetRequest(url);

        return mapResponse(new TypeReference<List<NbaTeamStatistic>>(){}, body).resultSets;
    }

    private String makeGetRequest(UrlBuilder url) throws Exception {
        // Build the request to the external API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url.toString()))
                .header("Accept", "*/*")
                .header("User-Agent", "PostmanRuntime/7.31.1")
                .header("Accept-Encoding", "gzip")
                .header("Referer", "https://stats.nba.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<InputStream> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofInputStream());
        if (!HttpStatus.valueOf(response.statusCode()).is2xxSuccessful()) {
            throw new Exception("Received a bad status code: " + response.statusCode() + ", Response: " + response.body());
        }

        var gzipStream = new GZIPInputStream(response.body());
        var streamReader = new InputStreamReader(gzipStream, StandardCharsets.UTF_8);
        var buffReader = new BufferedReader(streamReader);

        var sb = new StringBuilder();
        String itVal;
        while((itVal = buffReader.readLine()) != null) {
            sb.append(itVal);
        }

        return sb.toString();
    }

    private static <T> NbaApiResponse<T> mapResponse(TypeReference<T> rawType, String body) throws JsonProcessingException {
        JavaType type = new ObjectMapper()
                .getTypeFactory()
                .constructParametricType(NbaApiResponse.class, rawType.getClass());

        return new ObjectMapper().readValue(body, type);
    }
}
