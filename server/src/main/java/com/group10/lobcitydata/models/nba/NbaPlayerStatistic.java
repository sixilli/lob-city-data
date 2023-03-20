package com.group10.lobcitydata.models.nba;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = NbaPlayerStatisticDeserializer.class)
public class NbaPlayerStatistic {
    private List<NbaPlayerSeasonStats> seasonTotalsRegularSeason;
    private List<NbaPlayerSeasonStats> seasonTotalsPostSeason;
    private NbaPlayerCareerStats careerTotalsRegularSeason;
    private NbaPlayerCareerStats careerTotalsPostSeason;

    public List<NbaPlayerSeasonStats> getSeasonTotalsRegularSeason() {
        return this.seasonTotalsRegularSeason;
    }

    public void setSeasonTotalsRegularSeason(List<NbaPlayerSeasonStats> seasonTotalsRegularSeason) {
        this.seasonTotalsRegularSeason = seasonTotalsRegularSeason;
    }

    public List<NbaPlayerSeasonStats> getSeasonTotalsPostSeason() {
        return this.seasonTotalsPostSeason;
    }

    public void setSeasonTotalsPostSeason(List<NbaPlayerSeasonStats> seasonTotalsPostSeason) {
        this.seasonTotalsPostSeason = seasonTotalsPostSeason;
    }

    public NbaPlayerCareerStats getCareerTotalsRegularSeason() {
        return this.careerTotalsRegularSeason;
    }

    public void setCareerTotalsRegularSeason(NbaPlayerCareerStats careerTotalsRegularSeason) {
        this.careerTotalsRegularSeason = careerTotalsRegularSeason;
    }

    public NbaPlayerCareerStats getCareerTotalsPostSeason() {
        return this.careerTotalsPostSeason;
    }

    public void setCareerTotalsPostSeason(NbaPlayerCareerStats careerTotalsPostSeason) {
        this.careerTotalsPostSeason = careerTotalsPostSeason;
    }

}
