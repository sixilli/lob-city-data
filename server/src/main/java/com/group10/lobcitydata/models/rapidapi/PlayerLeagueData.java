package com.group10.lobcitydata.models.rapidapi;

public class PlayerLeagueData {
    private int jersey;
    private boolean active;
    private String pos;


    public int getJersey() {
        return this.jersey;
    }

    public void setJersey(int jersey) {
        this.jersey = jersey;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPos() {
        return this.pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

}
