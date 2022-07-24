import request from "supertest"
import cloudflareParameters from "../../../utils/cloudflareParameters"
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi"
//import reporter from "../../../utils/reporter"

class LiveStreamsRestApi {

    static getLoadLiveEventUrlRes: any
    static postFillGeneralInfoRes: any
    static postFillProfileInfoRes: any
    static postFillAvatarInfoRes: any
    static getGeneratePageSessionByEventIdRes: any
    static postValidateRegisteredUserSessionRes: any
    static postValidateRegistrationRes: any
    static postReregisterCheckRes: any
    static getNavigateToSessionRes = new Map<string, string>()
    static getChatMessagesAtSessionPageRes = new Map<string, string>()
    static postCommentAtSessionPageRes = new Map<string, string>()
    static getQuestionsAtSessionPageRes = new Map<string, string>()
    static getCommentsByQuestionIdAtSessionPageRes = new Map<string, string>()
    static getBreakoutRoomUsageRes: any
    static getBreakoutRoomEndedRes: any
    static getRoomOpentokTestRes = new Map<string, string>()
    static getOpentokSessionByIdRes = new Map<string, string>()
    static getOpentokTokenRes = new Map<string, string>()
    static getBreakoutRoomByUuidRes: any
    static postBroadcastAtFiresideRes: any
    static getFiresideLiveEventAccessRes: any
    static putBroadcastAtFiresideAliveRes: any
    static patchBroadcastAtFiresideStartRes: any
    static patchBroadcastAtFiresideStopRes: any
    static postFiresideActionsRes: any

    constructor(){

    }

    async getLoadLiveEventUrl(host: string, liveHost: string, eventNamePath: string): Promise<any> {

        let endpoint = `/e3-ticket-info/${liveHost}/${eventNamePath}`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    //.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("*/*")
                    .query(queryStr)

        console.log(`>> Response: ${JSON.stringify(response)}`)
        LiveStreamsRestApi.getLoadLiveEventUrlRes = JSON.parse(JSON.stringify(response))
        return LiveStreamsRestApi.getLoadLiveEventUrlRes
    }

    async postFillGeneralInfo(host: string, eventUuid: string, payload: string): Promise<any> {

        let endpoint = `/e3-create-registration/${eventUuid}`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .post(endpoint)
                    //.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .set("bl-profile-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .set("content-type", "application/json")
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        LiveStreamsRestApi.postFillGeneralInfoRes = JSON.parse(response.text.replace('\\', ''))
        return LiveStreamsRestApi.postFillGeneralInfoRes
    }

    async postFillProfileInfo(host: string, payload: string): Promise<any> {

        let endpoint = `/e3-complete-profile`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .post(endpoint)
                    //.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .set("bl-profile-token", LiveStreamsRestApi.postFillGeneralInfoRes.token)
                    .set("content-type", "application/json")
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        LiveStreamsRestApi.postFillProfileInfoRes = JSON.parse(response.text.replace('\\', ''))
        return LiveStreamsRestApi.postFillProfileInfoRes
    }

    async postFillAvatarInfo(host: string, payload: string): Promise<any> {

        let endpoint = `/e3-complete-profile`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .post(endpoint)
                    //.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .set("bl-profile-token", LiveStreamsRestApi.postFillProfileInfoRes.token)
                    .set("content-type", "application/json")
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        LiveStreamsRestApi.postFillAvatarInfoRes = JSON.parse(response.text.replace('\\', ''))
        return LiveStreamsRestApi.postFillAvatarInfoRes
    }

