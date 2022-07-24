import { Given, When, Then } from "@cucumber/cucumber";
import Avatar from "../../../page-objects/streams/UI/avatar";
import AvatarDetailsLive from "../../../page-objects/streams/UI/avatarDetailsLive";
import Directory from "../../../page-objects/streams/UI/directory";
import DirectoryLive from "../../../page-objects/streams/UI/directoryLive";
import EventHeader from "../../../page-objects/streams/UI/eventHeader";
import EventLandingPage from "../../../page-objects/streams/UI/eventLandingPage";
import GeneralInfo from "../../../page-objects/streams/UI/generalInfo";
import LeftNavigation from "../../../page-objects/streams/UI/leftNavigation";
import Messaging from "../../../page-objects/streams/UI/messaging";
import ProfileDetails from "../../../page-objects/streams/UI/profileDetails";
import ProfileInfo from "../../../page-objects/streams/UI/profileInfo";
import ProfileInfoLive from "../../../page-objects/streams/UI/profileInfoLive";
import RegistrationSettingGeneralInfo from "../../../page-objects/streams/UI/registrationSettingGeneralInfo";
import reporter from "../../../utils/reporter"
import WindowActions from "../../../utils/windowActions";

Given(/^Enable the Profile and Avatar for the event "3.0" registration$/, async function () {
    reporter.addStep("info", `Enabling the Profile Info and Avatar toggles from Registration...`)
    await LeftNavigation.clickOnRegistrationTab()
    await ProfileInfo.profileInfoToggleAction("ON")
    await Avatar.avatarToggleAction("ON")
    reporter.addStep("info", "Profile Info and Avatar toggles are enabled successfylly...")
})

Given(/^Enable the Directory toggle$/, async function () {
    reporter.addStep("info", `Enabling the Directory toggles...`)
    await LeftNavigation.clickOnSocialTab()
    await Directory.clickOnDirectoryCard()
    await Directory.directoryToggleAction("ON")
    await Avatar.socialAvatarToggleAction("ON")
    reporter.addStep("info", "Directory toggle is enabled successfylly...")
})

Given(/^Publish and Go live$/, async function () {
    reporter.addStep("info", `Publish and Go live...`)
    await EventHeader.publishEvent()
    await EventLandingPage.goLiveWithTheEvent()
    await browser.pause(4000)
    await WindowActions.switchToNextWindow(1)
    reporter.addStep("info", "Event is published and opened in the new tab...")
})

Given(/^Multiple attendees register for an event sequentially and the Directory tab is seen$/, async function (datatable) {
    reporter.addStep("info", `Multiple attendees registration...`)
    let regInfo = datatable.hashes()
    console.log(`Datatable first First Name: ${regInfo[0].FirstName}`)
    console.log(`Datatable first Last Name: ${regInfo[0].LastName}`)
    console.log(`Datatable first Email: ${regInfo[0].Email}`)
    console.log(`Datatable first Password: ${regInfo[0].Passcode}`)
    console.log(`Datatable first Company Name: ${regInfo[0].CompanyName}`)
    console.log(`Datatable first Bio: ${regInfo[0].Bio}`)
    console.log(`Datatable first Fun Fact: ${regInfo[0].FunFact}`)
    console.log(`Datatable first Media Name: ${regInfo[0].MediaName}`)
    console.log(`Datatable second First Name: ${regInfo[1].FirstName}`)
    console.log(`Datatable second Last Name: ${regInfo[1].LastName}`)
    console.log(`Datatable second Email: ${regInfo[1].Email}`)
    console.log(`Datatable second Password: ${regInfo[1].Passcode}`)
    console.log(`Datatable second Company Name: ${regInfo[1].CompanyName}`)
    console.log(`Datatable second Bio: ${regInfo[1].Bio}`)
    console.log(`Datatable second Fun Fact: ${regInfo[1].FunFact}`)
    console.log(`Datatable second Media Name: ${regInfo[1].MediaName}`)


    reporter.addStep("info", `First user Attendee registration...`)
    await EventLandingPage.clickOnRegistrationButton()
    await GeneralInfo.enterGeneralInfo(regInfo[0].FirstName, regInfo[0].LastName, regInfo[0].Email, regInfo[0].Passcode)
    await ProfileInfoLive.enterProfileInfo(regInfo[0].CompanyName, regInfo[0].Bio, regInfo[0].FunFact)
    await AvatarDetailsLive.uploadAvatarDetails(regInfo[0].MediaName)
    await DirectoryLive.verifyDirectoryTab()
    await EventLandingPage.logOutFromEvent()
    reporter.addStep("info", "Registration for first users is completed successfully...")

    reporter.addStep("info", `Second user Attendee registration...`)
    await browser.pause(3000)
    await WindowActions.switchToNextWindow(1)
    await GeneralInfo.enterGeneralInfo(regInfo[1].FirstName, regInfo[1].LastName, regInfo[1].Email, regInfo[1].Passcode)
    await ProfileInfoLive.enterProfileInfo(regInfo[1].CompanyName, regInfo[1].Bio, regInfo[1].FunFact)
    await AvatarDetailsLive.uploadAvatarDetails(regInfo[1].MediaName)
    await DirectoryLive.verifyDirectoryTab()
    reporter.addStep("info", "Registration for the second user is completed successfully...")
})

