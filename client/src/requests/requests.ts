const urlBase = import.meta.env.API_URL;

export async function requestTeams(): Promise<any> {
  let resp = fetch(urlBase + "/teams");
  return resp;
}
