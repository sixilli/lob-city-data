import { Team } from "../models/rapidapi";

const urlBase = import.meta.env.VITE_API_URL;

export async function requestTeams(): Promise<Team[]> {
  const url = urlBase + "/teams";
  const response = await fetch(url);
  return response.json();
}