Given(/^Check multiple registered attendees list is displayed on the directory page$/, async function () {
    reporter.addStep("info", `Multiple attendees registered list...`)
    await DirectoryLive.clickOnTheDirectoryTab()
    await browser.pause(3000)
    await DirectoryLive.verifyAttendeesProfileCardsList()
    reporter.addStep("info", "Verified Multiple attendees registered list successfully...")
})

Given(/^Enable Bookmark attendees toggle$/, async function () {
    reporter.addStep("info", `Enable bookmark toggle...`)
    await WindowActions.switchToNextWindow(0)
    await Directory.bookmarkAttendeesToggleAction("ON")
    await EventHeader.publishEvent()
    reporter.addStep("info", "Enabled the bookmark attendees toggle...")
})

Given(/^Check bookmark icon is displayed on the attendees profile and functioning correctly$/, async function () {
    reporter.addStep("info", `Verify bookmark icon is displayed...`)
    await WindowActions.switchToNextWindow(1)
    await DirectoryLive.verifyBookMarkAttendeesIcon()
    reporter.addStep("info", "Verified bookmark icon...")
})

Given(/^Enable the Avatar toggles$/, async function () {
    reporter.addStep("info", `Enable Avatar toggle...`)
    await WindowActions.switchToNextWindow(0)
    await Avatar.socialAvatarToggleAction("ON")
    await EventHeader.publishEvent()
    reporter.addStep("info", "Enabled the Avatar toggle...")
})

Given(/^Avatar can be seen to the attendees on the directory page$/, async function () {
    reporter.addStep("info", `verify Avatar to profile...`)
    await WindowActions.switchToNextWindow(1)
    await DirectoryLive.verifyAvatarToAttendeesProfile()
    reporter.addStep("info", "Verified the Avatar to the attendees profile...")
})

Given(/^Add multi-select or drop down registration questions$/, async function (datatable) {
    let regInfo = datatable.hashes()
    console.log(`Datatable first Question Title: ${regInfo[0].QuestionTitle}`)
    console.log(`Datatable first Question Type: ${regInfo[0].QuestionType}`)
    console.log(`Datatable first No of Options: ${regInfo[0].NoOfOptions}`)
    console.log(`Datatable first option value one: ${regInfo[0].ValueOne}`)
    console.log(`Datatable first option value two: ${regInfo[0].ValueTwo}`)
    console.log(`Datatable first option value three: ${regInfo[0].ValueThree}`)
    reporter.addStep("info", `Add Registration question for the Directory filter...`)
    await WindowActions.switchToNextWindow(0)
    await LeftNavigation.clickOnRegistrationTab()
    await RegistrationSettingGeneralInfo.clickOnPencilIcon()
    await RegistrationSettingGeneralInfo.clickOnAddCustomFieldButton()
    await RegistrationSettingGeneralInfo.enterQuestionTitle(regInfo[0].QuestionTitle)
    await RegistrationSettingGeneralInfo.selectRegistrationQuestionType(regInfo[0].QuestionType, regInfo[0].NoOfOptions,
        regInfo[0].ValueOne, regInfo[0].ValueTwo, regInfo[0].ValueThree)
    await RegistrationSettingGeneralInfo.clickOnApply()
    await RegistrationSettingGeneralInfo.clickOnApply()
    reporter.addStep("info", "Added registration question for the Directory filter...")
})

