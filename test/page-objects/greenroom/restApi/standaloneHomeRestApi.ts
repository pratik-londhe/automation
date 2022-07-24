import request from "supertest"
import HomeRestApi from "./homeRestApi"
import fs from "fs"
import SGREventCreationPage from "../UI/Standalone/SGREventCreationPage"
import { getMySqlQueryResult } from "../../../utils/dbMySql";
import editJsonFile from "edit-json-file";
class StandaloneHomeRestApi {


    static getStandAloneChannelResponse: any
    static getStandAloneTotalEventsResponse: any
    static getCreateSGRResponse: any // This is response we get from creating sgr event 
    static getNewSGRMeetingId: any // This is a new meeting
    static getNewSGRSlugMeetingId: any // New meeting slug id
    static setNewSGREventName // New Meeting sgr name 
    static channelId: any
    static getCopySGRResponse: any
    static getpresenterAccess: any
    static updateProfile: any
    static getSGRMeetingsbyChannelId: any
    static getSGRMeetingsbyEventId: any
    static getActiveRoomsRes: any
    static getDetailsByMeetingId: any
    static getLogDetailsRes: any
    static getGrUserProfileId: number

    constructor() {

    }

    async getStandAloneChannels(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/profile/greenroom`;
        console.log(`The url is >> ${host}${endpoint}`)

        let response = await request(host)
            .get(endpoint)
            .set("content-type", "application/json")
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
            .accept("application/json")

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        StandaloneHomeRestApi.getStandAloneChannelResponse = JSON.parse(JSON.stringify(response.body))
        return StandaloneHomeRestApi.getStandAloneChannelResponse
    }

    async getStandaloneEvents(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/standalone/meetings`;
        console.log(`The url is >> ${host}${endpoint}`)

        let response = await request(host)
            .get(endpoint)
            .set("content-type", "application/json")
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
            .accept("application/json")

        StandaloneHomeRestApi.getStandAloneTotalEventsResponse = JSON.parse(JSON.stringify(response.body))
        return StandaloneHomeRestApi.getStandAloneTotalEventsResponse
    }

    async postStandaloneCreateEvent(host: string, payload: string): Promise<any> {
        let endpoint = `/v2/greenroom/create-or-update-meeting`
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        let response = await request(host)
            .post(endpoint)
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
            .set("content-type", "application/json")
            .accept("application/json")
            .send(payload)
        StandaloneHomeRestApi.getCreateSGRResponse = JSON.parse(JSON.stringify(response.body))
        console.log(`>> Response here : ${JSON.stringify(response.body)}`)
        return StandaloneHomeRestApi.getCreateSGRResponse

    }

    async postCopyGreenroom(host: string, payload: string): Promise<any> {
        let endpoint = `/v2/greenroom/copy-meeting`
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        let response = await request(host)
            .post(endpoint)
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
            .set("content-type", "application/json")
            .accept("application/json")
            .send(payload)
        StandaloneHomeRestApi.getCopySGRResponse = JSON.parse(JSON.stringify(response.body))
        console.log(`>> Response here : ${JSON.stringify(response.body)}`)
        return StandaloneHomeRestApi.getCopySGRResponse
    }

    async checkPresenterAccess(host: string, payload: string): Promise<any> {
        let endpoint = `/v2/greenroom/presenter/login`
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        let response = await request(host)
            .post(endpoint)
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
            .set("content-type", "application/json")
            .accept("application/json")
            .send(payload)
        StandaloneHomeRestApi.getpresenterAccess = JSON.parse(JSON.stringify(response.body))
        console.log(`>> Response here : ${JSON.stringify(response.body)}`)
        return StandaloneHomeRestApi.getpresenterAccess
    }

    async updateProfileDetail(host: string, payload: string): Promise<any> {
        let endpoint = `/v2/greenroom/profile`
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        let response = await request(host)
            .put(endpoint)
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
            .set("content-type", "application/json")
            .accept("application/json")
            .send(payload)
        StandaloneHomeRestApi.updateProfile = JSON.parse(JSON.stringify(response.body))
        console.log(`>> Response here : ${JSON.stringify(response.body)}`)
        return StandaloneHomeRestApi.getCreateSGRResponse
    }

    async getSGRMeetingByChannelId(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/standalone/meetings/${StandaloneHomeRestApi.channelId}`;
        console.log(`The url is >> ${host}${endpoint}`)

        let response = await request(host)
            .get(endpoint)
            .set("content-type", "application/json")
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
            .accept("application/json")

        StandaloneHomeRestApi.getSGRMeetingsbyChannelId = JSON.parse(JSON.stringify(response.body))
        return StandaloneHomeRestApi.getSGRMeetingsbyChannelId
    }

    async getSGRMeetingByEventId(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/standalone/meetings/${StandaloneHomeRestApi.getNewSGRMeetingId}`;
        console.log(`The url is >> ${host}${endpoint}`)

        let response = await request(host)
            .get(endpoint)
            .set("content-type", "application/json")
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
            .accept("application/json")

        StandaloneHomeRestApi.getSGRMeetingsbyEventId = JSON.parse(JSON.stringify(response.body))
        return StandaloneHomeRestApi.getSGRMeetingsbyEventId
    }

    async getActiveRooms(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/active-rooms`;
        console.log(`The url is >> ${host}${endpoint}`)

        let response = await request(host)
            .get(endpoint)
            .set("content-type", "application/json")
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
            .accept("application/json")

        console.log(`>>Get ACtive Room Response: ${JSON.stringify(response.body)}`)
        StandaloneHomeRestApi.getActiveRoomsRes = JSON.parse(JSON.stringify(response))
        return StandaloneHomeRestApi.getActiveRoomsRes
    }


    async getDetailsByMeetingId(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/${StandaloneHomeRestApi.getNewSGRMeetingId}`;
        console.log(`The url is >> ${host}${endpoint}`)

        let response = await request(host)
            .get(endpoint)
            .set("content-type", "application/json")
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
            .accept("application/json")

        console.log(`>>Get details by meeting id Response: ${JSON.stringify(response.body)}`)
        StandaloneHomeRestApi.getNewSGRSlugMeetingId = JSON.parse(JSON.stringify(response.body['meeting_id']))
        console.log(`>>Slug: ${StandaloneHomeRestApi.getNewSGRSlugMeetingId}`)
        StandaloneHomeRestApi.getDetailsByMeetingId = JSON.parse(JSON.stringify(response.body))
        return response
    }

    async postJoinRoomCreateLog(host: string, payload: string): Promise<any> {
        let endpoint = `/v2/greenroom/logger/log`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        let response = await request(host)
            .post(endpoint)
            .set("content-type", "application/json")
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
            .accept("application/json").send(payload)

        console.log(`>>Get Create log Respone Status: ${JSON.stringify(response.status)}`)
        StandaloneHomeRestApi.getLogDetailsRes = JSON.parse(JSON.stringify(response))
        return response
    }

    async getGrUserProfile(email: string) {
        let query = `select gr_user from gr_users where email = '${email}'`
        let user = await getMySqlQueryResult(query).then(user => {
            return user[0].gr_user
        })
        StandaloneHomeRestApi.getGrUserProfileId = user
        return user
    }

}

export default new StandaloneHomeRestApi