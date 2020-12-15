package com.tts.MapsApp;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MapService {
	/*
	 * You can obtain an API key from
	 * https://developers.google.com/maps/documentation/javascript/get-api-key. Copy
	 * and paste your API key to application.properties.
	 */
	@Value("${api_key}")
	private String apiKey;

	public void addCoordinates(Location location) {
		try {
			String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + location.getCity() + ","
					+ location.getState() + "&key=" + apiKey;
			RestTemplate restTemplate = new RestTemplate();
			GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
			Location coordinates = response.getResults().get(0).getGeometry().getLocation();
			location.setLat(coordinates.getLat());
			location.setLng(coordinates.getLng());
		} catch (Exception ex) {
			location.setLat("42.434722");
			location.setLng("-83.985");
			location.setCity("Hell");
			location.setState("Michigan.  An error occured and you were sent here automatically. Try again.");
		}
	}

	public void getRandomCoordinates(Location location) {
		try {
			String randomLat = String.valueOf((Math.random() * 180.0) - 90.0);
			String randomLong = String.valueOf((Math.random() * 360.0) - 180.0);
			String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + randomLat + "," + randomLong
					+ "&key=" + apiKey;
			RestTemplate restTemplate = new RestTemplate();
			GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
			Location coordinates = response.getResults().get(0).getGeometry().getLocation();
			location.setLat(randomLat);
			location.setLng(randomLong);
			location.setCity(coordinates.getCity());
			location.setState(coordinates.getState());
			System.out.print(location);
		} catch (Exception ex) {
			location.setLat("42.434722");
			location.setLng("-83.985");
			location.setCity("Hell");
			location.setState("Michigan.  An error occured and you were sent here automatically. Try again.");
		}
	}
}