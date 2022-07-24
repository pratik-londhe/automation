import request from "supertest"
import cloudflareParameters from "../../../utils/cloudflareParameters"
import HomeRestApi from "./homeRestApi"

class ReactionRestAPi {

    static getChannelResponceRes: any
    static getUpdateReactionRes: any

    constructor() {

    }

    async getChannelReactions(host: string, channelId: number): Promise<any> {

        let endpoint = `/v3/admin/channel/reactions/custom/${channelId}`;
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
        ReactionRestAPi.getChannelResponceRes = JSON.parse(JSON.stringify(response.body))
        return ReactionRestAPi.getChannelResponceRes
    }

    async updateReactionsToSession(host: string, payload: string): Promise<any> {

        let endpoint = `/v3/admin/event/session`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        let response = await request(host)
            .put(endpoint)
            .set("content-type", "application/json")
            .accept("application/json")
            .query(queryStr)
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
            .send(payload)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        ReactionRestAPi.getUpdateReactionRes = JSON.parse(JSON.stringify(response.body))
        return ReactionRestAPi.getUpdateReactionRes
    }
}
export default new ReactionRestAPi