export interface TeamStatistic {
  id: string;
  teamId: number;
  teamCity: string;
  teamName: string;
  year: string;
  gp: number;
  wins: number;
  losses: number;
  winPct: number;
  confRank: number;
  divRank: number;
  poWins: number;
  poLosses: number;
  confCount: number;
  divCount: number;
  nbaFinalsAppearance: string;
  fgm: number;
  fga: number;
  fgPct: number;
  fg3m: number;
  fg3a: number;
  fg3Pct: number;
  ftm: number;
  fta: number;
  ftPct: number;
  offensiveReb: number;
  defensiveReb: number;
  reb: number;
  ast: number;
  pf: number;
  stl: number;
  tov: number;
  blk: number;
  pts: number;
  ptsRank: number;
}

export interface Team {
  id: number;
  abbreviation: string;
  nickname: string;
  yearFounded: number;
  city: string;
  fullName: string;
  state: string;
  championshipYears: string[];
}

export interface BasicPlayer {
  id: number;
  lastName: string;
  firstName: string;
  fullName: string;
  isActive: boolean;
}
