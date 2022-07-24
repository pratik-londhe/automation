import { Then } from '@cucumber/cucumber';
import chai from 'chai';
import UploadGRApi, {
    CreateMediaPayload, MediaResponse,
    UploadAPIData,
    UploadPayloadRequest
} from '../../../page-objects/greenroom/restApi/uploadGRRestApi';
import StandaloneHomeRestApi from '../../../page-objects/greenroom/restApi/standaloneHomeRestApi';
import path from 'path';
import { random } from '../../../utils/random';
import { getMockImageArray } from '../../../utils/api/mockResponse';

// we need this to be the same throughout the whole test
const date = new Date();
const tempName = date.toISOString().replace(/:\s*/g, '-');
const randomPathSection = random(10);
const uuid = 'some-uuid';
const mockPagesPdf = 5;

Then(/^Upload a (.*) to GR Event$/, async (fileType: string) => {
    const meetingId = Number(
        `${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}`,
    );
    const channelId = Number(
        `${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.channelId}`,
    );

    const payload: UploadPayloadRequest = {
        filename: `test-${tempName}.${fileType}`,
        prefix: `uploads/${meetingId}/${channelId}/${tempName}`,
    };

    const config = browser.config as unknown as { [key: string]: any };
    const response: UploadAPIData = await UploadGRApi.postUpload(
        config.Greenroom_Api_Host,
        payload,
    );

    chai.expect(response.status).to.equal(200);
    chai.expect(response.body.fields.Key).to.equal(`${payload.prefix}/${payload.filename}`);
});

Then(/^Upload the (.*) to AWS$/, async (fileType: string) => {
    let fileName = "";
    switch (fileType) {
        case "mp4":
            fileName = "sample_video";
            break;
        case "jpg":
            fileName = "sample_image";
            break;
    }
    console.log("fileType", fileType);
    console.log("fileName", fileName);
    const file = path.relative(process.cwd(), `./data/fileUpload/greenroom/${fileName}.${fileType}`);
    const response = await UploadGRApi.postUploadFileToAws(file);
    chai.expect(response.status).to.equal(204);
});

Then(/^Notify backend that upload has completed$/, async () => {
    const config = browser.config as unknown as { [key: string]: any };
    const response = await UploadGRApi.postUploadFinish(config.Greenroom_Api_Host);
    chai.expect(response.status).to.equal(200);
    chai.expect(response.text).to.equal('OK');
});

Then(/^Create thumbnail for (.*)$/, async (fileType: string) => {
    const meetingId = Number(
        `${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}`,
    );
    const channelId = Number(
        `${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.channelId}`,
    );

    const payload: UploadPayloadRequest = {
        filename: `test-${tempName}.jpg`,
        prefix: `uploads/${meetingId}/${channelId}/${tempName}`,
    };

    const config = browser.config as unknown as { [key: string]: any };
    const response: UploadAPIData = await UploadGRApi.postUpload(
        config.Greenroom_Api_Host,
        payload,
    );

    chai.expect(response.status).to.equal(200);
    chai.expect(response.body.fields.Key).to.equal(`${payload.prefix}/${payload.filename}`);
});

Then(/^Upload thumbnail to AWS$/, async () => {
    const thumbnailFile = path.relative(process.cwd(), './data/fileUpload/greenroom/sample_image.jpg');
    const response = await UploadGRApi.postUploadFileToAws(thumbnailFile);
    chai.expect(response.status).to.equal(204);
});

Then(/^Tell the backend to create the (.*) media item$/, async (fileType: string) => {
    const now = new Date();
    const meetingId = Number(
        `${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}`,
    );
    const userId = Number(
        `${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getGrUserProfileId}`,
    );
    const channelId = Number(
        `${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.channelId}`,
    );

    let fileName = "";
    switch (fileType) {
        case "mp4":
            fileName = "sample_video";
            break;
        case "jpg":
            fileName = "sample_image";
            break;
    }

    const payload: CreateMediaPayload = {
        cloud_convert_id: null,
        convert_status: 'processing',
        created_by: userId,
        created_date: now.getTime(),
        endpoint: `https://assets.brandlive.com/uploads/${meetingId}/${channelId}/${tempName}`,
        images: `https://assets.brandlive.com/uploads/${meetingId}/${channelId}/${tempName}/test-${tempName}.${fileType}`,
        meeting: meetingId,
        original_name: `${fileName}.${fileType}`,
        type: fileType,
    };

    const config = browser.config as unknown as { [key: string]: any };
    const response: MediaResponse = await UploadGRApi.postMediaCreate(
        config.Greenroom_Api_Host,
        payload,
    );

    chai.expect(response.status).to.equal(200);
    chai.expect(response.body[0]).to.not.equal(undefined || null);
    chai.expect(response.body[0].id > 0).to.equal(true);
    chai.expect(response.body[0].meeting).to.equal(meetingId);
});

