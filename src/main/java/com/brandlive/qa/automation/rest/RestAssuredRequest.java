package com.brandlive.qa.automation.rest;

import com.brandlive.qa.automation.utils.Doer;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Map;



public class RestAssuredRequest extends Doer {
	// Get method
	public Response sendJsonRequestWithoutBody(String url, Map<String, String> headers) {
		Response resp = given().log().all().headers(headers).contentType("application/json").when().get(url).then()
				.extract().response();
		return resp;
	}

	// Post method - with headers
	public Response sendJsonRequestWithBody(String url, Object object, Map<String, String> headers) {
		Response resp = given()
				.config(RestAssured.config()
						.encoderConfig(new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
				.log().all().headers(headers).and().contentType("application/json").and().accept("application/json")
				.and().body(object).when().post(url).then().extract().response();
		return resp;
	}

	// Post method - without headers
	public Response sendJsonRequestWithBody(String url, Object object) {
		Response resp = given()
				.config(RestAssured.config()
						.encoderConfig(new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
				.log().all().contentType("application/json").and().accept("application/json").and().body(object).when()
				.post(url).then().extract().response();
		return resp;
	}

	// Post method - without headers and body
	public Response sendJsonPostRequestWithURL(String url) {
		Response resp = given()
				.config(RestAssured.config()
						.encoderConfig(new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
				.log().all().contentType("application/json").and().accept("application/json").when().post(url).then()
				.extract().response();
		return resp;
	}

	// Put method
	public Response sendPutJsonRequestWithBody(String url, Object object, Map<String, String> headers) {
		Response resp = given()
				.config(RestAssured.config()
						.encoderConfig(new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
				.log().all().headers(headers).and().contentType("application/json").and().accept("application/json")
				.and().body(object).when().put(url).then().extract().response();
		return resp;

	}
	
	// Put method without body
	public Response sendPutJsonRequestWithoutBody(String url, Map<String, String> headers) {
		Response resp = given()
				.config(RestAssured.config()
						.encoderConfig(new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
				.log().all().headers(headers).and().contentType("application/json").and().accept("application/json")
				.and().when().put(url).then().extract().response();
		return resp;

	}

	// Multipart Post Method - upload a file
	public Response sendPostMultiParMedia(Map<String, String> headers, String url, File newVideoFile) {
		Response resp = given().log().all().headers(headers).and().contentType("multipart/form-data").and()
				.accept("*/*").and().multiPart("", newVideoFile).when().post(url).then().extract().response();
		return resp;
	}
	
	// Multipart Post Method with Form Data - upload a file to S3
	public Response sendPostMultiPartMedia(Map<String, String> formParams, String url, File newVideoFile, String mimeType) {
		Response resp = given().urlEncodingEnabled(false)
		.config(RestAssured.config()
				.encoderConfig(new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
				.log().all()
				.and().contentType("multipart/form-data").and().accept("*/*")
				.and().multiPart("Key", formParams.get("Key"))
				.multiPart("bucket", formParams.get("bucket"))
				.multiPart("X-Amz-Algorithm", formParams.get("X-Amz-Algorithm"))
				.multiPart("X-Amz-Credential", formParams.get("X-Amz-Credential"))
				.multiPart("X-Amz-Date", formParams.get("X-Amz-Date"))
				.multiPart("Policy", formParams.get("Policy"))
				.multiPart("X-Amz-Signature", formParams.get("X-Amz-Signature"))
				.multiPart("file", newVideoFile, mimeType)
				.when().post(url).then().extract().response();
		return resp;
	}

	// Delete method - without body
	public Response deleteJsonRequestWithoutBody(String url, Map<String, String> headers) {
//		Response resp = given().baseUri(url).headers(headers).when().delete().then().extract().response();
		Response resp = given().config(RestAssured.config()
				.encoderConfig(new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
				.log().all().headers(headers).when().delete(url).then().extract().response();
		return resp;
	}
	
	// Delete method - with body
	public Response deleteJsonRequestWithBody(String url, Object object, Map<String, String> headers) {
		Response resp = given().config(RestAssured.config()
				.encoderConfig(new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
				.log().all().headers(headers).and().contentType("application/json").and().accept("application/json")
				.and().body(object).when().delete(url).then().extract().response();
		return resp;
	}
}
