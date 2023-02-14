package com.group10.lobcitydata.models.rapidapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {
    int id;
    String name;
    String nickname;
    String code;
    String city;
    String logo;
    Boolean allStar;
    Boolean nbaFranchise;
    League leagues;

    @JsonCreator
    public Team(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("nickname") String nickname,
            @JsonProperty("code") String code,
            @JsonProperty("city") String city,
            @JsonProperty("logo") String logo,
            @JsonProperty("allStar") Boolean allStar,
            @JsonProperty("nbaFranchise") Boolean nbaFranchise,
            @JsonProperty("leagues") League leagues
    ) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.code = code;
        this.city = city;
        this.logo = logo;
        this.allStar = allStar;
        this.nbaFranchise = nbaFranchise;
        this.leagues = leagues;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Boolean getAllStar() {
        return allStar;
    }

    public void setAllStar(Boolean allStar) {
        this.allStar = allStar;
    }

    public Boolean getNbaFranchise() {
        return nbaFranchise;
    }

    public void setNbaFranchise(Boolean nbaFranchise) {
        this.nbaFranchise = nbaFranchise;
    }

    public League getLeagues() {
        return leagues;
    }

    public void setLeagues(League leagues) {
        this.leagues = leagues;
    }
}
