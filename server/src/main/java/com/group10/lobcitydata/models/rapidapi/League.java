package com.group10.lobcitydata.models.rapidapi;

public class League {
    private LeagueData standard;
    private LeagueData vegas;
    private LeagueData utah;
    private LeagueData sacramento;

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
