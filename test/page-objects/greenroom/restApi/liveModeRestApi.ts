import request from "supertest"
import HomeRestApi from "../../../page-objects/greenroom/restApi/homeRestApi"
import { BodyStatusResponse } from "./detailsPageRestApi";
import standaloneHomeRestApi from "./standaloneHomeRestApi"


class LiveModeRestApi {

	static getMediaDetailsResponse: any
	
    constructor() {

    }

	async getMediaDetails(host:string): Promise<any> {
		let endpoint = `/v2/greenroom/media/${Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRMeetingId
		}`;
        console.log(`The url is >> ${host}${endpoint}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json")

        console.log(`>>Get Media Room Details Response: ${JSON.stringify(response.body)}`)
        LiveModeRestApi.getMediaDetailsResponse = JSON.parse(JSON.stringify(response.body))
        return LiveModeRestApi.getMediaDetailsResponse
	}


	async writeSetPresenterMedia(host: string,payload: string): Promise<any> {
		let endpoint = `/write-state`
		console.log(`The url is >> ${host}${endpoint}`)
		console.log(`The payload is >> ${payload}`)
		
		let response = await request(host)
						.post(endpoint)
						.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
						.set("content-type", "application/json")
						.accept("application/json")
						.send(payload)
		console.log(`>> Response status : ${JSON.stringify(response.status)}`)
	return response
	}


	async requestState(host: string, mediaId: number): Promise<BodyStatusResponse> {
		let endpoint = `/request-state/${mediaId}`;

		console.log(`The url is >> ${host}${endpoint}`);

		const response = await request(host)
			.get(endpoint)
			.set('bl-token', Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
			.set('content-type', 'application/json')
			.accept('application/json');

		console.log(`>> Response body : ${JSON.stringify(response.body)}`);
		console.log(`>> Response status : ${response.status}`);

		return response;
	}


	async getDirectChatMessages(host:string): Promise<any> {
		let endpoint = `/v2/greenroom/chat/direct/${Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRMeetingId}`;
        console.log(`The url is >> ${host}${endpoint}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json")
		console.log(`>>Get Direct Chat Message Status Response: ${JSON.stringify(response.status)}`)
		return response
	}

	async getRoomChatMessages(host:string): Promise<any> {
			let endpoint = `/v2/greenroom/chat/rooms/${Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRMeetingId}`;
			console.log(`The url is >> ${host}${endpoint}`)
			
			let response = await request(host)
						.get(endpoint)
						.set("content-type", "application/json")
						.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
						.accept("application/json")
			console.log(`>>Get Room Chat Message Status Response: ${JSON.stringify(response.status)}`)
			return response
	}

	async postSetSeenNotification(host: string,payload: string): Promise<any> {
		let endpoint = `/v2/greenroom/notifications/set-seen`
		console.log(`The url is >> ${host}${endpoint}`)
		console.log(`The payload is >> ${payload}`)
		
		let response = await request(host)
						.post(endpoint)
						.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
						.set("content-type", "application/json")
						.accept("application/json")
						.send(payload)
		console.log(`>> Response status : ${JSON.stringify(response.status)}`)
	return response
	}

	async postCreateFeatureFlags(host: string): Promise<any> {
		let endpoint = `/v2/greenroom/feature-flags`
		console.log(`The url is >> ${host}${endpoint}`)
		
		let response = await request(host)
						.post(endpoint)
						.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
						.set("content-type", "application/json")
						.accept("application/json")

		console.log(`>> Response status : ${JSON.stringify(response.status)}`)
		console.log(`>> Response  : ${JSON.stringify(response.body)}`)
	return response
	}


}

export default new LiveModeRestApi