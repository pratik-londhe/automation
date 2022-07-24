import request from "supertest"
import standaloneHomeRestApi from "./standaloneHomeRestApi";
import shotsRestApi from "./shotsRestApi";
import HomeRestApi from "../../../page-objects/greenroom/restApi/homeRestApi"

interface KeyStringObject {
    [key: string]: any;
}

export interface BulkEditShotsPayload {
    meeting: number;
    shots: KeyStringObject[];
}

export interface BodyStatusResponse {
    body: KeyStringObject[] | undefined;
    status: number;
};

class DetailsPageRestApi{

    static getInvitationsByMeetingId: any
    static postCreateInvitationsRes: any
	static getMeetingGraphicsDetails: any
    static postBulkEditShotsResponse: BodyStatusResponse
	static getGRNotificationResponseBody:any
	static getTokBoxToken:any

    constructor(){

    }

    async getDetailsByInvitationsByRoomId(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/invitations/${Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRMeetingId}`;
        console.log(`The url is >> ${host}${endpoint}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json")

        console.log(`>>Get invitations by meeting id Response: ${JSON.stringify(response.body)}`)
        DetailsPageRestApi.getInvitationsByMeetingId = JSON.parse(JSON.stringify(response))
        return DetailsPageRestApi.getInvitationsByMeetingId
    }

    async postCreateInvitations(host: string, payload: string): Promise<any> {
        let endpoint = `/v2/greenroom/create-invitations`;
        console.log(`The url is >> ${host}${endpoint}`)
		console.log(`The payload is >> ${payload}`)
        
        let response = await request(host)
                    .post(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json").send(payload)

        console.log(`>>Create invitations by meeting id Response: ${JSON.stringify(response.body)}`)
        DetailsPageRestApi.postCreateInvitationsRes = JSON.parse(JSON.stringify(response))
        return DetailsPageRestApi.postCreateInvitationsRes
    }


	async requestStateSync(host: string): Promise<any> {
        let endpoint = `/request-state/${Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRMeetingId}`;
        console.log(`The url is >> ${host}${endpoint}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json")

        console.log(`>>Request State Sync response status: ${JSON.stringify(response.status)}`)

        return response
    }

	async getGraphicsDetails(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/graphics/${Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRMeetingId}`;
        console.log(`The url is >> ${host}${endpoint}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json")

        console.log(`>>Get Graphics Details Response: ${JSON.stringify(response.body)}`)
        DetailsPageRestApi.getMeetingGraphicsDetails = JSON.parse(JSON.stringify(response.body))
        return response
    }

	async getShowSessions(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/meetings/${Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRMeetingId}/show-sessions`;
        console.log(`The url is >> ${host}${endpoint}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json")

			console.log(`>>Get Show Sessions response status: ${JSON.stringify(response.status)}`)
        return response
    }

	async getAllMeetingBackground(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/media/all-meetings/backgrounds`;
        console.log(`The url is >> ${host}${endpoint}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json")

        console.log(`>>Get Background Media Details Response: ${JSON.stringify(response.body)}`)
        return response
    }


	async getPresenterMsgs(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/events/get-presenter-messages/${Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRSlugMeetingId}`;
        console.log(`The url is >> ${host}${endpoint}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json")

        console.log(`>>Get Presenter Msgs Status: ${JSON.stringify(response.status)}`)
        return response
    }

	async joinRequestByMeetingId(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/join-requests/${Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRMeetingId}`;
        console.log(`The url is >> ${host}${endpoint}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json")

        console.log(`>>Get Join Request Status: ${JSON.stringify(response.body)}`)
        return response
    }


	async postTokBoxToken(host: string,payload: string): Promise<any> {
		let endpoint = `/get-tokbox-token`;
        console.log(`The url is >> ${host}${endpoint}`)
		console.log(`The payload is >> ${payload}`)
        
        let response = await request(host)
                    .post(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json").send(payload)

        DetailsPageRestApi.getTokBoxToken = JSON.parse(JSON.stringify(response.body))
        return response
    }


	async getGrNotifications(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/notifications/get`;
        console.log(`The url is >> ${host}${endpoint}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json")

        console.log(`>>Green Room Notification Status : ${JSON.stringify(response.status)}`)
        DetailsPageRestApi.getGRNotificationResponseBody = JSON.parse(JSON.stringify(response.body))
        return response
    }

    async generateRandomString() {
        let result = '';
        let characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        let charactersLength = characters.length;
        for (let i = 0; i < 12; i++) {
          result += characters.charAt(Math.floor(Math.random() *
            charactersLength));
        }
        return result;
      }

      async getSessionTypes(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/show-sessions/types`;
        console.log(`The url is >> ${host}${endpoint}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json")

        console.log(`>>Green Room session types : ${JSON.stringify(response.status)}`)
        DetailsPageRestApi.getGRNotificationResponseBody = JSON.parse(JSON.stringify(response.body))
        return response
    }
}

export default new DetailsPageRestApi