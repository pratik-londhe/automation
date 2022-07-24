import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import PresenterInvitationApi, {
	CreateInvitationPayload,
	CreateNotificationPayload, CreateIosPayload,
} from "../../../page-objects/greenroom/restApi/presenterInvitationRestApi";
import { RevokeInvitationPayload } from "../../../page-objects/greenroom/restApi/presenterInvitationRestApi";
import StandaloneHomeRestApi from "../../../page-objects/greenroom/restApi/standaloneHomeRestApi"

Given(/^Create an invitation for (.*)$/, async (email: string) => {
	const config = browser.config as unknown as { [key: string]: any };
	const meetingId = Number(
		`${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}`,
	);
	const channelId = Number(
		`${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.channelId}`,
	);
	const payload: CreateInvitationPayload = {
		meeting: meetingId,
		channel_name: config.ChannelName,
		title:"InvitationsApi",
		channel: channelId,
		invitations:[
			{
				email,
				watcher_only:false,
			}
		],
	};

	const response = await PresenterInvitationApi.postCreateInvitation(
		config.Greenroom_Api_Host,
		payload,
	);

	chai.expect(response.status).to.equal(200);
	chai.expect(response.body[0].profile.email).to.equal(email);
});

Given(/^Create a notification for (.*)$/, async (email: string) => {
	const meetingId = Number(
		`${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}`,
	);
	const meetingSlugId = Number(
		`${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRSlugMeetingId}`,
	);
	const channelId = Number(
		`${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.channelId}`,
	);
	const userId = Number(
		`${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getGrUserProfileId}`,
	);
	const payload: CreateNotificationPayload = {
		notification:{
			meeting: meetingId,
				sending_user: userId,
				channel: channelId,
				created: new Date().toISOString(),
				type: "invite-presenter",
				receiving_emails: [email],
				receiving_users: [],
				data: {
				message: "**%%notification_sender%%** invited you as a presenter on **%%notification_meeting%%**",
					meeting_slug: `${meetingSlugId}`,
					meeting_name: "InvitationsApi",
					first_name: "first_name",
					last_name: "last_name",
					wallpaper: "",
			},
		},
	};
	const config = browser.config as unknown as { [key: string]: any };
	const response = await PresenterInvitationApi.postCreateNotification(
		config.Greenroom_Api_Host,
		payload,
	);

	chai.expect(response.status).to.equal(200);
});

Given(/^Create an iOS notification for (.*)$/, async (email: string) => {
	const payload: CreateIosPayload = {
		emails: email,
		profiles:"",
		message:"You’ve been invited as a presenter",
	};

	const config = browser.config as unknown as { [key: string]: any };
	const response = await PresenterInvitationApi.postCreateIosNotification(
		config.Greenroom_Api_Host,
		payload,
	);

	chai.expect(response.status).to.equal(200);
});

Given(/^Revoke an invitation for (.*)$/, async (email: string) => {
	const channelId = Number(
		`${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.channelId}`,
	);
	const meetingId = Number(
		`${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}`,
	);
	const payload: RevokeInvitationPayload = {
		channel: channelId,
		email: email,
		meeting: meetingId,
	};
	const config = browser.config as unknown as { [key: string]: any };
	const { body, status } = await PresenterInvitationApi.postRevokeInvitation(
		config.Greenroom_Api_Host,
		payload,
	);

	chai.expect(body).to.be.empty;
	chai.expect(status).to.equal(200);
});

Given(/^Get presenter invitations for (.*)$/, async (email: string) => {
	const meetingId = Number(
		`${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}`,
	);
	const config = browser.config as unknown as { [key: string]: any };
	const { body, status } = await PresenterInvitationApi.getPresenterInvitations(
		config.Greenroom_Api_Host,
	);

	chai.expect(body).to.not.be.empty;
	chai.expect(status).to.equal(200);

	const currentMeetingWithInvites: { [key: string]: any } | undefined = body.find(
		(meetingObj) => meetingObj.meeting === meetingId
	);

	chai.expect(currentMeetingWithInvites).to.be.undefined;
});

Given(/^Get notifications for user$/, async () => {
	const meetingId = Number(
		`${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}`,
	);
	const config = browser.config as unknown as { [key: string]: any };
	const { body, status } = await PresenterInvitationApi.getUserNotifications(
		config.Greenroom_Api_Host,
	);

	chai.expect(body).to.not.be.empty;
	chai.expect(status).to.equal(200);

	const matchingMeetingNotifications: { [key: string]: any }[] = body.filter(
		(notificationObj) => notificationObj.meeting === meetingId
	);

	chai.expect(matchingMeetingNotifications).to.be.empty;
});
