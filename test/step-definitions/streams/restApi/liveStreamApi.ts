import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import CreateEventRestApi from "../../../page-objects/streams/restApi/createEventRestApi"
import LiveStreamsRestApi from "../../../page-objects/streams/restApi/liveStreamsRestApi"
import * as crypto from "crypto"
import {v4 as uuidv4} from 'uuid'


let secretKey: string = `5bfa4c0e68dcb9b6e0470f4cac75124c`
let sessionDetails = {
    sessionUuid: null,
    sessionId: null,
    breakoutUuid: null
}

enum SessionTypesEnum {
    'On Demand' = 'on-demand',
    'Broadcast' = 'broadcast',
    'Breakout Room' = 'breakout-rooms',
    'Fireside' = 'fireside'
}

async function encryptNew(plain_text: string, encryptionMethod: string, secret: string, iv: Buffer): Promise<string> {
    var cipher = crypto.createCipheriv(encryptionMethod, secret, iv);
    const encrypted = cipher.update(Buffer.from(plain_text));
    const final = Buffer.concat([encrypted, cipher.final()]);
    return iv.toString('hex') + "." + final.toString('hex');
}

async function encrypt(string: string): Promise<string> {
    const iv = crypto.randomBytes(16);
    //return this.encryptNew(string, 'AES-256-CBC', process.env.HASH_GEN_KEY as string, iv);
    return encryptNew(string, 'AES-256-CBC', secretKey, iv);
}

async function decryptNew(encryptedMessage: string, encryptionMethod: string, secret: string): Promise<string> {
    if (!encryptedMessage.includes('.')) throw new Error('Encrypted string missing IV');

    let parts = encryptedMessage.split(".");
    let iv = Buffer.from(parts.shift()!, 'hex');
    let encryptedText = Buffer.from(parts.join("."), 'hex');
    var decipher = crypto.createDecipheriv(encryptionMethod, Buffer.from(secret), iv);
    let decrypted = decipher.update(encryptedText);

    decrypted = Buffer.concat([decrypted, decipher.final()]);
    return decrypted.toString();
}

async function decrypt(string: string): Promise<string> {
    //return this.decryptNew(string, 'AES-256-CBC', process.env.HASH_GEN_KEY as string);
    return decryptNew(string, 'AES-256-CBC', secretKey);
}

async function getSessionDetailsObject(sessionType: string): Promise<any> {
    let generalInfoDetails = Object.getPrototypeOf(LiveStreamsRestApi).constructor.postFillGeneralInfoRes
    let sessionsArr = generalInfoDetails.eventBundle.sessions

    let session = sessionsArr.find(session => session.session_type === SessionTypesEnum[sessionType]);
    sessionDetails.sessionUuid = session.uuid
    sessionDetails.sessionId = session.session

    if (session.session_type === SessionTypesEnum['Breakout Room']) {
        sessionDetails.breakoutUuid = session.breakout_rooms[0].uuid
        console.log(`Validating Breakout Uuid: ${sessionDetails.breakoutUuid}`)
    }

    console.log(`Validating Session Uuid: ${sessionDetails.sessionUuid}`)
    console.log(`Validating Session Id: ${sessionDetails.sessionId}`)

    return sessionDetails
}

