
import request from "supertest";
import cloudflareParameters from "../../../utils/cloudflareParameters";
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi";
const path = require('path');

class PeopleRestApi {

    static addMembertoPaidListRes: any
    static getChannelPaidListsRes: any
    static lastChannelPaidListRes: any
    static putUploadEndpointRes: any
    static putUploadEndpointMakePublicRes: any
    static addMultipleMemberstoPaidListRes: any
    static addNewPasscodeListEmailAndPassRes: any
    static addNewPasscodeListEmailOnlyRes: any
    static addNewPasscodeListPasscodeOnlyRes: any
    static getPasscodeListsRes: any
    static addNewPasscodeListNoMemberRes: any
    static addMemberToAudienceListRes: any
    static getPasscodeListMembersRes: any
    static removeMemberFromPasscodeListRes: any
    static updateMasterPasscodeRes: any
    static getPasscodeListEncryptRes: any
    static deletePasscodeListRes: any
    static updateMaxUsesRes: any
    static addMultiMembersToPasscodeListRes: any

    private passcodeLists: string
    private passcodeListsNoMembers: string
    private passcodeListAddMember: string
    private passcodeListDeleteMember: string
    private updateListMasterPasscode: string
    private passcodeListDelete: string
    private passcodeListMaxUses: string
    private passcodeListAddMembers: string
    peoplePaidLists(channelId: number): string{return `/v3/admin/paid-lists/${channelId}`}
    peoplePaidListsMembers(paidListUUID: string): string{return `/v3/admin/paid-lists/members/${paidListUUID}`}
    peoplePaidListMembersMultiple(paidListUUID: string): string{return `/v3/admin/paid-lists/members/multiple/${paidListUUID}`}
    allPasscodeLists(channelId: number): string{return `/v3/admin/content/passcode-lists/${channelId}`}
    passcodeListMembers(passcodeListId: number): string {return `/v3/admin/content/passcode-lists/members/${passcodeListId}/0/0`}
    passcodeListEncrypt(channelId: number, passcodeList: number): string {return `/v3/admin/content/passcode-lists/encrypt/${channelId}/${passcodeList}`}

    constructor() {
        this.passcodeLists = '/v3/admin/content/passcode-lists';
        this.passcodeListsNoMembers = '/v3/admin/content/passcode-lists/no-members';
        this.passcodeListAddMember = '/v3/admin/content/passcode-lists/addmember';
        this.passcodeListDeleteMember = '/v3/admin/content/passcode-lists/removemember';
        this.updateListMasterPasscode = '/v3/admin/content/passcode-lists/update-list/master-passcode';
        this.passcodeListDelete = '/v3/admin/content/passcode-lists/delete';
        this.passcodeListMaxUses = '/v3/admin/content/passcode-lists/update-list/max-uses';
        this.passcodeListAddMembers = '/v3/admin/content/passcode-lists/members';
    }

    async getChannelPaidLists(host: string, channelId: number): Promise<any> {

        let endpoint = this.peoplePaidLists(channelId);
        console.log(`The url is >> ${host}${endpoint}`);
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
        PeopleRestApi.getChannelPaidListsRes = JSON.parse(JSON.stringify(response.body));
        return response;
    }

    async getPaidListMembers(host: string, paidListUuid: string): Promise<any> {

        let endpoint = this.peoplePaidListsMembers(paidListUuid) + "/0";
        console.log(`The url is >> ${host}${endpoint}`);
        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        let response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr);

