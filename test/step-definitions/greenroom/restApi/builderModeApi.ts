
import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import builderModeRestApi from "../../../page-objects/greenroom/restApi/builderModeRestApi"
import editJsonFile from "edit-json-file";
import standaloneHomeRestApi from "../../../page-objects/greenroom/restApi/standaloneHomeRestApi";

class builderModeApi{
    constructor(){

    }

    public async getPayloadOfSetSettings(payloadSetSettings: string,roomState: number){ 
        let file = editJsonFile(payloadSetSettings)	
        file.set("meeting", Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRMeetingId)
        file.unset("settings")
        let setting = 
        `{\"templateAccordionOpen\":false,\"spacingAccordionOpen\":false,\"wallpaperAccordionOpen\":false,\"backgroundAccordionOpen\":false,\"greenroomSettingsAccordionOpen\":false,\"useModeratedQuestions\":true,\"previewLayout\":\"single cover\",\"askToJoin\":false,\"selectedResolution\":\"1080p\",\"settingsTab\":1,\"entryWithoutProducer\":true,\"overlayVisible\":false,\"backstageCommsActive\":true,\"useDefaultEndpoint\":true,\"defaultResolution\":\"1080p\",\"customDestinations\":[],\"selectedCustomDestination\":\"\",\"roomState\":${roomState},\"useEmailInvites\":true,\"clearShot\":false,\"useShowboard\":true,\"defaultMeetingImage\":{\"image\":\"\",\"color\":\"\",\"scale\":0},\"feedScaling\":true,\"autoMute\":false,\"hasFetchedFeatureFlags\":false,\"preMedia\":null,\"postMedia\":null,\"preMediaUploading\":false,\"postMediaUploading\":false}`
        file.set("settings",setting)
        return  JSON.stringify(file.toObject())
    }
}

export default new builderModeApi
   
  
Given (/^Post settings in (.*)$/, async function(greenrooMode:string){

    let roomState: number;
    if(greenrooMode=='builder mode'){
        roomState = 2
    }else{
        roomState = 1
    }
        let setSetting = "./data/jsonFiles/greenroom/payload_settings.json"
        let file = await (new builderModeApi().getPayloadOfSetSettings(setSetting,roomState))
        let payload = file
    
        //@ts-ignore
        let response = await builderModeRestApi.postSettings(browser.config.Greenroom_Api_Host , payload)
        chai.expect(response.status).to.equal(200)
        reporter.addStep("info", `Room State setting is success!`)
        
     })