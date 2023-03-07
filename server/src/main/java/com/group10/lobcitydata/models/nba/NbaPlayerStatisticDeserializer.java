package com.group10.lobcitydata.models.nba;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NbaPlayerStatisticDeserializer extends StdDeserializer<List<NbaPlayerStatistic>> {
    public NbaPlayerStatisticDeserializer () {
        this(null);
    }

    public NbaPlayerStatisticDeserializer (Class<?> vc) {
        super(vc);
    }

    @Override
    public List<NbaPlayerStatistic> deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        var playerStatistics = new ArrayList<NbaPlayerStatistic>();

        var resultSet = node.elements();
        while (resultSet.hasNext()) {

        }
        return playerStatistics;
    }
}
