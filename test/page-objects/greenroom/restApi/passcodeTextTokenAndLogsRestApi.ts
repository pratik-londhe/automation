import request from "supertest"
import HomeRestApi from "./homeRestApi"
import standaloneHomeRestApi from "./standaloneHomeRestApi"
import { getMySqlQueryResult } from "../../../utils/dbMySql"
import passcodeTextTokenAndLogsApi from "../../../step-definitions/greenroom/restApi/passcodeTextTokenAndLogsApi"



class passcodeTextTokenAndLogsRestApi {

	static getPasscodeResponse: any
	static updatePasscodeResponse: any
	static deletePasscodeResponse: any
	static gr_user: any
	static phoneText: any
	static emailText: any
	static tokbox_sessionId: any
	static refresh_token: any
	static postLogsResponse: any;
	static getLogsResponse: any;

    constructor() {

    }


	async updatePasscode(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/passcode/${Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRMeetingId}`;
        console.log(`The url is >> ${host}${endpoint}`)
        let response = await request(host)
                    .put(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json")

					passcodeTextTokenAndLogsRestApi.updatePasscodeResponse = JSON.parse(JSON.stringify(response.body))
		console.log(`>> Response here : ${JSON.stringify(response.body)}`)
        return passcodeTextTokenAndLogsRestApi.updatePasscodeResponse
    }

	async getPasscode(host: string): Promise<any> {

        let endpoint = `/v2/greenroom/passcode/${Object.getPrototypeOf(passcodeTextTokenAndLogsApi).constructor.passcode }`;
        console.log(`The url is >> ${host}${endpoint}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json")

					passcodeTextTokenAndLogsRestApi.getPasscodeResponse = JSON.parse(JSON.stringify(response))
		console.log(`>> Response Code : ${JSON.stringify(response.statusCode)}`)
        return passcodeTextTokenAndLogsRestApi.getPasscodeResponse
    }

	async deletePasscode(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/passcode/${Object.getPrototypeOf(passcodeTextTokenAndLogsApi).constructor.passcode}`;
        console.log(`The url is >> ${host}${endpoint}`)
        
        let response = await request(host)
                    .delete(endpoint)
                    .set("content-type", "application/json")	
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json")

		passcodeTextTokenAndLogsRestApi.deletePasscodeResponse = JSON.parse(JSON.stringify(response))
		console.log(`>> Response Code : ${JSON.stringify(response.statusCode)}`)
        return passcodeTextTokenAndLogsRestApi.deletePasscodeResponse
    }


	async sendEmailTextLink(host: string,payload: string): Promise<any> {
		let endpoint = `/v2/greenroom/email-link`
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)
		
		let response = await request(host)
						.post(endpoint)
						.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
						.set("content-type", "application/json")
						.accept("application/json")
						.send(payload)
		passcodeTextTokenAndLogsRestApi.emailText = JSON.parse(JSON.stringify(response))
		console.log(`>> Response here : ${JSON.stringify(response.status)}`)
	return passcodeTextTokenAndLogsRestApi.emailText
	}


	async sendPhoneTextLink(host: string,payload: string): Promise<any> {
		let endpoint = `/v2/greenroom/text-link`
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)
		
		let response = await request(host)
						.post(endpoint)
						.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
						.set("content-type", "application/json")
						.accept("application/json")
						.send(payload)
		passcodeTextTokenAndLogsRestApi.phoneText = JSON.parse(JSON.stringify(response))
		console.log(`>> Response here : ${JSON.stringify(response.status)}`)
	return passcodeTextTokenAndLogsRestApi.phoneText	
	}


	async refreshToken(host: string): Promise<any> {
		let endpoint = `/v2/greenroom/refresh-token`
        console.log(`The url is >> ${host}${endpoint}`)
		
		let response = await request(host)
						.post(endpoint)
						.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
						.set("content-type", "application/json")
						.accept("application/json")
		passcodeTextTokenAndLogsRestApi.refresh_token = JSON.parse(JSON.stringify(response.body))
		console.log(`>> Response here : ${JSON.stringify(response.body)}`)
	return passcodeTextTokenAndLogsRestApi.refresh_token	
	}


	async getTokboxSession(host: string): Promise<any> {
		let endpoint = `/v2/greenroom/get-tokbox-session`
        console.log(`The url is >> ${host}${endpoint}`)
		
		let response = await request(host)
						.post(endpoint)
						.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
						.set("content-type", "application/json")
						.accept("application/json")
		passcodeTextTokenAndLogsRestApi.tokbox_sessionId = JSON.parse(JSON.stringify(response.body))
		console.log(`>> Response here : ${JSON.stringify(response.body)}`)
	return passcodeTextTokenAndLogsRestApi.tokbox_sessionId	
	}

	async postLogs(host: string,payload: string): Promise<any> {
		let endpoint = `/v2/greenroom/logger/log`
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)
		
		let response = await request(host)
						.post(endpoint)
						.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
						.set("content-type", "application/json")
						.accept("application/json")
						.send(payload)
		passcodeTextTokenAndLogsRestApi.postLogsResponse = JSON.parse(JSON.stringify(response))
		console.log(`>> Response here : ${JSON.stringify(response.status)}`)
	return passcodeTextTokenAndLogsRestApi.postLogsResponse
	}

	async getLogs(host: string): Promise<any> {
        let endpoint = `/v2/greenroom/logger/logs`;
        console.log(`The url is >> ${host}${endpoint}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken)
                    .accept("application/json")

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
		passcodeTextTokenAndLogsRestApi.getLogsResponse = JSON.parse(JSON.stringify(response.body))
        return passcodeTextTokenAndLogsRestApi.getLogsResponse
    }


	//private method
	async getGrUserProfile(email: string){
		let query = `select gr_user from gr_users where email = '${email}'`
		let user = await getMySqlQueryResult(query).then(user => { 
			  return user[0].gr_user
		})
		return user
	}
}


export default new passcodeTextTokenAndLogsRestApi


