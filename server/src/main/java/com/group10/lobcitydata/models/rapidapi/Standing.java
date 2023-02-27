package com.group10.lobcitydata.models.rapidapi;

public class Standing {
    private String league;
    private int season;
    private Team team;
    private String conference;
    private String division;


    @JsonCreator
    public Standing(
            @JsonProperty("league") String league,
            @JsonProperty("season") int season,
            @JsonProperty("team") Team team,
            @JsonProperty("conference") String conference,
            @JsonProperty("division") String division

    ) {
        this.league = league;
        this.season = season;
        this.team = team;
        this.conference = conference;
        this.conference = division;
    }


    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

}

