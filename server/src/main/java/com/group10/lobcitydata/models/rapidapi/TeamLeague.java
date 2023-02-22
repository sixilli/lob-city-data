package com.group10.lobcitydata.models.rapidapi;

public class TeamLeague {
    private TeamLeagueData standard;
    private TeamLeagueData vegas;
    private TeamLeagueData utah;
    private TeamLeagueData sacramento;

    public TeamLeagueData getStandard() {
        return standard;
    }

    public void setStandard(TeamLeagueData standard) {
        this.standard = standard;
    }

    public TeamLeagueData getVegas() {
        return vegas;
    }

    public void setVegas(TeamLeagueData vegas) {
        this.vegas = vegas;
    }

    public TeamLeagueData getUtah() {
        return utah;
    }

    public void setUtah(TeamLeagueData utah) {
        this.utah = utah;
    }

    public TeamLeagueData getSacramento() {
        return sacramento;
    }

    public void setSacramento(TeamLeagueData sacramento) {
        this.sacramento = sacramento;
    }
}