Then(/^Request the newly created media item$/, async () => {
    const expectedResponse = UploadGRApi.getCreateMediaResponse();
    const meetingId = Number(
        `${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}`,
    );

    const config = browser.config as unknown as { [key: string]: any };
    const response: MediaResponse = await UploadGRApi.getMediaItem(
        config.Greenroom_Api_Host,
        meetingId,
    );

    const fetchedMediaItem = response?.body?.find((media) => media.id == expectedResponse[0].id);

    chai.expect(response.status).to.equal(200);
    chai.expect(fetchedMediaItem).to.not.equal(null || undefined);
    chai.expect(fetchedMediaItem.created_date).to.equal(expectedResponse[0].created_date);
    chai.expect(fetchedMediaItem.edited_date).to.equal(expectedResponse[0].edited_date);
    chai.expect(fetchedMediaItem.created_by).to.equal(expectedResponse[0].created_by);
    chai.expect(fetchedMediaItem.edited_by).to.equal(expectedResponse[0].edited_by);
    chai.expect(fetchedMediaItem.meeting).to.equal(expectedResponse[0].meeting);
    chai.expect(fetchedMediaItem.type).to.equal(expectedResponse[0].type);
    chai.expect(fetchedMediaItem.num_pages).to.equal(expectedResponse[0].num_pages);
    chai.expect(fetchedMediaItem.shared_with).to.equal(expectedResponse[0].shared_with);
    chai.expect(fetchedMediaItem.cloud_convert_id).to.equal(expectedResponse[0].cloud_convert_id);
    chai.expect(fetchedMediaItem.convert_status).to.equal(expectedResponse[0].convert_status);
    chai.expect(fetchedMediaItem.original_name).to.equal(expectedResponse[0].original_name);
    chai.expect(fetchedMediaItem.custom_name).to.equal(expectedResponse[0].custom_name);
    chai.expect(fetchedMediaItem.endpoint).to.equal(expectedResponse[0].endpoint);
    chai.expect(fetchedMediaItem.images).to.equal(expectedResponse[0].images);
});

Then(/^Mock get CloudConvert job for the PDF$/, async () => {
    const channelId = Number(
        `${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.channelId}`,
    );
    const meetingSlugId = Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRSlugMeetingId;
    const response = await UploadGRApi.getCloudConvertJob(
        uuid,
        channelId,
        meetingSlugId,
        randomPathSection,
    );
    chai.expect(response.status).to.equal(200);
});

Then(/^Tell the backend to create the PDF$/, async () => {
    const baseEndpoint = 'https://assets.brandlive.com/uploads';
    const now = new Date();
    const meetingId = Number(
        `${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}`,
    );
    const meetingSlugId = Object.getPrototypeOf(
        StandaloneHomeRestApi
    ).constructor.getNewSGRSlugMeetingId;
    const userId = Number(
        `${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getGrUserProfileId}`,
    );
    const channelId = Number(
        `${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.channelId}`,
    );
    const [filename, ext] = 'sample_pdf.pdf'.split('.');
    const imagesEndpoint = `${baseEndpoint}/${channelId}/${meetingSlugId}/${randomPathSection}`;
    const payload: CreateMediaPayload = {
        cloud_convert_id: uuid,
        convert_status: 'processing',
        created_by: userId,
        created_date: now.getTime(),
        endpoint: imagesEndpoint,
        images: getMockImageArray(imagesEndpoint, filename, mockPagesPdf),
        meeting: meetingId,
        original_name: filename,
        type: ext,
    };

    const config = browser.config as unknown as { [key: string]: any };
    const response: MediaResponse = await UploadGRApi.postMediaCreate(
        config.Greenroom_Api_Host,
        payload,
    );

    chai.expect(response.status).to.equal(200);
    chai.expect(response.body[0]).to.not.equal(undefined || null);
    chai.expect(response.body[0].id > 0).to.equal(true);
    chai.expect(response.body[0].meeting).to.equal(meetingId);
});

Then(/^Get converted PDF ID$/, async () => {
    const expectedResponse = UploadGRApi.getCloudConvertJobResponse();
    const meetingId = Number(
        `${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}`,
    );
    const config = browser.config as unknown as { [key: string]: any };
    const response: MediaResponse = await UploadGRApi.getMediaItem(
        config.Greenroom_Api_Host,
        meetingId,
    );
    const fetchedMediaItem = response?.body?.find(
        (media) => media.cloud_convert_id === expectedResponse.id,
    );

    chai.expect(response.status).to.equal(200);
    chai.expect(fetchedMediaItem).to.not.equal(null || undefined);
    chai.expect(fetchedMediaItem.cloud_convert_id).to.equal(expectedResponse.id);
    chai.expect(fetchedMediaItem.endpoint).to.equal(expectedResponse.endpoint);
    chai.expect(fetchedMediaItem.images).to.have.length;
    chai.expect(fetchedMediaItem.media_data.image_array).to.have.lengthOf(mockPagesPdf);
});
