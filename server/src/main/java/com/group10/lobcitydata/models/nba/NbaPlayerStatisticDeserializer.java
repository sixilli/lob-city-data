package com.group10.lobcitydata.models.nba;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NbaPlayerStatisticDeserializer extends JsonDeserializer<NbaPlayerStatistic> {
    @Override
    public NbaPlayerStatistic deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        // Convert to JsonNode
        JsonNode node = jp.getCodec().readTree(jp);
        // Declare new NbaPlayerStatistic object
        NbaPlayerStatistic playerStatistic = new NbaPlayerStatistic();
        // Get resultSets node, which contains all relevant data sets of
        // playercareerstats
        JsonNode resultSets = node.get("resultSets");
        // Iterate through resultsSets
        for (JsonNode resultSet : resultSets) {
            // Get name node
            JsonNode name = resultSet.get("name");
            // If null, return null
            if (name == null)
                return null;
            // Convert to String
            String nameAsText = name.asText();
            // If CareerTotalsRegularSeason
            if (nameAsText.equals("CareerTotalsRegularSeason")) {
                // Deserialize
                NbaPlayerCareerStats careerTotalsRegularSeason = deserializeCareerStat(resultSet);
                // Set careerTotalsRegularSeason of playerStatistic to returned result
                playerStatistic.setCareerTotalsRegularSeason(careerTotalsRegularSeason);
                // If CareerTotalsPostSeason
            } else if (nameAsText.equals("CareerTotalsPostSeason")) {
                // Deserialize
                NbaPlayerCareerStats careerTotalsPostSeason = deserializeCareerStat(resultSet);
                // Set careerTotalsPostSeason of playerStatistic to returned result
                playerStatistic.setCareerTotalsRegularSeason(careerTotalsPostSeason);
                // If SeasonTotalsRegularSeason
            } else if (nameAsText.equals("SeasonTotalsRegularSeason")) {
                // Deserialize
                List<NbaPlayerSeasonStats> seasonTotalsRegularSeason = deserializeSeasonStats(resultSet);
                // Set seasonTotalsRegularSeason of playerStatistic to returned result
                playerStatistic.setSeasonTotalsRegularSeason(seasonTotalsRegularSeason);
                // If SeasonTotalsPostSeason
            } else if (nameAsText.equals("SeasonTotalsPostSeason")) {
                // Deserialize
                List<NbaPlayerSeasonStats> seasonTotalsPostSeason = deserializeSeasonStats(resultSet);
                // Set seasonTotalsPostSeason of playerStatistic to returned result
                playerStatistic.setSeasonTotalsPostSeason(seasonTotalsPostSeason);
            }
        }
        return playerStatistic;

    }

    // Deserialization method for careerTotalsRegularSeason and
    // careerTotalsPostSeason
    private NbaPlayerCareerStats deserializeCareerStat(JsonNode resultSet) {
        // Declare new NbaPlayerCareerStats object
        NbaPlayerCareerStats stat = new NbaPlayerCareerStats();
        // Get rowSet JsonNode, which should contain a single array
        JsonNode rowSet = resultSet.get("rowSet");
        // Count of current field
        int count = 0;
        // Iterate through each field
        for (JsonNode field : rowSet) {
            // Switch on count to appropriate NbaPlayerCareerStats setter, set converted
            // field value
            switch (count) {
                case 0 -> stat.setPlayerId(field.asInt());
                case 1 -> stat.setLeagueId(field.asInt());
                case 2 -> stat.setTeamId(field.asInt());
                case 3 -> stat.setGp(field.asInt());
                case 4 -> stat.setGs(field.asInt());
                case 5 -> stat.setMin(field.asInt());
                case 6 -> stat.setFgm(field.asInt());
                case 7 -> stat.setFga(field.asInt());
                case 8 -> stat.setFgPct(field.asDouble());
                case 9 -> stat.setFg3m(field.asInt());
                case 10 -> stat.setFg3a(field.asInt());
                case 11 -> stat.setFg3Pct(field.asDouble());
                case 12 -> stat.setFtm(field.asInt());
                case 13 -> stat.setFta(field.asInt());
                case 14 -> stat.setFtPct(field.asDouble());
                case 15 -> stat.setOffensiveReb(field.asInt());
                case 16 -> stat.setDefensiveReb(field.asInt());
                case 17 -> stat.setReb(field.asInt());
                case 18 -> stat.setAst(field.asInt());
                case 19 -> stat.setStl(field.asInt());
                case 20 -> stat.setBlk(field.asInt());
                case 21 -> stat.setTov(field.asInt());
                case 22 -> stat.setPf(field.asInt());
                case 23 -> stat.setPts(field.asInt());
            }
            count++;
        }
        return stat;
    }

    // Deserialization method for seasonTotalsRegularSeason and
    // seasonTotalsPostSeason
    // Same logic as careerTotals deserialization method, but with a list of seasons
    // and the extra fields
    private List<NbaPlayerSeasonStats> deserializeSeasonStats(JsonNode resultSet) {
        // Declare new List stats
        List<NbaPlayerSeasonStats> stats = new ArrayList<>();
        // Get rowSet node
        JsonNode rowSet = resultSet.get("rowSet");
        // Iterate through each season
        for (JsonNode season : rowSet) {
            // Declare new NbaPlayerSeasonStats object stat
            NbaPlayerSeasonStats stat = new NbaPlayerSeasonStats();
            // Track count
            int count = 0;
            // Iterate through each field of the current season
            for (JsonNode field : season) {
                // Switch on count to appropriate NbaPlayerSeasonStats setter, set converted
                // field value
                switch (count) {
                    case 0 -> stat.setPlayerId(field.asInt());
                    case 1 -> stat.setSeasonId(field.asInt());
                    case 2 -> stat.setLeagueId(field.asInt());
                    case 3 -> stat.setTeamId(field.asInt());
                    case 4 -> stat.setTeamAbbreviation(field.asText());
                    case 5 -> stat.setPlayerAge(field.asInt());
                    case 6 -> stat.setGp(field.asInt());
                    case 7 -> stat.setGs(field.asInt());
                    case 8 -> stat.setMin(field.asInt());
                    case 9 -> stat.setFgm(field.asInt());
                    case 10 -> stat.setFga(field.asInt());
                    case 11 -> stat.setFgPct(field.asDouble());
                    case 12 -> stat.setFg3m(field.asInt());
                    case 13 -> stat.setFg3a(field.asInt());
                    case 14 -> stat.setFg3Pct(field.asDouble());
                    case 15 -> stat.setFtm(field.asInt());
                    case 16 -> stat.setFta(field.asInt());
                    case 17 -> stat.setFtPct(field.asDouble());
                    case 18 -> stat.setOffensiveReb(field.asInt());
                    case 19 -> stat.setDefensiveReb(field.asInt());
                    case 20 -> stat.setReb(field.asInt());
                    case 21 -> stat.setAst(field.asInt());
                    case 22 -> stat.setStl(field.asInt());
                    case 23 -> stat.setBlk(field.asInt());
                    case 24 -> stat.setTov(field.asInt());
                    case 25 -> stat.setPf(field.asInt());
                    case 26 -> stat.setPts(field.asInt());
                }
                count++;
            }
            // Might need to assign an id here first
            // Add stat to stats list
            stats.add(stat);
        }
        return stats;
    }

}
