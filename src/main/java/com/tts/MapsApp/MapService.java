package com.tts.MapsApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MapService {
	/*
	 * You can obtain an API key from https://developers.google.com/maps/documentation/javascript/get-api-key. 
	 * Copy and paste your API key to application.properties.
	 */
	@Value("${api_key}")
	private String apiKey;

	public void addCoordinates(Location location) {
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + location.getCity() + ","
				+ location.getState() + "&key=" + apiKey;
		RestTemplate restTemplate = new RestTemplate();
		GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
		Location coordinates = response.getResults().get(0).getGeometry().getLocation();
		location.setLat(coordinates.getLat());
		location.setLng(coordinates.getLng());
	}
}