Given(/^Save filter for the registration questions$/, async function () {
    reporter.addStep("info", `Save the filter Registration question...`)
    await LeftNavigation.clickOnSocialTab()
    await Directory.clickOnDirectoryCard()
    await RegistrationSettingGeneralInfo.clickOnPencilIcon()
    await Directory.selectFilterQuestion()
    await Directory.clickOnSaveFilter()
    reporter.addStep("info", "Save the filter for registration question...")
})

Given(/^Enable the filter toggle$/, async function () {
    reporter.addStep("info", `Enabling the filter toggle...`)
    await Directory.filterToggleAction("ON")
    await EventHeader.publishEvent()
    reporter.addStep("info", "Filter toggle is enabled successfully...")
})

Given(/^Check attendee registration with registration questions$/, async function (datatable) {
    reporter.addStep("info", `Attendee registration with Registration question...`)
    let regInfo = datatable.hashes()
    console.log(`Datatable first First Name: ${regInfo[0].FirstName}`)
    console.log(`Datatable first Last Name: ${regInfo[0].LastName}`)
    console.log(`Datatable first Email: ${regInfo[0].Email}`)
    console.log(`Datatable first Password: ${regInfo[0].Passcode}`)
    console.log(`Datatable first Company Name: ${regInfo[0].CompanyName}`)
    console.log(`Datatable first Bio: ${regInfo[0].Bio}`)
    console.log(`Datatable first Fun Fact: ${regInfo[0].FunFact}`)
    console.log(`Datatable first Media Name: ${regInfo[0].MediaName}`)
    await WindowActions.switchToNextWindow(1)
    await EventLandingPage.logOutFromEvent()
    await EventLandingPage.clickOnRegistrationButton() 
    await GeneralInfo.enterGeneralInfo(regInfo[0].FirstName, regInfo[0].LastName, regInfo[0].Email, regInfo[0].Passcode)
    await ProfileInfoLive.enterProfileInfo(regInfo[0].CompanyName, regInfo[0].Bio, regInfo[0].FunFact)
    await AvatarDetailsLive.uploadAvatarDetails(regInfo[0].MediaName)
    await DirectoryLive.clickOnTheDirectoryTab()
    await browser.pause(2000)
    reporter.addStep("info", "Attendee is registered succssfully with registration question...")
})

Given(/^Filter is seen on the live page and functioning correctly for the registered attendees$/, async function () {
    reporter.addStep("info", `Verify the filter at live page and its fucntionality...`)
    await DirectoryLive.verifyFilterContainer()
    await DirectoryLive.verifyFilterFunctionality()
    await browser.refresh()
    reporter.addStep("info", "Verified the filter at live and functioning correctly...")
})

Given(/^Enable the Profile details About and Topics toggles$/, async function () {
    reporter.addStep("info", `Enable Profile details toggles...`)
    await WindowActions.switchToNextWindow(0)
    await LeftNavigation.clickOnSocialTab()
    await ProfileDetails.clickOnProfileDetailsCard()
    await ProfileDetails.profileDetailsToggleAction("ON")
    await ProfileDetails.aboutToggleAction("ON")
    await ProfileDetails.topicsToggleAction("ON")
    await EventHeader.publishEvent()
    reporter.addStep("info", "Enabled profile details toggles...")
})

Given(/^Check user profile pop up is opened with all the registered details$/, async function () {
    reporter.addStep("info", `Verify registered details on the  Profile details pop up...`)
    await WindowActions.switchToNextWindow(1)
    await browser.pause(3000)
    await DirectoryLive.VerifyPopUPDetailsforAttendees()
    reporter.addStep("info", "Verified the profile pop up details...")
})

