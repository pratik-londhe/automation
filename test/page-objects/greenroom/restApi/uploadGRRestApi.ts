import request from "supertest";
import { getMockResponse } from "../../../utils/api/mockResponse";
import HomeRestApi from "./homeRestApi";

export interface UploadPayloadRequest {
	filename: string;
	prefix: string;
}

export interface CommonAwsResponse {
	'X-Amz-Algorithm': string;
	'X-Amz-Credential': string;
	'X-Amz-Date': string;
	Policy: string;
	'X-Amz-Signature': string;
}

export interface UploadPayloadAPIResponse {
	url: string;
	fields: CommonAwsResponse & {
		Key: string;
		bucket: string;
	};
}

export interface CreateMediaPayload {
	cloud_convert_id: string | null;
	convert_status: string;
	created_by: number;
	created_date: number;
	endpoint: string;
	images: string;
	meeting: number;
	original_name: string;
	type: string;
}

export interface  UploadAPIData {
	body: UploadPayloadAPIResponse,
	status: number;
}

export interface CreateMediaData {
	id: number,
	created_date: number;
	edited_date: number;
	created_by: number;
	edited_by: number | null;
	meeting: number;
	type: string;
	num_pages: number;
	shared_with: string | null;
	cloud_convert_id: string | null;
	convert_status: string;
	original_name: string;
	custom_name: string | null;
	endpoint: string;
	images: string;
	media_data: {
		image_array: string[];
		fill: boolean;
		background_color: string;
		loop: boolean;
		description: string;
	};
}

export interface MediaResponse {
	body: CreateMediaData[],
	status: number;
}

export interface CloudConvertAWSParameters extends CommonAwsResponse {
	acl: string;
	key: string;
	success_action_status: string;
}

export interface InitialMediaConvertResponse {
	endpoint: string,
	form: {
		parameters: CloudConvertAWSParameters;
		url: string;
	};
	id: string;
}

export interface FormattedMediaConvertResponse {
	body: InitialMediaConvertResponse,
	status: number;
}

class UploadGRRestApi {
	static postUploadResponse: UploadPayloadAPIResponse;
	static postUploadFileToAwsResponse: Response;
	static finishUploadResponse: Response;
	static postMediaCreateResponse: MediaResponse;
	static getMediaItemResponse: MediaResponse;
	static getMediaConvertResponse: FormattedMediaConvertResponse;

	async postUpload(
		host: string,
		payload: UploadPayloadRequest,
	) {
		const endpoint = '/v2/greenroom/media/upload';
		const token = Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken;

		console.log(`The url is >> ${host}${endpoint}`);
		console.log(`The payload is >> ${payload}`);

		const response = await request(host)
			.post(endpoint)
			.set('content-type', 'application/json')
			.set('bl-token', token)
			.accept('application/json')
			.send(payload);

		console.log(`The response is >> ${JSON.stringify(response.body, null, 2)}`);

		UploadGRRestApi.postUploadResponse = response.body;

		return {
			body: UploadGRRestApi.postUploadResponse,
			status: response.status,
		};
	}

	async postUploadFileToAws(fileToUpload: string) {
		const payload = UploadGRRestApi.postUploadResponse;
		console.log(`The url is >> ${payload.url}`);
		console.log(`The payload is >> ${payload.fields}`);

		const response = await request(payload.url)
			.post('/')
			.set("content-type", "multipart/form-data")
			.accept("*/*")
			.field('Key', payload.fields.Key)
			.field('bucket', payload.fields.bucket)
			.field('X-Amz-Algorithm', payload.fields['X-Amz-Algorithm'])
			.field('X-Amz-Credential', payload.fields['X-Amz-Credential'])
			.field('X-Amz-Date', payload.fields['X-Amz-Date'])
			.field('Policy', payload.fields.Policy)
			.field('X-Amz-Signature', payload.fields['X-Amz-Signature'])
			.attach('file', fileToUpload);

		console.log(`The response is >> ${JSON.stringify(response.body, null, 2)}`);

		UploadGRRestApi.postUploadFileToAwsResponse = response.body;

		return response;
	}

