/**
 * For all entity uploads
 */

 import { config } from "dotenv";
import request from "supertest";
 import cloudflareParameters from "./../utils/cloudflareParameters";
 import HomeRestApi from "./streams/restApi/homeRestApi";
 const path = require('path');

 class UploadRestApi {
    static putUploadEndpointRes: any;

    private uploadEndpoint: string;
    private uploadsBrandlive: string;

    constructor() {
        this.uploadEndpoint = '/v3/admin/channel/upload-endpoint';
        //@ts-ignore
        this.uploadsBrandlive = `${browser.config.Streams_Api_Uploads}`;
    }

    async putUploadEndpoint(host: string, fileName: string): Promise<any>{
        const endpoint = this.uploadEndpoint;
        const payload = {
            "filename": fileName,
            "isThumb": false
        };
        console.log(`The url is >> ${host}${endpoint}`)
        await cloudflareParameters.generateCloudflareParameters(endpoint);
        let queryStr = `mac=${cloudflareParameters.mac}&expiry=${cloudflareParameters.expiry}`;
        console.log(`The url with query is >> ${host}${endpoint}?${queryStr}`);

        const response = await request(host)
                    .put(endpoint)
                    .set("content-type", "application/json")
                    .set("bl-token", Object.getPrototypeOf(HomeRestApi).constructor.streamsToken)
                    .accept("application/json")
                    .query(queryStr)
                    .send(payload);

        //console.log(`>> Response: ${JSON.stringify(response.body)}`);
        UploadRestApi.putUploadEndpointRes = response.body;
        return response;
    }

    async postUploadsBrandlive(fields: any, csvWithPath: string): Promise<any> {
        const host = this.uploadsBrandlive;
        console.log(JSON.parse(JSON.stringify(fields)));

        const csvWithRelativePath = path.relative(process.cwd(), csvWithPath);

        const response = await request(host)
                    .post('/')
                    .set("content-type", "multipart/form-data")
                    .accept("*/*")
                    .field('Key', fields.Key)
                    .field('bucket', fields.bucket)
                    .field('X-Amz-Algorithm', fields['X-Amz-Algorithm'])
                    .field('X-Amz-Credential', fields['X-Amz-Credential'])
                    .field('X-Amz-Date', fields['X-Amz-Date'])
                    .field('Policy', fields.Policy)
                    .field('X-Amz-Signature', fields['X-Amz-Signature'])
                    .attach('file', csvWithRelativePath);

        return response;
    }
 }

 export default new UploadRestApi
