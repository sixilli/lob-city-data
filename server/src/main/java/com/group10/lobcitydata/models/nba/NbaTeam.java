package com.group10.lobcitydata.models.nba;

import java.util.List;

/*
    2.2.3 NBA data models
*/
public class NbaTeam {
    public int id;
    public String abbreviation;
    public String nickname;
    public int yearFounded;
    public String city;
    public String fullName;
    public String state;
    public List<Integer> championshipYears;

    public NbaTeam(int id,
                   String abbreviation,
                   String nickname,
                   int yearFounded,
                   String city,
                   String fullName,
                   String state,
                   List<Integer> championshipYears) {
        this.id = id;
        this.abbreviation = abbreviation;
        this.nickname = nickname;
        this.yearFounded = yearFounded;
        this.fullName = fullName;
        this.city = city;
        this.state = state;
        this.championshipYears = championshipYears;
    }
}
