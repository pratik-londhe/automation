import request from "supertest"
import cloudflareParameters from "../../../utils/cloudflareParameters"

class HomeRestApi {

    static postLoginToStreamsRes: any
    static streamsToken: string
    static getChannelsForProfileRes: any
    static getEventsForChannelRes: any

    constructor() {

    }

    async postLoginToStreams(host: string, payload: string): Promise<any> {

        let endpoint = `/v3/admin/auth/sign-in`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .post(endpoint)
                    .set("content-type", "application/json")
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        HomeRestApi.postLoginToStreamsRes = JSON.parse(JSON.stringify(response.body))
        HomeRestApi.streamsToken = HomeRestApi.postLoginToStreamsRes.token
        console.log(`The token is: ${HomeRestApi.streamsToken}`)
        return HomeRestApi.postLoginToStreamsRes
    }

    async getChannelsForProfile(host: string): Promise<any> {

        let endpoint = `/v3/admin/auth/channels`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", HomeRestApi.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        HomeRestApi.getChannelsForProfileRes = JSON.parse(JSON.stringify(response.body))
        return HomeRestApi.getChannelsForProfileRes
    }

    async getEventsForChannel(host: string, channelId: number): Promise<any> {

        let endpoint = `/v3/admin/events/${channelId}`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", HomeRestApi.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        //console.log(`>> Response: ${JSON.stringify(response.body)}`)
        HomeRestApi.getEventsForChannelRes = JSON.parse(JSON.stringify(response.body))
        return response
    }

}

export default new HomeRestApi