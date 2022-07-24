import { Given } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import StandaloneHomeRestApi from "../../../page-objects/greenroom/restApi/standaloneHomeRestApi"
import DestinationSetupApi, { SaveSettingsPayload, UpdateRtmpEndpointPayload } from "../../../page-objects/greenroom/restApi/destinationSetupRestApi"

// Random 10 character string
const customDestinationId = "d4Lb6ASkjP";

Given(/^Settings call for adding streaming destination$/, async function(datatable) {
    let meetingRoomId = Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId;

    const data = datatable.hashes();
    const name = data[0].Name;
    const rtmpAddress = data[0].RtmpAddress;
    const streamKey = data[0].StreamKey;

    const payload: SaveSettingsPayload = {
        meeting: meetingRoomId,
        settings: `{\"templateAccordionOpen\":false,\"spacingAccordionOpen\":false,\"wallpaperAccordionOpen\":false,\"backgroundAccordionOpen\":false,\"greenroomSettingsAccordionOpen\":false,\"useModeratedQuestions\":true,\"previewLayout\":\"single cover\",\"askToJoin\":false,\"selectedResolution\":\"1080p\",\"settingsTab\":1,\"entryWithoutProducer\":true,\"overlayVisible\":false,\"backstageCommsActive\":true,\"useDefaultEndpoint\":true,\"defaultResolution\":\"1080p\",\"customDestinations\":[{\"id\":\"${customDestinationId}\",\"name\":\"${name}\",\"url\":\"${rtmpAddress}\",\"stream_key\":\"${streamKey}\",\"resolution\":\"1080p\",\"logo\":\"\",\"type\":0}],\"selectedCustomDestination\":\"\",\"roomState\":2,\"useEmailInvites\":true,\"clearShot\":false,\"useShowboard\":true,\"defaultMeetingImage\":{\"image\":\"\",\"color\":\"\",\"scale\":0},\"feedScaling\":true,\"autoMute\":false,\"hasFetchedFeatureFlags\":false}`
    };

    //@ts-ignore
    let response = await DestinationSetupApi.saveSettings(browser.config.Greenroom_Api_Host, payload)
    chai.expect(response.status).to.equal(200)
    reporter.addStep("info", `Create streaming destination is success!`)
})

Given(/^Settings call for enabling streaming destination$/, async function(datatable) {
    let meetingRoomId = Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId;

    const data = datatable.hashes();
    const name = data[0].Name;
    const rtmpAddress = data[0].RtmpAddress;
    const streamKey = data[0].StreamKey;
    const useDefaultEndpoint = false;

    const payload: SaveSettingsPayload = {
        meeting: meetingRoomId,
        settings: `{\"templateAccordionOpen\":false,\"spacingAccordionOpen\":false,\"wallpaperAccordionOpen\":false,\"backgroundAccordionOpen\":false,\"greenroomSettingsAccordionOpen\":false,\"useModeratedQuestions\":true,\"previewLayout\":\"single cover\",\"askToJoin\":false,\"selectedResolution\":\"1080p\",\"settingsTab\":1,\"entryWithoutProducer\":true,\"overlayVisible\":false,\"backstageCommsActive\":true,\"useDefaultEndpoint\":${useDefaultEndpoint},\"defaultResolution\":\"1080p\",\"customDestinations\":[{\"id\":\"${customDestinationId}\",\"name\":\"${name}\",\"url\":\"${rtmpAddress}\",\"stream_key\":\"${streamKey}\",\"resolution\":\"1080p\",\"logo\":\"\",\"type\":0}],\"selectedCustomDestination\":\"${customDestinationId}\",\"roomState\":2,\"useEmailInvites\":true,\"clearShot\":false,\"useShowboard\":true,\"defaultMeetingImage\":{\"image\":\"\",\"color\":\"\",\"scale\":0},\"feedScaling\":true,\"autoMute\":false,\"hasFetchedFeatureFlags\":false}`
    };

    //@ts-ignore
    let response = await DestinationSetupApi.saveSettings(browser.config.Greenroom_Api_Host, payload)
    chai.expect(response.status).to.equal(200)
    reporter.addStep("info", `Eanble streaming destination is success!`)
})

Given(/^Update broadcast details to meeting room$/, async function(datatable) {
    let meetingRoomId = Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId;

    const data = datatable.hashes();
    const name = data[0].Name;
    const rtmpAddress = data[0].RtmpAddress;
    const streamKey = data[0].StreamKey;

    const payload: UpdateRtmpEndpointPayload = {
        name,
        rtmpAddress,
        streamKey
    };

    //@ts-ignore
    let response = await DestinationSetupApi.enableStreamingDestination(browser.config.Greenroom_Api_Host, meetingRoomId, payload)
    chai.expect(response.body.name).to.equal("Streams")
    reporter.addStep("info", `Update broadcast details to meeting room is success!`)
})