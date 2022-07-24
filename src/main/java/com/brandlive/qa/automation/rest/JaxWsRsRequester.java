package com.brandlive.qa.automation.rest;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.brandlive.qa.automation.utils.RestUtil;

public class JaxWsRsRequester extends RestUtil {

	//protected static final Client client = ClientBuilder.newClient().register(Logger.class);
	protected static final Client client = ClientBuilder.newClient();
	
	protected <Request, T> String getStringResponse(final WebTarget target, Request request) {
		String response = null;
		try {
			Builder builder = target.request();
			// Set the default value for headers
			builder = target.request(MediaType.APPLICATION_JSON);

			if (request == null) {
				response = builder.get(String.class);

			} else {
				response = builder.post(Entity.json(request), String.class);
			}
		} catch (NotFoundException nfe) {
			wrapFatalException(nfe, "No resource was found for URI: " + target.getUri());
		} catch (WebApplicationException wae) {
			wrapFatalException(wae,
					"Unable to connect to " + target.getUri() + ": " + wae.getMessage() + " - " + wae.getResponse());
		}
		return response;
	}
	
	protected <Request, T> String getStringResponse(final WebTarget target, Request request, MultivaluedMap<String, Object> headers) {
		String response = null;
		try {
			Builder builder = target.request();
			// Set the default value for headers
			if (headers == null) {
				builder = target.request(MediaType.APPLICATION_JSON);
			}
			else {
				builder.headers(headers);
			}

			if (request == null) {
				response = builder.get(String.class);

			} else {
				response = builder.post(Entity.json(request), String.class);
			}
		} catch (NotFoundException nfe) {
			wrapFatalException(nfe, "No resource was found for URI: " + target.getUri());
		} catch (WebApplicationException wae) {
			wrapFatalException(wae,
					"Unable to connect to " + target.getUri() + ": " + wae.getMessage() + " - " + wae.getResponse());
		}
		return response;
	}
}