async function getModuleIdForSessionPage(sessionType: string, moduleName: string): Promise<number> {
    let generalInfoDetails = Object.getPrototypeOf(LiveStreamsRestApi).constructor.postFillGeneralInfoRes
    let sessionsArr = generalInfoDetails.eventBundle.sessions

    let moduleId: number
    let modulesArr = []

    if(sessionsArr.length >= 1) {
        for(let ele of sessionsArr) {
            for(let key in ele) {
                let keyVal = ele[key]
                if(key.match('session_type') && keyVal.match('on-demand') && sessionType.match('On Demand')) {
                    modulesArr = ele['modules']
                    if(modulesArr.length >= 1) {
                        for(let modEle of modulesArr) {
                            for(let modKey in modEle) {
                                if(modKey.match('content') && modEle[modKey] != null) {
                                    console.log(`>> content: ${JSON.stringify(modEle[modKey])}`)
                                    let content = JSON.parse(JSON.stringify(modEle[modKey]))
                                    let en = content.custom_heading.en
                                    console.log(`>> en: ${en}`)
                                    if(en.match(moduleName)) {
                                        moduleId = modEle['id']
                                        break
                                    }
                                }
                            }
                        }
                    }
                } else if(key.match('session_type') && keyVal.match('broadcast') && sessionType.match('Broadcast')) {
                    modulesArr = ele['modules']
                    if(modulesArr.length >= 1) {
                        for(let modEle of modulesArr) {
                            for(let modKey in modEle) {
                                if(modKey.match('content') && modEle[modKey] != null) {
                                    console.log(`>> content: ${JSON.stringify(modEle[modKey])}`)
                                    let content = JSON.parse(JSON.stringify(modEle[modKey]))
                                    let en = content.custom_heading.en
                                    console.log(`>> en: ${en}`)
                                    if(en.match(moduleName)) {
                                        moduleId = modEle['id']
                                        break
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    console.log(`Validating Session Question Module Id: ${moduleId}`)  
    
    return moduleId
}

async function getEventId(): Promise<number> {
    let eventDetails = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes
    let eventId = eventDetails.event

    return eventId
}

async function getChannelId(): Promise<number> {
    let eventDetails = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes
    let channelId = eventDetails.channel

    return channelId
}

async function getEventUuid(): Promise<string> {
    let eventDetails = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes
    let eventUuid = eventDetails.uuid

    return eventUuid
}

async function getEventName(): Promise<string> {
    let eventDetails = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes
    let eventName = eventDetails.name
    //let eventNamePath = eventName.replaceAll(/(\ |,|\/|:|\\s)+/g, "-")

    return eventName
}

Given (/^Load the landing page using API$/, async function(){

    //@ts-ignore
    let liveHost = browser.config.Channel_Live_Host
    console.log(`Validating Live Host: ${liveHost}`)

    let eventName = await getEventName()
    let eventNamePath = eventName.replace(/(\ |,|\/|:|\\s)+/g, "-")

    //@ts-ignore
    let response = await LiveStreamsRestApi.getLoadLiveEventUrl(browser.config.Streams_Live_Api_Host, liveHost, eventNamePath)
    chai.expect(response.status).to.equals(204)

    reporter.addStep("info", `Load the event live... is success. **************************************************`)
})

Given (/^Fill general info form using API$/, async function(){

    //@ts-ignore
    let channelHost = browser.config.Channel_Host
    console.log(`Validating Live Host: ${channelHost}`)

    let eventName = await getEventName()
    let eventNamePath = eventName.replace(/(\ |,|\/|:|\\s)+/g, "-")
    console.log(`Validating Event Path: ${eventNamePath}`)

    let fields = `{"1":"Pradnyan","2":"Bhilare","3":"pradnyan.bhilare@brandlive.com"}`
    let source = `https://${channelHost}/${eventNamePath}/en`
    let payload = `{"fields":${fields},"lang":"en","source":"${source}","userCode":null,"timezone":"America/Los_Angeles",
    "isFinalStep":false,"referrer":null,"allQueryParams":null,"action":"signup","hostname":"${channelHost}",
    "isFinalNonTicketStep":false,"step":"general"}`

    //@ts-ignore
    let response = await LiveStreamsRestApi.postFillGeneralInfo(browser.config.Streams_Live_Api_Host, await getEventUuid(), payload)
    chai.expect(response.registrationId).to.not.null
    chai.expect(response.token).to.not.null
    chai.expect(response.validSessions).to.not.null
    chai.expect(response.stepsCompleted.general).to.not.null

    reporter.addStep("info", `Fill the general info form... is success. **************************************************`)
})

Given (/^Get generated page session using API$/, async function(){

    let eventId = await getEventId()
    console.log(`Validating Event Id: ${eventId}`)

    let generalInfoDetails = Object.getPrototypeOf(LiveStreamsRestApi).constructor.postFillGeneralInfoRes
    let registrationId = generalInfoDetails.registrationId
    console.log(`Validating Registration Id: ${registrationId}`)

    //@ts-ignore
    let response = await LiveStreamsRestApi.getGeneratePageSessionByEventId(browser.config.Streams_Live_Api_Host, eventId, registrationId)
    chai.expect(response.id).to.not.null
    chai.expect(response.uuid).to.not.null

    reporter.addStep("info", `Get generated page session... is success. **************************************************`)
})

Given (/^Validate registration user session using API$/, async function(){

    let eventUuid = await getEventUuid()
    console.log(`Validating Event Uuid: ${eventUuid}`)

    let generalInfoDetails = Object.getPrototypeOf(LiveStreamsRestApi).constructor.postFillGeneralInfoRes
    let registrationId = generalInfoDetails.registrationId
    console.log(`Validating Registration Id: ${registrationId}`)

    let payload = `{"registration_id":"${registrationId}","checkType":"reload"}`

    //@ts-ignore
    let response = await LiveStreamsRestApi.postValidateRegisteredUserSession(browser.config.Streams_Live_Api_Host, eventUuid, payload)
    chai.expect(response.success).to.false

    reporter.addStep("info", `Validate registration user session... is success. **************************************************`)
})

Given (/^Fill profile info form using API$/, async function(){

    //@ts-ignore
    let channelHost = browser.config.Channel_Host
    console.log(`Validating Live Host: ${channelHost}`)

    let eventName = await getEventName()
    console.log(`Validating Event Name: ${eventName}`)
    let eventNamePath = eventName.replace(/(\ |,|\/|:|\\s)+/g, "-")
    console.log(`Validating Event Path: ${eventNamePath}`)

    let eventUuid = await getEventUuid()
    console.log(`Validating Event Uuid: ${eventUuid}`)
    let channelId = await getChannelId()
    console.log(`Validating Channel Id: ${channelId}`)

    let generalInfoDetails = Object.getPrototypeOf(LiveStreamsRestApi).constructor.postFillGeneralInfoRes
    let registrationId = generalInfoDetails.registrationId
    console.log(`Validating Registration Id: ${registrationId}`)

    let fields = `{"1":"Pradnyan","2":"Bhilare","3":"pradnyan.bhilare@brandlive.com","4":"None","6":"Brandlive","9":"None"}`
    let source = `https://${channelHost}/${eventNamePath}/en`
    let payload = `{"fields":${fields},"lang":"en","source":"${source}","timezone":"America/Los_Angeles", 
    "isFinalStep":false,"allQueryParams":null,"avatar":null,"channel":${channelId},"eventUuid":"${eventUuid}",
    "isFinalNonTicketStep":false,"step":"profile","registrationId":"${registrationId}","event_title":"${eventName}"}`

    //@ts-ignore
    let response = await LiveStreamsRestApi.postFillProfileInfo(browser.config.Streams_Live_Api_Host, payload)
    chai.expect(response.token).to.not.null

    reporter.addStep("info", `Fill the profile info form... is success. **************************************************`)
})

Given (/^Fill avatar form using API$/, async function(){

    //@ts-ignore
    let channelHost = browser.config.Channel_Host
    console.log(`Validating Live Host: ${channelHost}`)

    let eventName = await getEventName()
    console.log(`Validating Event Name: ${eventName}`)
    let eventNamePath = eventName.replace(/(\ |,|\/|:|\\s)+/g, "-")
    console.log(`Validating Event Path: ${eventNamePath}`)

    let eventUuid = await getEventUuid()
    console.log(`Validating Event Uuid: ${eventUuid}`)
    let channelId = await getChannelId()
    console.log(`Validating Channel Id: ${channelId}`)

    let generalInfoDetails = Object.getPrototypeOf(LiveStreamsRestApi).constructor.postFillGeneralInfoRes
    let registrationId = generalInfoDetails.registrationId
    console.log(`Validating Registration Id: ${registrationId}`)

    let fields = `{}`
    let source = `https://${channelHost}/${eventNamePath}/en`
    let payload = `{"fields":${fields},"lang":"en","source":"${source}","timezone":"America/Los_Angeles", 
    "isFinalStep":true,"allQueryParams":null,"avatar":null,"channel":${channelId},"eventUuid":"${eventUuid}",
    "isFinalNonTicketStep":true,"step":"avatar","registrationId":"${registrationId}","event_title":"${eventName}"}`

    //@ts-ignore
    let response = await LiveStreamsRestApi.postFillAvatarInfo(browser.config.Streams_Live_Api_Host, payload)
    chai.expect(response.token).to.not.null

    reporter.addStep("info", `Fill the avatar info form... is success. **************************************************`)
})

Given (/^Validate registration using API$/, async function(){

    let eventUuid = await getEventUuid()
    console.log(`Validating Event Uuid: ${eventUuid}`)

    let generalInfoDetails = Object.getPrototypeOf(LiveStreamsRestApi).constructor.postFillGeneralInfoRes
    let registrationId = generalInfoDetails.registrationId
    console.log(`Validating Registration Id: ${registrationId}`)

    let payload = `{"registration_id":"${registrationId}","userCode":null}`

    //@ts-ignore
    let ValidateRegistrationRes = await LiveStreamsRestApi.postValidateRegistration(browser.config.Streams_Live_Api_Host, eventUuid, payload)
    chai.expect(ValidateRegistrationRes.registrationId).to.not.null
    chai.expect(ValidateRegistrationRes.token).to.not.null
    chai.expect(ValidateRegistrationRes.validSessions).to.not.null
    chai.expect(ValidateRegistrationRes.stepsCompleted.general).to.not.null
    chai.expect(ValidateRegistrationRes.stepsCompleted.profile).to.not.null

    let code = await encrypt(`${registrationId}/${eventUuid}`)
    payload = `{"code":"${code}"}`

    //@ts-ignore
    let ReregisterCheckRes = await LiveStreamsRestApi.postReregisterCheck(browser.config.Streams_Live_Api_Host, eventUuid, payload)
    chai.expect(ReregisterCheckRes.registrationId).to.not.null
    chai.expect(ReregisterCheckRes.token).to.not.null
    chai.expect(ReregisterCheckRes.validSessions).to.not.null
    // chai.expect(ReregisterCheckRes.stepsCompleted.general).to.not.null
    // chai.expect(ReregisterCheckRes.stepsCompleted.profile).to.not.null

    reporter.addStep("info", `Validate registration... is success. **************************************************`)
})

Given (/^Revalidate registration using API$/, async function(){

    let eventUuid = await getEventUuid()
    console.log(`Validating Event Uuid: ${eventUuid}`)

    let generalInfoDetails = Object.getPrototypeOf(LiveStreamsRestApi).constructor.postFillGeneralInfoRes
    let registrationId = generalInfoDetails.registrationId
    console.log(`Validating Registration Id: ${registrationId}`)

    let code = await encrypt(`${registrationId}/${eventUuid}`)

    let payload = `{"registration_id":"${registrationId}","userCode":"${code}"}`

    //@ts-ignore
    let ValidateRegistrationRes = await LiveStreamsRestApi.postValidateRegistration(browser.config.Streams_Live_Api_Host, eventUuid, payload)
    chai.expect(ValidateRegistrationRes.registrationId).to.not.null
    chai.expect(ValidateRegistrationRes.token).to.not.null
    chai.expect(ValidateRegistrationRes.validSessions).to.not.null
    chai.expect(ValidateRegistrationRes.stepsCompleted.general).to.not.null
    chai.expect(ValidateRegistrationRes.stepsCompleted.profile).to.not.null

    reporter.addStep("info", `Revalidate registration... is success. **************************************************`)
})

Given (/^Navigate to (.*) session using API$/, async function(sessionType: string){
    let generalInfoRes = Object.getPrototypeOf(LiveStreamsRestApi).constructor.postFillGeneralInfoRes
    let registrationId = generalInfoRes.registrationId
    console.log(`Validating Registration Id: ${registrationId}`)

    let sessionDetail = await getSessionDetailsObject(sessionType)

    //@ts-ignore
    let response = await LiveStreamsRestApi.getNavigateToSession(browser.config.Streams_Live_Api_Host, registrationId, 
        sessionDetail.sessionId, sessionType)
    let res: any
    if(sessionType.match('On Demand')) {
        res = JSON.parse(response.get('On Demand'))
    } else if (sessionType.match('Broadcast')) {
        res = JSON.parse(response.get('Broadcast'))
    } else if (sessionType.match('Breakout Room')) {
        res = JSON.parse(response.get('Breakout Room'))
    } else if (sessionType.match('Fireside')) {
        res = JSON.parse(response.get('Fireside'))
    }
    chai.expect(res.id).to.not.null
    chai.expect(res.uuid).to.not.null
    console.log(`>> ID: ${res.id}`)
    console.log(`>> UUID: ${res.uuid}`)

    reporter.addStep("info", `Navigate to ${sessionType} session... is success. **************************************************`)
})

Given (/^Enter chat at (.*) session using API$/, async function(sessionType: string){

    let uuid = uuidv4()

    let eventId = await getEventId()
    console.log(`Validating Event Id: ${eventId}`)
    let channelId = await getChannelId()
    console.log(`Validating Channel Id: ${channelId}`)

    let generalInfoDetails = Object.getPrototypeOf(LiveStreamsRestApi).constructor.postFillGeneralInfoRes
    let registrationId = generalInfoDetails.registrationId
    console.log(`Validating Registration Id: ${registrationId}`)

    let sessionDetail = await getSessionDetailsObject(sessionType)

    let sessionDetailsRes = Object.getPrototypeOf(LiveStreamsRestApi).constructor.getNavigateToSessionRes
    let sessionDetails: any
    if(sessionType.match('On Demand')) {
        sessionDetails = JSON.parse(sessionDetailsRes.get('On Demand'))
    } else if (sessionType.match('Broadcast')) {
        sessionDetails = JSON.parse(sessionDetailsRes.get('Broadcast'))
    } else if (sessionType.match('Fireside')) {
        sessionDetails = JSON.parse(sessionDetailsRes.get('Fireside'))
    } else if (sessionType.match('Breakout Room')) {
        sessionDetails = JSON.parse(sessionDetailsRes.get('Breakout Room'))
    }
    let userUuid = sessionDetails.uuid
    console.log(`Validating User Uuid: ${userUuid}`)

    let payload = `{"uuid":"${uuid}","comment":"Hello World","gif":null,"image":null,
    "session_uuid":"${sessionDetail.sessionUuid}","reply_to_id":null,"reply_to":null,"channel":${channelId},
    "event":${eventId},"message_type":"chat","language":"en","registration_id":"${registrationId}",
    "user_session":"${userUuid}"}`

    //@ts-ignore
    let response = await LiveStreamsRestApi.postCommentAtSessionPage(browser.config.Streams_Live_Api_Host, sessionDetail.sessionId, 
        sessionType, payload)
    let res: any
    if(sessionType.match('On Demand')) {
        res = JSON.parse(response.get('On Demand'))
    } else if (sessionType.match('Broadcast')) {
        res = JSON.parse(response.get('Broadcast'))
    } else if (sessionType.match('Breakout Room')) {
        res = JSON.parse(response.get('Breakout Room'))
    } else if (sessionType.match('Fireside')) {
        res = JSON.parse(response.get('Fireside'))
    }
    chai.expect(res.comment).to.equal('Hello World')

    reporter.addStep("info", `Enter chat for ${sessionType}... is success. **************************************************`)
})

Given (/^Get chat at (.*) session using API$/, async function(sessionType: string){

    let sessionDetail = await getSessionDetailsObject(sessionType)

    //@ts-ignore
    let response = await LiveStreamsRestApi.getChatMessagesAtSessionPage(browser.config.Streams_Live_Api_Host, sessionDetail.sessionUuid, 
        sessionType)
    let res: any
    if(sessionType.match('On Demand')) {
        res = JSON.parse(response.get('On Demand'))
    } else if (sessionType.match('Broadcast')) {
        res = JSON.parse(response.get('Broadcast'))
    } else if (sessionType.match('Breakout Room')) {
        res = JSON.parse(response.get('Breakout Room'))
    } else if (sessionType.match('Fireside')) {
        res = JSON.parse(response.get('Fireside'))
    }
    chai.expect(res.length).to.greaterThan(0)

    reporter.addStep("info", `Get chat messages for ${sessionType} session... is success. **************************************************`)
})

Given (/^Get questions at (.*) session using API$/, async function(sessionType: string){

    let questionModuleId = await getModuleIdForSessionPage(sessionType, 'Questions')

    //@ts-ignore
    let questions = await LiveStreamsRestApi.getQuestionsAtSessionPage(browser.config.Streams_Live_Api_Host, questionModuleId, sessionType)
    let res: any
    if(sessionType.match('On Demand')) {
        res = JSON.parse(questions.get('On Demand'))
    } else if (sessionType.match('Broadcast')) {
        res = JSON.parse(questions.get('Broadcast'))
    }
    chai.expect(res.questions.length).to.greaterThan(0)

    reporter.addStep("info", `Get questions for ${sessionType} session... is success. **************************************************`)
})

Given (/^Enter question at (.*) session using API$/, async function(sessionType: string){

    let eventId = await getEventId()
    console.log(`Validating Event Id: ${eventId}`)
    let channelId = await getChannelId()
    console.log(`Validating Channel Id: ${channelId}`)

    let sessionDetail = await getSessionDetailsObject(sessionType)

    let questionModuleId = await getModuleIdForSessionPage(sessionType, 'Questions')

    let payload = `{"message_type":"question","question":"Question?","first_name":"pradnyan","last_name":"bhilare",
    "profile":{"${channelId}":{"1":"pradnyan","2":"bhilare","3":"pradnyan.bhilare@brandlive.com","4":"none","6":"brandlive",
    "9":"none","verified":true}},"event":${eventId},"channel":${channelId},"session":${sessionDetail.sessionId},"email":"pradnyan.bhilare@brandlive.com",
    "module_id":${questionModuleId},"session_uuid":"${sessionDetail.sessionUuid}","language":"en"}`

    //@ts-ignore
    let response = await LiveStreamsRestApi.postCommentAtSessionPage(browser.config.Streams_Live_Api_Host, sessionDetail.sessionId, sessionType, 
        payload)
    let res: any
    if(sessionType.match('On Demand')) {
        res = JSON.parse(response.get('On Demand'))
    } else if (sessionType.match('Broadcast')) {
        res = JSON.parse(response.get('Broadcast'))
    }
    chai.expect(res.question).to.equal('Question?')

    reporter.addStep("info", `Enter question for ${sessionType}... is success. **************************************************`)
})

Given (/^Get answers by question id at (.*) session using API$/, async function(sessionType: string){

    let questions = Object.getPrototypeOf(LiveStreamsRestApi).constructor.getQuestionsAtSessionPageRes

    let res: any
    if(sessionType.match('On Demand')) {
        res = JSON.parse(questions.get('On Demand'))
    } else if (sessionType.match('Broadcast')) {
        res = JSON.parse(questions.get('Broadcast'))
    }
    chai.expect(res.questions.length).to.greaterThan(0)

    let question_id = res.questions[0].id

    //@ts-ignore
    let questionById = await LiveStreamsRestApi.getCommentsByQuestionIdAtSessionPage(browser.config.Streams_Live_Api_Host, question_id, 
        sessionType)
    if(sessionType.match('On Demand')) {
        res = JSON.parse(questionById.get('On Demand'))
    } else if (sessionType.match('Broadcast')) {
        res = JSON.parse(questionById.get('Broadcast'))
    }
    chai.expect(res.comments.length).to.greaterThan(0)

    reporter.addStep("info", `Get comments for ${sessionType} session... is success. **************************************************`)
})

Given (/^Enter answer at (.*) session using API$/, async function(sessionType: string){

    let eventId = await getEventId()
    console.log(`Validating Event Id: ${eventId}`)
    let channelId = await getChannelId()
    console.log(`Validating Channel Id: ${channelId}`)

    let sessionDetail = await getSessionDetailsObject(sessionType)

    let questionModuleId = await getModuleIdForSessionPage(sessionType, 'Questions')

    let questions = Object.getPrototypeOf(LiveStreamsRestApi).constructor.getQuestionsAtSessionPageRes

    let res: any
    if(sessionType.match('On Demand')) {
        res = JSON.parse(questions.get('On Demand'))
    } else if (sessionType.match('Broadcast')) {
        res = JSON.parse(questions.get('Broadcast'))
    }
    chai.expect(res.questions.length).to.greaterThan(0)

    let question_id = res.questions[0].id

    let payload = `{"message_type":"question_comment","comment":"Answer","first_name":"pradnyan",
    "last_name":"bhilare","profile":{"${channelId}":{"1":"pradnyan","2":"bhilare","3":"pradnyan.bhilare@brandlive.com",
    "4":"none","6":"brandlive","9":"none","verified":true}},"event":${eventId},"channel":${channelId},"session":${sessionDetail.sessionId},
    "email":"pradnyan.bhilare@brandlive.com","module_id":${questionModuleId},"question_id":${question_id},
    "session_uuid":"${sessionDetail.sessionUuid}","language":"en"}`

    //@ts-ignore
    let response = await LiveStreamsRestApi.postCommentAtSessionPage(browser.config.Streams_Live_Api_Host, sessionDetail.sessionId, 
        sessionType, payload)
    if(sessionType.match('On Demand')) {
        res = JSON.parse(response.get('On Demand'))
    } else if (sessionType.match('Broadcast')) {
        res = JSON.parse(response.get('Broadcast'))
    }
    chai.expect(res.comment).to.equal('Answer')

    reporter.addStep("info", `Enter answer for ${sessionType}... is success. **************************************************`)
})

Given (/^Get Breakout Room Usage using API$/, async function(){

    let sessionDetail = await getSessionDetailsObject("Breakout Room")

    //@ts-ignore
    let response = await LiveStreamsRestApi.getBreakoutRoomUsage(browser.config.Streams_Live_Api_Host, sessionDetail.sessionUuid)
    //chai.expect(response).to.equal({})

    reporter.addStep("info", `Get Breakout Room session Usage... is success. **************************************************`)
})

Given (/^Get Breakout Room Ended using API$/, async function(){

    let sessionDetail = await getSessionDetailsObject("Breakout Room")

    //@ts-ignore
    let response = await LiveStreamsRestApi.getBreakoutRoomEnded(browser.config.Streams_Live_Api_Host, sessionDetail.sessionUuid)
    //chai.expect(response).to.equal({})

    reporter.addStep("info", `Get Breakout Room session ended... is success. **************************************************`)
})

Given (/^Get room opentok test for (.*) using API$/, async function(sessionType: string){

    //@ts-ignore
    let response = await LiveStreamsRestApi.getRoomOpentokTest(browser.config.Streams_Live_Api_Host, sessionType)
    let res: any
    if(sessionType.match('Breakout Room')) {
        res = JSON.parse(response.get('Breakout Room'))
    } else if (sessionType.match('Fireside')) {
        res = JSON.parse(response.get('Fireside'))
    }
    chai.expect(res.token).to.not.null
    chai.expect(res.sessionId).to.not.null

    reporter.addStep("info", `Get room opentok test... is success. **************************************************`)
})

Given (/^Get opentok session by id for (.*) using API$/, async function(sessionType: string){

    let opentokTest = Object.getPrototypeOf(LiveStreamsRestApi).constructor.getRoomOpentokTestRes
    let res: any
    if(sessionType.match('Breakout Room')) {
        res = JSON.parse(opentokTest.get('Breakout Room'))
    } else if (sessionType.match('Fireside')) {
        res = JSON.parse(opentokTest.get('Fireside'))
    }
    let sessionId = res.sessionId

    let response = await LiveStreamsRestApi.getOpentokSessionById(sessionId, sessionType)

    reporter.addStep("info", `Get opentok session by id... is success. **************************************************`)
})

Given (/^Get opentok token for (.*) by session id using API$/, async function(sessionType: string){

    let opentokTest = Object.getPrototypeOf(LiveStreamsRestApi).constructor.getRoomOpentokTestRes
    let res: any
    if(sessionType.match('Breakout Room')) {
        res = JSON.parse(opentokTest.get('Breakout Room'))
    } else if (sessionType.match('Fireside')) {
        res = JSON.parse(opentokTest.get('Fireside'))
    }
    let sessionId = res.sessionId

    //@ts-ignore
    let response = await LiveStreamsRestApi.getOpentokToken(browser.config.Streams_Live_Api_Host, sessionId, sessionType)
    let resp: any
    if(sessionType.match('Breakout Room')) {
        resp = JSON.parse(response.get('Breakout Room'))
    } else if (sessionType.match('Fireside')) {
        resp = JSON.parse(response.get('Fireside'))
    }
    chai.expect(resp.token).to.not.null

    reporter.addStep("info", `Get opentok token by session id... is success. **************************************************`)
})

Given (/^Get to the breakout session by uuid using API$/, async function(){
    let sessionDetail = await getSessionDetailsObject('Breakout Room')

    //@ts-ignore
    let response = await LiveStreamsRestApi.getBreakoutRoomByUuid(browser.config.Streams_Live_Api_Host, sessionDetail.sessionUuid, sessionDetail.breakoutUuid)
    //chai.expect(response.token).to.not.null

    reporter.addStep("info", `Get to the breakout session by uuid... is success. **************************************************`)
})

Given (/^Post broadcast for the Fireside using API$/, async function(){

    let sessionDetail = await getSessionDetailsObject('Fireside')
    let payload = `{}`

    //@ts-ignore
    let response = await LiveStreamsRestApi.postBroadcastAtFireside(browser.config.Streams_Api_Host, sessionDetail.sessionUuid, payload)
    chai.expect(response.current_state).to.equal('starting_up')

    reporter.addStep("info", `Post broadcast for the Fireside... is success. **************************************************`)
})

Given (/^Access fireside live event using API$/, async function(){

    let sessionDetail = await getSessionDetailsObject('Fireside')

    //@ts-ignore
    let response = await LiveStreamsRestApi.getFiresideLiveEventAccess(browser.config.Streams_Api_Host, sessionDetail.sessionUuid)
    //chai.expect(response.token).to.not.null

    reporter.addStep("info", `Post broadcast for the Fireside... is success. **************************************************`)
})

Given (/^Check broadcast for fireside using API$/, async function(){

    let sessionDetail = await getSessionDetailsObject('Fireside')
    let payload = `{}`

    //@ts-ignore
    let response = await LiveStreamsRestApi.putBroadcastAtFiresideAlive(browser.config.Streams_Api_Host, sessionDetail.sessionUuid, payload)
    chai.expect(response).to.equal('OK')

    reporter.addStep("info", `Put or check broadcast for the Fireside... is success. **************************************************`)
})

Given (/^Start broadcast for the Fireside using API$/, async function(){

    let sessionDetail = await getSessionDetailsObject('Fireside')
    let payload = `{"resolution":"1920x1080"}`

    //@ts-ignore
    let response = await LiveStreamsRestApi.patchBroadcastAtFiresideStart(browser.config.Streams_Api_Host, sessionDetail.sessionUuid, payload)
    chai.expect(response.current_state).to.equal('broadcast_starting')

    reporter.addStep("info", `Start broadcast for the Fireside... is success. **************************************************`)

})

Given (/^Stop broadcast for the fireside using API$/, async function(){

    let sessionDetail = await getSessionDetailsObject('Fireside')
    let payload = `{}`

    //@ts-ignore
    let response = await LiveStreamsRestApi.patchBroadcastAtFiresideStop(browser.config.Streams_Api_Host, sessionDetail.sessionUuid, payload)
    chai.expect(response.current_state).to.equal('broadcast_stopped')

    reporter.addStep("info", `Stop broadcast for the Fireside... is success. **************************************************`)
})

Given (/^Check start action for Fireside using API$/, async function(){

    let eventId = await getEventId()
    console.log(`Validating Event Id: ${eventId}`)
    let channelId = await getChannelId()
    console.log(`Validating Channel Id: ${channelId}`)

    //@ts-ignore
    let host = browser.config.Streams_Live_Api_Host
    let bl_profile_id: number
    if(host.includes('qa')) {
        bl_profile_id = 50689
    } else {
        bl_profile_id = 50729
    }

    let sessionDetail = await getSessionDetailsObject("Fireside")

    let uuid = uuidv4()

    let generalInfoDetails = Object.getPrototypeOf(LiveStreamsRestApi).constructor.postFillGeneralInfoRes
    let registrationId = generalInfoDetails.registrationId
    console.log(`Validating Registration Id: ${registrationId}`)

    // let sql = `select bl_profile_id from bl_profiles where email like "%pradnyan.bhilare@brandlive.com%"`

    // let result = await getPgQueryResult(sql)
    // console.log(`>> Result : ${result}`)
    // let bl_profile_id = result[0].bl_profile

    let sessionDetailsRes = Object.getPrototypeOf(LiveStreamsRestApi).constructor.getNavigateToSessionRes
    let sessionDetails: any
    sessionDetails = JSON.parse(sessionDetailsRes.get('Fireside'))
    let userUuid = sessionDetails.uuid
    console.log(`Validating User Uuid: ${userUuid}`)

    let payload = `{"source_type":"session","source_id":${sessionDetail.sessionId},"action_id":"${uuid}",
    "bl_profile":${bl_profile_id},"channel_id":${channelId},"event_id":${eventId},"registration_id":"${registrationId}",
    "source_app":"events","source_app_version":"3.1.2","user_session_uuid":"${userUuid}",
    "target_id_string":"on-demand","target_type":"video","action":"start","action_type":"passive"}`

    //@ts-ignore
    let response = await LiveStreamsRestApi.postFiresideActions(browser.config.Streams_Live_Api_Host, payload)
    //chai.expect(response).to.equal({})

    reporter.addStep("info", `Start action... is success. **************************************************`)
})

Given (/^Check milestone action for Fireside using API$/, async function(){

    let eventId = await getEventId()
    console.log(`Validating Event Id: ${eventId}`)
    let channelId = await getChannelId()
    console.log(`Validating Channel Id: ${channelId}`)

    //@ts-ignore
    let host = browser.config.Streams_Live_Api_Host
    let bl_profile_id: number
    if(host.includes('qa')) {
        bl_profile_id = 50689
    } else {
        bl_profile_id = 50729
    }

    let sessionDetail = await getSessionDetailsObject("Fireside")

    let uuid = uuidv4()

    let generalInfoDetails = Object.getPrototypeOf(LiveStreamsRestApi).constructor.postFillGeneralInfoRes
    let registrationId = generalInfoDetails.registrationId
    console.log(`Validating Registration Id: ${registrationId}`)

    // let sql = `select bl_profile_id from bl_profiles where email like "%pradnyan.bhilare@brandlive.com%"`

    // let result = await getPgQueryResult(sql)
    // console.log(`>> Result : ${result}`)
    // let bl_profile_id = result[0].bl_profile

    let sessionDetailsRes = Object.getPrototypeOf(LiveStreamsRestApi).constructor.getNavigateToSessionRes
    let sessionDetails: any
    sessionDetails = JSON.parse(sessionDetailsRes.get('Fireside'))
    let userUuid = sessionDetails.uuid
    console.log(`Validating User Uuid: ${userUuid}`)

    let year = new Date().getFullYear()
    let month = new Date().getMonth()
    let day = new Date().getDay()
    let hour = new Date().getHours()
    let minute = new Date().getMinutes()
    console.log(`>> Date Time: ${year} ${month} ${day} ${hour} ${minute}`)

    let misc = `{"milestone":{"languageSelection":null,"playedSeconds":6.409371,"played":0.7625362374102251,
    "playback_url":"https://events-v3-ivs-recordings.s3-us-west-2.amazonaws.com/ivs/v1/111776770072/PqeMJZGyGKy5/${year}/${month}/${day}/${hour}/${minute}/zHDtMigGuwHG/media/hls/master.m3u8"}}`

    let payload = `{"source_type":"session","source_id":${sessionDetail.sessionId},"action_id":"${uuid}","bl_profile":${bl_profile_id},
    "channel_id":${channelId},"event_id":${eventId},"registration_id":"${registrationId}","source_app":"events",
    "source_app_version":"3.1.2","user_session_uuid":"${userUuid}","target_id_string":"on-demand",
    "target_type":"video","playedSeconds":6.409371,"action":"milestone","action_type":"passive",
    "miscellaneous":"${misc}"}`

    //@ts-ignore
    let response = await LiveStreamsRestApi.postFiresideActions(browser.config.Streams_Live_Api_Host, payload)
    //chai.expect(response).to.equal({})

    reporter.addStep("info", `Milestone action... is success. **************************************************`)

})

Given (/^Check end action for Fireside using API$/, async function(){

    let eventId = await getEventId()
    console.log(`Validating Event Id: ${eventId}`)
    let channelId = await getChannelId()
    console.log(`Validating Channel Id: ${channelId}`)

    //@ts-ignore
    let host = browser.config.Streams_Live_Api_Host
    let bl_profile_id: number
    if(host.includes('qa')) {
        bl_profile_id = 50689
    } else {
        bl_profile_id = 50729
    }

    let sessionDetail = await getSessionDetailsObject("Fireside")

    let uuid = uuidv4()

    let generalInfoDetails = Object.getPrototypeOf(LiveStreamsRestApi).constructor.postFillGeneralInfoRes
    let registrationId = generalInfoDetails.registrationId
    console.log(`Validating Registration Id: ${registrationId}`)

    // let sql = `select bl_profile_id from bl_profiles where email like "%pradnyan.bhilare@brandlive.com%"`

    // let result = await getPgQueryResult(sql)
    // console.log(`>> Result : ${result}`)
    // let bl_profile_id = result[0].bl_profile

    let sessionDetailsRes = Object.getPrototypeOf(LiveStreamsRestApi).constructor.getNavigateToSessionRes
    let sessionDetails: any
    sessionDetails = JSON.parse(sessionDetailsRes.get('Fireside'))
    let userUuid = sessionDetails.uuid
    console.log(`Validating User Uuid: ${userUuid}`)

    let payload = `{"source_type":"session","source_id":${sessionDetail.sessionId},"action_id":"${uuid}",
    "bl_profile":${bl_profile_id},"channel_id":${channelId},"event_id":${eventId},"registration_id":"${registrationId}",
    "source_app":"events","source_app_version":"3.1.2","user_session_uuid":"${userUuid}",
    "target_id_string":"on-demand","target_type":"video","action":"end","action_type":"passive"}`

    //@ts-ignore
    let response = await LiveStreamsRestApi.postFiresideActions(browser.config.Streams_Live_Api_Host, payload)
    //chai.expect(response).to.equal({})

    reporter.addStep("info", `End action... is success. **************************************************`)
})