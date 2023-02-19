package com.group10.lobcitydata.models.rapidapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {
    int id;
    String firstName;
    String lastName;
    Birth birth;
    Nba nba;
    Height height;
    Weight weight;
    String college;
    String affiliation;
    League leagues;
    
    @JsonCreator
    public Player(
        @JsonProperty("id") int id,
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("birth") Birth birth,
        @JsonProperty("nba") Nba nba,
        @JsonProperty("height") Height height,
        @JsonProperty("weight") Weight weight,
        @JsonProperty("college") String college,
        @JsonProperty("affiliation") String affiliation,
        @JsonProperty("leagues") League leagues
      
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.nba = nba;
        this.height = height;
        this.weight = weight;
        this.college = college;
        this.affiliation = affiliation;
        this.leagues = leagues;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Birth getBirth() {
        return this.birth;
    }

    public void setBirth(Birth birth) {
        this.birth = birth;
    }

    public Nba getNba() {
        return this.nba;
    }

    public void setNba(Nba nba) {
        this.nba = nba;
    }

    public Height getHeight() {
        return this.height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public Weight getWeight() {
        return this.weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public String getCollege() {
        return this.college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getAffiliation() {
        return this.affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public League getLeagues() {
        return this.leagues;
    }

    public void setLeagues(League leagues) {
        this.leagues = leagues;
    }
}