Given(/^Check profile details with In a Pop-up option and functioning correctly$/, async function () {
    reporter.addStep("info", `Verify profile details In a Pop up option...`)
    await WindowActions.switchToNextWindow(0)
    await ProfileDetails.clickOnSettingIcon()
    await ProfileDetails.clickOnArrowDownIcon()
    await ProfileDetails.selectProfileAppearance("In a Pop-up")
    await EventHeader.publishEvent()
    await WindowActions.switchToNextWindow(1)
    await DirectoryLive.verifyInPopUpView()
    reporter.addStep("info", "Verified profile details with In pop up option...")
})

Given(/^Check profile details with As a Page option and functioning correctly$/, async function () {
    reporter.addStep("info", `Verify profile details As a Page option...`)
    await WindowActions.switchToNextWindow(0)
    await ProfileDetails.clickOnArrowDownIcon()
    await ProfileDetails.selectProfileAppearance("As a Page")
    await EventHeader.publishEvent()
    await browser.pause(3000)
    await WindowActions.switchToNextWindow(1)
    await DirectoryLive.verifyAsPageView()
    await browser.pause(3000)
    reporter.addStep("info", "Verified profile details with As a Page option...")
})

Given(/^Enable the Direct Messaging toggle$/, async function () {
    reporter.addStep("info", `Enabling the Direct Messaging toggle...`)
    await WindowActions.switchToNextWindow(0)
    await LeftNavigation.clickOnSocialTab()
    await Messaging.clickOnMessagingsCard()
    await Messaging.directMessagingToggleAction("ON")
    reporter.addStep("info", "Enabled Direct mesaging toggle...")
})

Given(/^Create a new event channel$/, async function (datatable) {
    reporter.addStep("info", `Creating a new channel...`)
    let channelInfo = datatable.hashes()
    console.log(`Datatable Event Channel Name: ${channelInfo[0].EventChannelName}`)
    console.log(`Datatable Media Name: ${channelInfo[0].MediaName}`)

    await Messaging.clickOnEventChannelAddButton()
    await browser.pause(3000)
    await Messaging.setEventChannelName(channelInfo[0].EventChannelName)
    await browser.pause(2000)
    await Messaging.uploadChannelImageDetails(channelInfo[0].MediaName)
    reporter.addStep("info", "New channel is created successfully...")
})

Given(/^Enable the Topic Group Chats toggle$/, async function () {
    reporter.addStep("info", `Enabling Topic group chats toggle...`)
    await Messaging.topicGroupChatsToggleAction("ON")
    await EventHeader.publishEvent()
    reporter.addStep("info", "Enabled topic group chats successfully...")
    await browser.pause(3000)
})

Given(/^Check the Chat bubble and event channel is displayed on the live page$/, async function (datatable) {
    reporter.addStep("info", `Verify chat bubble and event channel...`)
    let channelInfo = datatable.hashes()
    console.log(`Datatable Event Channel Name: ${channelInfo[0].EventChannelName}`)

    await WindowActions.switchToNextWindow(1)
    reporter.addStep("info", `Verify chat bubble on the live Home page...`)
    await EventLandingPage.clickOnHomeTab();
    await DirectoryLive.verifyDirectMessagingChatBubble()
    reporter.addStep("info", `Verify chat bubble on the live Session page...`)
    await EventLandingPage.clickOnSessionTab();
    await DirectoryLive.verifyDirectMessagingChatBubble()
    reporter.addStep("info", `Verify chat bubble on the live Directory page...`)
    await DirectoryLive.clickOnTheDirectoryTab()
    await DirectoryLive.verifyDirectMessagingChatBubble()
    await DirectoryLive.clickOnDirectMessagingChatBubble()
    await DirectoryLive.verifyEventLobbyDefaultChannel()
    await DirectoryLive.verifyNewEventChannelsUnderChatBubble(channelInfo[0].EventChannelName)
    reporter.addStep("info", "Verified chat bubble and event channel successfully...")
})

Given(/^Verify attendee is able to send message in the event channel$/, async function (datatable) {
    reporter.addStep("info", `Verify attendee send message...`)
    let chatMessageInfo = datatable.hashes()
    console.log(`Datatable chat message is: ${chatMessageInfo[0].ChatMessage}`)

    await DirectoryLive.verifyAttendeesAbleToSendMessageInChannels(chatMessageInfo[0].ChatMessage)
    reporter.addStep("info", "Attendee is able to send message in the event channels successfully...")
    await WindowActions.switchToNextWindow(0)
})
