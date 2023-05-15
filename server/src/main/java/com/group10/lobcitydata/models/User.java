package com.group10.lobcitydata.models;

/*
    2.2.1 User
*/
public class User {
    public String uuid;
    public String displayName;
    public String lastSignOn;
    public String favoriteTeam;
    public int teamId;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFavoriteTeam() {
        return favoriteTeam;
    }

    public void setFavoriteTeam(String favoriteTeam) {
        this.favoriteTeam = favoriteTeam;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLastSignOn() {
        return lastSignOn;
    }

    public void setLastSignOn(String lastSignOn) {
        this.lastSignOn = lastSignOn;
    }
}
