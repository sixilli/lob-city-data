package com.group10.lobcitydata.models.rapidapi;

public class PlayerLeague {
    private PlayerLeagueData standard;
    private PlayerLeagueData vegas;
    private PlayerLeagueData africa;
    private PlayerLeagueData utah;
    private PlayerLeagueData sacramento;

    public PlayerLeagueData getStandard() {
        return standard;
    }

    public void setStandard(PlayerLeagueData standard){
        this.standard = standard;
    }

    public PlayerLeagueData getVegas() {
        return vegas;
    }

    public void setVegas(PlayerLeagueData vegas) {
        this.vegas = vegas;
    }

    public PlayerLeagueData getUtah() {
        return utah;
    }

    public void setUtah(PlayerLeagueData utah) {
        this.utah = utah;
    }

    public PlayerLeagueData getSacramento() {
        return sacramento;
    }

    public void setSacramento(PlayerLeagueData sacramento) {
        this.sacramento = sacramento;
    }

    public PlayerLeagueData getAfrica() {
        return africa;
    }

    public void setAfrica(PlayerLeagueData africa) {
        this.africa = africa;
    }
}
