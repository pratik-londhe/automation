
import request from "supertest"
import HomeRestApi from "./homeRestApi"

class shotsRestApi{
	static postLoadShotResponseBody: any
	static addShotResponseBody: any
    constructor(){

    }

	static getShotId: number

	async postLoadShots(host: string, payload: string): Promise<any> {
        let endpoint = `/v2/greenroom/shots/load`;
        console.log(`The url is >> ${host}${endpoint}`)
		console.log(`The payload is >> ${payload}`)
        
        let response = await request(host)
                    .post(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json").send(payload)

        console.log(`>>Post Load Shots Response: ${JSON.stringify(response.body)}`)
        shotsRestApi.postLoadShotResponseBody = JSON.stringify(response.body)
        return response
    }

    async postAddShotInBuilderMode(host: string,payload: string): Promise<any> {
		let endpoint = `/v2/greenroom/shots/add`
		console.log(`The url is >> ${host}${endpoint}`)
		console.log(`The payload for add shot is >> ${payload}`)
		
		let response = await request(host)
						.post(endpoint)
						.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
						.set("content-type", "application/json")
						.accept("application/json")
						.send(payload)
        console.log(`>> Response  for Add shot : ${JSON.stringify(response.body)}`)
		shotsRestApi.addShotResponseBody = JSON.stringify(response.body)
		shotsRestApi.getShotId = JSON.parse(JSON.stringify(response.body['shot_id']))
		console.log('shot id is',shotsRestApi.getShotId )
	return response
	}

    async postBulkEditInBuilderMode(host: string,payload: string): Promise<any> {
		let endpoint = `/v2/greenroom/shots/bulk-edit`
		console.log(`The url is >> ${host}${endpoint}`)
		console.log(`The payload for bulk edit is >> ${payload}`)
		
		let response = await request(host)
						.post(endpoint)
						.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
						.set("content-type", "application/json")
						.accept("application/json")
						.send(payload)
        console.log(`>> Response  for bulk edit : ${JSON.stringify(response.status)}`)
	return response
	}

	async postDeleteShot(host: string,payload: string): Promise<any> {
		let endpoint = `/v2/greenroom/shots/delete`
		console.log(`The url is >> ${host}${endpoint}`)
		console.log(`The payload for delete shot is >> ${payload}`)
		
		let response = await request(host)
						.post(endpoint)
						.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
						.set("content-type", "application/json")
						.accept("application/json")
						.send(payload)
        console.log(`>> Response  for Delete shot : ${JSON.stringify(response.body)}`)

	return response
	}
	async postEditNewlyAddedShot(host: string,payload: string): Promise<any> {
		let endpoint = `/v2/greenroom/shots/edit`
		console.log(`The url is >> ${host}${endpoint}`)
		console.log(`The payload for edit newly added shot is >> ${payload}`)
		
		let response = await request(host)
						.post(endpoint)
						.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
						.set("content-type", "application/json")
						.accept("application/json")
						.send(payload)
        console.log(`>> Response  for Edit newly added shot : ${JSON.stringify(response.body)}`)

	return response
	}
}
export default new shotsRestApi