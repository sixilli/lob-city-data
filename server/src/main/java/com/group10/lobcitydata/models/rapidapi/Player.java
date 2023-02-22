package com.group10.lobcitydata.models.rapidapi;

public class Player {
    int id;
    String firstname;
    String lastname;
    Birth birth;
    Nba nba;
    Height height;
    Weight weight;
    String college;
    String affiliation;
    TeamLeague leagues;
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
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

    public TeamLeague getLeagues() {
        return this.leagues;
    }

    public void setLeagues(TeamLeague leagues) {
        this.leagues = leagues;
    }
}
