package com.group10.lobcitydata.models.rapidapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Height {
    private String feets;
    private String inches;
    private String meters;

    @JsonCreator
    public Height(
        @JsonProperty("feets") String feets,
        @JsonProperty("inches") String inches,
        @JsonProperty("meters") String meters
    ) {
        this.feets = feets;
        this.inches = inches;
        this.meters = meters;
    }


    public String getFeets() {
        return this.feets;
    }

    public void setFeets(String feets) {
        this.feets = feets;
    }

    public String getInches() {
        return this.inches;
    }

    public void setInches(String inches) {
        this.inches = inches;
    }

    public String getMeters() {
        return this.meters;
    }

    public void setMeters(String meters) {
        this.meters = meters;
    }

}


