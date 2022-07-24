import request from "supertest"
import cloudflareParameters from "../../../utils/cloudflareParameters"
import HomeRestApi from "./homeRestApi"

class SessionRestApi {

    static getSessionResponse: any

    constructor() {

    }

    async getSessionDetails(host: string, sessionID: string): Promise<any> {

        let endpoint = `/v3/admin/events/session/${sessionID}`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        let response = await request(host)
            .get(endpoint)
            .set("content-type", "application/json")
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
            .accept("application/json")
            .query(queryStr)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        SessionRestApi.getSessionResponse = JSON.parse(JSON.stringify(response.body))
        return SessionRestApi.getSessionResponse
    }
}
export default new SessionRestApi