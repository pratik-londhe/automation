
import request from "supertest"
import HomeRestApi from "../../../page-objects/greenroom/restApi/homeRestApi"

class builderModeRestApi{
    constructor(){

    }

    async postSettings(host: string,payload: string): Promise<any> {
		let endpoint = `/v2/greenroom/settings`
		console.log(`The url is >> ${host}${endpoint}`)
		console.log(`The payload is >> ${payload}`)
		
		let response = await request(host)
						.post(endpoint)
						.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
						.set("content-type", "application/json")
						.accept("application/json")
						.send(payload)
        console.log(`>> Response  for settings : ${JSON.stringify(response.body)}`)
		console.log(`>> Response status for settings : ${JSON.stringify(response.status)}`)
	return response
	}

}

export default new builderModeRestApi