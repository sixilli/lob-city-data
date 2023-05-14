import { UserData } from "../models/user";

const urlBase = import.meta.env.VITE_API_URL;

async function makeRequest(url: string): Promise<Response> {
  const response = await fetch(url);
  if (!response.ok) {
    const message = await response.json();
    throw new Error(
      `received a HTTP status code of: ${
        response.status
      }, body: ${JSON.stringify(message)}`
    );
  }
  return response;
}

async function makePatch(url: string, body: string): Promise<Response> {
  const response = await fetch(url, {
    method: "PATCH",
    body: body,
    headers: {
      "Content-type": "application/json; charset=UTF-8",
    },
  });

  if (!response.ok) {
    const message = await response.json();
    throw new Error(
      `received a HTTP status code of: ${
        response.status
      }, body: ${JSON.stringify(message)}`
    );
  }
  return response;
}

async function makePost(url: string, body: string): Promise<Response> {
  const response = await fetch(url, {
    method: "POST",
    body: body,
    headers: {
      "Content-type": "application/json; charset=UTF-8",
    },
  });

  if (!response.ok) {
    const message = await response.json();
    throw new Error(
      `received a HTTP status code of: ${
        response.status
      }, body: ${JSON.stringify(message)}`
    );
  }
  return response;
}

export async function pingBackend(): Promise<Response> {
  const response = await makeRequest(urlBase);
  return response.json();
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

export async function postGetUserData(user: UserData): Promise<any> {
  const url = urlBase + "/users";
  const response = await makePost(url, JSON.stringify(user));
  return response.json();
}

export async function patchUserData(user: UserData): Promise<any> {
  const url = urlBase + "/users";
  const response = await makePatch(url, JSON.stringify(user));
  return response.json();
}
