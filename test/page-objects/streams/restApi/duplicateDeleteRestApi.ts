import request from "supertest"
import cloudflareParameters from "../../../utils/cloudflareParameters"
import HomeRestApi from "./homeRestApi"

class DuplicateDeleteRestApi {

    static duplicateEventRes: any
    static deleteDuplicateEventRes: any

    constructor() {

    }

    async duplicateTheEvent(host: string, eventUuid: number, payload: string): Promise<any> {

        let endpoint = `/v3/admin/events/duplicate-event/${eventUuid}`;
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
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
            .send(payload)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        DuplicateDeleteRestApi.duplicateEventRes = JSON.parse(JSON.stringify(response.body))
        return DuplicateDeleteRestApi.duplicateEventRes
    }

    async DeleteDuplicateEvent(host: string, eventUuid: number): Promise<any> {

        let endpoint = `/v3/admin/events/event/${eventUuid}`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        let response = await request(host)
            .delete(endpoint)
            .set("content-type", "application/json")
            .accept("application/json")
            .query(queryStr)
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        DuplicateDeleteRestApi.deleteDuplicateEventRes = JSON.parse(JSON.stringify(response.body))
        return DuplicateDeleteRestApi.deleteDuplicateEventRes
    }
}

export default new DuplicateDeleteRestApi