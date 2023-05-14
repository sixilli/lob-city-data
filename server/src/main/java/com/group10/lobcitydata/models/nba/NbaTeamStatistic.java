package com.group10.lobcitydata.models.nba;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = NbaTeamStatsDeserializer.class)
public class NbaTeamStatistic {
    public String id;
    public int teamId;
    public String teamCity;
    public String teamName;
    public String year;
    public int gp;
    public int wins;
    public int losses;
    public double winPct;
    public int confRank;
    public int divRank;
    public int poWins;
    public int poLosses;
    public int confCount;
    public int divCount;
    public String nbaFinalsAppearance;
    public int fgm;
    public int fga;
    public double fgPct;
    public int fg3m;
    public int fg3a;
    public double fg3Pct;
    public int ftm;
    public int fta;
    public double ftPct;
    public int offensiveReb;
    public int defensiveReb;
    public int reb;
    public int ast;
    public int pf;
    public int stl;
    public int tov;
    public int blk;
    public int pts;
    public int ptsRank;

    public NbaTeamStatistic() {}

    public NbaTeamStatistic(String id, int teamId, String teamCity, String teamName, String year, int gp, int wins,
                            int losses, double winPct, int confRank, int divRank, int poWins, int poLosses,
                            int confCount, int divCount, String nbaFinalsAppearance, int fgm, int fga,
                            int fgPct, int fg3m, int fg3a, int fg3Pct, int ftm, int fta,
                            int ftPct, int offensiveReb, int defensiveReb, int reb, int ast, int pf,
                            int stl, int tov, int blk, int pts, int ptsRank) {
        this.id = id;
        this.teamId = teamId;
        this.teamCity = teamCity;
        this.teamName = teamName;
        this.year = year;
        this.gp = gp;
        this.wins = wins;
        this.losses = losses;
        this.winPct = winPct;
        this.confRank = confRank;
        this.divRank = divRank;
        this.poWins = poWins;
        this.poLosses = poLosses;
        this.confCount = confCount;
        this.divCount = divCount;
        this.nbaFinalsAppearance = nbaFinalsAppearance;
        this.fgm = fgm;
        this.fga = fga;
        this.fgPct = fgPct;
        this.fg3m = fg3m;
        this.fg3a = fg3a;
        this.fg3Pct = fg3Pct;
        this.ftm = ftm;
        this.fta = fta;
        this.ftPct = ftPct;
        this.offensiveReb = offensiveReb;
        this.defensiveReb = defensiveReb;
        this.reb = reb;
        this.ast = ast;
        this.pf = pf;
        this.stl = stl;
        this.tov = tov;
        this.blk = blk;
        this.pts = pts;
        this.ptsRank = ptsRank;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getGp() {
        return gp;
    }

    public void setGp(int gp) {
        this.gp = gp;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public double getWinPct() {
        return winPct;
    }

    public void setWinPct(double winPct) {
        this.winPct = winPct;
    }

    public int getConfRank() {
        return confRank;
    }

    public void setConfRank(int confRank) {
        this.confRank = confRank;
    }

    public int getDivRank() {
        return divRank;
    }

    public void setDivRank(int divRank) {
        this.divRank = divRank;
    }

    public int getPoWins() {
        return poWins;
    }

    public void setPoWins(int poWins) {
        this.poWins = poWins;
    }

    public int getPoLosses() {
        return poLosses;
    }

    public void setPoLosses(int poLosses) {
        this.poLosses = poLosses;
    }

    public int getConfCount() {
        return confCount;
    }

    public void setConfCount(int confCount) {
        this.confCount = confCount;
    }

    public int getDivCount() {
        return divCount;
    }

    public void setDivCount(int divCount) {
        this.divCount = divCount;
    }

    public String getNbaFinalsAppearance() {
        return nbaFinalsAppearance;
    }

    public void setNbaFinalsAppearance(String nbaFinalsAppearance) {
        this.nbaFinalsAppearance = nbaFinalsAppearance;
    }

    public int getFgm() {
        return fgm;
    }

    public void setFgm(int fgm) {
        this.fgm = fgm;
    }

    public int getFga() {
        return fga;
    }

    public void setFga(int fga) {
        this.fga = fga;
    }

    public double getFgPct() {
        return fgPct;
    }

    public void setFgPct(double fgPct) {
        this.fgPct = fgPct;
    }

    public int getFg3m() {
        return fg3m;
    }

    public void setFg3m(int fg3m) {
        this.fg3m = fg3m;
    }

    public int getFg3a() {
        return fg3a;
    }

    public void setFg3a(int fg3a) {
        this.fg3a = fg3a;
    }

    public double getFg3Pct() {
        return fg3Pct;
    }

    public void setFg3Pct(double fg3Pct) {
        this.fg3Pct = fg3Pct;
    }

    public int getFtm() {
        return ftm;
    }

    public void setFtm(int ftm) {
        this.ftm = ftm;
    }

    public int getFta() {
        return fta;
    }

    public void setFta(int fta) {
        this.fta = fta;
    }

    public double getFtPct() {
        return ftPct;
    }

    public void setFtPct(double ftPct) {
        this.ftPct = ftPct;
    }

    public int getOffensiveReb() {
        return offensiveReb;
    }

    public void setOffensiveReb(int offensiveReb) {
        this.offensiveReb = offensiveReb;
    }

    public int getDefensiveReb() {
        return defensiveReb;
    }

    public void setDefensiveReb(int defensiveReb) {
        this.defensiveReb = defensiveReb;
    }

    public int getReb() {
        return reb;
    }

    public void setReb(int reb) {
        this.reb = reb;
    }

    public int getAst() {
        return ast;
    }

    public void setAst(int ast) {
        this.ast = ast;
    }

    public int getPf() {
        return pf;
    }

    public void setPf(int pf) {
        this.pf = pf;
    }

    public int getStl() {
        return stl;
    }

    public void setStl(int stl) {
        this.stl = stl;
    }

    public int getTov() {
        return tov;
    }

    public void setTov(int tov) {
        this.tov = tov;
    }

    public int getBlk() {
        return blk;
    }

    public void setBlk(int blk) {
        this.blk = blk;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getPtsRank() {
        return ptsRank;
    }

    public void setPtsRank(int ptsRank) {
        this.ptsRank = ptsRank;
    }

    public void assignId() {
        var sb = new StringBuilder(this.year);
        sb.delete(4,7);
        this.id = this.teamId + sb.toString();
    }

    public static String getDbId(String id, String season) {
        return id + season;
    }
}