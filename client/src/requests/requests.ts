const urlBase = "https://lob-city-data-api-ql3yzcjy5a-uc.a.run.app"

export async function requestTeams(): Promise<any> {
    return fetch(urlBase + "/teams")
}