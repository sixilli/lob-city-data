package com.group10.lobcitydata.models.nba;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NbaTeamStatsDeserializer extends JsonDeserializer<List<NbaTeamStatistic>> {
    @Override
    public List<NbaTeamStatistic> deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        var teamStatistics = new ArrayList<NbaTeamStatistic>();

        var name = node.get("name");
        if (name == null || !name.asText().equals("TeamStats")) {
            return null;
        }

        var rowSetIterator = node.get("rowSet").elements();
        while (rowSetIterator.hasNext()) {
            var seasonStats = rowSetIterator.next().elements();

            int count = 0;
            var stat = new NbaTeamStatistic();
            while (seasonStats.hasNext()) {
                var seasonField = seasonStats.next();
                switch (count) {
                    case 0 -> stat.setTeamId(seasonField.asInt());
                    case 1 -> stat.setTeamCity(seasonField.asText());
                    case 2 -> stat.setTeamName(seasonField.asText());
                    case 3 -> stat.setYear(seasonField.asText());
                    case 4 -> stat.setGp(seasonField.asInt());
                    case 5 -> stat.setWins(seasonField.asInt());
                    case 6 -> stat.setLosses(seasonField.asInt());
                    case 7 -> stat.setWinPct(seasonField.asDouble());
                    case 8 -> stat.setConfRank(seasonField.asInt());
                    case 9 -> stat.setDivCount(seasonField.asInt());
                    case 10 -> stat.setNbaFinalsAppearance(seasonField.asText());
                    case 11 -> stat.setFgm(seasonField.asInt());
                    case 12 -> stat.setFga(seasonField.asInt());
                    case 13 -> stat.setFgPct(seasonField.asDouble());
                    case 14 -> stat.setFtm(seasonField.asInt());
                    case 15 -> stat.setFta(seasonField.asInt());
                    case 16 -> stat.setFtPct(seasonField.asDouble());
                    case 17 -> stat.setOffensiveReb(seasonField.asInt());
                    case 18 -> stat.setDefensiveReb(seasonField.asInt());
                    case 19 -> stat.setReb(seasonField.asInt());
                    case 20 -> stat.setAst(seasonField.asInt());
                    case 21 -> stat.setPf(seasonField.asInt());
                    case 22 -> stat.setStl(seasonField.asInt());
                    case 23 -> stat.setTov(seasonField.asInt());
                    case 24 -> stat.setBlk(seasonField.asInt());
                    case 25 -> stat.setPts(seasonField.asInt());
                    case 26 -> stat.setPtsRank(seasonField.asInt());
                }
                count++;
            }
            stat.assignId();
            teamStatistics.add(stat);
        }

        return teamStatistics;
    }
}
