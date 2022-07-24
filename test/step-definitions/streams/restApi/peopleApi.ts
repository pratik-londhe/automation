import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import fs  from "fs";
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi";
import PeopleRestApi from "../../../page-objects/streams/restApi/peopleRestApi";
import UploadRestApi from "../../../page-objects/uploadRestApi";

const expect = chai.expect;
const assert: any = chai.assert;
const testEmail = "automatedTest@brandlive.com";
const testPasscode = "passcode1234!"; //passcodes get tolowered
let channelId: number;
let paidListUuid: string;
let stripe_payment: number;
let originalMasterPasscode = 'MasterPC1234!';
let updatedMasterPasscode = 'MasterPC12345!';

Given (/^A channel paid list exists$/, async function(){
    getChannelId();
    //@ts-ignore
    const peoplePaidList = await PeopleRestApi.getChannelPaidLists(browser.config.Streams_Api_Host, channelId);
    assert(peoplePaidList.status === 200, "Request sucessful");
    console.log(peoplePaidList.status);
    assert(Object.keys(peoplePaidList.body).length > 0, "A Channel Paid List exists");
})

When (/^A new member is added to paid list$/, async function(){
    getChannelId();
    //@ts-ignore
    let peoplePaidList = await PeopleRestApi.getChannelPaidLists(browser.config.Streams_Api_Host, channelId);
    const index = Math.floor(Math.random() * Object.keys(peoplePaidList.body).length);   
    peoplePaidList = JSON.parse(JSON.stringify(peoplePaidList.body));
    let keys = Object.keys(peoplePaidList);
    paidListUuid = keys[index];
    
    //@ts-ignore
    const addMemberToPaidListRes = await PeopleRestApi.addMemberToPaidList(browser.config.Streams_Api_Host, testEmail, paidListUuid);
    assert(addMemberToPaidListRes.status === 200, `Requst to add new member to paid list successful - status: ${addMemberToPaidListRes.status}`);
    assert(addMemberToPaidListRes.body.succeeded === true, "New member was added successfully");
    assert(addMemberToPaidListRes.body.email === testEmail, "Added email matches sent email");
    stripe_payment = addMemberToPaidListRes.body.stripe_payment;    
})

Then (/^A new memeber is found in paid list$/, async function(){
    getChannelId();
    //@ts-ignore
    const paidListMembersRes = await PeopleRestApi.getPaidListMembers(browser.config.Streams_Api_Host, paidListUuid);
    assert(paidListMembersRes.status === 200, "GET Paid Members List");
    const paidListMembers = Object.getPrototypeOf(PeopleRestApi).constructor.lastChannelPaidListRes;
    const members = paidListMembers['members'];
    if(members.length){
        const matchingItem = members.find((member: any) => {
            return member.stripe_payment === stripe_payment;
        });
        console.log(JSON.parse(JSON.stringify(matchingItem)));
        assert(matchingItem.email === testEmail, "New member email found in list");
    }
})

