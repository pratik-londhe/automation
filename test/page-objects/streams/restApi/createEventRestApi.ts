import request from "supertest"
import cloudflareParameters from "../../../utils/cloudflareParameters"
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi"
import reporter from "../../../utils/reporter"

class CreateEventRestApi {

    static getTemplatesForChannelRes: any
    static eventNameByApi: string
    static eventTemplateNumber: number
    static postCheckEventNameRes: any
    static getTracksForChannelRes: any
    static postCreateEventRes: any
    static getEventDetailsByUuidRes: any
    static postCheckEventPathUrlRes: any
    static statusCode: any
    constructor() {

    }

    async selectEventTemplateByNumber(): Promise<number> {
        try {
            reporter.addStep("info", `Selecting the event template by number...`)
            let eventTemplateNumber = Math.floor(Math.random() * 3) + 1
            reporter.addStep("info", `The event template is:  ${eventTemplateNumber}`);
            reporter.addStep("info", `event template selected...`)
            return eventTemplateNumber
        } catch (err) {
            err.message = `Error selecting the event template: , ${err.message} `
            throw err
        }
    }

    async generateSessionName(sessionName: String): Promise<string> {
        try {
            reporter.addStep("info", `Generating the Session name...`)
            let random = Math.floor(Math.random() * 10) + 1
            let nameOfSession = sessionName + " " + random;
            reporter.addStep("info", `The session name is:  ${nameOfSession}`);
            reporter.addStep("info", `Generated the Session name...`)
            return nameOfSession
        } catch (err) {
            err.message = `Error generating the session name: , ${err.message} `
            throw err
        }
    }

    async generateEventName(): Promise<string> {
        try {
            reporter.addStep("info", `Generating the Event name...`)
            let random = Math.floor(Math.random() * 1000) + 1
            let date = new Date().toLocaleString()
            CreateEventRestApi.eventTemplateNumber = await this.selectEventTemplateByNumber()
            CreateEventRestApi.eventNameByApi = "Automation template " + CreateEventRestApi.eventTemplateNumber + " Event " + random + " " + date
            reporter.addStep("info", `The Event name is:  ${CreateEventRestApi.eventNameByApi}`);
            reporter.addStep("info", `Generated the Event name...`)          
            return CreateEventRestApi.eventNameByApi
        } catch (err) {
            err.message = `Error generating the event name: , ${err.message} `
            throw err
        }
    }

    async getTemplatesForChannel(host: string, channelId: number): Promise<any> {

        let endpoint = `/v3/admin/events/templates/${channelId}`;
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
        CreateEventRestApi.getTemplatesForChannelRes = JSON.parse(JSON.stringify(response.body))
        return CreateEventRestApi.getTemplatesForChannelRes
    }

    async postCheckEventName(host: string, payload: string): Promise<any> {

        let endpoint = `/v3/admin/events/check-event-name`;
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
        CreateEventRestApi.postCheckEventNameRes = JSON.parse(JSON.stringify(response.body))
        return CreateEventRestApi.postCheckEventNameRes
    }

    async getTracksForChannel(host: string, channelId: number): Promise<any> {

        let endpoint = `/v3/admin/events/tracks/${channelId}`;
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
        CreateEventRestApi.getTracksForChannelRes = JSON.parse(JSON.stringify(response.body))
        return CreateEventRestApi.getTracksForChannelRes
    }

    async postCreateEvent(host: string, payload: string): Promise<any> {

        let endpoint = `/v3/admin/event`;
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
        CreateEventRestApi.statusCode = JSON.parse(JSON.stringify(response.status))
        CreateEventRestApi.postCreateEventRes = JSON.parse(JSON.stringify(response.body))
        return CreateEventRestApi.postCreateEventRes
    }

    async getEventDetailsByUuid(host: string, uuid: string): Promise<any> {

        let endpoint = `/v3/admin/event/${uuid}`;
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

        console.log(`>> Response: ${JSON.parse(JSON.stringify(response.body))}`)
        CreateEventRestApi.getEventDetailsByUuidRes = JSON.parse(JSON.stringify(response.body))
        return CreateEventRestApi.getEventDetailsByUuidRes
    }

    async postCheckEventPathUrl(host: string, payload: string): Promise<any>{
        let endpoint = `/v3/admin/events/check-url`;
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
        CreateEventRestApi.postCheckEventPathUrlRes = JSON.parse(JSON.stringify(response.body))
        return CreateEventRestApi.postCheckEventPathUrlRes
    }
}

export default new CreateEventRestApi