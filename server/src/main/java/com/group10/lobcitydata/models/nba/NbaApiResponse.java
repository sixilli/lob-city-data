package com.group10.lobcitydata.models.nba;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(value = { "parameters" })
public class NbaApiResponse<T> {
    public String resource;
    @JsonDeserialize(using = NbaTeamStatsDeserializer.class)
    public T resultSets;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public T getResultSets() {
        return resultSets;
    }

    public void setResultSets(T resultSets) {
        this.resultSets = resultSets;
    }
}
