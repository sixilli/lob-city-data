package com.group10.lobcitydata.models.rapidapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Weight {
    private String pounds;
    private String kilograms;

    @JsonCreator
    public Weight(
        @JsonProperty("pounds") String pounds,
        @JsonProperty("kilograms") String kilograms
    ) {
        this.pounds = pounds;
        this.kilograms = kilograms;
    }


    public String getPounds() {
        return this.pounds;
    }

    public void setPounds(String pounds) {
        this.pounds = pounds;
    }

    public String getKilograms() {
        return this.kilograms;
    }

    public void setKilograms(String kilograms) {
        this.kilograms = kilograms;
    }

}
