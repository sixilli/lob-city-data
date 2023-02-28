export interface Team {
  id: Number;
  name: String;
  nickname: String;
  code: String;
  city: String;
  logo: String;
  allStar: Boolean;
  nbaFranchise: Boolean;
  leagues: TeamLeague;
}

export interface Player {
  id: Number;
  firstname: String;
  lastname: String;
  birth: Birth;
  nba: Nba;
  height: Height;
  weight: Weight;
  college: String;
  affiliation: String;
  leagues: PlayerLeague;
}

export interface Birth {
  date: String;
  country: String;
}

export interface Nba {
  start: Number;
  pro: Number;
}

export interface Height {
  feets: String;
  inches: String;
  meters: String;
}

export interface Weight {
  pounds: String;
  kilograms: String;
}
export interface TeamLeague {
  standard: TeamLeagueData;
  vegas: TeamLeagueData;
  utah: TeamLeagueData;
  sacramento: TeamLeagueData;
}

export interface TeamLeagueData {
  conference: String;
  division: String;
}

export interface PlayerLeague {
  jersey: Number;
  active: Boolean;
  pos: String;
}

export interface TeamStatistics {
  games: Number;
  fastBreakPoints: Number;
  pointsInPaint: Number;
  biggestLead: Number;
  secondChancePoints: Number;
  pointsOffTurnovers: Number;
  longestRun: Number;
  points: Number;
  fgm: Number;
  fga: Number;
  fgp: Number;
  ftm: Number;
  fta: Number;
  ftp: Number;
  tpm: Number;
  tpa: Number;
  tpp: Number;
  offReb: Number;
  defReb: Number;
  totReb: Number;
  assists: Number;
  pFouls: Number;
  steals: Number;
  turnovers: Number;
  blocks: Number;
  plusMinus: Number;
}
