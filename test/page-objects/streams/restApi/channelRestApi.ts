import request from "supertest"
import cloudflareParameters from "../../../utils/cloudflareParameters"
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi"

class ChannelRestApi {

    static getChannelRegistrationsRes: any
    static getChannelRegistrationsCountRes: any
    static getChannelPasscodeListsRes: any
    static getPasscodeListMembersRes: any
    static getPasscodeListMembersCountRes: any
    static getChannelPaidListsRes: any
    static getPaidListMembersRes: any
    static getStripeStatusRes: any
    static getGoogleAnalyticsStatusRes: any
    static postCheckIntegrationUserRes: any
    static getIntegrationSolutionsRes: any
    static getSettingsAuthAdminsRes: any

    constructor() {

    }

    async getChannelRegistrations(host: string, channelId: number): Promise<any> {

        let endpoint = `/v3/admin/events/registrations/${channelId}/0/8`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        //console.log(`>> Response: ${JSON.stringify(response.body)}`)
        ChannelRestApi.getChannelRegistrationsRes = JSON.parse(JSON.stringify(response.body))
        return response
    }

    async getChannelRegistrationsCount(host: string, channelId: number): Promise<any> {

        let endpoint = `/v3/admin/events/count-registrations/count/${channelId}`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        //console.log(`>> Response: ${JSON.stringify(response.body)}`)
        ChannelRestApi.getChannelRegistrationsRes = JSON.parse(JSON.stringify(response.body))
        return ChannelRestApi.getChannelRegistrationsRes
    }

    async getChannelPasscodeLists(host: string, channelId: number): Promise<any> {

        let endpoint = `/v3/admin/content/passcode-lists/${channelId}`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host) 
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        //console.log(`>> Response: ${JSON.stringify(response.body)}`)
        ChannelRestApi.getChannelPasscodeListsRes = JSON.parse(JSON.stringify(response.body))
        return ChannelRestApi.getChannelPasscodeListsRes
    }

    async getPasscodeListMembers(host: string, passcodeListId: number): Promise<any> {

        let endpoint = `/v3/admin/content/passcode-lists/members/${passcodeListId}/0/0`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        //console.log(`>> Response: ${JSON.stringify(response.body)}`)
        ChannelRestApi.getPasscodeListMembersRes = JSON.parse(JSON.stringify(response.body))
        return ChannelRestApi.getPasscodeListMembersRes
    }

    async getPasscodeListMembersCount(host: string, passcodeListId: number): Promise<any> {

        let endpoint = `/v3/admin/content/passcode-lists/members-count/${passcodeListId}`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        //console.log(`>> Response: ${JSON.stringify(response.body)}`)
        ChannelRestApi.getPasscodeListMembersCountRes = JSON.parse(JSON.stringify(response.body))
        return ChannelRestApi.getPasscodeListMembersCountRes
    }

    async getChannelPaidLists(host: string, channelId: number): Promise<any> {

        let endpoint = `/v3/admin/paid-lists/${channelId}`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        ChannelRestApi.getChannelPaidListsRes = JSON.parse(JSON.stringify(response.body))
        return ChannelRestApi.getChannelPaidListsRes
    }

    async getPaidListMembers(host: string, paidListUuid: number): Promise<any> {

        let endpoint = `/v3/admin/paid-lists/members/${paidListUuid}/0`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        ChannelRestApi.getPaidListMembersRes = JSON.parse(JSON.stringify(response.body))
        return ChannelRestApi.getPaidListMembersRes
    }
    
    async getStripeStatus(host: string): Promise<any> {

        let endpoint = `/v3/admin/channel/stripe`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        ChannelRestApi.getStripeStatusRes = JSON.parse(JSON.stringify(response.body))
        return ChannelRestApi.getStripeStatusRes
    }    

    async getGoogleAnalyticsStatus(host: string, channelId: string): Promise<any> {

        let endpoint = `/v3/admin/google-analytics/${channelId}`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        ChannelRestApi.getGoogleAnalyticsStatusRes = JSON.parse(JSON.stringify(response.body))
        return ChannelRestApi.getGoogleAnalyticsStatusRes
    } 

    async postCheckIntegrationUser(host: string, payload: string): Promise<any> {

        let endpoint = `/v3/admin/channel/integrations/user`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .post(endpoint)
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .set("content-type", "application/json")
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        ChannelRestApi.postCheckIntegrationUserRes = JSON.parse(JSON.stringify(response.body))
        return ChannelRestApi.postCheckIntegrationUserRes
    }

    async getIntegrationSolutions(host: string): Promise<any> {

        let endpoint = `/v3/admin/channel/integrations/solutions`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        ChannelRestApi.getIntegrationSolutionsRes = JSON.parse(JSON.stringify(response.body))
        return ChannelRestApi.getIntegrationSolutionsRes
    } 

    async getSettingsAuthAdmins(host: string): Promise<any> {

        let endpoint = `/v3/admin/auth/admins`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        ChannelRestApi.getSettingsAuthAdminsRes = JSON.parse(JSON.stringify(response.body))
        return ChannelRestApi.getSettingsAuthAdminsRes
    } 
    
    async getChannelId(channelName: string): Promise<number> {
        let allStreamsChannelsArr = Object.getPrototypeOf(HomeRestApi).constructor.getChannelsForProfileRes
        console.log(`Channels >>> ${JSON.stringify(allStreamsChannelsArr)}`)
    
        let channelId: number
        if(allStreamsChannelsArr.length >= 1) {
            for(let ele of allStreamsChannelsArr) {
                for(let key in ele) {
                    let keyVal = `${ele[key]}`
                    if(keyVal.match(channelName)) {
                        channelId = parseInt(`${ele['channel']}`)
                    }
                }
            }
        }
        if(!channelId) throw Error(`The channel id is ${channelId}`)
    
        console.log(`Channel id is: ${channelId}`)
        return channelId
    }

}

export default new ChannelRestApi