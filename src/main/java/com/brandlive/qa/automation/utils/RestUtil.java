package com.brandlive.qa.automation.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

public class RestUtil extends Doer {

	protected String[] generateCloudflareParameters(String urlPath) {

		String[] params = new String[2];

		try {

			String secret = "Wp4RYjW0bg/pzkoz6sx/yhmw3FFeKcUMk74za2oVpeI";
			String timestamp = String.valueOf(System.currentTimeMillis() + 60000);
			log.debug("Expiry: " + timestamp);

//	         String message = "/v3/admin/auth/sign-in";
//	         String finalStr = message.concat(timestamp);
			String finalStr = urlPath.concat(timestamp);

			Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
			SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
			sha256_HMAC.init(secret_key);

			String mac = Base64.getEncoder().encodeToString(sha256_HMAC.doFinal(finalStr.getBytes()));
			log.debug("Mac: " + mac);

			params[0] = timestamp;
			params[1] = mac;
		} catch (Exception e) {
			log.debug("There is an Error");
		}

		return params;
	}

	protected String createRandomUUID() {
		return UUID.randomUUID().toString();
	}

	protected String getEditDate() {
		Date editShotDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String newDate = sdf.format(editShotDate);
		log.debug("Edit Date : " + newDate);
		return newDate;
	}
	
	protected String createRandomEventName() {
		int randomInt = (int) (Math.random() * 1000);
		java.util.Date date = new java.util.Date();
		return "Automation Event " + randomInt + " " + date;
	}

	protected int createRandomTemplate() {
		int template = (int) (Math.random() * 3) + 1;
		return template;
	}

	protected String createRandomSessionName() {
		String nameOfSession = "Broadcast Session " + (int) (Math.random() * 10) + 1;
		return nameOfSession;
	}
	
	protected String createRandomSessionName(String sessionType) {
		String nameOfSession = sessionType + " Session " + (int) (Math.random() * 10) + 1;
		return nameOfSession;
	}
}
