package com.group10.lobcitydata.models.rapidapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Nba {
    private int start;
    private int pro;


    @JsonCreator
    public Nba(
        @JsonProperty("start") int start,
        @JsonProperty("pro") int pro
    ) {
        this.start = start;
        this.pro = pro;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPro() {
        return this.pro;
    }

    public void setPro(int pro) {
        this.pro = pro;
    }
}

