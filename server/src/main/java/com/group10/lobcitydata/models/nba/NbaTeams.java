package com.group10.lobcitydata.models.nba;

import java.util.Arrays;
import java.util.List;

public class NbaTeams {
    public static final List<NbaTeam> teams = Arrays.asList(
            new NbaTeam(1610612737, "ATL", "Hawks", 1949, "Atlanta", "Atlanta Hawks", "Atlanta", List.of(1958)),
            new NbaTeam(1610612738, "BOS", "Celtics", 1946, "Boston", "Boston Celtics", "Massachusetts", List.of(1957, 1959, 1960, 1961, 1962, 1963, 1964, 1965, 1966, 1968, 1969, 1974, 1976, 1981, 1984, 1986, 2008)),
            new NbaTeam(1610612739, "CLE", "Cavaliers", 1970, "Cleveland", "Cleveland Cavaliers", "Ohio", List.of(2016)),
            new NbaTeam(1610612740, "NOP", "Pelicans", 2002, "New Orleans", "New Orleans Pelicans", "Louisiana", null),
            new NbaTeam(1610612741, "CHI", "Bulls", 1966, "Chicago", "Chicago Bulls", "Illinois", List.of(1991, 1992, 1993, 1996, 1997, 1998)),
            new NbaTeam(1610612742, "DAL", "Mavericks", 1980, "Dallas", "Dallas Mavericks", "Texas", List.of(2011)),
            new NbaTeam(1610612743, "DEN", "Nuggets", 1976, "Denver", "Denver Nuggets", "Colorado", null),
            new NbaTeam(1610612744, "GSW", "Warriors", 1946, "Golden State", "Golden State Warriors", "California", List.of(1947, 1956, 1975, 2015, 2017, 2018, 2022)),
            new NbaTeam(1610612745, "HOU", "Rockets", 1967, "Houston", "Houston Rockets", "Texas", List.of(1994, 1995)),
            new NbaTeam(1610612746, "LAC", "Clippers", 1970, "Los Angeles", "Los Angeles Clippers", "California", null),
            new NbaTeam(1610612747, "LAL", "Lakers", 1948, "Los Angeles", "Los Angeles Lakers", "California", List.of(1949, 1950, 1952, 1953, 1954, 1972, 1980, 1982, 1985, 1987, 1988, 2000, 2001, 2002, 2009, 2010, 2020)),
            new NbaTeam(1610612748, "MIA", "Heat", 1988, "Miami", "Miami Heat", "Florida", List.of(2006, 2012, 2013)),
            new NbaTeam(1610612749, "MIL", "Bucks", 1968, "Milwaukee", "Milwaukee Bucks", "Wisconsin", List.of(1971, 2021)),
            new NbaTeam(1610612750, "MIN", "Timberwolves", 1989, "Minnesota", "Minnesota Timberwolves", "Minnesota", null),
            new NbaTeam(1610612751, "BKN", "Nets", 1976, "Brooklyn", "Brooklyn Nets", "New York", null),
            new NbaTeam(1610612752, "NYK", "Knicks", 1946, "New York", "New York Knicks", "New York", List.of(1970, 1973)),
            new NbaTeam(1610612753, "ORL", "Magic", 1989, "Orlando", "Orlando Magic", "Florida", null),
            new NbaTeam(1610612754, "IND", "Pacers", 1976, "Indiana", "Indiana Pacers", "Indiana", null),
            new NbaTeam(1610612755, "PHI", "76ers", 1949, "Philadelphia", "Philadelphia 76ers", "Pennsylvania", List.of(1955, 1967, 1983)),
            new NbaTeam(1610612756, "PHX", "Suns", 1968, "Phoenix", "Phoenix Suns", "Arizona", null),
            new NbaTeam(1610612757, "POR", "Trail Blazers", 1970, "Portland", "Portland Trail Blazers", "Oregon", List.of(1977)),
            new NbaTeam(1610612758, "SAC", "Kings", 1948, "Sacramento", "Sacramento Kings", "California", List.of(1951)),
            new NbaTeam(1610612759, "SAS", "Spurs", 1976, "San Antonio", "San Antonio Spurs", "Texas", List.of(1999, 2003, 2005, 2007, 2014)),
            new NbaTeam(1610612760, "OKC", "Thunder", 1967, "Oklahoma City", "Oklahoma City Thunder", "Oklahoma", List.of(1979)),
            new NbaTeam(1610612761, "TOR", "Raptors", 1995, "Toronto", "Toronto Raptors", "Ontario", List.of(2019)),
            new NbaTeam(1610612762, "UTA", "Jazz", 1974, "Utah", "Utah Jazz", "Utah", null),
            new NbaTeam(1610612763, "MEM", "Grizzlies", 1995, "Memphis", "Memphis Grizzlies", "Tennessee", null),
            new NbaTeam(1610612764, "WAS", "Wizards", 1961, "Washington", "Washington Wizards", "District of Columbia", List.of(1978)),
            new NbaTeam(1610612765, "DET", "Pistons", 1948, "Detroit", "Detroit Pistons", "Michigan", List.of(1989, 1990, 2004)),
            new NbaTeam(1610612766, "CHA", "Hornets", 1988, "Charlotte", "Charlotte Hornets", "North Carolina", null));

    public static List<NbaTeam> getTeams() {
        return teams;
    }
}
