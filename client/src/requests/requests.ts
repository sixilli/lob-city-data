const urlBase = import.meta.env.VITE_API_URL;

async function makeRequest(url: string): Promise<Response> {
  const response = await fetch(url);
  if (!response.ok) {
    throw new Error(
      `recieved a HTTP status code of: ${response.status}, body: ${response.body}`
    );
  }
  return response;
}

export async function requestTeams(): Promise<any> {
  try {
    const url = urlBase + "/teams";
    const response = await makeRequest(url);
    return response.json();
  } catch (error) {
    console.log(error);
  }
}

export async function requestPlayers(): Promise<any> {
  try {
    const url = urlBase + "/players?country=USA";
    const response = await makeRequest(url);
    return response.json();
  } catch (error) {
    console.log(error);
  }
}