async function getChannelId(): Promise<number> {
    let allStreamsChannelsArr = Object.getPrototypeOf(HomeRestApi).constructor.getChannelsForProfileRes;
    console.log(`Channels >>> ${JSON.stringify(allStreamsChannelsArr)}`);
    //@ts-ignore
    let channelName = browser.config.ChannelName;
    
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

When (/^A csv file of new members is added to paid list$/, async function() {
    getChannelId();
    //@ts-ignore
    const host = browser.config.Streams_Api_Host;
    //@ts-ignore
    const environment = browser.config.Environment;

    let peoplePaidList = await PeopleRestApi.getChannelPaidLists(host, channelId);
    const index = Math.floor(Math.random() * Object.keys(peoplePaidList.body).length);   
    peoplePaidList = JSON.parse(JSON.stringify(peoplePaidList.body));
    let keys = Object.keys(peoplePaidList);
    paidListUuid = keys[index];

    const uploadEndpoint = await UploadRestApi.putUploadEndpoint(host, 'multi-member-emails.csv');
    assert(uploadEndpoint.status === 200, "Request successful");
    const fields = uploadEndpoint.body.fields;
   
    const brandliveUpload = await UploadRestApi.postUploadsBrandlive(fields, './data/fileUpload/streams/multi-member-emails.csv');
    assert(brandliveUpload.status === 204, "Request successful");
    
    const addMultipleMembersToPaidList = await PeopleRestApi.addMultipleMembersToPaidList(host, paidListUuid, fields.Key);
    assert(addMultipleMembersToPaidList.status === 200, `Request successful - ${addMultipleMembersToPaidList.status}`);
})
    
Then (/^Each new member is found in paid list$/, async function() {
    getChannelId();
    const now = new Date(); 
    const timeStamp = now.toISOString().substring(0,15);
    let timeout = 20;
    let allItemsFound = false;
    while (timeout > 0 && !allItemsFound){
        //@ts-ignore
        const paidListMembersRes = await PeopleRestApi.getPaidListMembers(browser.config.Streams_Api_Host, paidListUuid);
    
        assert(paidListMembersRes.status === 200, "GET Paid Members List");
        const paidListMembers = Object.getPrototypeOf(PeopleRestApi).constructor.lastChannelPaidListRes;
        const members = paidListMembers['members'];
        
        let itemsFound = 0;
        //for each email in the csv
        if(members.length){
            let fileData = fs.readFileSync('./data/fileUpload/streams/multi-member-emails.csv', 'utf8');
            console.log(fileData);
            let fileDataSplit = fileData.split('\n');
            for (let i = 1; i < fileDataSplit.length; ++i){
                const matchingItem = members.find((member: any) => {
                    return member.email === fileDataSplit[i];
                });
                if (typeof matchingItem !== 'undefined' && matchingItem.email === fileDataSplit[i] && matchingItem.created.includes(timeStamp)) ++itemsFound;
                if(timeout === 1 || itemsFound === fileDataSplit.length -1){
                    assert(typeof matchingItem !== 'undefined', `A match was found for ${fileDataSplit[i]}`);
                    assert(matchingItem.email === fileDataSplit[i] && matchingItem.created.includes(timeStamp), `${fileDataSplit[i]} found in Paid List with time stamp of ${now} within 20 seconds`);
                    allItemsFound = true;
                }
            } 
        }
        await new Promise(resolve => setTimeout(resolve, 1000)); //wait one second
        --timeout;
    }
})

When (/^A new passcode list with no members is created$/, async function() {
    getChannelId();
    //@ts-ignore
    const host = browser.config.Streams_Api_Host;

    const addNewPasscodeListNoMember = await PeopleRestApi.addNewPasscodeListNoMembers(host, channelId, 'Email only', `Test Passcode List ${new Date()}`, 0, originalMasterPasscode);
    assert(addNewPasscodeListNoMember.status === 200, "Request successful");
})

When (/^A new passcode list of type email and passcode is created$/, async function() {
    getChannelId();
    //@ts-ignore
    const host = browser.config.Streams_Api_Host;
    
    const uploadEndpoint = await UploadRestApi.putUploadEndpoint(host, 'createPasscodeList_emailAndPass.csv');
    assert(uploadEndpoint.status === 200, "Request successful");
    const fields = uploadEndpoint.body.fields;
  
    const brandliveUpload = await UploadRestApi.postUploadsBrandlive(fields, './data/fileUpload/streams/createPasscodeList_emailAndPass.csv');
    assert(brandliveUpload.status === 204, `Request successful - ${brandliveUpload.status}`);

    const addNewPasscodeList = await PeopleRestApi.addNewPasscodeList(host, channelId, fields.Key, 'Email and Passcode', `Test Passcode List ${Date.now()}`, 0, originalMasterPasscode);
    console.log(`>>> RESPONSE: ${addNewPasscodeList.body}`);
    assert(addNewPasscodeList.status === 200, `Request successful - ${addNewPasscodeList.status}`);

})

When (/^A new passcode list of type email only is created$/, async function(){

    getChannelId();
    //@ts-ignore
    const host = browser.config.Streams_Api_Host;
    
    const uploadEndpoint = await UploadRestApi.putUploadEndpoint(host, 'createPasscodeList_emailOnly.csv');
    assert(uploadEndpoint.status === 200, "Request successful");
    const fields = uploadEndpoint.body.fields;
  
    const brandliveUpload = await UploadRestApi.postUploadsBrandlive(fields, './data/fileUpload/streams/createPasscodeList_emailOnly.csv');
    assert(brandliveUpload.status === 204, `Request successful - ${brandliveUpload.status}`);

    const addNewPasscodeList = await PeopleRestApi.addNewPasscodeList(host, channelId, fields.Key, 'Email only', `Test Passcode List ${Date.now()}`, 0, originalMasterPasscode);
    assert(addNewPasscodeList.status === 200, `Request successful - ${addNewPasscodeList.status}`);

})
    
When (/^A new passcode list of type passcode only is created$/, async function(){

    getChannelId();
    //@ts-ignore
    const host = browser.config.Streams_Api_Host;
    
    const uploadEndpoint = await UploadRestApi.putUploadEndpoint(host, 'createPasscodeList_pascodeOnly.csv');
    assert(uploadEndpoint.status === 200, "Request successful");
    const fields = uploadEndpoint.body.fields;
  
    const brandliveUpload = await UploadRestApi.postUploadsBrandlive(fields, './data/fileUpload/streams/createPasscodeList_passcodeOnly.csv');
    assert(brandliveUpload.status === 204, `Request successful - ${brandliveUpload.status}`);

    const addNewPasscodeList = await PeopleRestApi.addNewPasscodeList(host, channelId, fields.Key, 'Passcode only', `Test Passcode List ${Date.now()}`, 0, originalMasterPasscode);
    assert(addNewPasscodeList.status === 200, `Request successful - ${addNewPasscodeList.status}`);
}) 

When (/^A new passcode list is verified$/, async function(){
    getChannelId();
    //@ts-ignore
    const host = browser.config.Streams_Api_Host;
    const passcodeListNoMember = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListNoMemberRes;
    const passcodeListEmailAndPass = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListEmailAndPassRes;
    const passcodeListEmailOnly = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListEmailOnlyRes;
    const passcodeListPasscodeOnly = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListPasscodeOnlyRes;
    const getPasscodeList = await PeopleRestApi.getPasscodeLists(host, channelId);
    assert(getPasscodeList.status === 200, "Request successful");
    const passcodeLists = getPasscodeList.body;
    assert(passcodeLists.length)
    const matchingPasscodeListNoMember = passcodeLists.find((list: any) => {
        return list.passcode_list === passcodeListNoMember.passcode_list;
    });
    assert(passcodeListNoMember.passcode_list === matchingPasscodeListNoMember.passcode_list, `A match was found for ${matchingPasscodeListNoMember.name}`);
    
    const matchingPasscodeListEmailAndPass = passcodeLists.find((list: any) => {
        return list.passcode_list === passcodeListEmailAndPass.passcode_list;
    });
    assert(passcodeListEmailAndPass.passcode_list === matchingPasscodeListEmailAndPass.passcode_list, `A match was found for ${matchingPasscodeListEmailAndPass.name}`);
    
    const matchingPasscodeListEmailOnly = passcodeLists.find((list: any) => {
        return list.passcode_list === passcodeListEmailOnly.passcode_list;
    });
    assert(passcodeListEmailOnly.passcode_list === matchingPasscodeListEmailOnly.passcode_list, `A match was found for ${matchingPasscodeListEmailOnly.name}`);
    
    const matchingPasscodeListPasscodeOnly = passcodeLists.find((list: any) => {
        return list.passcode_list === passcodeListPasscodeOnly.passcode_list;
    });
    assert(passcodeListPasscodeOnly.passcode_list === matchingPasscodeListPasscodeOnly.passcode_list, `A match was found for ${matchingPasscodeListPasscodeOnly.name}`);
    
})
    
When (/^A new member is added to a passcode list$/, async function(){
    getChannelId();
    //@ts-ignore
    const host = browser.config.Streams_Api_Host;
    this.testEmail = `test-${Date.now()}.email.com`;
    const testEmail = this.testEmail;
    const passcodeListNoMember = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListNoMemberRes;
    const passcodeListEmailAndPass = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListEmailAndPassRes;
    const passcodeListEmailOnly = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListEmailOnlyRes;
    const passcodeListPasscodeOnly = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListPasscodeOnlyRes;

    //no members
    let addMemberToPasscodeList = await PeopleRestApi.addMemberToPasscodeList(host, passcodeListNoMember.passcode_list, testEmail, '');
    assert(addMemberToPasscodeList.status === 200, `Request Successful - ${addMemberToPasscodeList.status}`);

    let getPasscodeListMembers = await PeopleRestApi.getPasscodeListMembers(passcodeListNoMember.passcode_list, host);
    assert(getPasscodeListMembers.status === 200, `Request Successful - ${getPasscodeListMembers.status}`);
    let passcodeListMembers = getPasscodeListMembers.body;
    assert(passcodeListMembers.length);
    let matchingListMember = passcodeListMembers.find((member: any) => {
        return member.email === testEmail;
    });
    assert(testEmail === matchingListMember.email, `A match was found for ${matchingListMember.email}`);
    //email and passcode
    addMemberToPasscodeList = await PeopleRestApi.addMemberToPasscodeList(host, passcodeListEmailAndPass.passcode_list, testEmail, testPasscode);
    assert(addMemberToPasscodeList.status === 200, `Request Successful - ${addMemberToPasscodeList.status}`);

    getPasscodeListMembers = await PeopleRestApi.getPasscodeListMembers(passcodeListEmailAndPass.passcode_list, host);
    assert(getPasscodeListMembers.status === 200, `Request Successful - ${getPasscodeListMembers.status}`);
    passcodeListMembers = getPasscodeListMembers.body;
    assert(passcodeListMembers.length);
    matchingListMember = passcodeListMembers.find((member: any) => {
        return member.email === testEmail;
    });
    assert(testEmail === matchingListMember.email, `A match was found for ${matchingListMember.email}`);
    //email only
    addMemberToPasscodeList = await PeopleRestApi.addMemberToPasscodeList(host, passcodeListEmailOnly.passcode_list, testEmail, '');
    assert(addMemberToPasscodeList.status === 200, `Request Successful - ${addMemberToPasscodeList.status}`);

    getPasscodeListMembers = await PeopleRestApi.getPasscodeListMembers(passcodeListEmailOnly.passcode_list, host);
    assert(getPasscodeListMembers.status === 200, `Request Successful - ${getPasscodeListMembers.status}`);
    passcodeListMembers = getPasscodeListMembers.body;
    assert(passcodeListMembers.length);
    matchingListMember = passcodeListMembers.find((member: any) => {
        return member.email === testEmail;
    });
    assert(testEmail === matchingListMember.email, `A match was found for ${matchingListMember.email}`);
    //passcode only
    addMemberToPasscodeList = await PeopleRestApi.addMemberToPasscodeList(host, passcodeListPasscodeOnly.passcode_list, '', testPasscode);
    assert(addMemberToPasscodeList.status === 200, `Request Successful - ${addMemberToPasscodeList.status}`);

    getPasscodeListMembers = await PeopleRestApi.getPasscodeListMembers(passcodeListPasscodeOnly.passcode_list, host);
    assert(getPasscodeListMembers.status === 200, `Request Successful - ${getPasscodeListMembers.status}`);
    passcodeListMembers = getPasscodeListMembers.body;
    assert(passcodeListMembers.length);
    matchingListMember = passcodeListMembers.find((member: any) => {
        return member.passcode === testPasscode;
    });
    assert(testPasscode === matchingListMember.passcode, `A match was found for ${matchingListMember.passcode}`);
    
})

When(/^A member is removed from a passcode list$/, async function(){
    getChannelId();
    //@ts-ignore
    const host = browser.config.Streams_Api_Host;

    const passcodeListNoMember = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListNoMemberRes;

    let getPasscodeListMembers = await PeopleRestApi.getPasscodeListMembers(passcodeListNoMember.passcode_list, host);
    assert(getPasscodeListMembers.status === 200, `Request Successful - ${getPasscodeListMembers.status}`);
    let passcodeListMembers = getPasscodeListMembers.body;
    assert(passcodeListMembers.length);
    let matchingListMember = passcodeListMembers.find((member: any) => {
        return member.email === this.testEmail;
    });
    console.log(matchingListMember);
    const memberId = matchingListMember.passcode_list_member;

    assert(passcodeListMembers.length);
    const removeMemberFromList = await PeopleRestApi.removeMemberFromPasscodeList(host, [memberId]);
    assert(removeMemberFromList.status === 200, `Request Successful - ${removeMemberFromList}`);

    getPasscodeListMembers = await PeopleRestApi.getPasscodeListMembers(passcodeListNoMember.passcode_list, host);
    assert(getPasscodeListMembers.status === 200, `Request Successful - ${getPasscodeListMembers.status}`);
    passcodeListMembers = getPasscodeListMembers.body;
    matchingListMember = passcodeListMembers.find((member: any) => {
        return member.passcode_list_member === memberId;
    });

    assert(typeof matchingListMember === 'undefined', `Pascode List member was removed`);

})

When(/^A passcode list max uses is updated$/, async function (){
    getChannelId();
    //@ts-ignore
    const host = browser.config.Streams_Api_Host;

    const passcodeListEmailAndPass = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListEmailAndPassRes;

    const updateMaxUses = await PeopleRestApi.updateMaxUses(host, passcodeListEmailAndPass.passcode_list, 8);
    assert(updateMaxUses.status === 200, `Request Successful - ${updateMaxUses.status}`);
})

When(/^A passcode list master passcode is updated$/, async function (){
    getChannelId();
    //@ts-ignore
    const host = browser.config.Streams_Api_Host;

    const passcodeListEmailOnly = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListEmailOnlyRes;
    
    let updateMasterPasscode = await PeopleRestApi.updateMasterPasscode(host, passcodeListEmailOnly.passcode_list, updatedMasterPasscode);
    assert(updateMasterPasscode.status === 200, `Request Successful - ${updateMasterPasscode.status}`);

    updateMasterPasscode = await PeopleRestApi.updateMasterPasscode(host, passcodeListEmailOnly.passcode_list, originalMasterPasscode);
    assert(updateMasterPasscode.status === 200, `Request Successful - ${updateMasterPasscode.status}`);

    const getPasscodeList = await PeopleRestApi.getPasscodeListEncrypt(host, passcodeListEmailOnly.passcode_list, channelId);
    assert(getPasscodeList.status === 200, `Request Successful - ${getPasscodeList.status}`);

})

Then(/^Passcode lists are deleted$/, async function(){
    getChannelId();
    //@ts-ignore
    const host = browser.config.Streams_Api_Host;
    const passcodeListNoMember = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListNoMemberRes;
    const passcodeListEmailAndPass = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListEmailAndPassRes;
    const passcodeListEmailOnly = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListEmailOnlyRes;
    const passcodeListPasscodeOnly = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListPasscodeOnlyRes;

    const deletePasscodeListNoMembers = await PeopleRestApi.deletePasscodeList(host, channelId, passcodeListNoMember);
    assert(deletePasscodeListNoMembers.status === 200, `Request Successful - ${deletePasscodeListNoMembers.status}`);
    assert(deletePasscodeListNoMembers.body.listRemoved, 'Passcode List Removed');

    let deletePasscodeList = await PeopleRestApi.deletePasscodeList(host, channelId, passcodeListEmailAndPass);
    assert(deletePasscodeList.status === 200, `Request Successful - ${deletePasscodeList.status}`);
    assert(deletePasscodeList.body.listRemoved, 'Passcode List Removed');

    deletePasscodeList = await PeopleRestApi.deletePasscodeList(host, channelId, passcodeListEmailOnly);
    assert(deletePasscodeList.status === 200, `Request Successful - ${deletePasscodeList.status}`);
    assert(deletePasscodeList.body.listRemoved, 'Passcode List Removed');

    deletePasscodeList = await PeopleRestApi.deletePasscodeList(host, channelId, passcodeListPasscodeOnly);
    assert(deletePasscodeList.status === 200, `Request Successful - ${deletePasscodeList.status}`);
    assert(deletePasscodeList.body.listRemoved, 'Passcode List Removed');
})

async function addMultipleMembersToPasscodeList(host: string, passcodeList: any, fileName: string, type: string): Promise<any>{
    const uploadEndpoint = await UploadRestApi.putUploadEndpoint(host, fileName);
    assert(uploadEndpoint.status === 200, "Request successful");
    const fields = uploadEndpoint.body.fields;
   
    const brandliveUpload = await UploadRestApi.postUploadsBrandlive(fields, `./data/fileUpload/streams/${fileName}`);
    assert(brandliveUpload.status === 204, "Request successful");

    console.log("KEY: " + fields.Key);

    const addMultiMembersToPasscodeList = await PeopleRestApi.addMultiMembersToPasscodeList(host, channelId, fileName, passcodeList.passcode_list, type, fields.Key)
    assert(addMultiMembersToPasscodeList.status === 200, `Request Successful - ${addMultiMembersToPasscodeList.status}`);

    //verify all new entries
    const now = new Date(); 
    const timeStamp = now.toISOString().substring(0,15);
    let timeout = 5;
    let allItemsFound = false;
    while (timeout > 0 && !allItemsFound){
        //@ts-ignore
        const passcodeListMembersRes = await PeopleRestApi.getPasscodeListMembers(passcodeList.passcode_list, host);
        assert(passcodeListMembersRes.status === 200, `Request Successful - ${passcodeListMembersRes.status}`);

        const passcodeListMembers = Object.getPrototypeOf(PeopleRestApi).constructor.getPasscodeListMembersRes;
        
        let itemsFound = 0;
        //for each email in the csv
        let fileData = fs.readFileSync(`./data/fileUpload/streams/${fileName}`, 'utf8');
        console.log(fileData);
        let fileDataSplit = fileData.split('\n');
        for (let i = 1; i < fileDataSplit.length; ++i){
            const matchingItem = passcodeListMembers.find((member: any) => {
                if(type === 'Passcode only'){
                    return fileDataSplit[i].includes(member.passcode);
                }
                return fileDataSplit[i].includes(member.email);
            });
            if (typeof matchingItem !== 'undefined' && (fileDataSplit[i].includes(matchingItem.email) || fileDataSplit[i].includes(matchingItem.passcode)) && matchingItem.created_date.includes(timeStamp)) ++itemsFound;
            if(timeout === 1 || itemsFound === fileDataSplit.length -1){
                assert(typeof matchingItem !== 'undefined', `A match was found for ${fileDataSplit[i]}`);
                assert((fileDataSplit[i].includes(matchingItem.email) || fileDataSplit[i].includes(matchingItem.passcode)) && matchingItem.created_date.includes(timeStamp), `${fileDataSplit[i]} found in Passcode List with time stamp of ${now} within 5 seconds`);
                allItemsFound = true;
            }
        } 
        
        await new Promise(resolve => setTimeout(resolve, 100)); //wait one second
        --timeout;
    }
}

When(/^Multiple members are added to passcode list$/, async function(){
    getChannelId();
    //@ts-ignore
    const host = browser.config.Streams_Api_Host;
    const passcodeListEmailAndPass = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListEmailAndPassRes;
    const passcodeListEmailOnly = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListEmailOnlyRes;
    const passcodeListPasscodeOnly = Object.getPrototypeOf(PeopleRestApi).constructor.addNewPasscodeListPasscodeOnlyRes;

    await addMultipleMembersToPasscodeList(host, passcodeListEmailAndPass, 'addToPasscodeList_emailAndPass.csv', 'Email and Passcode');
    await addMultipleMembersToPasscodeList(host, passcodeListEmailOnly, 'addToPasscodeList_emailOnly.csv', 'Email only');
    await addMultipleMembersToPasscodeList(host, passcodeListPasscodeOnly, 'addToPasscodeList_passcodeOnly.csv', 'Passcode only'); 

})