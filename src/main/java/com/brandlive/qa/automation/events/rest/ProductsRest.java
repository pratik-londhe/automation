package com.brandlive.qa.automation.events.rest;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ProductsRest extends RestUtil{

	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest eventHomePageRest = new EventsHomePageRest();
	
	public static Response getEventProductsByChannelIdRes;
	public static Response putAddExistingProductToEventRes;
	
	public static JsonPath getEventProductsByChannelIdJsonPath;
	public static JsonPath putAddExistingProductToEventJsonPath;
	
	public static List<Map<String, Object>> channelProducts;
	public static Map<String, Object> addedProductMap;
	public static Map<String, Object> selectedProduct; //Product for the payload
	
	public static Map<String, Object> insertedProduct;
	public static Map<String, Object> deletedProduct;
	
	// Public methods
	
	public void getChannelProducts(String host, String channelName) {
		channelProducts = getEventProductsByChannelId(host, channelName).get("$");
	}
	
	public void getFirstProductFromListOfChannelProducts() {
		
		int channel = getEventProductsByChannelIdJsonPath.get("[0].channel");
		int created_by = getEventProductsByChannelIdJsonPath.get("[0].created_by");
		String created_at = getEventProductsByChannelIdJsonPath.get("[0].created_at");
		int product = getEventProductsByChannelIdJsonPath.get("[0].product");
		int module_id = getEventProductsByChannelIdJsonPath.get("[0].module_id");
		boolean use_attributes = getEventProductsByChannelIdJsonPath.get("[0].use_attributes");
		String imageUrl = getEventProductsByChannelIdJsonPath.get("[0].images[0]");
		String product_title_en = getEventProductsByChannelIdJsonPath.get("[0].product_title.en");
		String product_title_base = getEventProductsByChannelIdJsonPath.get("[0].product_title.base");	
		String product_title_changed = getEventProductsByChannelIdJsonPath.get("[0].product_title.changed");
		String description_en = getEventProductsByChannelIdJsonPath.get("[0].description.en");
		String description_base = getEventProductsByChannelIdJsonPath.get("[0].description.base");	
		String description_changed = getEventProductsByChannelIdJsonPath.get("[0].description.changed");
		String price_en = getEventProductsByChannelIdJsonPath.get("[0].price.en");
		String price_base = getEventProductsByChannelIdJsonPath.get("[0].price.base");	
		String price_changed = getEventProductsByChannelIdJsonPath.get("[0].price.changed");
		String sale_price_en = getEventProductsByChannelIdJsonPath.get("[0].sale_price.en");
		String sale_price_base = getEventProductsByChannelIdJsonPath.get("[0].sale_price.base");	
		String sale_price_changed = getEventProductsByChannelIdJsonPath.get("[0].sale_price.changed");
		
		selectedProduct = new HashMap<String, Object>();
		selectedProduct.put("channel", new Integer(channel));
		selectedProduct.put("created_by", new Integer(created_by));
		selectedProduct.put("product", new Integer(product));
		selectedProduct.put("module_id", new Integer(module_id));
		selectedProduct.put("created_at", created_at);
		selectedProduct.put("use_attributes", new Boolean(use_attributes));
		selectedProduct.put("imageUrl", imageUrl);
		selectedProduct.put("product_title.en", product_title_en);
		selectedProduct.put("product_title.base", product_title_base);
		selectedProduct.put("product_title.changed", product_title_changed);
		selectedProduct.put("description.en", description_en);
		selectedProduct.put("description.base", description_base);
		selectedProduct.put("description.changed", description_changed);
		selectedProduct.put("price.en", price_en);
		selectedProduct.put("price.base", price_base);
		selectedProduct.put("price.changed", price_changed);
		selectedProduct.put("sale_price.en", sale_price_en);
		selectedProduct.put("sale_price.base", sale_price_base);
		selectedProduct.put("sale_price.changed", sale_price_changed);
		
		for(Object obj : selectedProduct.values()) {
			if(obj instanceof String) log.debug(obj);
			if(obj instanceof Boolean) log.debug(obj);
			if(obj instanceof Integer) log.debug(obj);
		}
	}
	
	public void addExistingProductToEvent(String host) {
		addedProductMap = putAddExistingProductToEvent(host).get("$");
	}
	
	public void uploadNewProductFile(String host) {
		insertedProduct = postProductFileUpload(host).get("$");
	}
	
	public void deleteUploadedProduct(String host) {
		deletedProduct = deleteUploadedProductFile(host).get("$");
	}
	
	// Private methods
	
	private JsonPath getEventProductsByChannelId(String host, String channelName) {
		
		eventHomePageRest.e3Channels(host, channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Event Products by channel Id " + channel_id);
		params = generateCloudflareParameters("/v3/admin/channel/products/" + channel_id);
		url = "https://" + host + "/v3/admin/channel/products/" + channel_id + "?expiry=" + params[0] + "&mac="
				+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 get products rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		getEventProductsByChannelIdRes = restRequest.sendJsonRequestWithoutBody(url, headers);
		getEventProductsByChannelIdJsonPath = getEventProductsByChannelIdRes.jsonPath();
		return getEventProductsByChannelIdJsonPath;
	}

	
	private JsonPath putAddExistingProductToEvent(String host) {
		
		Reader reader;
		ObjectMapper objectMapperForProduct = new ObjectMapper();
		JsonNode productJsonRoot = null;
		ArrayNode images = null;
		JsonNode product_title = null;
		JsonNode description = null;
		JsonNode price = null;
		JsonNode sale_price = null;

		try {
			reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_E3_product.json"));
			productJsonRoot = objectMapperForProduct.readTree(reader);
			images = (ArrayNode) productJsonRoot.path("images");
			product_title = (ObjectNode) productJsonRoot.path("product_title");
			description = (ObjectNode) productJsonRoot.path("description");
			price = (ObjectNode) productJsonRoot.path("price");
			sale_price = (ObjectNode) productJsonRoot.path("sale_price");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((ObjectNode) productJsonRoot).put("channel", (int) selectedProduct.get("channel"));
		((ObjectNode) productJsonRoot).put("created_by", (int) selectedProduct.get("created_by"));
		((ObjectNode) productJsonRoot).put("created_at", (String) selectedProduct.get("created_at"));
		((ObjectNode) productJsonRoot).put("product", (int) selectedProduct.get("product"));
		((ObjectNode) productJsonRoot).put("module_id", (int) selectedProduct.get("module_id"));
		((ObjectNode) productJsonRoot).put("use_attributes", (boolean) selectedProduct.get("use_attributes"));
		
		((ObjectNode) product_title).put("en", (String) selectedProduct.get("product_title.en"));
		((ObjectNode) product_title).put("base", (String) selectedProduct.get("product_title.base"));
		((ObjectNode) product_title).put("changed", (String) selectedProduct.get("product_title.changed"));
		
		((ObjectNode) description).put("en", (String) selectedProduct.get("description.en"));
		((ObjectNode) description).put("base", (String) selectedProduct.get("description.base"));
		((ObjectNode) description).put("changed", (String) selectedProduct.get("description.changed"));
		
		((ObjectNode) price).put("en", (String) selectedProduct.get("price.en"));
		((ObjectNode) price).put("base", (String) selectedProduct.get("price.base"));
		((ObjectNode) price).put("changed", (String) selectedProduct.get("price.changed"));
		
		((ObjectNode) sale_price).put("en", (String) selectedProduct.get("sale_price.en"));
		((ObjectNode) sale_price).put("base", (String) selectedProduct.get("sale_price.base"));
		((ObjectNode) sale_price).put("changed", (String) selectedProduct.get("sale_price.changed"));
		
		if(images.isArray()) {
			images.removeAll();
			images.add((String) selectedProduct.get("imageUrl"));
		}
		
		String payloadJson = "{\"product\":" + productJsonRoot.toString() + ",\"languages\":[\"en\"]}";
		//log.debug(payloadJson);
		
		String url = null;
		String token = null;
		String[] params = null;

		params = generateCloudflareParameters("/v3/admin/channel/products/");
		url = "https://" + host + "/v3/admin/channel/products/?expiry=" + params[0] + "&mac="+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 add product to event rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		putAddExistingProductToEventRes = restRequest.sendPutJsonRequestWithBody(url, payloadJson, headers);
		//log.debug(putAddExistingProductToEventRes.prettyPrint());
		putAddExistingProductToEventJsonPath = putAddExistingProductToEventRes.jsonPath();
		return putAddExistingProductToEventJsonPath;
		
	}
	
	private JsonPath postProductFileUpload(String host) {
		String url = null;
		String token = null;
		String[] params = null;
		
		String productUrl = UploadRest.uploadFile.get("url") + "/" + UploadRest.uploadFileResFields.get("Key");
		
		params = generateCloudflareParameters("/v3/admin/channel/products/");
		url = "https://" + host + "/v3/admin/channel/products/?expiry=" + params[0] + "&mac=" + params[1];
		
		// creating payload
		JsonObject uploadProductPayload = new JsonObject();
		uploadProductPayload.addProperty("use_attributes", false);
		uploadProductPayload.addProperty("buy_now_link", "");
		
		JsonObject tab_title = new JsonObject();
		tab_title.addProperty("base", "");
		tab_title.addProperty("changed", "");
		
		JsonObject button_text = new JsonObject();
		button_text.addProperty("base", "");
		button_text.addProperty("changed", "");
		
		JsonObject product_title = new JsonObject();
		product_title.addProperty("base", "Artistic Glasses");
		product_title.addProperty("changed", "");
		
		JsonObject description = new JsonObject();
		description.addProperty("base", "Artistic Glasses");
		description.addProperty("changed", "");
		
		JsonObject price = new JsonObject();
		price.addProperty("base", "200.00");
		price.addProperty("changed", "");
		
		JsonObject sale_price = new JsonObject();
		sale_price.addProperty("base", "150.00");
		sale_price.addProperty("changed", "");
		
		JsonArray attributes = new JsonArray();
		//attributes.add("");
		
		JsonArray categories = new JsonArray();
		//categories.add("");
		
		JsonArray images = new JsonArray();
		images.add(productUrl);
		
		uploadProductPayload.add("tab_title", tab_title);
		uploadProductPayload.add("button_text", button_text);
		uploadProductPayload.add("product_title", product_title);
		uploadProductPayload.add("description", description);
		uploadProductPayload.add("price", price);
		uploadProductPayload.add("sale_price", sale_price);
		uploadProductPayload.add("attributes", attributes);
		uploadProductPayload.add("categories", categories);
		uploadProductPayload.add("images", images);
		
		String payloadJson = "{\"product\":" + uploadProductPayload.toString() + "}";
		log.debug(payloadJson);

		token = LoginLogoutRest.E3_Token;

		log.info("E3 upload product to channel file rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithBody(url, payloadJson, headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}
	
	private JsonPath deleteUploadedProductFile(String host) {
		String url = null;
		String token = null;
		String[] params = null;
		
		params = generateCloudflareParameters("/v3/admin/channel/products");
		url = "https://" + host + "/v3/admin/channel/products?expiry=" + params[0] + "&mac=" + params[1];
		
		JsonObject payloadJson = new JsonObject();
		payloadJson.addProperty("channel", (int) insertedProduct.get("channel"));
		
		JsonArray productIds = new JsonArray();
		productIds.add((int) insertedProduct.get("product"));
		payloadJson.add("productIDs", productIds);
		
		log.debug(payloadJson);

		token = LoginLogoutRest.E3_Token;

		log.info("E3 delete product from channel rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.deleteJsonRequestWithBody(url, payloadJson.toString(), headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}
	
}
