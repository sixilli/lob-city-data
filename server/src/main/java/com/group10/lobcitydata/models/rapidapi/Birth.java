package com.group10.lobcitydata.models.rapidapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Birth {
    private String date;

    private String country;

    @JsonCreator
    public Birth(
        @JsonProperty("date") String date,
        @JsonProperty("country") String country
    ) {
        this.date = date;
        this.country = country;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    
}
