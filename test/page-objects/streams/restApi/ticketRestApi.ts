import request from "supertest"
import cloudflareParameters from "../../../utils/cloudflareParameters";
import  HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi";

class TicketApi {
    static getStripeStatusRes: any;
    static getGlobalCurrenciesRes:any;

    constructor(){}

    async getStripeStatus(host: string): Promise<any> {

        let endpoint = `/v3/admin/channel/stripe`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token",Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        TicketApi.getStripeStatusRes = JSON.parse(JSON.stringify(response.body))
        return TicketApi.getStripeStatusRes
    }
    async getExchangeRate(host: string): Promise<any> {

        let endpoint = `/v3/admin/channel/exchange-rate/USD`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token",Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        TicketApi.getStripeStatusRes = JSON.parse(JSON.stringify(response.body))
        return TicketApi.getStripeStatusRes
    }
    async getGlobalCurrencies(host: string): Promise<any> {

        let endpoint = `/v3/admin/channel/global-currencies`;
        console.log(`The url is >> ${host}${endpoint}`)

        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)
        
        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token",Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        console.log(`>> Response: ${JSON.stringify(response.body)}`)
        TicketApi.getGlobalCurrenciesRes = JSON.parse(JSON.stringify(response.body))
        return TicketApi.getGlobalCurrenciesRes
    }
}

export default new TicketApi;