	async postUploadFinish(host: string) {
		const endpoint = '/v2/greenroom/media/upload/finish';
		const token = Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken;
		const uploadData = UploadGRRestApi.postUploadResponse;
		const payload = {
			filename: `${uploadData.fields.bucket}/${uploadData.fields.Key}`,
		};

		console.log(`The url is >> ${host}${endpoint}`);
		console.log(`The payload is >> ${payload}`);

		const response = await request(host)
			.post(endpoint)
			.set('content-type', 'application/json')
			.set('bl-token', token)
			.accept('application/json')
			.send(payload);

		console.log(`The response is >> ${response.body}`);

		UploadGRRestApi.finishUploadResponse = response.body;

		return response;
	}

	async postMediaCreate(
		host: string,
		payload: CreateMediaPayload,
	) {
		const endpoint = '/v2/greenroom/media/create';
		const token = Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken;

		console.log(`The url is >> ${host}${endpoint}`);
		console.log(`The payload is >> ${payload}`);

		const response = await request(host)
			.post(endpoint)
			.set('content-type', 'application/json')
			.set('bl-token', token)
			.accept('application/json')
			.send(payload);

		console.log(`The response is >> ${JSON.stringify(response.body, null, 2)}`);

		UploadGRRestApi.postMediaCreateResponse = {
			body: response.body,
			status: response.status,
		};

		return UploadGRRestApi.postMediaCreateResponse;
	}

	async getMediaItem(
		host: string,
		meetingId: number,
	) {
		const endpoint = `/v2/greenroom/media/${meetingId}`;
		const token = Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken;

		console.log(`The url is >> ${host}${endpoint}`);
		console.log(`The mediaId is >> ${meetingId}`);

		const response = await request(host)
			.get(endpoint)
			.set('content-type', 'application/json')
			.set('bl-token', token)
			.accept('application/json')
			.send();

		console.log(`The response is >> ${JSON.stringify(response.body, null, 2)}`);

		UploadGRRestApi.getMediaItemResponse = {
			body: response.body,
			status: response.status,
		};

		return UploadGRRestApi.getMediaItemResponse;
	}

	getCreateMediaResponse(): CreateMediaData[] {
		return UploadGRRestApi.postMediaCreateResponse.body;
	}

	async getCloudConvertJob(
		uuid: string,
		channelId: number,
		meetingSlugId: string,
		randomPathSection: string,
	): Promise<FormattedMediaConvertResponse> {
		console.log(`The channelId is >> ${channelId}`);
		console.log(`The meetingSlugId is >> ${meetingSlugId}`);
		console.log(`The randomPathSection is >> ${randomPathSection}`);

		const mockResponseObject: FormattedMediaConvertResponse = {
			body: {
				id: uuid,
				endpoint: `https://assets.brandlive.com/uploads/${channelId}/${meetingSlugId}/${randomPathSection}`,
				form: {
					url: 'https://storage.cloudconvert.com/tasks',
					parameters: {
						acl: 'private',
						key: 'key',
						success_action_status: '201',
						'X-Amz-Credential': 'credential',
						'X-Amz-Algorithm': 'algorithm',
						'X-Amz-Date': '20220101T111111Z',
						Policy: 'policy',
						'X-Amz-Signature': 'signature',
					},
				},
			},
			status: 200,
		};
		const mockResponse: FormattedMediaConvertResponse = await getMockResponse<FormattedMediaConvertResponse>(
			mockResponseObject,
			500,
		);

		console.log(`The response is >> ${JSON.stringify(mockResponse.body, null, 2)}`);

		UploadGRRestApi.getMediaConvertResponse = {
			body: mockResponse.body,
			status: mockResponse.status,
		};

		return UploadGRRestApi.getMediaConvertResponse;
	}

	getCloudConvertJobResponse(): InitialMediaConvertResponse {
		return UploadGRRestApi.getMediaConvertResponse.body;
	}
}

export default new UploadGRRestApi;
