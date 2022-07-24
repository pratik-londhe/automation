import request from "supertest"
import cloudflareParameters from "../../../utils/cloudflareParameters"
import HomeRestApi from "./homeRestApi"

class IntegrationRestApi {

    static getChannelIntegrationsSolutionsRes: any
    static getChannelIntegrationsSolutionsInstancesRes: any
    static integrationUserRes: any
    static createSolutionInstancesRes: any
    static authWindowRes: any
    static toggleInstanceRes: any
    static updateSolutionInstancesRes: any
    static passcodeListRes: any
    static passcodeListEncryptRes: any

    constructor() {

    }

    async getChannelIntegrationsSolution(host: string): Promise<any> {

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
        IntegrationRestApi.getChannelIntegrationsSolutionsRes = JSON.parse(JSON.stringify(response.body))
        return IntegrationRestApi.getChannelIntegrationsSolutionsRes
    }

    async getChannelIntegrationsSolutionInstances(host: string, trayID: number): Promise<any> {

        let endpoint = `/v3/admin/channel/integrations/solution-instances/${trayID}`;
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
        IntegrationRestApi.getChannelIntegrationsSolutionsInstancesRes = JSON.parse(JSON.stringify(response.body))
        return IntegrationRestApi.getChannelIntegrationsSolutionsInstancesRes
    }

    async createChannelIntegrationUser(host: string, payload: string): Promise<any> {

        let endpoint = `/v3/admin/channel/integrations/user`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        let response = await request(host)
            .post(endpoint)
            .set("content-type", "application/json")
            .accept("application/json")
            .query(queryStr)
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
            .send(payload)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        IntegrationRestApi.integrationUserRes = JSON.parse(JSON.stringify(response.body))
        return IntegrationRestApi.integrationUserRes
    }

    async createIntegrationSolutionInstances(host: string, payload: string): Promise<any> {

        let endpoint = `/v3/admin/channel/integrations/create/solution-instance`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        let response = await request(host)
            .post(endpoint)
            .set("content-type", "application/json")
            .accept("application/json")
            .query(queryStr)
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
            .send(payload)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        IntegrationRestApi.createSolutionInstancesRes = JSON.parse(JSON.stringify(response.body))
        return IntegrationRestApi.createSolutionInstancesRes
    }

    async getChannelIntegrationsAuthWindowDetails(host: string, trayID: number, instanceID: number): Promise<any> {

        let endpoint = `/v3/admin/channel/integrations/auth-window/${trayID}/${instanceID}`;
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
        IntegrationRestApi.authWindowRes = JSON.parse(JSON.stringify(response.body))
        return IntegrationRestApi.authWindowRes
    }

    async getPassCodeListDetailsByChannelID(host: string, channelID: number): Promise<any> {

        let endpoint = `/v3/admin/content/passcode-lists/${channelID}`;
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
        IntegrationRestApi.passcodeListRes = JSON.parse(JSON.stringify(response.body))
        return IntegrationRestApi.passcodeListRes
    }

    async getPasscodeListEncryptDetailsByChannelIDandPassList(host: string, channelID: number, passcode_List: number): Promise<any> {

        let endpoint = `/v3/admin/content/passcode-lists/encrypt/${channelID}/${passcode_List}`;
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
        IntegrationRestApi.passcodeListEncryptRes = JSON.parse(JSON.stringify(response.body))
        return IntegrationRestApi.passcodeListEncryptRes
    }

    async updateIntegrationSolutionInstances(host: string, payload: string): Promise<any> {

        let endpoint = `/v3/admin/channel/integrations/solution-instance/update`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        let response = await request(host)
            .post(endpoint)
            .set("content-type", "application/json")
            .accept("application/json")
            .query(queryStr)
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
            .send(payload)

        console.log(`>> Response: ${JSON.stringify(response)}`)
        IntegrationRestApi.updateSolutionInstancesRes = JSON.parse(JSON.stringify(response))
        return IntegrationRestApi.updateSolutionInstancesRes
    }

    async toggleInstanceOfIntegration(host: string, payload: string): Promise<any> {

        let endpoint = `/v3/admin/channel/integrations/toggle-instance`;
        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`The payload is >> ${payload}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        let response = await request(host)
            .post(endpoint)
            .set("content-type", "application/json")
            .accept("application/json")
            .query(queryStr)
            .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
            .send(payload)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        IntegrationRestApi.toggleInstanceRes = JSON.parse(JSON.stringify(response.body))
        return IntegrationRestApi.toggleInstanceRes
    }
}
export default new IntegrationRestApi