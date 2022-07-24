import request from "supertest"
import cloudflareParameters from "../../../utils/cloudflareParameters"
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi"
//import reporter from "../../../utils/reporter"

class PublishEventRestApi {

    static getPublishStatusByUuidRes: any
    static postPublishEventRes: any

    constructor(){

    }

    async getPublishStatusByUuid(host: string, uuid: string): Promise<any> {

        let endpoint = `/v3/admin/events/published-status/${uuid}`;
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
        PublishEventRestApi.getPublishStatusByUuidRes = JSON.parse(JSON.stringify(response.body))
        return PublishEventRestApi.getPublishStatusByUuidRes
    }

    async postPublishEvent(host: string, payload: string): Promise<any>{
        let endpoint = `/v3/admin/events/publish`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .post(endpoint)
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .set("content-type", "application/json")
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        PublishEventRestApi.postPublishEventRes = JSON.parse(JSON.stringify(response.body))
        return PublishEventRestApi.postPublishEventRes
    }

}

export default new PublishEventRestApi