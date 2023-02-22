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

export interface Player {
  id: Number
  firstname: String
  lastname: String
  birth: Birth
  nba: Nba
  height: Height
  weight: Weight
  college: String
  affiliation: String
  leagues: League
}

export interface Birth {
  date: String
  country: String
}

export interface Nba {
  start: Number
  pro: Number
}

export interface Height {
  feets: String
  inches: String
  meters: String
}

export interface Weight {
  pounds: String
  kilograms: String
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