        //console.log(`>> Response: ${JSON.stringify(response.body)}`);
        PeopleRestApi.lastChannelPaidListRes = JSON.parse(JSON.stringify(response.body));
        return response;
    }

    async addMemberToPaidList(host: string, memberEmailAddress: string, paidListUUID: string): Promise<any>{
        const endpoint = this.peoplePaidListsMembers(paidListUUID);

        const payload = {
            "email": memberEmailAddress
        };
        console.log(`The url is >> ${host}${endpoint}`)
        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        const response = await request(host)
                    .put(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload);

        //console.log(`>> Response: ${JSON.stringify(response.body)}`);
        PeopleRestApi.addMembertoPaidListRes = response.body;
        return response;
    }

    async addMultipleMembersToPaidList(host: string, paidListUUID: string, key: string): Promise<any>{
        const endpoint = this.peoplePaidListMembersMultiple(paidListUUID);
        //@ts-ignore
        const url = browser.config.Streams_Api_Uploads;

        const payload = {
            "url": `${url}/${key}`
        };
        console.log(`The url is >> ${host}${endpoint}`)
        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        const response = await request(host)
                    .put(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload);

        //console.log(`>> Response: ${JSON.stringify(response.body)}`);
        PeopleRestApi.addMultipleMemberstoPaidListRes = response.body;
        return response;
    }

    async addNewPasscodeList(host: string, channelId: number, key: string, listType: string, name: string, maxUses: number, masterPasscode: string): Promise<any>{
        const endpoint = this.passcodeLists;
        //@ts-ignore
        const url = browser.config.Streams_Api_Uploads

        let type = 2;
        if(listType === 'Passcode only') type = 1;
        if(listType === 'Email only') type = 0;

        const payload = {

                "type": type,
                "name": name,
                "max_uses": maxUses,
                "master_passcode": masterPasscode,
                "url": `${url}/${key}`,
                "channel": channelId
        }

        console.log(`The url is >> ${host}${endpoint}`)
        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        const response = await request(host)
                    .post(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload);
                    
        console.log(`>> Response: ${JSON.stringify(response.body)}`);
        if(type === 2) PeopleRestApi.addNewPasscodeListEmailAndPassRes = response.body;
        if(type === 1) PeopleRestApi.addNewPasscodeListPasscodeOnlyRes = response.body;
        if(type === 0) PeopleRestApi.addNewPasscodeListEmailOnlyRes = response.body;
        return response;
    }

    async getPasscodeLists(host: string, channelId: number): Promise<any> {

        let endpoint = this.allPasscodeLists(channelId);
        console.log(`The url is >> ${host}${endpoint}`);
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
        PeopleRestApi.getPasscodeListsRes = JSON.parse(JSON.stringify(response.body));
        return response;
    }

    async addNewPasscodeListNoMembers(host: string, channelId: number, listType: string, name: string, maxUses: number, masterPasscode: string): Promise<any>{
        const endpoint = this.passcodeListsNoMembers;

        let type = 2;
        if(listType === 'Passcode only') type = 1;
        if(listType === 'Email only') type = 0;

        const payload = {

                "type": type,
                "name": name,
                "max_uses": maxUses,
                "master_passcode": masterPasscode,
                "url": "",
                "channel": channelId
        }

        console.log(`The url is >> ${host}${endpoint}`)
        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        const response = await request(host)
                    .post(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload);

        console.log(`>> Response: ${JSON.stringify(response.body)}`);
        PeopleRestApi.addNewPasscodeListNoMemberRes = response.body;
        return response;
    }

    async addMemberToPasscodeList(host: string, listNumber: number, email: string, passcode: string): Promise <any>{
        const endpoint = this.passcodeListAddMember;
        const payload = {
                "list": listNumber,
                "passcode": passcode,
                "email": email
        }

        console.log(`The url is >> ${host}${endpoint}`)
        console.log(`PASSCODE: ${passcode}`);
        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        const response = await request(host)
                    .post(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload);

        console.log(`>> Response: ${JSON.stringify(response.body)}`);
        PeopleRestApi.addMemberToAudienceListRes = response.body;
        return response;
    }
    async getPasscodeListMembers(passcodeList: number, host: string): Promise<any>{
        const endpoint = this.passcodeListMembers(passcodeList);

        console.log(`The url is >> ${host}${endpoint}`)
        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        const response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        console.log(`>> Response: ${JSON.stringify(response.body)}`);
        PeopleRestApi.getPasscodeListMembersRes = response.body;
        return response;
    }

    async removeMemberFromPasscodeList(host:string, members: Array<string>): Promise<any>{
        const endpoint = this.passcodeListDeleteMember;

        const payload = {
                "passcodeListMembers": members
        }

        console.log(`The url is >> ${host}${endpoint}`)
        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        const response = await request(host)
                    .delete(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload);

        console.log(`>> Response: ${JSON.stringify(response.body)}`);
        PeopleRestApi.removeMemberFromPasscodeListRes = response.body;
        return response;
    }

    async updateMasterPasscode(host: string, listNumber: number, masterPasscode: string): Promise<any> {
        const endpoint = this.updateListMasterPasscode;

        const payload = {
                "passcode": masterPasscode,
                "list": listNumber
        }

        console.log(`The url is >> ${host}${endpoint}`)
        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        const response = await request(host)
                    .put(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload);

        console.log(`>> Response: ${JSON.stringify(response.body)}`);
        PeopleRestApi.updateMasterPasscodeRes = response.body;
        return response;
    }

    async getPasscodeListEncrypt(host: string, listNumber: number, channelId: number): Promise<any>{
        const endpoint = this.passcodeListEncrypt(channelId, listNumber);

        console.log(`The url is >> ${host}${endpoint}`)
        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        const response = await request(host)
                    .get(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)

        console.log(`>> Response: ${JSON.stringify(response.body)}`);
        PeopleRestApi.getPasscodeListEncryptRes = response.body;
        return response;
    }

    async deletePasscodeList(host: string, channelId: number, passcodeList: Object): Promise<any>{
        const endpoint = this.passcodeListDelete;

        const payload = {
                "channel": channelId,
                "list": passcodeList
        }

        console.log(`The url is >> ${host}${endpoint}`)
        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        const response = await request(host)
                    .put(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload);

        console.log(`>> Response: ${JSON.stringify(response.body)}`);
        PeopleRestApi.deletePasscodeListRes = response.body;
        return response;

    }

    async updateMaxUses(host: string, listNumber: number, maxUses: number): Promise<any>{
        const endpoint = this.passcodeListMaxUses;

        const payload = {
                "uses": maxUses,
                "list": listNumber
        }

        console.log(`The url is >> ${host}${endpoint}`)
        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        const response = await request(host)
                    .put(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload);

        console.log(`>> Response: ${JSON.stringify(response.body)}`);
        PeopleRestApi.updateMaxUsesRes = response.body;
        return response;
    }

    async addMultiMembersToPasscodeList(host: string, channel: number, fileName: string, passcodeListId: number, listType: string, key: string): Promise <any>{
        const endpoint = this.passcodeListAddMembers;
         //@ts-ignore
        const url  = browser.config.Streams_Api_Uploads

        let type = 2;
        if(listType === 'Passcode only') type = 1;
        if(listType === 'Email only') type = 0;

        const payload = {
            "filename": fileName,
            "passcode_list": passcodeListId,
            "type": type,
            "url": `${url}/${key}`,
            "channel": channel
        }

        console.log(`The url is >> ${host}${endpoint}`)
        await cloudflareParameters.generateCloudflareParameters(endpoint)
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`)

        const response = await request(host)
                    .post(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload);
                    
        console.log(`>> Response: ${JSON.stringify(response.body)}`);
        PeopleRestApi.addMultiMembersToPasscodeListRes = response.body;
        return response;
    }

}
export default new PeopleRestApi;

