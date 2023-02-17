export interface Team {
  id: Number;
  name: String;
  nickname: String;
  code: String;
  city: String;
  logo: String;
  allStar: Boolean;
  nbaFranchise: Boolean;
  leagues: League;
}

export interface League {
  standard: LeagueData;
  vegas: LeagueData;
  utah: LeagueData;
  sacramento: LeagueData;
}

export interface LeagueData {
  conference: String;
  division: String;
}
