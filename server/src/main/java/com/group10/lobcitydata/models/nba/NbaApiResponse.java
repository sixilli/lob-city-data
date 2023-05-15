package com.group10.lobcitydata.models.nba;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
    2.2.3 NBA data models
*/
@JsonIgnoreProperties(value = { "parameters" })
public class NbaApiResponse<T> {
    public String resource;
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