    async getGeneratePageSessionByEventId(host: string, eventId: string, registrationId: string): Promise<any> {

        let endpoint = `/e3-generate-page-session/${eventId}`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}
        &registration_id=${registrationId}&lang=en-US`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-profile-token", LiveStreamsRestApi.postFillGeneralInfoRes.token)
                    .accept("*/*")
                    .query(queryStr)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        LiveStreamsRestApi.getGeneratePageSessionByEventIdRes = JSON.parse(response.text.replace('\\', ''))
  
        return LiveStreamsRestApi.getGeneratePageSessionByEventIdRes

    }

    async postValidateRegisteredUserSession(host: string, eventUuid: string, payload: string): Promise<any> {

        let endpoint = `/e3-validate-registered-user-sessions/${eventUuid}`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .post(endpoint)
                    //.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .set("bl-profile-token", LiveStreamsRestApi.postFillGeneralInfoRes.token)
                    .set("content-type", "application/json")
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        LiveStreamsRestApi.postValidateRegisteredUserSessionRes = JSON.parse(response.text.replace('\\', ''))
        return LiveStreamsRestApi.postValidateRegisteredUserSessionRes
    }

    async postValidateRegistration(host: string, eventUuid: string, payload: string): Promise<any> {

        let endpoint = `/e3-validate-registration/${eventUuid}`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .post(endpoint)
                    //.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .set("bl-profile-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .set("content-type", "application/json")
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        LiveStreamsRestApi.postValidateRegistrationRes = JSON.parse(response.text.replace('\\', ''))
        return LiveStreamsRestApi.postValidateRegistrationRes
    }

    async postReregisterCheck(host: string, eventUuid: string, payload: string): Promise<any> {

        let endpoint = `/e3-reregister-check/${eventUuid}`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .post(endpoint)
                    .set("bl-profile-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .set("content-type", "application/json")
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload)

        //console.log(`>> Response: ${response.text.replace('\\', '')}`)
        console.log(`>> Response: ${JSON.stringify(response)}`)
        LiveStreamsRestApi.postReregisterCheckRes = JSON.parse(response.text.replace('\\', ''))
        return LiveStreamsRestApi.postReregisterCheckRes
    }

    async getNavigateToSession(host: string, registrationId: string, sessionId: number, sessionType: string): Promise<any> {

        let endpoint = `/e3-generate-session/${sessionId}`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}
        &registration_id=${registrationId}&lang=en-US`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-profile-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .accept("*/*")
                    .query(queryStr)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        if(sessionType.match("On Demand")) {
            LiveStreamsRestApi.getNavigateToSessionRes.set("On Demand", response.text.replace('\\', ''))
        } else if (sessionType.match("Broadcast")) {
            LiveStreamsRestApi.getNavigateToSessionRes.set("Broadcast", response.text.replace('\\', ''))
        } else if (sessionType.match("Breakout Room")) {
            LiveStreamsRestApi.getNavigateToSessionRes.set("Breakout Room", response.text.replace('\\', ''))
        } else if (sessionType.match("Fireside")) {
            LiveStreamsRestApi.getNavigateToSessionRes.set("Fireside", response.text.replace('\\', ''))
        }
  
