import request from "supertest"
import cloudflareParameters from "../../../utils/cloudflareParameters"
import HomeRestApi from "./homeRestApi"

class AddVideoToODSessionRestApi {

    static getChannelResponse: any
    static getAddVideoResponse: any
    static getVideoActionResponse: any

    constructor() {

    }

    async addVideoToSession(host: string, payload: string): Promise<any> {

        let endpoint = `/v3/admin/event/session`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        let response = await request(host)
            .put(endpoint)
            .set("content-type", "application/json")
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
            .accept("application/json")
            .query(queryStr)
            .send(payload)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        AddVideoToODSessionRestApi.getAddVideoResponse = JSON.parse(JSON.stringify(response.body))
        return AddVideoToODSessionRestApi.getAddVideoResponse
    }

    async getChannelDetails(host: string, channelID: string): Promise<any> {

        let endpoint = `/v3/admin/channel/videos/channel/${channelID}`;
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
        AddVideoToODSessionRestApi.getChannelResponse = JSON.parse(JSON.stringify(response.body))
        return AddVideoToODSessionRestApi.getChannelResponse
    }

    async videoAction(host: string, payload: string): Promise<any> {

        let endpoint = `/actions`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        let response = await request(host)
            .post(endpoint)
            .set("content-type", "application/json")
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
            .accept("application/json")
            .query(queryStr)

        console.log(`>> Response: ${JSON.stringify(response)}`)
        AddVideoToODSessionRestApi.getVideoActionResponse = JSON.parse(JSON.stringify(response))
        return AddVideoToODSessionRestApi.getVideoActionResponse
    }
}
export default new AddVideoToODSessionRestApi