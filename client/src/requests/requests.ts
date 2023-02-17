import { Team } from "../models/rapidapi";

const urlBase = import.meta.env.API_URL;

export async function requestTeams(): Promise<Team[]> {
  const response = await fetch(urlBase + "/teams");
  const teams = (await response.json()) as Team[];
  return teams;
}
