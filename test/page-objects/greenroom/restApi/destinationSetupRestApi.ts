import request from "supertest"
import HomeRestApi from "./homeRestApi"

export interface SaveSettingsPayload {
    meeting: number;
    settings: string;
}

export interface UpdateRtmpEndpointPayload {
    name: string;
    rtmpAddress: string;
    streamKey: string;
}

class DestinationSetupApi {

    async saveSettings(host: string, payload: SaveSettingsPayload): Promise<any> {
        let endpoint = `/v2/greenroom/settings`
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        let response = await request(host)
            .post(endpoint)
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
            .set("content-type", "application/json")
            .accept("application/json")
            .send(payload)
        return response;
    }

    async enableStreamingDestination(host: string, meetingId: string, payload: UpdateRtmpEndpointPayload): Promise<any> {
        let endpoint = `/v2/greenroom/broadcast/endpoint/${meetingId}`
        console.log(`The url is >> ${host}${endpoint}`)
        console.log("The payload is >> ", payload)

        let response = await request(host)
            .put(endpoint)
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
            .set("content-type", "application/json")
            .accept("application/json")
            .send(payload)
        return response;
    }
}

export default new DestinationSetupApi