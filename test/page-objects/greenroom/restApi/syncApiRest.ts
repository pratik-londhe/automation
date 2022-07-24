import request from "supertest"
import HomeRestApi from "./homeRestApi"

class syncApiRest{
    constructor(){

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

}
export default new syncApiRest