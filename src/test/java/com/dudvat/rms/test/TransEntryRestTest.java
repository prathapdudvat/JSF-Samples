package com.dudvat.rms.test;

import com.dudvat.rms.rest.TransEntryRequest;
import com.dudvat.rms.utils.RmsUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class TransEntryRestTest {
	public static String  appurl="http://localhost:7070/rms/rest";
	public static void main(String[] args) {
		savePurchaseRest();
		searchPurchaseRest();
	}
	private static void searchPurchaseRest() {
		try {

			TransEntryRequest tsrPojo = new TransEntryRequest(null, null, null,"prathapd");

			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResource = client.resource(appurl+"/purchase/search");

			ClientResponse response = webResource.accept("application/json")
												.type("application/json")
												.post(ClientResponse.class, tsrPojo);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Server response .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	private static void savePurchaseRest() {
		try {

			TransEntryRequest tsrPojo = new TransEntryRequest(RmsUtils.getToday(), "Oils", 129d,"prathapd");

			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResource = client.resource(appurl+"/purchase/save");

			ClientResponse response = webResource.accept("application/json")
												.type("application/json")
												.post(ClientResponse.class, tsrPojo);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Server response .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
