import request from 'supertest';
import { BodyStatusResponse } from './detailsPageRestApi';
import HomeRestApi from './homeRestApi';

export interface InvitationObject {
  email: string;
  watcher_only: boolean;
}

export interface CreateInvitationPayload {
  meeting: number;
  channel_name: string;
  title: string;
  channel: number;
  invitations: InvitationObject[];
}

export interface CreateNotificationPayload {
  notification: {
    meeting: number;
    sending_user: number;
    channel: number;
    created: string;
    type: string;
    receiving_emails: string[];
    receiving_users: string[];
    data: {
      message: string;
      meeting_slug: string;
      meeting_name: string;
      first_name: string;
      last_name: string;
      wallpaper: string;
    }
  }
}

export interface CreateIosPayload {
  emails: string;
  profiles: string;
  message: string;
}

export interface RevokeInvitationPayload {
  channel: number;
  email: string;
  meeting: number;
}

class PresenterInvitationApi {

  static postCreateNotificationResponse: request.Response;
  static postCreateInvitationResponse: {
    body: {
      profile: {
        email: string;
      };
    }[];
    status: number;
  };
  static postCreateIosNotificationResponse: request.Response;
  static postRevokeInvitationResponse: BodyStatusResponse;
  static getPresenterInvitationsResponse: BodyStatusResponse;
  static getUserNotificationsResponse: BodyStatusResponse;

  async postCreateNotification(
    host: string,
    payload: CreateNotificationPayload,
  ) {
    const endpoint = '/v2/greenroom/notifications/create';
    const token = Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken;

    console.log(`The url is >> ${host}${endpoint}`)
    console.log(`The payload is >> ${payload}`)

    const response = await request(host)
      .post(endpoint)
      .set('content-type', 'application/json')
      .set('bl-token', token)
      .accept('application/json')
      .send(payload);

    console.log(`The response is >> ${JSON.stringify(response.body, null, 2)}`);

    PresenterInvitationApi.postCreateNotificationResponse = {
      ...JSON.parse(
        JSON.stringify(response.body),
      ),
      status: response.status,
    };

    return PresenterInvitationApi.postCreateNotificationResponse;
  }

  async postCreateInvitation(
    host: string,
    payload: CreateInvitationPayload,
  ) {
    const endpoint = '/v2/greenroom/create-invitations';
    const token = Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken;

    console.log(`The url is >> ${host}${endpoint}`)
    console.log(`The payload is >> ${payload}`)

    const response = await request(host)
      .post(endpoint)
      .set('content-type', 'application/json')
      .set('bl-token', token)
      .accept('application/json')
      .send(payload);

    console.log(`The response is >> ${JSON.stringify(response.body, null, 2)}`);

    PresenterInvitationApi.postCreateInvitationResponse = {
      body: JSON.parse(
        JSON.stringify(response.body),
      ),
      status: response.status,
    };

    return PresenterInvitationApi.postCreateInvitationResponse;
  }

  async postCreateIosNotification(
    host: string,
    payload: CreateIosPayload,
  ) {
    const endpoint = '/v2/greenroom/ios-notification/create';
    const token = Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken;

    console.log(`The url is >> ${host}${endpoint}`)
    console.log(`The payload is >> ${payload}`)

    const response = await request(host)
      .post(endpoint)
      .set('content-type', 'application/json')
      .set('bl-token', token)
      .accept('application/json')
      .send(payload);

    console.log(`The response is >> ${JSON.stringify(response.body, null, 2)}`);

    PresenterInvitationApi.postCreateIosNotificationResponse = {
      ...JSON.parse(
          JSON.stringify(response.body),
        ),
      status: response.status,
    };

    return PresenterInvitationApi.postCreateIosNotificationResponse;
}

  async postRevokeInvitation(
    host: string,
    payload: RevokeInvitationPayload,
  ): Promise<BodyStatusResponse> {
    const endpoint = `/v2/greenroom/revoke-invitation`;
    const token = Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken;

    console.log(`The url is >> ${host}${endpoint}`);
    console.log(`The payload is >> ${JSON.stringify(payload, null, 2)}`);

    const response = await request(host)
      .post(endpoint)
      .set('content-type', 'application/json')
      .set('bl-token', token)
      .accept('application/json')
      .send(payload);

    console.log(`The response is >> ${JSON.stringify(response, null, 2)}`);

    PresenterInvitationApi.postRevokeInvitationResponse = {
      body: JSON.parse(
        JSON.stringify(response.body),
      ),
      status: response.status,
    };

    return PresenterInvitationApi.postRevokeInvitationResponse;
  }

  async getPresenterInvitations(host: string): Promise<BodyStatusResponse> {
    const endpoint = `/v2/greenroom/presenter-invitations`;
    const token = Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken;

    console.log(`The url is >> ${host}${endpoint}`);

    const response = await request(host)
      .get(endpoint)
      .set('content-type', 'application/json')
      .set('bl-token', token)
      .accept('application/json');

    console.log(`The response is >> ${JSON.stringify(response, null, 2)}`);

    PresenterInvitationApi.getPresenterInvitationsResponse = {
      body: JSON.parse(
        JSON.stringify(response.body),
      ),
      status: response.status,
    };

    return PresenterInvitationApi.getPresenterInvitationsResponse;
  }

  async getUserNotifications(host: string): Promise<BodyStatusResponse> {
    const endpoint = `/v2/greenroom/notifications/get`;
    const token = Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken;

    console.log(`The url is >> ${host}${endpoint}`);

    const response = await request(host)
      .get(endpoint)
      .set('content-type', 'application/json')
      .set('bl-token', token)
      .accept('application/json');

    console.log(`The response is >> ${JSON.stringify(response, null, 2)}`);

    PresenterInvitationApi.getUserNotificationsResponse = {
      body: JSON.parse(
        JSON.stringify(response.body),
      ),
      status: response.status,
    };

    return PresenterInvitationApi.getUserNotificationsResponse;
  }

}

export default new PresenterInvitationApi;
