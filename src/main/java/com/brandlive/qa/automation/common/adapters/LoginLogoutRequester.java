package com.brandlive.qa.automation.common.adapters;

import java.net.URI;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import com.brandlive.qa.automation.rest.JaxWsRsRequester;

public class LoginLogoutRequester extends JaxWsRsRequester {
	
	public String getE3LoginResponse(String host, Object reqObj) {
		
		String[] params = generateCloudflareParameters("/v3/admin/auth/sign-in");
		String url = "https://" + host + "/v3/admin/auth/sign-in?expiry=" + params[0] + "&mac=" + params[1];
		
		MultivaluedMap<String, Object> headers = new MultivaluedHashMap<String, Object>();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		WebTarget target = client.target(URI.create(url));

		log.info("  Final REST API URL: " + target.getUri());
		return getStringResponse(target, reqObj, headers);
	}
	
	public String getGRLoginResponse(String host, Object reqObj) {
		
		String url = "https://" + host + "/v2/greenroom/producer/login";
		
		MultivaluedMap<String, Object> headers = new MultivaluedHashMap<String, Object>();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		WebTarget target = client.target(URI.create(url));

		log.info("  Final REST API URL: " + target.getUri());
		return getStringResponse(target, reqObj, headers);
		
	}

}
