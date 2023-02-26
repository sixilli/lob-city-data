const urlBase = import.meta.env.VITE_API_URL;

async function makeRequest(url: string): Promise<Response> {
  const response = await fetch(url);
  if (!response.ok) {
    const message = await response.json();
    throw new Error(
      `recieved a HTTP status code of: ${
        response.status
      }, body: ${JSON.stringify(message)}`
    );
  }
  return response;
}

export async function requestTeams(): Promise<any> {
  const url = urlBase + "/teams";
  const response = await makeRequest(url);
  return response.json();
}

export async function requestPlayers(): Promise<any> {
  const url = urlBase + "/players?country=USA";
  const response = await makeRequest(url);
  return response.json();
}

export async function requestTeamStatistics(
  teamId: string,
  season: string
): Promise<any> {
  const url = new URL(`${urlBase}/teams/${teamId}/statistics`);
  url.searchParams.append("season", season);
  const response = await makeRequest(url.toString());
  return response.json();
}