        return LiveStreamsRestApi.getNavigateToSessionRes
    }

    async getChatMessagesAtSessionPage(host: string, sessionUuid: string, sessionType: string): Promise<any> {

        let endpoint = `/e3-chat-messages/${sessionUuid}/en`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    //.set("bl-profile-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .accept("*/*")
                    .query(queryStr)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        if(sessionType.match("On Demand")) {
            LiveStreamsRestApi.getChatMessagesAtSessionPageRes.set("On Demand", response.text.replace('\\', ''))
        } else if (sessionType.match("Broadcast")) {
            LiveStreamsRestApi.getChatMessagesAtSessionPageRes.set("Broadcast", response.text.replace('\\', ''))
        } else if (sessionType.match("Breakout Room")) {
            LiveStreamsRestApi.getChatMessagesAtSessionPageRes.set("Breakout Room", response.text.replace('\\', ''))
        } else if (sessionType.match("Fireside")) {
            LiveStreamsRestApi.getChatMessagesAtSessionPageRes.set("Fireside", response.text.replace('\\', ''))
        }
  
        return LiveStreamsRestApi.getChatMessagesAtSessionPageRes
    }

    async postCommentAtSessionPage(host: string, sessionId: number, sessionType: string, payload: string): Promise<any> {

        let endpoint = `/e3-comment/${sessionId}`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .post(endpoint)
                    //.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .set("bl-profile-token", LiveStreamsRestApi.postValidateRegistrationRes.token)
                    .set("content-type", "application/json")
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        if(sessionType.match("On Demand")) {
            LiveStreamsRestApi.postCommentAtSessionPageRes.set("On Demand", response.text.replace('\\', ''))
        } else if (sessionType.match("Broadcast")) {
            LiveStreamsRestApi.postCommentAtSessionPageRes.set("Broadcast", response.text.replace('\\', ''))
        } else if (sessionType.match("Breakout Room")) {
            LiveStreamsRestApi.postCommentAtSessionPageRes.set("Breakout Room", response.text.replace('\\', ''))
        } else if (sessionType.match("Fireside")) {
            LiveStreamsRestApi.postCommentAtSessionPageRes.set("Fireside", response.text.replace('\\', ''))
        }
        return LiveStreamsRestApi.postCommentAtSessionPageRes
    }  
    
    async getQuestionsAtSessionPage(host: string, questionModuleId: number, sessionType: string): Promise<any> {

        let endpoint = `/e3-get-module-questions/${questionModuleId}/en`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-profile-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .accept("*/*")
                    .query(queryStr)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        if(sessionType.match("On Demand")) {
            LiveStreamsRestApi.getQuestionsAtSessionPageRes.set("On Demand", response.text.replace('\\', ''))
        } else if (sessionType.match("Broadcast")) {
            LiveStreamsRestApi.getQuestionsAtSessionPageRes.set("Broadcast", response.text.replace('\\', ''))
        }
  
        return LiveStreamsRestApi.getQuestionsAtSessionPageRes
    }

    async getCommentsByQuestionIdAtSessionPage(host: string, questionId: number, sessionType: string): Promise<any> {

        let endpoint = `/e3-get-questions-comments/${questionId}`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}&page=0`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-profile-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .accept("*/*")
                    .query(queryStr)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        if(sessionType.match("On Demand")) {
            LiveStreamsRestApi.getCommentsByQuestionIdAtSessionPageRes.set("On Demand", response.text.replace('\\', ''))
        } else if (sessionType.match("Broadcast")) {
            LiveStreamsRestApi.getCommentsByQuestionIdAtSessionPageRes.set("Broadcast", response.text.replace('\\', ''))
        }
  
        return LiveStreamsRestApi.getCommentsByQuestionIdAtSessionPageRes
    }

    async getBreakoutRoomUsage(host: string, sessionUuid: string): Promise<any> {

        let endpoint = `/e3-breakout-room-usage/${sessionUuid}`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-profile-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .accept("*/*")
                    .query(queryStr)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        LiveStreamsRestApi.getBreakoutRoomUsageRes = response.text.replace('\\', '')
  
        return LiveStreamsRestApi.getBreakoutRoomUsageRes
    }

    async getBreakoutRoomEnded(host: string, sessionUuid: string): Promise<any> {

        let endpoint = `/e3-breakout-room/ended/${sessionUuid}`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-profile-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .accept("*/*")
                    .query(queryStr)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        LiveStreamsRestApi.getBreakoutRoomEndedRes = JSON.parse(response.text.replace('\\', ''))
  
        return LiveStreamsRestApi.getBreakoutRoomEndedRes
    }

    async getRoomOpentokTest(host: string, sessionType: string): Promise<any> {

        let endpoint = `/e3-get-room-test-info/opentok/test`;
        console.log(`The url is >> ${host}${endpoint}`) 

        let isFiresides = (sessionType.match('Fireside'))? true : false

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}&isFiresides=${isFiresides}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-profile-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .accept("*/*")
                    .query(queryStr)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        if(sessionType.match("Breakout Room")) {
            LiveStreamsRestApi.getRoomOpentokTestRes.set("Breakout Room", response.text.replace('\\', ''))
        } else if (sessionType.match("Fireside")) {
            LiveStreamsRestApi.getRoomOpentokTestRes.set("Fireside", response.text.replace('\\', ''))
        }
		LiveStreamsRestApi.getRoomOpentokTestRes.set("token", JSON.parse(response.text.replace('\\', ''))?.token)
  
        return LiveStreamsRestApi.getRoomOpentokTestRes
    }

    async getOpentokSessionById(sessionId: string, sessionType: string): Promise<any> {

        let host = `https://api-standard.opentok.com`
        let endpoint = `/session/${sessionId}`;
        console.log(`The url is >> ${host}${endpoint}`) 

        let queryStr = `extended=true`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
					.set("x-opentok-auth", LiveStreamsRestApi.getRoomOpentokTestRes.get('token'))
                    .accept("application/json")
                    .query(queryStr)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        if(sessionType.match("Breakout Room")) {
            LiveStreamsRestApi.getOpentokSessionByIdRes.set("Breakout Room", response.text.replace('\\', ''))
        } else if (sessionType.match("Fireside")) {
            LiveStreamsRestApi.getOpentokSessionByIdRes.set("Fireside", response.text.replace('\\', ''))
				}
  
        return LiveStreamsRestApi.getOpentokSessionByIdRes
    }

    async getOpentokToken(host: string, sessionId: string, sessionType: string): Promise<any> {
        let endpoint: string
        let queryStr: string
        if(sessionType.match('Fireside')) {
            const firesideSessionIdRes = JSON.parse(LiveStreamsRestApi.getOpentokSessionByIdRes.get('Fireside'))
            let _sessionId = firesideSessionIdRes?.[0]?.session_id ?? sessionId
            endpoint = `/e3-get-opentok-token/opentok/${_sessionId}/firesides/token`
            await cloudflareParameters.generateCloudflareParameters(endpoint)
            queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}&isPublisher=true`
        }
        if (sessionType.match('Breakout Room')) {
            const breakoutRoomResponse = LiveStreamsRestApi.getBreakoutRoomByUuidRes
            const opentokId = breakoutRoomResponse.opentokId
            endpoint = `/e3-get-opentok-token/opentok/${opentokId}/token`;
            await cloudflareParameters.generateCloudflareParameters(endpoint)
            queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        }
        console.log(`The url is >> ${host}${endpoint}`) 
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
       
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-profile-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .accept("*/*")
                    .query(queryStr)

				const responseText = response.text.replace('\\', '')
        console.log(`>> Response: ${responseText}`)
				
				if (responseText.toLowerCase().includes('invalid request')) {
					console.log(response)
				}
        if(sessionType.match("Breakout Room")) {
            LiveStreamsRestApi.getOpentokTokenRes.set("Breakout Room", responseText)
        } else if (sessionType.match("Fireside")) {
            LiveStreamsRestApi.getOpentokTokenRes.set("Fireside", responseText)
				}
				LiveStreamsRestApi.getOpentokTokenRes.set("token", JSON.parse(responseText)?.token)
  
        return LiveStreamsRestApi.getOpentokTokenRes
    }

    async getBreakoutRoomByUuid(host: string, sessionUuid: string, uuid: string): Promise<any> {

        let endpoint = `/e3-breakout-room/${sessionUuid}/${uuid}`;
        console.log(`The url is >> ${host}${endpoint}`) 

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-profile-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .accept("*/*")
                    .query(queryStr)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        LiveStreamsRestApi.getBreakoutRoomByUuidRes = JSON.parse(response.text.replace('\\', ''))
  
        return LiveStreamsRestApi.getBreakoutRoomByUuidRes
    }

    async postBroadcastAtFireside(host: string, eventUuid: string, payload: string): Promise<any> {

        let endpoint = `/v3/admin/broadcast/${eventUuid}`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        console.log(`>> token: ${LiveStreamsRestApi.postFillAvatarInfoRes.token}`)
        
        let response = await request(host)
                    .post(endpoint)
                    //.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .set("bl-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .set("content-type", "application/json")
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        //console.log(`>> Response: ${JSON.stringify(response)}`)
        LiveStreamsRestApi.postBroadcastAtFiresideRes = JSON.parse(response.text.replace('\\', ''))
        return LiveStreamsRestApi.postBroadcastAtFiresideRes
    }

    async getFiresideLiveEventAccess(host: string, sessionUuid: string): Promise<any> {

        let endpoint = `/v3/live-event/firesides-access/${sessionUuid}`;
        console.log(`The url is >> ${host}${endpoint}`) 

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .accept("*/*")
                    .query(queryStr)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        LiveStreamsRestApi.getFiresideLiveEventAccessRes = JSON.parse(response.text.replace('\\', ''))
  
        return LiveStreamsRestApi.getFiresideLiveEventAccessRes
    }

    async putBroadcastAtFiresideAlive(host: string, eventUuid: string, payload: string): Promise<any> {

        let endpoint = `/v3/firesides/broadcast/${eventUuid}/alive`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .put(endpoint)
                    //.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .set("bl-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .set("content-type", "application/json")
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        //console.log(`>> Response: ${JSON.stringify(response)}`)
        LiveStreamsRestApi.putBroadcastAtFiresideAliveRes = response.text.replace('\\', '')
        return LiveStreamsRestApi.putBroadcastAtFiresideAliveRes
    }

    async patchBroadcastAtFiresideStart(host: string, sessionUuid: string, payload: string): Promise<any> {
			
				// In the browser we rely on sockets to let the client know when the broadcast is ready to go live and
				// the user just has to sit and watch patiently until it's ready.
				// Since we are in headless mode here we do not have socket io client so we run a recursive api call to
				// check if the broadcast machine is ready, once it's ready.
				await browser.setTimeout({implicit: 1000 * 60 * 5, pageLoad: 1000 * 60 * 5, script: 1000 * 60 * 5})

				let statusTries = 0;
				const recursivelyCheckBroadcastMachineStatus = async () => {
						if (statusTries >= 10) {
							console.log('Too many tries, bailing')
							return
						}
						statusTries++
						let endpoint = `/v3/admin/broadcast/${sessionUuid}`
						await cloudflareParameters.generateCloudflareParameters(endpoint)
						let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
						console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

						let _response = await request(host)
												.get(endpoint)
												.set("bl-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
												.set("content-type", "application/json")
												.accept("*/*")
												.query(queryStr)

					const body = JSON.parse(_response.text.replace('\\', ''))
					console.log('STATUS BODY', body)

					if (body?.current_state !== 'ready') {
						console.log('NOT READY, re-trying in 30 seconds...')
						await browser.pause(30000)
						console.log('Retrying...')
						return recursivelyCheckBroadcastMachineStatus()
					}
					console.log('Broadcast machine ready')
					return
				}

				await recursivelyCheckBroadcastMachineStatus()

				let endpoint = `/v3/admin/broadcast/${sessionUuid}/start/`;
				console.log(`The url is >> ${host}${endpoint}`)
				console.log(`The payload is >> ${payload}`)

				await cloudflareParameters.generateCloudflareParameters(endpoint)
				let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
				console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

				let response = await request(host)
										.patch(endpoint)
										//.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
										.set("bl-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
										.set("content-type", "application/json")
										.accept("application/json")
										.query(queryStr)
										.send(payload)
				
				console.log(`>> Response: ${response.text.replace('\\', '')}`)
				LiveStreamsRestApi.patchBroadcastAtFiresideStartRes = JSON.parse(response.text.replace('\\', ''))
				return LiveStreamsRestApi.patchBroadcastAtFiresideStartRes
    }

    async patchBroadcastAtFiresideStop(host: string, eventUuid: string, payload: string): Promise<any> {

        let endpoint = `/v3/admin/broadcast/${eventUuid}/stop`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .patch(endpoint)
                    //.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .set("bl-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .set("content-type", "application/json")
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload)

        console.log(`>> Response: ${response.text.replace('\\', '')}`)
        //console.log(`>> Response: ${JSON.stringify(response)}`)
        LiveStreamsRestApi.patchBroadcastAtFiresideStopRes = JSON.parse(response.text.replace('\\', ''))
        return LiveStreamsRestApi.patchBroadcastAtFiresideStopRes
    }

    async postFiresideActions(host: string, payload: string): Promise<any> {

        let endpoint = `/actions`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .post(endpoint)
                    //.set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .set("bl-profile-token", LiveStreamsRestApi.postFillAvatarInfoRes.token)
                    .set("content-type", "application/json")
                    .accept("*/*")
                    .query(queryStr)
                    .send(payload)

        //console.log(`>> Response: ${response.text.replace('\\', '')}`)
        console.log(`>> Response: ${response.text}`)
        LiveStreamsRestApi.postFiresideActionsRes = `${response.text}`
        return LiveStreamsRestApi.postFiresideActionsRes
    }

}

export default new LiveStreamsRestApi