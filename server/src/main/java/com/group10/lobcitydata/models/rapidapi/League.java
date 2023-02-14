package com.group10.lobcitydata.models.rapidapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class League {
    private LeagueData standard;
    private LeagueData vegas;
    private LeagueData utah;
    private LeagueData sacramento;

    @JsonCreator
    public League(
            @JsonProperty("standard") LeagueData standard,
            @JsonProperty("vegas") LeagueData vegas,
            @JsonProperty("utah") LeagueData utah,
            @JsonProperty("sacramento") LeagueData sacramento
    ) {
        this.standard = standard;
        this.vegas = vegas;
        this.utah = utah;
        this.sacramento = sacramento;
    }

    public LeagueData getStandard() {
        return standard;
    }

    public void setStandard(LeagueData standard) {
        this.standard = standard;
    }

    public LeagueData getVegas() {
        return vegas;
    }

    public void setVegas(LeagueData vegas) {
        this.vegas = vegas;
    }

    public LeagueData getUtah() {
        return utah;
    }

    public void setUtah(LeagueData utah) {
        this.utah = utah;
    }

    public LeagueData getSacramento() {
        return sacramento;
    }

    public void setSacramento(LeagueData sacramento) {
        this.sacramento = sacramento;
    }
}
